package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>  {

}

