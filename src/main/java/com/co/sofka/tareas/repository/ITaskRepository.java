package com.co.sofka.tareas.repository;

import com.co.sofka.tareas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
public interface ITaskRepository extends JpaRepository<Task, Long> {
}
