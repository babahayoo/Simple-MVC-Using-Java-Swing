/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasipegawai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Administator
 */
public class ControllerKasir {
    int baris;
    
    ModelKasir modelKasir;
    ViewKasir viewKasir;
    
    public ControllerKasir(ModelKasir modelKasir,ViewKasir viewKasir){
        this.modelKasir = modelKasir;
        this.viewKasir = viewKasir;
        
        viewKasir.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                try{
                    if(viewKasir.tfKodeProduk.getText().equals("")|| viewKasir.tfJumlahDibeli.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
                    }else if(modelKasir.TambahKeTabel(viewKasir.getKodeProduk(),viewKasir.getJumlahDibeli()) != null){
                        
                        viewKasir.tableModel.addRow(modelKasir.TambahKeTabel(viewKasir.getKodeProduk(),viewKasir.getJumlahDibeli()));
                        viewKasir.tfTotalBelanja.setText(modelKasir.getTotalBelanja());
                        
                        viewKasir.tfKodeProduk.setText("");
                        viewKasir.tfJumlahDibeli.setText("");
                        
                    }else
                        JOptionPane.showMessageDialog(null, "Produk Tidak Ada");
                
                }catch(ArrayIndexOutOfBoundsException aex){
                    System.out.println(aex.getMessage());
                }
            }
            
            
            
        });
        
        viewKasir.btnBayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    
                    if(viewKasir.tfTotalBelanja.getText().equals("") || viewKasir.tfUangPembeli.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Lakukan Transaksi Dengan Benar !");
                    }else{
                        if(Double.parseDouble(modelKasir.getKembalian(viewKasir.tfUangPembeli.getText(),viewKasir.tfTotalBelanja.getText())) <= 0){
                            
                            JOptionPane.showMessageDialog(null, "Uang Anda Kurang!");
                            
                        }else{
                            
                            viewKasir.tfUangKembalian.setText(modelKasir.getKembalian(viewKasir.tfUangPembeli.getText(),viewKasir.tfTotalBelanja.getText()));
                            
                            int input = JOptionPane.showConfirmDialog(null, "Konfirmasi Pembayaran?","",JOptionPane.YES_NO_OPTION);
                            System.out.println(input);
                            
                            switch(input){
                                case 0 : JOptionPane.showMessageDialog(null, "Terimakasih , Uang Kembalian Anda Rp."+modelKasir.getKembalian(viewKasir.tfUangPembeli.getText(),viewKasir.tfTotalBelanja.getText()));
                                         
                                         for(int a=0; a<viewKasir.tableModel.getRowCount(); a++){
                                             String kd = viewKasir.tableModel.getValueAt(a, 0).toString();
                                             String nm = viewKasir.tableModel.getValueAt(a, 1).toString();
                                             int hrg = Integer.parseInt(viewKasir.tableModel.getValueAt(a, 2).toString());
                                             int jml = Integer.parseInt(viewKasir.tableModel.getValueAt(a, 3).toString());
                                             
                                             modelKasir.transaksi(kd, nm, hrg, jml);
                                            
                                             
                                             
                                         }
                                         viewKasir.window.dispose();
                                         MVC_Kasir mvck = new MVC_Kasir();
                                         
                                
                                         break;
                            }
                        }
                    }
                    
                }catch(Exception ex){
                    
                }
            }
        });
        
        viewKasir.tabel.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent me){
                
                try{
                    baris = viewKasir.tabel.getSelectedRow();
                    
                    
                    viewKasir.btnHapus.setEnabled(true);
                    
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                
            }
        
        
        });
        
        viewKasir.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                int xhrg = (Integer.parseInt(viewKasir.tableModel.getValueAt(baris, 2).toString()))*(Integer.parseInt(viewKasir.tableModel.getValueAt(baris, 3).toString()));
                
                viewKasir.tfTotalBelanja.setText((Double.parseDouble(viewKasir.tfTotalBelanja.getText()) - xhrg)+"");
                viewKasir.tableModel.removeRow(baris);
                
                viewKasir.btnHapus.setEnabled(false);
            }
        });
        
        
        viewKasir.btnBatal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                int input = JOptionPane.showConfirmDialog(null, "Apa Anda Yakin?","",JOptionPane.YES_NO_OPTION);
                
                switch(input){
                    case 0 :
                        
                        if(viewKasir.tableModel.getRowCount() > 0){
                           for(int a = viewKasir.tableModel.getRowCount()-1; a > -1; a--){
                               viewKasir.tableModel.removeRow(a);
                           }
                        }
                        
                        break;
                }
                
                
            }
        });
        
        viewKasir.btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewKasir.window.dispose();
                MVC_Login mvcl = new MVC_Login();
            }
        });
        
    }
    
}
