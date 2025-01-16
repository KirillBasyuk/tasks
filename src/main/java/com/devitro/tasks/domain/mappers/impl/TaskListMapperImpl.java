package com.devitro.tasks.domain.mappers.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.devitro.tasks.domain.dto.TaskListDto;
import com.devitro.tasks.domain.entities.Task;
import com.devitro.tasks.domain.entities.TaskList;
import com.devitro.tasks.domain.entities.TaskStatus;
import com.devitro.tasks.domain.mappers.TaskListMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class TaskListMapperImpl implements TaskListMapper{

    private TaskMapperImpl taskMapperImpl;
    
    public TaskList fromDto(TaskListDto taskListDto) {

        return TaskList.builder()
                       .id(taskListDto.id())
                       .title(taskListDto.title())
                       .description(taskListDto.description())
                       .tasks(Optional.ofNullable(taskListDto.tasks())
                                      .map(tasks -> tasks.stream()
                                                         .map(taskMapperImpl::fromDto)
                                                         .toList())
                                      .orElse(null))
                       .build();
    }

    public TaskListDto toDto(TaskList taskList) {

        return new TaskListDto(
            taskList.getId(),
            taskList.getTitle(),
            taskList.getDescription(),
            Optional.ofNullable(taskList.getTasks())
                    .map(List::size)
                    .orElse(null),
            calculateTaskListProgress(taskList.getTasks()),
            Optional.ofNullable(taskList.getTasks())
                    .map(tasks -> tasks.stream()
                                       .map(taskMapperImpl::toDto)
                                       .toList())
                    .orElse(null)
            );
    }

    private Double calculateTaskListProgress(List<Task> taskList) {

        Double count = 0.0;
        if (taskList == null) {
            return null;
        }

        for (Task task : taskList) {
            if (task.getStatus() == TaskStatus.CLOSED) {
                count++;
            }
        }

        return count / taskList.size();
    }
}
