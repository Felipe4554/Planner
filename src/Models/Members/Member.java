/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Members;

/**
 *
 * @author ´Felipe Chacón
 */
public class Member {
 private String id;
 private String name;
 private String phone;
 private String email;
 private Role role;
 //Metodos de Acceso

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }
 
 
 //Constructores
    
//Constructor 1
 public Member(String id, String name, String phone, String email, Role role) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.role = role;
 }
 
 //Constructor 2
    public Member(String id, String name, String email, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }
 
//Constructor 3
    public Member(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Cedula=" + id + ", Nombre=" + name + ", Telefono=" + phone + ", Correo=" + email + ", Rol=" + role + '}';
    }
}
