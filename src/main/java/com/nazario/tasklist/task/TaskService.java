package com.nazario.tasklist.task;

import org.hibernate.query.criteria.internal.predicate.BooleanExpressionPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@SuppressWarnings("WeakerAccess")
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Iterable<Task> getTaskOfStatus(Task.Status status){
        BooleanExpression booleanExpression = QTask.task.status.eq(status);
        return taskRepository.findAll(booleanExpression);
    }

    public Task getTask(final UUID id){
        return taskRepository.getOne(id);
    }

    public Task createOrUpdate(final Task task){
        return taskRepository.save(task);
    }

    public Task doing(final UUID id){
        return updateStatusTask(id, Task.Status.DOING);
    }

    public Task done(final UUID id){
        return updateStatusTask(id, Task.Status.DONE);
    }

    public Task archived(final UUID id){
        return updateStatusTask(id, Task.Status.ARCHIVED);
    }

    public Task updateStatusTask(final UUID id, final Task.Status status){
        Task taskUpdate = taskRepository.getOne(id);
        taskUpdate.setStatus(status);
        return taskRepository.save(taskUpdate);
    }

}