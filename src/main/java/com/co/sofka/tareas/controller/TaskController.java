package com.co.sofka.tareas.controller;

import com.co.sofka.tareas.model.Task;
import com.co.sofka.tareas.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Controlado de tareas, contiene los endPoints
 * que seran consumidos por el cliente
 *
 * @author JD-Amaya
 * @version 01.02.003 16/06/2022
 * @since 01.
 */
@CrossOrigin
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
    public ArrayList<Task> getAllTask() {
        return this.taskService.getTaskAll();
    }

    @PostMapping
    public Task saveTask(@RequestBody Task task) {
        return this.taskService.saveTask(task);
    }

    /**
     * Permite eliminar una subtarea a partir del id
     *
     * @param idtask id de la tarea a ser eliminado
     * @return string con la operacion indicada.
     */
    @DeleteMapping("/deletetask")
    public String deleteTask(@RequestParam("idtask") Long idtask) {

        Boolean answer = taskService.deleteTask(idtask);
        if (answer) {
            return "se elimino correctamente";
        }
        return "No se pudo eliminar por favor intente de nuevo";
    }
}
