package com.devitro.tasks.domain.mappers;

import com.devitro.tasks.domain.dto.TaskListDto;
import com.devitro.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
