package com.gsn.UserManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsn.UserManagement.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
