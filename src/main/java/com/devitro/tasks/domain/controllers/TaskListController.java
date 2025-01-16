package com.devitro.tasks.domain.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devitro.tasks.domain.dto.TaskListDto;
import com.devitro.tasks.domain.entities.TaskList;
import com.devitro.tasks.domain.mappers.impl.TaskListMapperImpl;
import com.devitro.tasks.domain.services.impl.TaskListServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private final TaskListServiceImpl taskListServiceImpl;
    private final TaskListMapperImpl taskListMapperImpl;
    
    @GetMapping
    public List<TaskListDto> listTaskLists() {
        
        return taskListServiceImpl.listTaskLists()
                                  .stream()
                                  .map(taskListMapperImpl::toDto)
                                  .toList();
    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {

        TaskList taskList = taskListMapperImpl.fromDto(taskListDto);

        return taskListMapperImpl.toDto(taskListServiceImpl.createTaskList(taskList));
    }
    
}
