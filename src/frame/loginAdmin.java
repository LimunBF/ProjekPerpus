/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import database_admin.ReadAdmin;

/**
 *
 * @author Asus TUF
 */
public class loginAdmin extends javax.swing.JFrame {

    /**
     * Creates new form loginAdmin
     */
    private static final String DEFAULT_USERNAME_TEXT = "Username";
    private static final String DEFAULT_PASSWORD_TEXT = "Password";
    
    public loginAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginText = new javax.swing.JLabel();
        InputUsername = new javax.swing.JTextField();
        inputPassword = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        CreateAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LoginText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        LoginText.setText("LOGIN");

        InputUsername.setText("Username");
        InputUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InputUsernameFocusGained(evt);
            }
        });
        InputUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InputUsernameMouseClicked(evt);
            }
        });

        inputPassword.setText("Password");
        inputPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputPasswordFocusLost(evt);
            }
        });
        inputPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputPasswordMouseClicked(evt);
            }
        });
        inputPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPasswordActionPerformed(evt);
            }
        });

        LoginButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        LoginButton.setText("LOGIN");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        CreateAdmin.setFont(new java.awt.Font("Bebas Neue", 0, 12)); // NOI18N
        CreateAdmin.setText("Create");
        CreateAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(LoginText))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CreateAdmin)
                                .addGap(69, 69, 69)
                                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(InputUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(316, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(LoginText, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(InputUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreateAdmin)
                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        String username = InputUsername.getText();
        String password = new String(inputPassword.getText());

        boolean isValid = ReadAdmin.checkCredentials(username, password);

        if (isValid) {
            // Do something when login is successful
            Menu menuFrame = new Menu();
            menuFrame.setVisible(true);
            dispose();
        } else {
            // Do something when login fails
            System.out.println("Invalid Username or Password");
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void InputUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputUsernameMouseClicked
        // TODO add your handling code here:                                         
        if (InputUsername.getText().equals(DEFAULT_USERNAME_TEXT)) {
            InputUsername.setText("");
        }  
    }//GEN-LAST:event_InputUsernameMouseClicked

    private void InputUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InputUsernameFocusGained
        // TODO add your handling code here:
        if (InputUsername.getText().isEmpty()) {
            InputUsername.setText(DEFAULT_USERNAME_TEXT);
        }
    }//GEN-LAST:event_InputUsernameFocusGained

    private void inputPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPasswordActionPerformed

    private void inputPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputPasswordMouseClicked
        // TODO add your handling code here:
        if (inputPassword.getText().equals(DEFAULT_PASSWORD_TEXT)) {
            inputPassword.setText("");
        }  
    }//GEN-LAST:event_inputPasswordMouseClicked

    private void inputPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPasswordFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPasswordFocusLost

    private void inputPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPasswordFocusGained
        // TODO add your handling code here:
        if (inputPassword.getText().isEmpty()) {
            inputPassword.setText(DEFAULT_PASSWORD_TEXT);
        }
    }//GEN-LAST:event_inputPasswordFocusGained

    private void CreateAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateAdminActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(loginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateAdmin;
    private javax.swing.JTextField InputUsername;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel LoginText;
    private javax.swing.JTextField inputPassword;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
