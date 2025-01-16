package com.devitro.tasks.domain.mappers.impl;

import org.springframework.stereotype.Component;

import com.devitro.tasks.domain.dto.TaskDto;
import com.devitro.tasks.domain.entities.Task;
import com.devitro.tasks.domain.mappers.TaskMapper;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDto taskDto) {

        return Task.builder()
                   .id(taskDto.id())
                   .title(taskDto.title())
                   .description(taskDto.description())
                   .dueDate(taskDto.dueDate())
                   .status(taskDto.status())
                   .priority(taskDto.priority())
                   .build();
    }

    @Override
    public TaskDto toDto(Task task) {

        return new TaskDto(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            task.getPriority(),
            task.getStatus() );
    }

}
