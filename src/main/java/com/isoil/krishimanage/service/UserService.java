package com.isoil.krishimanage.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.isoil.krishimanage.model.User;
import com.isoil.krishimanage.repository.UserRepository;
import com.isoil.krishimanage.utils.JwtUtil;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final FileStorageService fileStorageService;

    public UserService(UserRepository userRepository, FileStorageService fileStorageService) {
        this.userRepository = userRepository;
        this.fileStorageService = fileStorageService;
    }
    
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }   

    public User registerUser(User user) {
        // Ensure profile picture is null during registration
        user.setProfilePicture(null);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public String deleteUser(Long id) {
        // Optional: Delete profile picture file when user is deleted
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // You can add file deletion logic here if needed
        }
        
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    public String loginUserByUserCode(String userCode, String password) {
        JwtUtil jwtUtil = new JwtUtil(); 
        User user = userRepository.findByUserCode(userCode);
        if (user != null && user.getPassword().equals(password)) {
            String token = jwtUtil.generateToken(user.getId(), user.getRole());
            return token;
        }
        return null;    
    }
    
    public Optional<User> findById(Number id) {
        return userRepository.findById(id);
    }

    public User findByUserCode(String userCode) {
        return userRepository.findByUserCode(userCode);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // New method to update profile picture with file upload
    public User updateProfilePicture(Long userId, MultipartFile profilePicture) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            
            // Store the file and get the filename
            String fileName = fileStorageService.storeFile(profilePicture);
            user.setProfilePicture(fileName);
            
            return userRepository.save(user);
        }
        throw new RuntimeException("User not found with id: " + userId);
    }

    // Method to get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Method to remove profile picture
    public User removeProfilePicture(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            
            // Optional: Delete the physical file
            // You can implement this based on your requirements
            
            user.setProfilePicture(null);
            return userRepository.save(user);
        }
        throw new RuntimeException("User not found with id: " + userId);
    }
}
