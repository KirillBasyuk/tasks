package com.devitro.tasks.domain.mappers;

import com.devitro.tasks.domain.dto.TaskDto;
import com.devitro.tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}