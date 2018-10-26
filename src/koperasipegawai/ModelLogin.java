package koperasipegawai;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelLogin {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL      = "jdbc:mysql://localhost/koperasipegawai";
    static final String USER        = "root";
    static final String PASS        = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelLogin(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean login(String user,String pass){
        
        try{
            
            String admin = "122";
            String kasir = "121";
            String manager = "123";
        
            statement = koneksi.createStatement();
            
            
            String query = "SELECT * FROM `akun` WHERE `username` = '"+user+"' AND  `password` = '"+pass+"' ";
        
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                
                System.out.println(query);
                
                if(user.equals(resultSet.getString("username")) && pass.equals(resultSet.getString("password"))){
                    
                    System.out.println("Sukses");
                    
                   
                    if(kasir.equals(resultSet.getString("id"))){
                        MVC_Kasir mvck = new MVC_Kasir();
                        JOptionPane.showMessageDialog(null, "LOGIN SUKSES!");
                        return true;
                    }
                    
                    if(admin.equals(resultSet.getString("id"))){
                        MVC_Admin mvca = new MVC_Admin();
                        JOptionPane.showMessageDialog(null, "LOGIN SUKSES!");
                        return true;
                    }
                    
                    if(manager.equals(resultSet.getString("id"))){
                        MVC_Manager mvcm = new MVC_Manager();
                        JOptionPane.showMessageDialog(null, "LOGIN SUKSES!");
                        return true;
                    }

                }
                
                
            }
            
        
        
        }catch(HeadlessException ex){
            System.out.println(ex.getMessage());
            
            JOptionPane.showMessageDialog(null, "Login Gagal");
        }catch(SQLException sql){
            
            System.out.println(sql.getMessage());
            
            JOptionPane.showMessageDialog(null, "Login Gagal");
            
        }
        
        return false;
        
    }
    
}
    


    


