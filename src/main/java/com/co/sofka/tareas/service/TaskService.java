package com.co.sofka.tareas.service;


import com.co.sofka.tareas.model.Task;
import com.co.sofka.tareas.repository.ITaskRepository;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Servicio implemente la interfaz del repositorio
 * para acceder a los metodos jpa y el los metodos
 * especificos que se hayan creado.
 *
 * @author JD-Amaya
 * @version 01.02.003 17/06/2022
 * @since 01.
 */
@Service
public class TaskService {

    final
    ITaskRepository taskRepository;

    final
    ModelMapper modelMapper;

    public TaskService(ITaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Permite obtener todas las tareas almacenadas.
     *
     * @return lista de tareas.
     */
    public ArrayList<Task> getTaskAll(){
        return (ArrayList<Task>) taskRepository.findAll();
    }

    /**
     * Permite guardar en base de datos una tarea
     *
     * @param task tarea a ser almacenada
     * @return tarea almacenada con su id incluido
     */
    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    /**
     * Obtiene un objeto entity a partir de su id
     *
     * @param idTask id de la tarea a buscar
     * @return objeto completo encontrado.
     */
    public Task getTaskId(Long idTask){
        return taskRepository.findById(idTask).orElseThrow();
    }

    /**
     * Permite eliminar un elemento aparti de su id.
     *
     * @param idTask id para buscar el elemento
     * @return true o false.
     */
    public Boolean deleteTask(Long idTask){
        try {
            taskRepository.delete(getTaskId(idTask));
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
