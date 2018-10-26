/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasipegawai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administator
 */
public class ModelManager {
    String getTotal;
    String getKode[]; 
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL      = "jdbc:mysql://localhost/koperasipegawai";
    static final String USER        = "root";
    static final String PASS        = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelManager(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            
            
            getKode = new String[getBanyakData()];
            getKodeProduk();
            
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public String[][] getDataTotalPemasukan(){
        try{

            int total = 0;
            String data[][] = new String[getBanyakData()][5];
            
            statement = koneksi.createStatement();
            
            for(int a=0; a<getBanyakData(); a++){
                
            System.out.println(getKode[a]+ " cek");
            
            String query = "SELECT namaproduk,SUM(jumlah),hargaproduk,SUM(hargaproduk*jumlah) FROM transaksi WHERE kodeproduk = '"+getKode[a]+"'";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data[a][0] = getKode[a];
                data[a][1] = (resultSet.getString(1));
                data[a][2] = (resultSet.getString(2));
                data[a][3] = (resultSet.getString(3));
                data[a][4] = (resultSet.getString(4));
                
                System.out.print(data[a][0] + " ");
                System.out.print(data[a][1] + " ");
                System.out.print(data[a][2] + " ");
                System.out.print(data[a][3] + " ");
                System.out.println(data[a][4] + " ");
                
                total = (total + Integer.parseInt(data[a][4]));
            }
            
            }
            
            getTotal = String.valueOf(total);
            return data;
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
        
        return null;
    }
    
    
    public void getKodeProduk(){
        try{
            int a=0;
            statement = koneksi.createStatement();
            
            String query = "SELECT * FROM produk";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                String kode = resultSet.getString(1);
                getKode[a] = kode;
                a++;
                //getDataTotalPemasukan(kode);
            }
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }

    
    public int getBanyakData(){
        int a=0;
        try{
            statement = koneksi.createStatement();
            
            String query = "SELECT * FROM `produk`";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                a++;
            }
            return a;
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
        return 0;
    }
    
}
