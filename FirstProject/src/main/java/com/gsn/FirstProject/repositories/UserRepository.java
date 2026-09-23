package com.gsn.FirstProject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsn.FirstProject.entity.UserEntity;

import jakarta.persistence.Id;

public interface UserRepository extends JpaRepository<UserEntity, Long>{


}
