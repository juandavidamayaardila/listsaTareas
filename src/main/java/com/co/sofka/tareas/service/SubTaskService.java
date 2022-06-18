package com.co.sofka.tareas.service;


import com.co.sofka.tareas.model.Subtask;
import com.co.sofka.tareas.repository.ISubTaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


/**
 * Servicio implemente la interfaz del repositorio
 * para acceder a los metodos jpa y el los metodos
 * especificos que se hayan creado.
 *
 * @author JD-Amaya
 * @version 01.02.003 16/06/2022
 * @since 01.
 */
@Service
public class SubTaskService {

    final
    ISubTaskRepository subTaskRepository;

    final
    ModelMapper modelMapper;


    /**
     * Inyactamos la depencia del repositorio.
     *
     * @param subTaskRepository repository
     */
    public SubTaskService(ISubTaskRepository subTaskRepository, ModelMapper modelMapper) {
        this.subTaskRepository = subTaskRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Permite obtener todas las subtareas almacenadas.
     *
     * @return lista de subtareas.
     */
    public ArrayList<Subtask> getSubtasAll() {

        return (ArrayList<Subtask>) subTaskRepository.findAll();
    }

    /**
     * Meotod que permite obtener todas las subtareas
     * pertenecientes a una tarea
     *
     * @param idTask parametro de busqueda
     * @return lista con todas las subtareas pertenecientes.
     */
    public ArrayList<Subtask> getSubtaskByIdTask(Long idTask) {

        return (ArrayList<Subtask>) subTaskRepository.findById_task(idTask);
    }

    /**
     * Permite almacenar un subtarea en base de datos.
     *
     * @param subtask subtarea a ser almacenada.
     * @return suptarea almacenada con su id.
     */
    public Subtask saveSubTask(Subtask subtask) {

        return subTaskRepository.save(subtask);
    }

    /**
     * Permite obtener el objeto apartir de us id.
     *
     * @param idSubtask id de la tarea a buscar.
     * @return el objeto encontrado.
     */
    public Subtask getSubTaskID(Long idSubtask) {

        return subTaskRepository.findById(idSubtask).orElseThrow();
    }

    /**
     * Permite eliminar una subtarea apartide su id.
     *
     * @param idSubTask id para buscar el objeto que va ser eliminado.
     * @return return true o false.
     */
    public Boolean deleteSubTaskId(Long idSubTask) {
        try {

            subTaskRepository.delete(getSubTaskID(idSubTask));
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
