/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package pildoras.javase_introspeccion_videos319_323;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro
 */
public class JavaSE_Introspeccion_Videos320 {

    public static void main(String[] args) {
        Persona ana = new Persona("Ana");

        System.out.println("Nombre: " + ana.getNombre());

        Empleado juan = new Empleado(45000, "Juan");
        System.out.println(juan.getNombre());
        System.out.println(juan.getSalario());

        // ESTOS SON COMANDOS DE INTROSPECCIÓN
        System.out.println("Juan es de la clase:" + juan.getClass());
        // EJEMPLO 2 (cuesta de ver la utilidad)
        // crear objeto con la clase Class y averiguar a que clase pertenece
        Class emp1 = juan.getClass();
        System.out.println("emp1 es de la clase:" + emp1.getName());// " devuelve Empleado"
        
        // EJEMPLO 3 (todavía más complicado encontrar una utilidad
        // Se trata de polimorfismo para cambiar en tiempo ejecución la clase de un objeto
        // Es una simulación solo para entender el concepto.
        // La idea crear una instancia usando una clase por parámetro de Class.forName("laClaseEjemplo")
        
        String nombreClase = "pildoras.javase_introspeccion_videos319_323.Empleado";       
        Class emp2;
        
        try {
            emp2 = Class.forName(nombreClase);// se crea instancia de "Empleado"
            System.out.println("emp2 pertenece a la clase: " + emp2.getName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaSE_Introspeccion_Videos320.class.getName()).log(Level.SEVERE, null, ex);
        }
        // ahora se cambia la instancia para ser de Persona
        // ahora se cambia la instancia para ser de Persona
        
        nombreClase = "pildoras.javase_introspeccion_videos319_323.Persona";
        
        try {
            emp2 = Class.forName(nombreClase);// se crea instancia de "Empleado"
            System.out.println("emp2 AHORA pertenece a la clase: " + emp2.getName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaSE_Introspeccion_Videos320.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

class Persona {

    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Empleado extends Persona {

    private double salario;

    public Empleado(double salario, String nombre) {
        super(nombre);
        this.salario = salario;
    }

    public void setIncentivo(double incentivo) {
        salario = salario + incentivo;
    }

    public String getSalario() {
        return "El salario es:" + salario;
    }
}
