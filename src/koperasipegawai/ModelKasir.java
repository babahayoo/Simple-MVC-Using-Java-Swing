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
import javax.swing.JOptionPane;

/**
 *
 * @author Administator
 */
public class ModelKasir {
    
    double xtotal=0,xkembali=0;
    String ttl,kembali;
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL      = "jdbc:mysql://localhost/koperasipegawai";
    static final String USER        = "root";
    static final String PASS        = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelKasir(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public String[] TambahKeTabel(String kode,String jml){
        
        try{
            
            statement = koneksi.createStatement();
            
            String query = "SELECT * FROM `produk` WHERE `kodeproduk` = '"+kode+"' ";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            if(resultSet.next()){
                System.out.println(query);
                
                if(kode.equals(resultSet.getString("kodeproduk"))){
                    
                    int xjml = Integer.parseInt(jml);
                    String data[] = {resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),jml.toString()};
                    
                    setTotalBelanja(((Double.parseDouble(resultSet.getString(3)))/2)*xjml);
                    
                    
                    return data;
                    
                }
                
                
            }
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public void setTotalBelanja(double total){
        xtotal = (xtotal + total);
        System.out.println(xtotal+" total blanja");
        ttl = String.valueOf(xtotal);
        
    }
    
    public String getTotalBelanja(){
        return ttl;
    }
    
    public String getKembalian(String uangpbl,String yttl){
        xkembali = (Double.parseDouble(uangpbl) - Double.parseDouble(yttl));
        System.out.println(xkembali+" kembali");
        kembali = String.valueOf(xkembali);
        return kembali;
    }
    
    public void transaksi(String kode,String nama,int harga,int jumlah){
        try{
        String query = "INSERT INTO `transaksi`(`kodeproduk`, `namaproduk`, `hargaproduk`, `jumlah`) " +
                "VALUES ('"+kode+"','"+nama+"',"+harga+","+jumlah+")";
        
        statement = koneksi.createStatement();
        statement.executeUpdate(query);
        System.out.println("Sukses");
        UpdateStok(kode, jumlah);
        
        
        
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
        
    }
    
    public void UpdateStok(String kode,int jumlahDibeli){
        try{
            
        String query = "SELECT * FROM `produk` WHERE `kodeproduk` = '"+kode+"' ";
            System.out.println("cari stok melalui kode = "+kode);
        statement = koneksi.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        
        if(resultSet.next()){
                
                if(kode.equals(resultSet.getString("kodeproduk"))){
                    System.out.println("xx");
                    int stokawal = Integer.parseInt(resultSet.getString("stok"));
                    System.out.println("stok awal "+stokawal+" jumlah dibeli : "+jumlahDibeli);
                    int stokbaru = (stokawal - jumlahDibeli);
                    
                    if(stokbaru < 0){
                        JOptionPane.showMessageDialog(null, "Produk Tidak Mencukupi");
                    }else{
                        
                        query = "UPDATE `produk` SET `stok` = "+stokbaru+" WHERE `kodeproduk` = '"+kode+"'";
                        statement.executeUpdate(query);
                        System.out.println("sukses diupdate");
                    }
                    
                }
        }
        
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    
    
    
}
