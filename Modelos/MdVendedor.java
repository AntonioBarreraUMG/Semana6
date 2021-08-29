/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author jeant
 */
public class MdVendedor {
    private final String errorMessage = "Dato no valido.";
    private String nombre = "";
    private Double enero = 0.0;
    private Double febrero = 0.0;
    private Double marzo = 0.0;
    private Double total = 0.0;
    
    private Boolean comprobacion(Double dato){
        return dato >= 0;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the enero
     */
    public Double getEnero() {
        return enero;
    }

    /**
     * @param enero the enero to set
     */
    public void setEnero(Double enero) {
        if(comprobacion(enero)){
            this.enero = enero;
        } else {
            this.enero = 0.0;
            System.out.println(errorMessage);
        }
    }

    /**
     * @return the febrero
     */
    public Double getFebrero() {
        return febrero;
    }

    /**
     * @param febrero the febrero to set
     */
    public void setFebrero(Double febrero) {
        if(comprobacion(febrero)){
            this.febrero = febrero;
        } else {
            this.febrero = 0.0;
            System.out.println(errorMessage);
        }
    }

    /**
     * @return the marzo
     */
    public Double getMarzo() {
        return marzo;
    }

    /**
     * @param marzo the marzo to set
     */
    public void setMarzo(Double marzo) {
        if(comprobacion(marzo)){
            this.marzo = marzo;
        } else {
            this.marzo = 0.0;
            System.out.println(errorMessage);
        }
    }
    
    /**
     * @return the total
     */
    public Double getTotal(){
        return total;
    }
    
    /**
     * @param total the total to set
     */
    public void setTotal(Double total){
        if(comprobacion(total)){
            this.total = total;
        } else {
            this.total = 0.0;
            System.out.println(errorMessage);
        }
    }
}
