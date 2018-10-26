/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasipegawai;

/**
 *
 * @author Administator
 */
public class MVC_Admin {
    
    ViewAdmin viewAdmin = new ViewAdmin();
    ModelAdmin modelAdmin = new ModelAdmin();
   
    ControllerAdmin controllerAdmin = new ControllerAdmin(modelAdmin, viewAdmin);
    
    
}
