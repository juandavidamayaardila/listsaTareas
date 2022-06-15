package com.co.sofka.tareas.controller;

import com.co.sofka.tareas.model.Task;
import com.co.sofka.tareas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/task")
public class TaskController {

    final
    TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * EndPoint que permite obtener todos las tareas.
     *
     * @return lista de todas las tareas.
     */
    @GetMapping
    public ArrayList<Task> getAllTask(){
        return this.taskService.getTaskAll();
    }

    @PostMapping
    public Task saveTask(@RequestBody Task task){
        return this.taskService.saveTask(task);
    }
}
