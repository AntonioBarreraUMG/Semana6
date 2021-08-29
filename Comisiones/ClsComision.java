/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comisiones;

import Modelos.MdVendedor;
import java.util.*;
import java.text.NumberFormat;

/**
 *
 * @author jeant
 */
public class ClsComision {
    private final NumberFormat formatoCantidad = NumberFormat.getCurrencyInstance(new Locale("es", "GT"));
    private final List <MdVendedor> Todos = new ArrayList();
    private final Double[] totales = new Double[4];
    private final Scanner t = new Scanner(System.in);
    
    private void ingresarInformacion(){
        try {
            MdVendedor vendedor = new MdVendedor();
            System.out.println("Nombre: ");
            vendedor.setNombre(t.nextLine());
            System.out.println("Enero: ");
            vendedor.setEnero(t.nextDouble());
            System.out.println("Febrero: ");
            vendedor.setFebrero(t.nextDouble());
            System.out.println("Marzo: ");
            vendedor.setMarzo(t.nextDouble());
            Todos.add(vendedor);
        } catch (Exception e) {
            System.out.println("\nArgumento no valido.\n");
            System.out.println("Registro cancelado.");
            t.nextLine();
        }
    }
    
    private void imprimirInformacion(){
        int contador = 1;
        for(MdVendedor elemento : Todos){
            System.out.println("-------------------");
            System.out.println("** Registro " + contador + " **");
            System.out.println("Nombre:    " + elemento.getNombre());
            System.out.println("Enero:     " + formatoCantidad.format(elemento.getEnero()));
            System.out.println("Febrero:   " + formatoCantidad.format(elemento.getFebrero()));
            System.out.println("Marzo:     " + formatoCantidad.format(elemento.getMarzo()));
            System.out.println("Total:     " + formatoCantidad.format(elemento.getTotal()));
            System.out.println("-------------------");
            contador ++;
        }
        if(totales[0] > 0){
            System.out.println("\n*******************");
            System.out.println("++ Generales ++");
            System.out.println("Enero:     " + formatoCantidad.format(totales[0]));
            System.out.println("Febrero:   " + formatoCantidad.format(totales[1]));
            System.out.println("Marzo:     " + formatoCantidad.format(totales[2]));
            System.out.println("Total:     " + formatoCantidad.format(totales[3]));
            System.out.println("*******************");
        } 
    }
    
    private String mayorVendedorMes(int mes){
        String nombre = "";
        Double mayor = 0.0;
        for(MdVendedor elemento : Todos){
            if(mes == 1){
                if(elemento.getEnero() > mayor){
                    mayor = elemento.getEnero();
                    nombre = elemento.getNombre();
                } 
            } else if(mes == 2) {
                if(elemento.getFebrero() > mayor){
                    mayor = elemento.getFebrero();
                    nombre = elemento.getNombre();
                }
            } else if(mes == 3) {
                if(elemento.getMarzo() > mayor){
                    mayor = elemento.getMarzo();
                    nombre = elemento.getNombre();
                }
            } else {
                return "Ingrese un mes valido";
            }
        }
        if(!"".equals(nombre)){
            return "El mayor vendedor es " + nombre + " con "
                    + String.valueOf(formatoCantidad.format(mayor));
        }
        return "Aun no se ha ingresado ningun dato";
    }
    
    private String menorVendedorMes(int mes){
        String nombre = "";
        Double menor = 999999.9;
        for(MdVendedor elemento : Todos){
            if(mes == 1){
                if(elemento.getEnero() < menor){
                    menor = elemento.getEnero();
                    nombre = elemento.getNombre();
                }
            } else if(mes == 2) {
                if(elemento.getFebrero() < menor){
                    menor = elemento.getFebrero();
                    nombre = elemento.getNombre();
                }
            } else if(mes == 3) {
                if(elemento.getMarzo() < menor){
                    menor = elemento.getMarzo();
                    nombre = elemento.getNombre();
                }
            } else {
                return "Ingrese un mes valido";
            }
        }
        if(!"".equals(nombre)){
            return "El menor vendedor es " + nombre + " con "
                    + String.valueOf(formatoCantidad.format(menor));
        }
        return "Aun no se ha ingresado ningun dato";
    }
    
    private void ejecutarMayorMenorVendedor(){
        int opcion = 0;
        int mes = 0;
        try {
            System.out.println("¡Que desea saber?");
            System.out.println("<1>Mayor vendedor <2>Menor vendedor");
            opcion = t.nextInt();
            t.nextLine();
            System.out.println("Ingrese el mes que desea evaluar:");
            System.out.println("<1>Enero <2>Febrero <3>Marzo");
            mes = t.nextInt();
            t.nextLine();
        } catch (Exception e){
            opcion = 0;
            t.nextLine();
        } 
        switch (opcion) {
            case 1 -> System.out.println(mayorVendedorMes(mes));
            case 2 -> System.out.println(menorVendedorMes(mes));
            default -> System.out.println("Ingrese una opcion valida.");
        }
    }
    
    private void totalIndividual(){
        for(MdVendedor elemento : Todos){
            elemento.setTotal(elemento.getEnero()
                            +elemento.getFebrero()
                            +elemento.getMarzo());
        }
    }
    
    private void totalesGenerales(){
        totales[0] = 0.0;
        totales[1] = 0.0;
        totales[2] = 0.0;
        totales[3] = 0.0;
        for(MdVendedor elemento : Todos){
            totales[0] += elemento.getEnero();
            totales[1] += elemento.getFebrero();
            totales[2] += elemento.getMarzo();
            totales[3] += elemento.getTotal();
        }
    }
    
    private String mayorVendedor(){
        Double mayor = 0.0;
        String nombre = "";
        for(MdVendedor elemento : Todos){
            if(elemento.getTotal() > mayor){
                mayor = elemento.getTotal();
                nombre = elemento.getNombre();
            }
        }
        if(mayor > 0.0){
            return "El mayor vendedor es " + nombre + " con " + 
                    String.valueOf(formatoCantidad.format(mayor));
        } 
        return "Aun no se han ingresado datos.";
    }
    
    private void editarDato(int fila, int col, String nuevoDato){
        switch(col){
            case 1 -> Todos.get(fila).setNombre(nuevoDato);
            case 2 -> Todos.get(fila).setEnero(Double.parseDouble(nuevoDato));
            case 3 -> Todos.get(fila).setFebrero(Double.parseDouble(nuevoDato));
            case 4 -> Todos.get(fila).setMarzo(Double.parseDouble(nuevoDato));
        }
    }
    
    private String buscarCantidad(Double cantidad){
        for(MdVendedor elemento : Todos){
            if(Objects.equals(elemento.getEnero(), cantidad)){
                return elemento.getNombre() + " en el mes de enero.";
            } else if(Objects.equals(elemento.getFebrero(), cantidad)){
                return elemento.getNombre() + " en el mes de febrero.";
            } else if(Objects.equals(elemento.getMarzo(), cantidad)){
                return elemento.getNombre() + " en el mes de marzo.";
            }
        }
        return "No se ha encontrado ninguna coincidencia.";
    }
    
    private void ejecutarCalculos(){
        totalIndividual();
        totalesGenerales();
    }
    
    private void ejecutarEditarDato(){
        try {
            imprimirInformacion();
            System.out.println("Ingrese el numero del registro que desea editar: ");
            int fila = t.nextInt() - 1;
            t.nextLine();
            System.out.println("Ingrese el numero del dato que desea editar");
            System.out.println("<1>Nombre <2>Enero <3>Febrero <4>Marzo");
            int columna = t.nextInt();
            t.nextLine();
            System.out.println("Ingrese el nuevo dato: ");
            String nuevoDato = t.nextLine();
            editarDato(fila, columna, nuevoDato);
        } catch (Exception e) {
            System.out.println("\nAlgo ha fallado. Intentelo de nuevo.");
            t.nextLine();
        }
    }

    private void ejecutarBuscarCantidad(){
        try {
            System.out.println("Ingrese la cantidad que desea buscar: ");
            Double cantidad = t.nextDouble();
            System.out.println(buscarCantidad(cantidad));
        } catch (Exception e) {
            System.out.println("\nAlgo ha fallado. Intentelo de nuevo.");
            t.nextLine();
        }
    }
    
    public void menu(){
        int opcion = 0;
        do{
            ejecutarCalculos();
            System.out.println("\n1- Ingresar informacion");
            System.out.println("2- Mayor y menor vendedor por mes");
            System.out.println("3- Mayor vendedor general");
            System.out.println("4- Editar dato especifico");
            System.out.println("5- Buscar por cantidad");            
            System.out.println("6- Ver informacion");
            System.out.println("7- Salir");
            try {
                opcion = t.nextInt();
            } catch (Exception e) {
                opcion = 0;
            } 
            t.nextLine();
            System.out.println("\n");
            switch(opcion){
                case 1 -> ingresarInformacion();
                case 2 -> ejecutarMayorMenorVendedor();
                case 3 -> System.out.println(mayorVendedor());
                case 4 -> ejecutarEditarDato();
                case 5 -> ejecutarBuscarCantidad();
                case 6 -> imprimirInformacion();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Por favor, intente con otro valor.");
            }
        }while(opcion != 7);
    }
}