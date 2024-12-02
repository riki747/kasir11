/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package formAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import konektor.koneksi;

public class formProfile extends javax.swing.JPanel {

//    private int userId;

    public formProfile(String userId) {
        initComponents();
        getProfile(userId);
    }
    
//  set profil user yang login //
    private void getProfile(String userId){
        String query = "SELECT * FROM user WHERE id_user=?";
        
         try {
            Connection conn = koneksi.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, userId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                idUser.setText(rs.getString("id_user"));
                namaUser.setText(rs.getString("nama_user"));
                emailUser.setText(rs.getString("email_user"));
                roleUser.setText(rs.getString("role"));
                usernameUser.setText(rs.getString("username_user"));
                passwordUser.setText("******"); 
            } else {
                JOptionPane.showMessageDialog(null, "Data user tidak ditemukan!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
//  set profil user yang login end //
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbHead = new javax.swing.JLabel();
        bgContent = new javax.swing.JPanel();
        iconUser = new javax.swing.JLabel();
        bgUser = new javax.swing.JPanel();
        lbIdUser = new javax.swing.JLabel();
        pnId = new javax.swing.JPanel();
        idUser = new javax.swing.JLabel();
        lbNamaUser = new javax.swing.JLabel();
        pnNama = new javax.swing.JPanel();
        namaUser = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        pnRole = new javax.swing.JPanel();
        roleUser = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        pnEmail = new javax.swing.JPanel();
        emailUser = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        pnUsername = new javax.swing.JPanel();
        usernameUser = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        pnPassword = new javax.swing.JPanel();
        passwordUser = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbHead.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbHead.setText("Profile Admin");

        bgContent.setBackground(new java.awt.Color(255, 255, 255));
        bgContent.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        iconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Admin-removebg-preview.png"))); // NOI18N

        bgUser.setBackground(new java.awt.Color(255, 255, 255));
        bgUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbIdUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbIdUser.setText("Id User");

        pnId.setBackground(new java.awt.Color(255, 255, 255));
        pnId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        idUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        idUser.setText("Id");

        javax.swing.GroupLayout pnIdLayout = new javax.swing.GroupLayout(pnId);
        pnId.setLayout(pnIdLayout);
        pnIdLayout.setHorizontalGroup(
            pnIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnIdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idUser)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        pnIdLayout.setVerticalGroup(
            pnIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnIdLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(idUser)
                .addContainerGap())
        );

        lbNamaUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbNamaUser.setText("Nama");

        pnNama.setBackground(new java.awt.Color(255, 255, 255));
        pnNama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        namaUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        namaUser.setText("Nama");

        javax.swing.GroupLayout pnNamaLayout = new javax.swing.GroupLayout(pnNama);
        pnNama.setLayout(pnNamaLayout);
        pnNamaLayout.setHorizontalGroup(
            pnNamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNamaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnNamaLayout.setVerticalGroup(
            pnNamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNamaLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(namaUser)
                .addContainerGap())
        );

        lbRole.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbRole.setText("Role");

        pnRole.setBackground(new java.awt.Color(255, 255, 255));
        pnRole.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        roleUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        roleUser.setText("Role");

        javax.swing.GroupLayout pnRoleLayout = new javax.swing.GroupLayout(pnRole);
        pnRole.setLayout(pnRoleLayout);
        pnRoleLayout.setHorizontalGroup(
            pnRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRoleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roleUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnRoleLayout.setVerticalGroup(
            pnRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRoleLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(roleUser)
                .addContainerGap())
        );

        lbEmail.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbEmail.setText("Email");

        pnEmail.setBackground(new java.awt.Color(255, 255, 255));
        pnEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        emailUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        emailUser.setText("Email");

        javax.swing.GroupLayout pnEmailLayout = new javax.swing.GroupLayout(pnEmail);
        pnEmail.setLayout(pnEmailLayout);
        pnEmailLayout.setHorizontalGroup(
            pnEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emailUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnEmailLayout.setVerticalGroup(
            pnEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEmailLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(emailUser)
                .addContainerGap())
        );

        lbUsername.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbUsername.setText("Username");

        pnUsername.setBackground(new java.awt.Color(255, 255, 255));
        pnUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        usernameUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        usernameUser.setText("Username");

        javax.swing.GroupLayout pnUsernameLayout = new javax.swing.GroupLayout(pnUsername);
        pnUsername.setLayout(pnUsernameLayout);
        pnUsernameLayout.setHorizontalGroup(
            pnUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUsernameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usernameUser)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        pnUsernameLayout.setVerticalGroup(
            pnUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUsernameLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(usernameUser)
                .addContainerGap())
        );

        lbPassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lbPassword.setText("Password");

        pnPassword.setBackground(new java.awt.Color(255, 255, 255));
        pnPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        passwordUser.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        passwordUser.setText("Password");

        javax.swing.GroupLayout pnPasswordLayout = new javax.swing.GroupLayout(pnPassword);
        pnPassword.setLayout(pnPasswordLayout);
        pnPasswordLayout.setHorizontalGroup(
            pnPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(passwordUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnPasswordLayout.setVerticalGroup(
            pnPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPasswordLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(passwordUser)
                .addContainerGap())
        );

        javax.swing.GroupLayout bgUserLayout = new javax.swing.GroupLayout(bgUser);
        bgUser.setLayout(bgUserLayout);
        bgUserLayout.setHorizontalGroup(
            bgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbIdUser, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbNamaUser, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbRole, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbEmail, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbUsername, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnRole, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbPassword))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        bgUserLayout.setVerticalGroup(
            bgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIdUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNamaUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgContentLayout = new javax.swing.GroupLayout(bgContent);
        bgContent.setLayout(bgContentLayout);
        bgContentLayout.setHorizontalGroup(
            bgContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContentLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(iconUser)
                .addGap(18, 18, 18)
                .addComponent(bgUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bgContentLayout.setVerticalGroup(
            bgContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContentLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(bgContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bgUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bgContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbHead)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHead)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bgContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgContent;
    private javax.swing.JPanel bgUser;
    private javax.swing.JLabel emailUser;
    private javax.swing.JLabel iconUser;
    private javax.swing.JLabel idUser;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbHead;
    private javax.swing.JLabel lbIdUser;
    private javax.swing.JLabel lbNamaUser;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JLabel namaUser;
    private javax.swing.JLabel passwordUser;
    private javax.swing.JPanel pnEmail;
    private javax.swing.JPanel pnId;
    private javax.swing.JPanel pnNama;
    private javax.swing.JPanel pnPassword;
    private javax.swing.JPanel pnRole;
    private javax.swing.JPanel pnUsername;
    private javax.swing.JLabel roleUser;
    private javax.swing.JLabel usernameUser;
    // End of variables declaration//GEN-END:variables
}
