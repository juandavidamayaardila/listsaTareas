package com.co.sofka.tareas.repository;

import com.co.sofka.tareas.model.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Interfaz que extiende de JPA y permite
 * realizar las operaciones sobre la bd, se
 * crea un metodo especifico con su query.
 *
 * @author JD-Amaya
 * @version 01.02.003 16/06/2022
 * @since 01.
 */
@Repository
public interface ISubTaskRepository extends JpaRepository<Subtask, Long> {

    /**
     * Permite encontrar todas las subtareas que tenga como llave foranea
     * de id_task el valor del parametro.
     *
     * @param idTask id de la tarea a la que pertenecen
     * @return lista de subtareas pertenecientes a la tarea.
     */
    @Query(value = "select * from Subtask t where t.id_task = :idTask", nativeQuery = true)
    ArrayList<Subtask> findById_task(Long idTask);
}
