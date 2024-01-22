/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildoras.javase_introspeccion_videos319_323;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro
 */
public class JavaSE_Introespeccion_Video321_323 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce nombre de la clase a examinar: ");

        String nombreClase;

        nombreClase = entrada.next();

        try {
            //obtener el nombre de una clase
            Class cl = Class.forName(nombreClase);
            //obtener la super clase a la que pertenece una clase
            Class superCl = cl.getSuperclass();

            //imprimir nombre de clase
            System.err.println("Clase (por String nombreClase): " + nombreClase);
            System.err.println("Clase (por cl.getname()): " + cl.getName());

            //imprimir super clase si la hubiera
            if (superCl != null && superCl != Object.class) {
                System.err.println("Super Clase (por cl.getSuperclass()): " + cl.getSuperclass());
            }

            //método que devuelve los constructores
            getConstructor(cl);
            //método que devuelve los métodos
            getMetodos(cl);
            //método que devuelve los campos o atributo
            getCampos(cl);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaSE_Introespeccion_Video321_323.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void getConstructor(Class cl) {
        //obtener todos los constructores tanto públicos como privados. También existe el método getConstructor()
        //que solo devuelve los públicos
        Constructor[] constructores = cl.getDeclaredConstructors();

        for (Constructor c : constructores) {
            //imprimir los constructores y modificador de alcance
            String nombreConstructor = c.getName();
            System.out.println("Constructor: " + nombreConstructor);
            System.out.println(" Modifier: " + Modifier.toString(c.getModifiers()));
            System.out.print(" " + nombreConstructor + "(");

            //obtener parámetros de la clase
            Class[] tipoParams = c.getParameterTypes();

            for (int i = 0; i < tipoParams.length; i++) {
                System.out.print(tipoParams[i].getName());
                if (i > 0) {
                    System.out.print(", ");
                }
            }
        }
        System.out.print(");");
    }

    private static void getMetodos(Class cl) {
        // Crear array de métodos de clase
        Method[] metodos = cl.getDeclaredMethods();

        for (Method m : metodos) {
            Class tipoDevuelto = m.getReturnType();

            String nombreMetodo = m.getName();

            System.out.print(" " + Modifier.toString(m.getModifiers()));
            System.out.print(" " + tipoDevuelto.getName() + " " + nombreMetodo + "(");

            // Obtener parámetros del método
            Class[] tipoParams = m.getParameterTypes();

            for (int i = 0; i < tipoParams.length; i++) {
                System.out.print(tipoParams[i].getName());
                if (i < tipoParams.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println(");");
        }
    }

    private static void getCampos(Class cl) {
        // Obtener todos los campos de la clase
        Field[] campos = cl.getDeclaredFields();

        for (Field campo : campos) {
            Class tipoCampo = campo.getType();
            String nombreCampo = campo.getName();

            System.out.println("Campo: " + nombreCampo);
            System.out.println(" Tipo: " + tipoCampo.getName());
            System.out.println(" Modificador: " + Modifier.toString(campo.getModifiers()));
            System.out.println();
        }
    }
}



////
