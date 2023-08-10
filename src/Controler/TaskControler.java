/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;


import Views.View;

/**
 * Clase que implementa la interfaz Controler para el tipo Task.
 * Encargada de controlar las operaciones relacionadas con las tareas.
 * @author Felipe Chacón
 */
public class TaskControler implements Controler<Task> {
    // Atributos de la clase
    private TaskList list; // Atributo TaskList
    private View view; // Atributo View

    // Constructor que recibe una instancia de la vista para interactuar con ella
    public TaskControler(View view) {
        list = TaskList.getInstance(); // Crear una nueva instancia de TaskList
        this.view = view; // Asignar la vista proporcionada al atributo view
    }

    @Override
    public void insert(Task task) {
        if (task.isComplete()) {
            list.insert(task);
            view.displayMessaje("Tarea agregada exitosamente.");
            readAll();
        } else {
            view.displayErrorMessaje("No se puede agregar la tarea. Faltan datos.");
        }
    }

    @Override
    public void update(Task task) {
        if (task.isComplete()) {
            list.update(task);
            view.displayMessaje("Tarea actualizada exitosamente.");
            readAll();
        } else {
            view.displayErrorMessaje("No se puede actualizar la tarea. Faltan datos.");
        }
    }

    @Override
    public void delete(Task task) {
        if (list.delete(task)) {
            view.displayMessaje("Tarea eliminada exitosamente.");
            readAll();
        } else {
            view.displayErrorMessaje("No se puede eliminar la tarea. No se encontró en la lista.");
        }
    }

    @Override
    public void read(Object id) {
        Task task = list.search(id);
        if (task != null) {
            view.display(task);
        } else {
            view.displayErrorMessaje("No se encontró la tarea con el ID proporcionado.");
        }
    }

    @Override
    public void readAll() {
        Task[] tasks = list.toArray();
        if (tasks.length > 0) {
            view.displayAll(tasks);
        }
    }
}
