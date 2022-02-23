package com.app.applistviewpersonalizado;
public class Item {

    private String Matricula,Nombre,Numero;
    private int Clave;
    // Clic derecho Generate, Constructor, seleccionar los 4 o mas.
       public Item(String matricula, String nombre, String numero) {
           Nombre=nombre;
           Matricula=matricula;
           Numero=numero;
    }   //Clicderecho Generate, Getter and Setter

    public String getMatricula() {
        return Matricula;
    }
    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNumero() {
        return Numero;
    }
    public void setNumero(String numero) {
        Numero = numero;
    }

    public int getClave() {
        return Clave;
    }
    public void setClave(int clave) { Clave = clave;
    }
}
