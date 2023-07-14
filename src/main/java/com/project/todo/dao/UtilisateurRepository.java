package com.project.todo.dao;

import com.project.todo.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("http://localhost:4300")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {


    Optional<Utilisateur> findById(int id);

    Optional<Utilisateur> findByUsername(String username);
    boolean existsUserByUsername(String username);
}