package com.devitro.tasks.domain.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devitro.tasks.domain.entities.TaskList;
import com.devitro.tasks.domain.repositories.TaskListRepository;
import com.devitro.tasks.domain.services.TaskListService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskListServiceImpl implements TaskListService{

    private final TaskListRepository taskListRepository;
    
    @Override
    public List<TaskList> listTaskLists() {
        
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {

        if (taskList.getId() != null) {
            throw new IllegalArgumentException("Task List already has an ID");
        }

        if (taskList.getTitle() == null || taskList.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task List title must be present");
        }

        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(TaskList.builder()
                                               .title(taskList.getTitle())
                                               .description(taskList.getDescription())
                                               .created(now)
                                               .updated(now)
                                               .build());
    }
}
