package com.co.sofka.tareas.controller;


import com.co.sofka.tareas.model.Subtask;
import com.co.sofka.tareas.service.SubTaskService;
import org.modelmapper.ModelMapper;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Controlado de subtareas, contiene los endPoints
 * que seran consumidos por el cliente
 *
 *  @version  01.02.003 16/06/2022
 *  @author JD-Amaya
 *  @since 01.
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/subtask")
public class SubTaskController {

    final
    SubTaskService subTaskService;

    final
    ModelMapper modelMapper;

    /**
     * Constructor que permite iyectar la dependencia del servicio
     * y el modelppaer.
     *
     * @param subTaskService servicio con la implementacion de metodos
     * @param modelMapper libreria para mapper y usar los dtos
     */
    public SubTaskController(SubTaskService subTaskService, ModelMapper modelMapper) {
        this.subTaskService = subTaskService;
        this.modelMapper = modelMapper;
    }

    /**
     * Obtiene todas las subtareas almaceandas.
     *
     * @return lista con las subtareas almacenadas.
     */
    @GetMapping
    public ArrayList<Subtask> getAllSubtask(){
        return subTaskService.getSubtasAll();

    }

    /**
     * Permite buscar una subtarea por medio del id de la tarea,
     * por medio de su llave foranea.
     *
     * @param idtask id de la tarea
     * @return lista de las subtareas pertenecientes a ese id
     */
    @GetMapping("/buscarsubtask")
    public ArrayList<Subtask> getSubtaskByIDTask(@RequestParam("idtask") Long idtask){
        return subTaskService.getSubtaskByIdTask(idtask);

    }

    /**
     * Permite guardar una subtarea
     *
     * @param subtask objeto a ser guardado.
     * @return objeto almacenado con su id.
     */
    @PostMapping
    public Subtask saveSubtask(@RequestBody Subtask subtask){

        return subTaskService.saveSubTask(subtask);

    }

    /**
     * Permite eliminar una subtarea por medio de us id.
     *
     * @param idsubtask id de la subtarea a ser eliminado.
     * @return texto con la operacion realizada.
     */
    @DeleteMapping("/deletesubtask")
    public String deleteSubTaskId(@RequestParam("idsubtask") Long idsubtask){
        Boolean answer = subTaskService.deleteSubTaskId(idsubtask);
        if(answer){
            return "se elimino correctamente";
        }
        return "No se pudo eliminar por favor intente de nuevo";
    }

    /**
     * Permite buscar una subtarea por medio del id y
     * settear el parametro complet
     *
     * @param idsubtask id de la tarea
     * @param complet parametro a ser actualizado.
     * @return elemento actualizado
     */
    @GetMapping("/subtaskcomplet")
    public Subtask updateCompletSubtask(@RequestParam("idsubtask") Long idsubtask,
                                                   @RequestParam("complet") Boolean complet)
    {
        Subtask subtaskTmp = subTaskService.getSubTaskID(idsubtask);
        subtaskTmp.setComplet(complet);
        return subTaskService.saveSubTask(subtaskTmp);
    }
}
