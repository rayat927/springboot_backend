package com.isoil.krishimanage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isoil.krishimanage.model.Adviser;

public interface AdviserRepository extends JpaRepository<Adviser, Long> {
    public Adviser findByUserId(Long userId);
    public List<Adviser> findByApproved(boolean approved);
}
