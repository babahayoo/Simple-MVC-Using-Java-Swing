/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasipegawai;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administator
 */
public class ViewManager {
    
    JFrame window = new JFrame("KOPERASI PEGAWAI UPN");
    JLabel ljudul = new JLabel ("KOPERASI PEGAWAI UPN VETERAN YOGYAKARTA");
    
    JButton btnKeluar = new JButton("Keluar");
    Object namaKolom[] = {"Kode","Nama Produk","Harga","Terjual","Pemasukan"};
    
    JLabel lOmset = new JLabel("Omset  : ");
        JTextField tfOmset = new JTextField();
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    
    public ViewManager(){
        
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        initComponents();
        
        
        window.setLayout(null);
        window.setSize(900,600);
        window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }
    
    public void initComponents(){
        
        window.add(ljudul);
        ljudul.setBounds(60, 5, 750, 30);
        ljudul.setFont(new Font("Poor Richard", Font.BOLD, 30));
        
        //TABEL
        window.add(scrollPane);
        scrollPane.setBounds(50, 60, 800, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //BUTTON
        
        
        window.add(btnKeluar);
        btnKeluar.setBounds(805,545,80,20);
        
        window.add(lOmset);
        lOmset.setBounds(605,380,50,20);
            window.add(tfOmset);
            tfOmset.setBounds(655, 380, 180, 20);
        
        
        
    }
    
}
