/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author rfid
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        setAppIcon();
    }

    private void setAppIcon() {
        String iconPath = "/Img/Logo_RFID_NAMVIET-01.jpg";
        java.net.URL iconURL = getClass().getResource(iconPath);

        if (iconURL != null) {
            try {
                ImageIcon icon = new ImageIcon(iconURL);
                this.setIconImage(icon.getImage());
            } catch (Exception e) {
                System.err.println("Lỗi khi đọc hình ảnh: " + e.getMessage());
            }
        } else {
            System.err.println("Không thể tìm thấy tài nguyên hình ảnh tại " + iconPath);
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_PhanCongCongViec = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_qc = new javax.swing.JButton();
        btn_tao_du_lieu_GS1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_PhanCongCongViec.setText("Phân Công Công Việc");
        btn_PhanCongCongViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PhanCongCongViecActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Ứng dụng phòng RFID");

        btn_qc.setText("QC");
        btn_qc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_qcActionPerformed(evt);
            }
        });

        btn_tao_du_lieu_GS1.setText("Tạo Dữ liêu");
        btn_tao_du_lieu_GS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tao_du_lieu_GS1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btn_PhanCongCongViec)
                .addGap(34, 34, 34)
                .addComponent(btn_tao_du_lieu_GS1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btn_qc)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_PhanCongCongViec)
                    .addComponent(btn_tao_du_lieu_GS1)
                    .addComponent(btn_qc))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_PhanCongCongViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PhanCongCongViecActionPerformed
        // TODO add your handling code here:
        PhanCongCV phanCong = new PhanCongCV();
        phanCong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        phanCong.setVisible(true);
    }//GEN-LAST:event_btn_PhanCongCongViecActionPerformed

    private void btn_qcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_qcActionPerformed
        // TODO add your handling code here:
        QC ac = new QC();
        ac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ac.setVisible(true);
    }//GEN-LAST:event_btn_qcActionPerformed

    private void btn_tao_du_lieu_GS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tao_du_lieu_GS1ActionPerformed
        // TODO add your handling code here:
        ChuyenDoiUpc chuyenDoiUPC = new ChuyenDoiUpc();
        chuyenDoiUPC.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chuyenDoiUPC.setVisible(true);
    }//GEN-LAST:event_btn_tao_du_lieu_GS1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            // Set the Look and Feel to Nimbus
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_PhanCongCongViec;
    private javax.swing.JButton btn_qc;
    private javax.swing.JButton btn_tao_du_lieu_GS1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
