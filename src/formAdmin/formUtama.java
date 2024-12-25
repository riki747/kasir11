
package formAdmin;
import formLogin.Login;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.util.Date;

public class formUtama extends javax.swing.JFrame {

    private String UserId;
    private String Username;
    private String Password; 
    private String Role;
    private String Fullname;
    private String Email;
    private String Notelepon;
    private String Alamat;
    
//  set nama user yang login start //    
    public void setUser(String UserId, String Username, String Password, String Role, String Fullname, String Email, String Notelepon, String Alamat) {

        this.UserId = UserId;
        this.Username = Username;
        this.Password = Password;
        this.Role = Role;
        this.Fullname = Fullname;
        this.Email = Email;
        this.Notelepon = Notelepon;
        this.Alamat = Alamat;

        lb_u.setText("Selamat Datang, " + this.Username ); // Perbarui label
    }

    
    public formUtama() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        execute();
        Date();
       
    }

//  set nama user yang login end //

//  set menu item //
    private void execute() {
        // icon list//
        ImageIcon iconHome = new ImageIcon(getClass().getResource("/image/home.png"));
        ImageIcon iconProfile = new ImageIcon(getClass().getResource("/image/profile.png"));
        ImageIcon iconDataUser = new ImageIcon(getClass().getResource("/image/data user.png"));
        ImageIcon iconDataProduk = new ImageIcon(getClass().getResource("/image/data barang.png"));
        ImageIcon iconTransaksi = new ImageIcon(getClass().getResource("/image/transaksi.png"));
        ImageIcon iconLogout = new ImageIcon(getClass().getResource("/image/logout.png"));

        
//      Set menu list // 
        
        formMenuList menuHome = new formMenuList(iconHome, false, null, "Home", (ActionEvent e) -> {
            isiContent.removeAll();
            isiContent.add(new formHome());
            isiContent.repaint();
            isiContent.revalidate();
        });
        formMenuList menuProfile = new formMenuList(iconProfile, false, null, "Profil", (ActionEvent e) ->{
            isiContent.removeAll();
            isiContent.add(new formProfile(UserId));
            isiContent.repaint();
            isiContent.revalidate();
        });
        formMenuList menuDataUser = new formMenuList(iconDataUser, false, null, "Data User", (ActionEvent e) -> {
            isiContent.removeAll();
            isiContent.add(new formDataUser());
            isiContent.repaint();
            isiContent.revalidate();
        });
        formMenuList menuDataProduk = new formMenuList(iconDataProduk, false, null, "Data Produk", (ActionEvent e) -> {
            isiContent.removeAll();
            isiContent.add(new formDataProduk());
            isiContent.repaint();
            isiContent.revalidate();
        });
        formMenuList menuTransaksi = new formMenuList(iconTransaksi, false, null, "Riwayat", (ActionEvent e) -> {
            isiContent.removeAll();
            isiContent.add(new formRTransaksi());
            isiContent.repaint();
            isiContent.revalidate();
        });
        
        formMenuList menuLogout = new formMenuList(iconLogout, false, null, "Logout", (ActionEvent e) -> {
            Login login = new Login();
            login.setVisible(true);
            dispose();
        });
        
        listMenuItem.add(menuHome);
        listMenuItem.add(menuProfile);
        listMenuItem.add(menuDataUser);
        listMenuItem.add(menuDataProduk);
        listMenuItem.add(menuTransaksi);
        listMenuItem.add(menuLogout);
        
        listMenuItem.revalidate();
        listMenuItem.repaint();
    }
    
//  set menu item end //
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        header1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_u = new javax.swing.JLabel();
        lb_tanggal = new javax.swing.JLabel();
        listMenu = new javax.swing.JPanel();
        listMenuItem = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        isiContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        header.setPreferredSize(new java.awt.Dimension(842, 100));

        header1.setBackground(new java.awt.Color(255, 255, 255));
        header1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/market-icons-15733-removebg-preview.png"))); // NOI18N
        jLabel1.setText("Toko Kami");

        lb_u.setFont(new java.awt.Font("News701 BT", 0, 14)); // NOI18N
        lb_u.setText("Nama User");

        lb_tanggal.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        lb_tanggal.setText("Tanggal");

        javax.swing.GroupLayout header1Layout = new javax.swing.GroupLayout(header1);
        header1.setLayout(header1Layout);
        header1Layout.setHorizontalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(90, 90, 90)
                .addComponent(lb_u)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, Short.MAX_VALUE)
                .addComponent(lb_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        header1Layout.setVerticalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header1Layout.createSequentialGroup()
                        .addGroup(header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_u)
                            .addComponent(lb_tanggal))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        listMenu.setPreferredSize(new java.awt.Dimension(255, 449));

        listMenuItem.setBackground(new java.awt.Color(153, 153, 255));
        listMenuItem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listMenuItem.setLayout(new javax.swing.BoxLayout(listMenuItem, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout listMenuLayout = new javax.swing.GroupLayout(listMenu);
        listMenu.setLayout(listMenuLayout);
        listMenuLayout.setHorizontalGroup(
            listMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listMenuItem, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        listMenuLayout.setVerticalGroup(
            listMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listMenuItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(listMenu, java.awt.BorderLayout.LINE_START);

        isiContent.setBackground(new java.awt.Color(255, 255, 255));
        isiContent.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        isiContent.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(isiContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(isiContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(content, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        isiContent.add(new formHome());
        isiContent.repaint();
        isiContent.revalidate();
    }//GEN-LAST:event_formWindowOpened

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel content;
    private javax.swing.JPanel header;
    private javax.swing.JPanel header1;
    private javax.swing.JPanel isiContent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_tanggal;
    private javax.swing.JLabel lb_u;
    private javax.swing.JPanel listMenu;
    private javax.swing.JPanel listMenuItem;
    // End of variables declaration//GEN-END:variables

    private void Date() {
        Date TanggalSekarang = new Date();
        SimpleDateFormat TanggalWaktu = new SimpleDateFormat("dd - MM - yyyy");
        String tanggal = TanggalWaktu.format(TanggalSekarang);
        lb_tanggal.setText(tanggal);
    }
}
