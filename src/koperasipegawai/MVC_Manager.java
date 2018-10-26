package koperasipegawai;

public class MVC_Manager {
    
    ViewManager viewManager = new ViewManager();
    ModelManager modelManager = new ModelManager();
    
    
    
    ControllerManager controllerManager = new ControllerManager(viewManager,modelManager);
    
}
