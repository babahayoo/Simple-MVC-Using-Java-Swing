/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasipegawai;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Administator
 */
public class ViewLogin {
    
    private String username,password;
    
    JFrame window = new JFrame("KOPERASI PEGAWAI UPN");
    
    JLabel judul = new JLabel ("Login Akun");
    JLabel luser = new JLabel ("Nama Pengguna    :");
    JLabel lpass = new JLabel ("Kata Sandi               :");
    
    JTextField tfuser = new JTextField();
    JTextField tfpass = new JPasswordField();
    JButton login = new JButton("Masuk");
    JButton keluar = new JButton("Keluar");
    
    
    public ViewLogin(){
    
        initComponents();

        window.setLayout(null);
        window.setSize(500, 200);
        window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
       
    }
    
    public void initComponents(){
             
        judul = new JLabel("Login Akun");
        window.add(judul);
        judul.setBounds(210,5,100,20);
        
        window.add(luser);
        luser.setBounds(90, 40, 110, 20);
            window.add(tfuser);
            tfuser.setBounds(210,40,150,20);
            
        window.add(lpass);
        lpass.setBounds(90, 70, 110, 20);
            window.add(tfpass);
            tfpass.setBounds(210,70,150,20);
            
        window.add(login);
        login.setBounds(160, 110, 80, 20);
        
        window.add(keluar);
        keluar.setBounds(250, 110, 80, 20);
    
    }

    public String getUsername() {
        return tfuser.getText();
    }

    public String getPassword() {
        return tfpass.getText();
    }
    


    
    
    
}