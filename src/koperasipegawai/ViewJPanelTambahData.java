/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasipegawai;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Administator
 */
public class ViewJPanelTambahData extends JPanel{
    
    
    
    JLabel lKodeProduk = new JLabel("Kode Produk    :");
        JTextField tfKodeProduk = new JTextField();
    JLabel lNamaproduk = new JLabel("Nama Produk   :");
        JTextField tfNamaProduk = new JTextField();
    JLabel lHargaProduk = new JLabel("Harga Produk  :");
        JTextField tfHargaProduk = new JTextField();
    JLabel lStokProduk = new JLabel("Stok Produk     :");
        JTextField tfStokProduk = new JTextField();
        
    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnBatalPanel = new JButton("Batal");
        
        public ViewJPanelTambahData(){
            
       
        setVisible(false);
        setLayout(null);
        setSize(300, 110);
        setBackground(Color.white);
            
            add(lKodeProduk);
        lKodeProduk.setBounds(5, 5, 90, 20);
            add(tfKodeProduk);
            tfKodeProduk.setBounds(110, 5, 120, 20);
        add(lNamaproduk);
        lNamaproduk.setBounds(5, 30, 90, 20);
            add(tfNamaProduk);
            tfNamaProduk.setBounds(110, 30, 120, 20);
        add(lHargaProduk);
        lHargaProduk.setBounds(5, 55, 90, 20);
            add(tfHargaProduk);
            tfHargaProduk.setBounds(110, 55, 120, 20);
        add(lStokProduk);
        lStokProduk.setBounds(5, 80, 90, 20);
            add(tfStokProduk);
            tfStokProduk.setBounds(110, 80, 120, 20);
            
        add(btnTambahPanel);
        btnTambahPanel.setBounds(20, 105, 90, 20);
        
        add(btnBatalPanel);
        btnBatalPanel.setBounds(130, 105, 90, 20);
            
        }
        
                
    
}
