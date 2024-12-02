package formKasir;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import konektor.koneksi;


public class formHalamanKasir extends javax.swing.JPanel {

    public formHalamanKasir() {
        initComponents();
        inputNamaProduk.setEditable(false);
        inputHarga.setEditable(false);
        inputIdTransaksi.setEditable(false);
        inputKembalian.setEditable(false);
        inputTotal.setEnabled(false);
        inputIdProduk.requestFocus();
        btnHapus.setEnabled(false);
        
        tabProduk.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && tabProduk.getSelectedRow() != -1) {
                    btnHapus.setEnabled(true);
                } else {
                    btnHapus.setEnabled(false);
                }
            }
        });
    }
    
//  Function Search Product Tab //
    private void searchProduct(){
        
        String keyword = inputIdProduk.getText().trim();
        
        if (keyword.isEmpty()) {
            inputNamaProduk.setText("");
            inputHarga.setText("");
            JOptionPane.showMessageDialog(this, "Kolom pencarian harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try{
            String sql = "SELECT * FROM tb_produk WHERE id_produk ='" + inputIdProduk.getText() + "'";
            Connection conn = koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
            while(rs.next()){
                inputIdProduk.setText(rs.getString("id_produk"));
                inputNamaProduk.setText(rs.getString("nama_produk"));
                inputHarga.setText(rs.getString("harga_jual"));
            }
            
        }catch(Exception e){
            
        }
    }
    
//  Function Search Product End //
    
//  Add Product To Cart //
    private void addProduct(){
        DefaultTableModel tbl = (DefaultTableModel)tabProduk.getModel();
        
        tbl.insertRow(0, new Object[]{
            inputIdProduk.getText(),
            inputNamaProduk.getText(),
            inputHarga.getText(),
            inputJumlah.getText()
        });
        
        inputIdProduk.setText("");
        inputNamaProduk.setText("");
        inputHarga.setText("");
        inputJumlah.setText("");
    }
    
//  Add Product To Cart End // 
    
//  Delete Row in TabProduk //
    private void deleteRow() {
        
        DefaultTableModel tbl = (DefaultTableModel) tabProduk.getModel();
        int selectedRow = tabProduk.getSelectedRow();

        if (selectedRow != -1) {
            tbl.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus!");
        }
}
//  Delete Row in TabProduk End //  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDbKasir = new javax.swing.JLabel();
        bg1 = new javax.swing.JPanel();
        lbProduk = new javax.swing.JLabel();
        inputIdProduk = new javax.swing.JTextField();
        lbNamaProduk = new javax.swing.JLabel();
        inputNamaProduk = new javax.swing.JTextField();
        lbHarga = new javax.swing.JLabel();
        inputHarga = new javax.swing.JTextField();
        lbJumlah = new javax.swing.JLabel();
        inputJumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabProduk = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        bg2 = new javax.swing.JPanel();
        lbTotal = new javax.swing.JLabel();
        inputTotal = new javax.swing.JTextField();
        lbIdTransaksi = new javax.swing.JLabel();
        inputIdTransaksi = new javax.swing.JTextField();
        lbTanggal = new javax.swing.JLabel();
        lbBayar = new javax.swing.JLabel();
        inputBayar = new javax.swing.JTextField();
        lbKembalian = new javax.swing.JLabel();
        inputKembalian = new javax.swing.JTextField();
        btnBayar = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        lbDbKasir.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbDbKasir.setText("Dashboard Kasir");

        bg1.setBackground(new java.awt.Color(255, 255, 255));
        bg1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbProduk.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbProduk.setText("Id Produk");

        inputIdProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIdProdukActionPerformed(evt);
            }
        });

        lbNamaProduk.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbNamaProduk.setText("Nama Produk");

        lbHarga.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbHarga.setText("Harga");

        inputHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputHargaActionPerformed(evt);
            }
        });

        lbJumlah.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbJumlah.setText("Jumlah");

        inputJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputJumlahActionPerformed(evt);
            }
        });

        tabProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Produk", "Nama Produk", "Harga Produk", "Jumlah"
            }
        ));
        jScrollPane1.setViewportView(tabProduk);

        btnTambah.setBackground(new java.awt.Color(51, 51, 255));
        btnTambah.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(51, 51, 255));
        btnSearch.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cari.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(51, 51, 255));
        btnHapus.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bg1Layout = new javax.swing.GroupLayout(bg1);
        bg1.setLayout(bg1Layout);
        bg1Layout.setHorizontalGroup(
            bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                    .addGroup(bg1Layout.createSequentialGroup()
                        .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bg1Layout.createSequentialGroup()
                                .addComponent(inputIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbProduk)
                            .addComponent(lbNamaProduk)
                            .addComponent(lbHarga)
                            .addGroup(bg1Layout.createSequentialGroup()
                                .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbJumlah))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTambah))
                            .addComponent(inputHarga)
                            .addComponent(inputNamaProduk))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        bg1Layout.setVerticalGroup(
            bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbProduk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNamaProduk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHarga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbJumlah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        bg2.setBackground(new java.awt.Color(153, 153, 255));
        bg2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lbTotal.setText("Total Harga");

        inputTotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        inputTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTotalActionPerformed(evt);
            }
        });

        lbIdTransaksi.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbIdTransaksi.setText("Id Transaksi");

        lbTanggal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbTanggal.setText("Tanggal Pembelian");

        lbBayar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbBayar.setText("Bayar");

        inputBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBayarActionPerformed(evt);
            }
        });

        lbKembalian.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbKembalian.setText("Kembalian");

        inputKembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputKembalianActionPerformed(evt);
            }
        });

        btnBayar.setBackground(new java.awt.Color(51, 51, 255));
        btnBayar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setText("Bayar");

        btnPrint.setBackground(new java.awt.Color(51, 51, 255));
        btnPrint.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Print");

        javax.swing.GroupLayout bg2Layout = new javax.swing.GroupLayout(bg2);
        bg2.setLayout(bg2Layout);
        bg2Layout.setHorizontalGroup(
            bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg2Layout.createSequentialGroup()
                        .addComponent(inputTotal)
                        .addContainerGap())
                    .addGroup(bg2Layout.createSequentialGroup()
                        .addGroup(bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTotal)
                            .addGroup(bg2Layout.createSequentialGroup()
                                .addGroup(bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(inputBayar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                            .addComponent(lbIdTransaksi, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inputIdTransaksi, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addComponent(lbBayar))
                                .addGap(18, 18, 18)
                                .addGroup(bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbKembalian)
                                    .addComponent(lbTanggal)
                                    .addComponent(inputKembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(6, 6, 6))))
        );
        bg2Layout.setVerticalGroup(
            bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdTransaksi)
                    .addComponent(lbTanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputIdTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBayar)
                    .addComponent(lbKembalian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDbKasir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDbKasir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bg1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputJumlahActionPerformed
        addProduct();
        inputIdProduk.requestFocus();
    }//GEN-LAST:event_inputJumlahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        addProduct();
        inputIdProduk.requestFocus();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        deleteRow();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void inputBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBayarActionPerformed

    }//GEN-LAST:event_inputBayarActionPerformed

    private void inputHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputHargaActionPerformed

    }//GEN-LAST:event_inputHargaActionPerformed

    private void inputKembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputKembalianActionPerformed

    }//GEN-LAST:event_inputKembalianActionPerformed

    private void inputTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTotalActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        searchProduct();
        inputJumlah.requestFocus();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void inputIdProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIdProdukActionPerformed
        searchProduct();
        inputJumlah.requestFocus();
    }//GEN-LAST:event_inputIdProdukActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg1;
    private javax.swing.JPanel bg2;
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTambah;
    private javax.swing.JTextField inputBayar;
    private javax.swing.JTextField inputHarga;
    private javax.swing.JTextField inputIdProduk;
    private javax.swing.JTextField inputIdTransaksi;
    private javax.swing.JTextField inputJumlah;
    private javax.swing.JTextField inputKembalian;
    private javax.swing.JTextField inputNamaProduk;
    private javax.swing.JTextField inputTotal;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBayar;
    private javax.swing.JLabel lbDbKasir;
    private javax.swing.JLabel lbHarga;
    private javax.swing.JLabel lbIdTransaksi;
    private javax.swing.JLabel lbJumlah;
    private javax.swing.JLabel lbKembalian;
    private javax.swing.JLabel lbNamaProduk;
    private javax.swing.JLabel lbProduk;
    private javax.swing.JLabel lbTanggal;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tabProduk;
    // End of variables declaration//GEN-END:variables
}
