package com.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodbox.entity.admin;

@Repository
public interface adminRepo extends JpaRepository<admin, Integer>{

}