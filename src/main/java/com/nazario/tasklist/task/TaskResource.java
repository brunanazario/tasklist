package com.nazario.tasklist.task;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Transactional
@RestController
@AllArgsConstructor
@RequestMapping("/api/tasks")
public class TaskResource {

    @Autowired
    TaskService taskService;

    @GetMapping("todo")
    private Iterable<Task> getToDo(){
        return taskService.getTaskOfStatus(Task.Status.TO_DO);
    }

    @GetMapping("doing")
    private Iterable<Task> getDoing(){
        return taskService.getTaskOfStatus(Task.Status.DOING);
    }

    @GetMapping("done")
    private Iterable<Task> getDone(){
        return taskService.getTaskOfStatus(Task.Status.DONE);
    }

    @GetMapping("{id}")
    private Task getTasks(@PathVariable(value = "id") UUID id){
        return taskService.getTask(id);
    }

    @PostMapping
    private Task createOrUpdate(@RequestBody Task task){
        return taskService.createOrUpdate(task);
    }

    @PutMapping("{id}/doing")
    private Task doing(@PathVariable(value = "id") UUID id){
        return taskService.doing(id);
    }

    @PutMapping("{id}/done")
    private Task done(@PathVariable(value = "id") UUID id){
        return taskService.done(id);
    }

    @PutMapping("{id}/archived")
    private Task archived(@PathVariable(value = "id") UUID id){
        return taskService.archived(id);
    }

}
