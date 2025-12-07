package com.isoil.krishimanage.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.isoil.krishimanage.model.User;
import com.isoil.krishimanage.response.UserResponse;
import com.isoil.krishimanage.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userService.getUserById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(mapToResponse(userOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User userData = userService.registerUser(user);
        return ResponseEntity.ok(mapToResponse(userData));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(mapToResponse(updatedUser));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }

    @PostMapping("/login")
    public String loginUserByUserCode(@RequestBody User user) {
        return userService.loginUserByUserCode(user.getUserCode(), user.getPassword());
    }

    // Update profile picture with file upload
    @PutMapping("/{id}/profile-picture")
    public ResponseEntity<?> updateProfilePicture(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {
        
        try {
            // Validate file type
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File cannot be empty");
            }
            
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                return ResponseEntity.badRequest().body("Only image files are allowed");
            }
            
            User updatedUser = userService.updateProfilePicture(id, file);
            UserResponse response = mapToResponse(updatedUser);
            
            // Add full URL to access the profile picture
            if (response.getProfilePicture() != null) {
                // This will be accessible via your existing FileController: /api/uploads/{filename}
                response.setProfilePicture(response.getProfilePicture());
            }
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to upload profile picture: " + e.getMessage());
        }
    }

    // Remove profile picture
    @DeleteMapping("/{id}/profile-picture")
    public ResponseEntity<?> removeProfilePicture(@PathVariable Long id) {
        try {
            User updatedUser = userService.removeProfilePicture(id);
            return ResponseEntity.ok(mapToResponse(updatedUser));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to remove profile picture: " + e.getMessage());
        }
    }

    private UserResponse mapToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setUserCode(user.getUserCode());
        response.setEmail(user.getEmail());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setAddress(user.getAddress());
        response.setRole(user.getRole());
        response.setProfilePicture(user.getProfilePicture()); // This stores just the filename
        return response;
    }
}