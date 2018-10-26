package koperasipegawai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelAdmin {
    
    
    
    String xdt[];
    
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL      = "jdbc:mysql://localhost/koperasipegawai";
    static final String USER        = "root";
    static final String PASS        = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelAdmin(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public String[][] TampilKeTabel(){
        int a=0;
        String data[][] = new String[getBanyakData()][4];

        try{
            statement = koneksi.createStatement();
            
            String query = "SELECT * FROM `produk`";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
               
                data[a][0] = resultSet.getString("kodeproduk");
                
                data[a][1] = resultSet.getString("namaproduk");
                data[a][2] = resultSet.getString("hargaproduk");
                data[a][3] = resultSet.getString("stok");
               
                a++;
            }
            return data;
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
        return null;
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
    
    public void TambahProdukBaru(String kode,String nama,int harga,int stok){
        try{
            
        if(kode.length() != 5){
            JOptionPane.showMessageDialog(null, "Jumlah Digit Kode Harus 5");
        }else{
            
            String query = "INSERT INTO `produk`(`kodeproduk`, `namaproduk`, `hargaproduk`, `stok`) VALUES ('"+kode+"','"+nama+"',"+harga+","+stok+")";
        
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Sukses");

            JOptionPane.showMessageDialog(null, "Tambahkan Produk Baru Sukses!");
            
            
            
            add(kode,nama,String.valueOf(harga),String.valueOf(stok));
            
        }
        
        
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public void add(String kode,String nama,String harga,String stok){
        
        String xdt[] = {kode,nama,harga,stok};
        
        this.xdt = xdt;
        
    }
    
    public String[] getDataBaru(){
        return xdt;
    }
    
    public void edit(String kode,String nama,String harga,String stok){
        try{
            
            statement = koneksi.createStatement();
            
            String query = "UPDATE `produk` SET `kodeproduk`='"+kode+"',`namaproduk`='"+nama+"',"
                    + "`hargaproduk`='"+Integer.parseInt(harga)+"',`stok`='"+Integer.parseInt(stok)+"' WHERE `kodeproduk` = '"+kode+"'";
            
            
            statement.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Edit Data Sukses!");
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void hapus(String kode){
        try{
            
            String query = "DELETE FROM `produk` WHERE `kodeproduk` = '"+kode+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
            
    }
    
}
