package koperasipegawai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerManager {
    
    ModelManager modelManager;
    ViewManager viewManager;
    
    public ControllerManager(ViewManager viewManager,ModelManager modelManager){
        this.viewManager = viewManager;
        this.modelManager = modelManager;
        
        
        if(modelManager.getBanyakData() != 0){
            

                String databarang[][] = modelManager.getDataTotalPemasukan();
                viewManager.tabel.setModel((new JTable(databarang, viewManager.namaKolom)).getModel());
                viewManager.tfOmset.setText(modelManager.getTotal);
            
        }else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        
        
        
        viewManager.btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewManager.window.dispose();
                MVC_Login mvcl = new MVC_Login();
            }
        });
        
        
        
    }
    
}
