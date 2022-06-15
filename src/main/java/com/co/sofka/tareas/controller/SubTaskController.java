package com.co.sofka.tareas.controller;

import com.co.sofka.tareas.model.Subtask;
import com.co.sofka.tareas.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/subtask")
public class SubTaskController {

    final
    SubTaskService subTaskService;

    public SubTaskController(SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    @GetMapping
    public ArrayList<Subtask> getAllSubtask(){
        return this.subTaskService.getSubtasAll();
    }

    @PostMapping
    public Subtask saveSubtask(@RequestBody Subtask subtask){
        return this.subTaskService.saveSubTask(subtask);
    }


}
