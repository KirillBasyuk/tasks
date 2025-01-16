package com.devitro.tasks.domain.services;

import java.util.List;

import com.devitro.tasks.domain.entities.TaskList;

public interface TaskListService {
    List<TaskList> listTaskLists();

    TaskList createTaskList(TaskList taskList);
}
