package koperasipegawai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerAdmin {
    
    ModelAdmin modelAdmin;
    ViewAdmin viewAdmin;
    ViewJPanelTambahData viewJPanelTambahData;
    
    
    public ControllerAdmin(ModelAdmin modelAdmin,ViewAdmin viewAdmin){
        
        this.modelAdmin = modelAdmin;
        this.viewAdmin = viewAdmin;
        
        String kode;
        
        
        if(modelAdmin.getBanyakData() != 0){
            String databarang[][] = modelAdmin.TampilKeTabel();
            viewAdmin.tabel.setModel((new JTable(databarang, viewAdmin.namaKolom)).getModel());
        }else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        viewAdmin.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                try{
                
                viewAdmin.panelTambahData.setVisible(true);
                
                
                viewAdmin.panelTambahData.btnTambahPanel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(viewAdmin.panelTambahData.tfHargaProduk.equals("") || 
                                viewAdmin.panelTambahData.tfKodeProduk.equals("") || 
                                viewAdmin.panelTambahData.tfNamaProduk.equals("") || 
                                viewAdmin.panelTambahData.tfStokProduk.equals("")){
                            
                            JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong!");
                            
                        }else{
                            
                            try{
                                
                                String kd = viewAdmin.panelTambahData.tfKodeProduk.getText();
                                String nm = viewAdmin.panelTambahData.tfNamaProduk.getText();
                                int hrg = Integer.parseInt(viewAdmin.panelTambahData.tfHargaProduk.getText());
                                int stk = Integer.parseInt(viewAdmin.panelTambahData.tfStokProduk.getText());

                                modelAdmin.TambahProdukBaru(kd, nm, hrg, stk);
                                viewAdmin.panelTambahData.tfNamaProduk.setText("");
                                viewAdmin.panelTambahData.tfKodeProduk.setText("");
                                viewAdmin.panelTambahData.tfStokProduk.setText("");
                                viewAdmin.panelTambahData.tfHargaProduk.setText("");
                                
                                String databarang[][] = modelAdmin.TampilKeTabel();
                                viewAdmin.tabel.setModel((new JTable(databarang, viewAdmin.namaKolom)).getModel());
                                
                                System.out.println("aaa");
                                
                            }catch(NumberFormatException nfe){
                                JOptionPane.showMessageDialog(null, "Inputan Harga dan Stok Harus Angka!");
                            }
                            
                            
                        }
                    }
                });
                
                viewAdmin.panelTambahData.btnBatalPanel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        viewAdmin.panelTambahData.tfNamaProduk.setText("");
                        viewAdmin.panelTambahData.tfKodeProduk.setText("");
                        viewAdmin.panelTambahData.tfStokProduk.setText("");
                        viewAdmin.panelTambahData.tfHargaProduk.setText("");
                        
                        viewAdmin.panelTambahData.setVisible(false);
                    }
                });
                    
                
                
                }catch(Exception nfe){
                    JOptionPane.showMessageDialog(null, "Inputan Harga dan Stok Harus Angka!");
                }
            }
        });
        
        
        viewAdmin.tabel.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent me){
                try{
                    int baris = viewAdmin.tabel.getSelectedRow();
                    int kolom = viewAdmin.tabel.getSelectedColumn();

                    String dataterpilih = viewAdmin.tabel.getValueAt(baris, kolom).toString();
                    String kode2 = viewAdmin.tabel.getValueAt(baris, 0).toString();
                    String nama2 = viewAdmin.tabel.getValueAt(baris, 1).toString();
                    String harga2 = viewAdmin.tabel.getValueAt(baris, 2).toString();
                    String stok2 = viewAdmin.tabel.getValueAt(baris, 3).toString();

                    System.out.println(kode2+" "+nama2+" "+harga2+" "+stok2);
                    
                    viewAdmin.panelTambahData.tfKodeProduk.setText(kode2);
                    viewAdmin.panelTambahData.tfNamaProduk.setText(nama2);
                    viewAdmin.panelTambahData.tfHargaProduk.setText(harga2);
                    viewAdmin.panelTambahData.tfStokProduk.setText(stok2);
                    
                    viewAdmin.btnEdit.setEnabled(true);
                    viewAdmin.btnHapus.setEnabled(true);
                    viewAdmin.panelTambahData.tfKodeProduk.setEditable(false);
                    
                    
                    //PROSESEDIT 
                    viewAdmin.panelTambahData.btnTambahPanel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                        
                            try{
                                
                                String edtNama = viewAdmin.panelTambahData.tfNamaProduk.getText();
                                String edtHarga = viewAdmin.panelTambahData.tfHargaProduk.getText();
                                String edtStok = viewAdmin.panelTambahData.tfStokProduk.getText();
                                
                                if(edtNama.equals("") || edtHarga.equals("") || edtStok.equals("")){
                                    JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong!");
                                }else{
                                    
                                    modelAdmin.edit(kode2,edtNama,edtHarga,edtStok);
                                    
                                    viewAdmin.btnEdit.setEnabled(false);
                                    viewAdmin.btnHapus.setEnabled(false);
                                    
                                    viewAdmin.panelTambahData.tfNamaProduk.setText("");
                                    viewAdmin.panelTambahData.tfKodeProduk.setText("");
                                    viewAdmin.panelTambahData.tfStokProduk.setText("");
                                    viewAdmin.panelTambahData.tfHargaProduk.setText("");

                                    viewAdmin.panelTambahData.setVisible(false);

                                    String databarang[][] = modelAdmin.TampilKeTabel();
                                    viewAdmin.tabel.setModel((new JTable(databarang, viewAdmin.namaKolom)).getModel());
                                    
                                }
                            }catch(Exception ex){
                                System.out.println(ex.getMessage());
                            }
                        }
                    });
                    
                    viewAdmin.panelTambahData.btnBatalPanel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            viewAdmin.panelTambahData.tfNamaProduk.setText("");
                            viewAdmin.panelTambahData.tfKodeProduk.setText("");
                            viewAdmin.panelTambahData.tfStokProduk.setText("");
                            viewAdmin.panelTambahData.tfHargaProduk.setText("");

                            viewAdmin.panelTambahData.setVisible(false);
                        }
                    });
                    
                    //HAPUS DATA
                    viewAdmin.btnHapus.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            int input = JOptionPane.showConfirmDialog(null, "Apa Anda Yakin Menghapus Produk Ini?","'"+kode2+"'",JOptionPane.YES_NO_OPTION);
                            System.out.println(input);
                            switch(input){
                                case 0 :
                                    
                                    modelAdmin.hapus(kode2);
                                    
                                    String databarang[][] = modelAdmin.TampilKeTabel();
                                    viewAdmin.tabel.setModel((new JTable(databarang, viewAdmin.namaKolom)).getModel());
                                    
                                    break;
                            }
                        }
                    });
                    
                    

                    }catch(NullPointerException n){
                        System.out.println(n.getMessage());
                    }
            }
        
        });
        
        viewAdmin.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewAdmin.panelTambahData.setVisible(true);
                viewAdmin.panelTambahData.btnTambahPanel.setText("Edit");
            }
        });
        
        viewAdmin.btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewAdmin.window.dispose();
                MVC_Login mvcl = new MVC_Login();
            }
        });
        
        
    }
    
    
    
}
