package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Manager;

public interface ManagerRepository  extends JpaRepository<Manager, Integer> {

}

