package koperasipegawai;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ViewAdmin {
    
    JFrame window = new JFrame("KOPERASI PEGAWAI UPN");
    JLabel ljudul = new JLabel ("KOPERASI PEGAWAI UPN VETERAN YOGYAKARTA");
    JButton btnTambah = new JButton("Tambah");
    JButton btnEdit = new JButton("Edit");
    JButton btnHapus = new JButton("Hapus");
    JButton btnKeluar = new JButton("Keluar");
    Object namaKolom[] = {"Kode","Nama Produk","Harga","Stok"};
    
    
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    
    ViewJPanelTambahData panelTambahData = new ViewJPanelTambahData();
    
    public ViewAdmin(){
        
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
        
        window.add(panelTambahData).setBounds(50, 405, 240, 130);
        panelTambahData.setVisible(false);
        
        window.add(ljudul);
        ljudul.setBounds(60, 5, 750, 30);
        ljudul.setFont(new Font("Poor Richard", Font.BOLD, 30));
        
        //TABEL
        window.add(scrollPane);
        scrollPane.setBounds(50, 60, 800, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //BUTTON
        window.add(btnTambah);
        btnTambah.setBounds(50, 380, 90, 20);
        
        window.add(btnEdit);
        btnEdit.setBounds(150, 380, 90, 20);
        btnEdit.setEnabled(false);
        
        window.add(btnHapus);
        btnHapus.setBounds(250, 380, 90, 20);
        btnHapus.setEnabled(false);
        
        window.add(btnKeluar);
        btnKeluar.setBounds(805,545,80,20);
        
        
        
    }
    
}
