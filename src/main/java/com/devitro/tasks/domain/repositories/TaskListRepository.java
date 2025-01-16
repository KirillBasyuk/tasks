package com.devitro.tasks.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devitro.tasks.domain.entities.TaskList;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, UUID> {

    
} 