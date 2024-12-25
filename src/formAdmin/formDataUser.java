package formAdmin;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import koneksi.koneksidb;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class formDataUser extends javax.swing.JPanel {

    public formDataUser() {
        initComponents();
        loadDataUser();
        
//      Menonaktifkan tombol Edit dan Delete saat pertama kali dibuka
       
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);

//      Menambahkan ListSelectionListener ke tabel
        tabUSer.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // Cek jika ada baris yang dipilih
                if (!event.getValueIsAdjusting() && tabUSer.getSelectedRow() != -1) {
                    
                    btnHapus.setEnabled(true);
                    btnBatal.setEnabled(true);
                    
                } else {

                    btnHapus.setEnabled(false);
                    btnBatal.setEnabled(false);
                    
                }
            }
        });
    }

// Load Data User //
    private void loadDataUser() {
        DefaultTableModel model = (DefaultTableModel) tabUSer.getModel();
        model.setRowCount(0); // Reset tabel

        try {
            Connection con = koneksidb.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT id_user, username, password, role, fullname, email, no_telepon,alamat FROM user"; 
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String idUser = rs.getString("id_user");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String no_telepon = rs.getString("no_telepon");
                String alamat = rs.getString("alamat");

     
                
                // Tambahkan data ke model tabel
                model.addRow(new Object[]{idUser, username, password, role, fullname, email, no_telepon, alamat});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
//  Load Data User end //   
    
//  Fungsi edit data user //
//    private void editDataUser(){
//        int selectedRow = tabUSer.getSelectedRow();
//        if (selectedRow != -1) {
//            String idUser = tabUSer.getValueAt(selectedRow, 0).toString();
//            String nama = tabUSer.getValueAt(selectedRow, 1).toString();
//            String role = tabUSer.getValueAt(selectedRow, 2).toString();
//            String email = tabUSer.getValueAt(selectedRow, 3).toString();
//            String username = tabUSer.getValueAt(selectedRow, 4).toString();
//            String password = tabUSer.getValueAt(selectedRow, 5).toString();
//
//            // Buka form edit dengan data pengguna yang dipilih
//            formEditUser editUserForm = new formEditUser(idUser, nama, role, email, username, password);
//            editUserForm.addWindowListener(new java.awt.event.WindowAdapter() {
//                @Override
//                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
//                    // Muat ulang data tabel setelah form edit ditutup
//                    loadDataUser();
//                }
//            });
//            editUserForm.setVisible(true);
//            
//        }
//    }
        
    private void editDataUser() {
        int selectedRow = tabUSer.getSelectedRow();
        if (selectedRow != -1) {
            String idUser = tabUSer.getValueAt(selectedRow, 0).toString();
            String username = tabUSer.getValueAt(selectedRow, 1).toString();
            String password = tabUSer.getValueAt(selectedRow, 2).toString();
            String role = tabUSer.getValueAt(selectedRow, 3).toString();
            String fullname = tabUSer.getValueAt(selectedRow, 4).toString();
            String email = tabUSer.getValueAt(selectedRow, 5).toString();
            String no_telepon = tabUSer.getValueAt(selectedRow, 6).toString();
            String alamat = tabUSer.getValueAt(selectedRow, 7).toString();

            // Buka form edit dengan data pengguna yang dipilih
            formEditUser editUserForm = new formEditUser(idUser, username, password, role, fullname, email, no_telepon, alamat);
            editUserForm.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    // Muat ulang data tabel setelah form edit ditutup
                    loadDataUser();

                    // Reset tombol ke "TAMBAH" setelah selesai ubah
                    btnTambah.setText("TAMBAH");
                }
            });
            editUserForm.setVisible(true);
        }
    }

//  Fungsi edit data user end //    
    
//  hapus data user //    
    private void hapusDataUser(){
        int selectedRow = tabUSer.getSelectedRow();
        if (selectedRow != -1) {
            String idUser = tabUSer.getValueAt(selectedRow, 0).toString();
            // Konfirmasi dan hapus data dari database berdasarkan ID
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus user ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Connection con = koneksidb.getConnection();
                    Statement st = con.createStatement();
                    String deleteQuery = "DELETE FROM user WHERE id_user = '" + idUser + "'";
                    st.executeUpdate(deleteQuery);
                    loadDataUser();
                    JOptionPane.showMessageDialog(this, "Data user berhasil dihapus.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data.");
                }
            }
        }
    }
//  ungsi hapus data user end //   
    
//  Fungsi seacrh user //
    private void searchUser() {
        String keyword = jTextField1.getText().trim();
        DefaultTableModel model = (DefaultTableModel) tabUSer.getModel();

        if (keyword.isEmpty()) {
            // Jika keyword kosong, tampilkan pesan dan muat ulang data asli
            loadDataUser();
            JOptionPane.showMessageDialog(this, "Kolom pencarian harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Reset tabel sebelum menampilkan hasil pencarian
        model.setRowCount(0);

        try {
            Connection con = koneksidb.getConnection();
            Statement st = con.createStatement();

            // Query untuk mencari data user berdasarkan ID, Nama, atau Email yang cocok dengan kata kunci
            String query = "SELECT id_user, username, password, role, fullname, email, no_telepon,alamat "
                    + "FROM user WHERE id_user LIKE '%" + keyword + "%'"
                    + "OR username LIKE '%" + keyword + "%' "
                    + "OR email LIKE '%" + keyword + "%'";

            ResultSet rs = st.executeQuery(query);

            // Jika data ditemukan, tambahkan ke model tabel
            while (rs.next()) {
                String idUser = rs.getString("id_user");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String no_telepon = rs.getString("no_telepon");
                String alamat = rs.getString("alamat");

                model.addRow(new Object[]{idUser, username, password, role, fullname, email, no_telepon, alamat});
            }

            // Pesan jika tidak ada data ditemukan
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Data user tidak ditemukan.", "Pencarian", JOptionPane.INFORMATION_MESSAGE);
                loadDataUser(); // Tampilkan kembali data asli jika tidak ada hasil
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mencari data.");
        }
    }
//  search user//    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDataUser = new javax.swing.JLabel();
        bgDataUSer = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabUSer = new javax.swing.JTable();
        btnBatal = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lbDataUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbDataUser.setText("Data User");

        bgDataUSer.setBackground(new java.awt.Color(255, 255, 255));
        bgDataUSer.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnTambah.setBackground(new java.awt.Color(51, 51, 255));
        btnTambah.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
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

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(51, 51, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cari.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tabUSer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id User", "Username", "Password", "Role", "Fullname", "Email", "No telepon", "Alamat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabUSer.setGridColor(new java.awt.Color(0, 0, 0));
        tabUSer.setSelectionBackground(new java.awt.Color(51, 51, 255));
        tabUSer.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabUSer.setShowGrid(false);
        tabUSer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabUSerMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tabUSerMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(tabUSer);

        btnBatal.setBackground(new java.awt.Color(51, 51, 255));
        btnBatal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgDataUSerLayout = new javax.swing.GroupLayout(bgDataUSer);
        bgDataUSer.setLayout(bgDataUSerLayout);
        bgDataUSerLayout.setHorizontalGroup(
            bgDataUSerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgDataUSerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgDataUSerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgDataUSerLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(bgDataUSerLayout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(btnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)
                        .addGap(37, 37, 37))))
        );
        bgDataUSerLayout.setVerticalGroup(
            bgDataUSerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgDataUSerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(bgDataUSerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgDataUSerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bgDataUSer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDataUser)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDataUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bgDataUSer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (btnTambah.getText().equals("Tambah")) {
        // Logika untuk tambah data
        formTambahUser tambahuser = new formTambahUser();
        tambahuser.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Muat ulang data tabel setelah form tambah ditutup
                loadDataUser();
            }
        });
        tambahuser.setVisible(true);
    } else if (btnTambah.getText().equals("Ubah")) {
        // Logika untuk ubah data
        editDataUser();
    }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        searchUser();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapusDataUser();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        searchUser();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tabUSerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabUSerMouseClicked
        // TODO add your handling code here:
        int selectedRow = tabUSer.getSelectedRow(); // Ambil baris yang diklik
    if (selectedRow != -1) {
        // Ubah teks tombol menjadi "UBAH"
        btnTambah.setText("Ubah");
    }
    }//GEN-LAST:event_tabUSerMouseClicked

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        loadDataUser();
        int selectedRow = tabUSer.getSelectedRow();
        if (selectedRow == -1) {
            btnTambah.setText("Tambah");
        }
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tabUSerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabUSerMouseExited
        // TODO add your handling code here:
        int selectedRow = tabUSer.getSelectedRow();
    if (selectedRow == -1) {
        btnTambah.setText("Tambah");
    }
    }//GEN-LAST:event_tabUSerMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgDataUSer;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbDataUser;
    private javax.swing.JTable tabUSer;
    // End of variables declaration//GEN-END:variables
}
