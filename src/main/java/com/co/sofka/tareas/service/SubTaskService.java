package com.co.sofka.tareas.service;

import com.co.sofka.tareas.model.Subtask;
import com.co.sofka.tareas.repository.ISubTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubTaskService {

    final
    ISubTaskRepository subTaskRepository;


    /**
     * Inyactamos la depencia del repositorio.
     *
     * @param subTaskRepository repository
     */
    public SubTaskService(ISubTaskRepository subTaskRepository) {
        this.subTaskRepository = subTaskRepository;
    }

    /**
     * Permite obtener todas las subtareas almacenadas.
     *
     * @return lista de subtareas.
     */
    public ArrayList<Subtask> getSubtasAll(){
        return (ArrayList<Subtask>) subTaskRepository.findAll();
    }

    /**
     * Permite almacenar un subtarea en base de datos.
     *
     * @param subtask subtarea a ser almacenada.
     * @return suptarea almacenada con su id.
     */
    public Subtask saveSubTask(Subtask subtask){
        return subTaskRepository.save(subtask);
    }

    /**
     * Permite obtener todas las subtareas almacenadas de una lista.
     *
     * @return lista de subtareas.
     */
   /* public ArrayList<Subtask> getSubtasAll(Long idTask){
        return (ArrayList<Subtask>) subTaskRepository.findByIdTask(idTask);
    }*/

}
