package koperasipegawai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerLogin {
    
    private String username,password;

    
    
    private ViewLogin viewLogin;
    private ModelLogin modelLogin;

    public ControllerLogin(ViewLogin viewLogin,ModelLogin modelLogin){
        
        this.viewLogin = viewLogin;
        this.modelLogin = modelLogin;


        
        viewLogin.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String user = viewLogin.getUsername();
                String pass = viewLogin.getPassword();
                
                System.out.println(user+" "+pass);
                
                
                if(modelLogin.login(user, pass)){
                    System.out.println("SUKSES");
                    viewLogin.window.dispose();
                }else
                    JOptionPane.showMessageDialog(null, "LOGIN GAGAL!");
            }
        });
        
        viewLogin.keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewLogin.window.dispose();
            }
        });
        
        
    }
    
}
