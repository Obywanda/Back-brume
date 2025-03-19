package com.brume.mp5.portfolio.repository;

import com.brume.mp5.portfolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
