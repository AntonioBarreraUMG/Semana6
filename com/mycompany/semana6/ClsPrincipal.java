/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.semana6;

import Comisiones.ClsComision;

/**
 *
 * @author jeant
 */
public class ClsPrincipal {
    private static final ClsComision comision = new ClsComision();
    public static void main(String[] args) {
        comision.menu();
    }
}
