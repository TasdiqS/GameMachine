package com.project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.springboot.model.ModelClass;

@Repository
public interface RepositoryInter extends JpaRepository<ModelClass, Long>{

}
