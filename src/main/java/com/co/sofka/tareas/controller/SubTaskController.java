package com.co.sofka.tareas.controller;


import com.co.sofka.tareas.model.Subtask;
import com.co.sofka.tareas.service.SubTaskService;
import org.modelmapper.ModelMapper;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin
@RestController
@RequestMapping("/subtask")
public class SubTaskController {

    final
    SubTaskService subTaskService;

    final
    ModelMapper modelMapper;

    public SubTaskController(SubTaskService subTaskService, ModelMapper modelMapper) {
        this.subTaskService = subTaskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ArrayList<Subtask> getAllSubtask(){
        return (ArrayList<Subtask>) subTaskService.getSubtasAll();

    }

    @GetMapping("/buscarsubtask")
    public ArrayList<Subtask> getSubtaskByIDTask(@RequestParam("idtask") Long idtask){
        return (ArrayList<Subtask>) subTaskService.getSubtaskByIdTask(idtask);

    }

    @PostMapping
    public Subtask saveSubtask(@RequestBody Subtask subtask){

        return subTaskService.saveSubTask(subtask);

    }

    @DeleteMapping("/deletesubtask")
    public String deleteSubTaskId(@RequestParam("idsubtask") Long idsubtask){
        Boolean answer = subTaskService.deleteSubTaskId(idsubtask);
        if(answer){
            return "se elimino correctamente";
        }
        return "No se pudo eliminar por favor intente de nuevo";
    }



}
