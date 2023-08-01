/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Models.Members.Member;
import Models.Members.MemberList;
import View.View;

/**
 * Clase que implementa la interfaz Controler para el tipo Member.
 * Encargada de controlar las operaciones relacionadas con los miembros.
 * @author ´Felipe Chacón
 */
public class MemberControler implements Controler<Member> {
    // Atributos de la clase
    private MemberList list; // Atributo MemberList
    private View<Member> view; // Atributo View

    // Constructor que recibe una instancia de la vista para interactuar con ella
    public MemberControler(View<Member> view) {
        this.list = new MemberList(); // Crear una nueva instancia de MemberList
        this.view = view; // Asignar la vista proporcionada al atributo view
    }

    @Override
    public void insert(Member member) {
        if (member.isComplete()) {
            list.insert(member);
            view.displayMessaje("Miembro agregado exitosamente.");
            readAll();
        } else {
            view.displayErrorMessaje("No se puede agregar el miembro. Faltan datos.");
        }
    }

    @Override
    public void update(Member member) {
        if (member.isComplete()) {
            list.update(member);
            view.displayMessaje("Miembro actualizado exitosamente.");
            readAll();
        } else {
            view.displayErrorMessaje("No se puede actualizar el miembro. Faltan datos.");
        }
    }

    @Override
    public void delete(Member member) {
        if (list.delete(member)) {
            view.displayMessaje("Miembro eliminado exitosamente.");
            readAll();
        } else {
            view.displayErrorMessaje("No se puede eliminar el miembro. No se encontró en la lista.");
        }
    }

    @Override
    public void read(Object id) {
        Member member = list.search(id);
        if (member != null) {
            view.display(member);
        } else {
            view.displayErrorMessaje("No se encontró el miembro con el ID proporcionado.");
        }
    }

    @Override
    public void readAll() {
        Member[] members = list.toArray();
        if (members.length > 0) {
            view.displayAll(members);
        }
    }
}
