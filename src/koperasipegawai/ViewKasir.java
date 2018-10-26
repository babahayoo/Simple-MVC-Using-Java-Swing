package koperasipegawai;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ViewKasir {
    
    private String kodeProduk,uangPembeli;
    
    JFrame window = new JFrame("KOPERASI PEGAWAI UPN");
    JLabel ljudul = new JLabel ("KOPERASI PEGAWAI UPN VETERAN YOGYAKARTA");
    JLabel lKodeProduk = new JLabel("Kode Produk    :");
        JTextField tfKodeProduk = new JTextField();
    JLabel lJumlahDibeli = new JLabel("Jumlah Dibeli :");
        JTextField tfJumlahDibeli = new JTextField();
    JLabel lUangPembeli = new JLabel("Uang Dibayarkan  :");
        JTextField tfUangPembeli = new JTextField();
    JLabel lUangKembalian = new JLabel("Uang Kembali  :");
        JTextField tfUangKembalian = new JTextField();
    JLabel lTotalBelanja = new JLabel("Total  : ");
        JTextField tfTotalBelanja = new JTextField();
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    
    JButton btnTambah = new JButton("Tambah");
    JButton btnHapus = new JButton("Hapus");
    JButton btnBayar = new JButton("Bayar");
    JButton btnBatal = new JButton("Batal");
    JButton btnKeluar = new JButton("Keluar");
    
    public ViewKasir(){
        Object namaKolom[] = {"Kode","Nama Produk","Harga","Jumlah"};
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
        
        //Inputan Data
        window.add(lKodeProduk);
        lKodeProduk.setBounds(5, 380, 90, 20);
            window.add(tfKodeProduk);
            tfKodeProduk.setBounds(110, 380, 120, 20);
        window.add(lJumlahDibeli);
        lJumlahDibeli.setBounds(5, 405, 90, 20);
            window.add(tfJumlahDibeli);
            tfJumlahDibeli.setBounds(110, 405, 120, 20);

        
            
                        window.add(lTotalBelanja);
                        lTotalBelanja.setBounds(605,380,50,20);
                            window.add(tfTotalBelanja);
                            tfTotalBelanja.setBounds(655, 380, 180, 20);
                        window.add(lUangPembeli);
                        lUangPembeli.setBounds(537, 405, 110, 20);
                            window.add(tfUangPembeli);
                            tfUangPembeli.setBounds(655, 405, 180, 20);
                        window.add(lUangKembalian);
                        lUangKembalian.setBounds(555, 430, 90, 20);
                            window.add(tfUangKembalian);
                            tfUangKembalian.setBounds(655, 430, 180, 20);
        
        //Button
        window.add(btnTambah);
        btnTambah.setBounds(45, 445, 80, 20);
        window.add(btnHapus);
        btnHapus.setBounds(150, 445, 80, 20);
        btnHapus.setEnabled(false);
        
        window.add(btnBayar);
        btnBayar.setBounds(340,520,80,30);
        window.add(btnBatal);
        btnBatal.setBounds(445,520,80,30);
        window.add(btnKeluar);
        btnKeluar.setBounds(805,545,80,20);
    }

    public String getKodeProduk() {
        return tfKodeProduk.getText();
    }
    
    public String getJumlahDibeli() {
        return tfJumlahDibeli.getText();
    }

    public String getUangPembeli() {
        return tfUangPembeli.getText();
    }
    
    
    
}
