/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

/**
 *
 * @author Edson Macaule
 */
import java.sql.*;
import dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void consultar() {
        String sql = "select * from tbusuarios where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtUsuNome.setText(rs.getString(2));
                txtUsuCell.setText(rs.getString(3));
                txtUsuLogin.setText(rs.getString(4));
                txUsutSenha.setText(rs.getString(5));
                cbUsuPerfil.setSelectedItem(rs.getString(6));

            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                txtUsuNome.setText(null);
                txtUsuCell.setText(null);
                txtUsuLogin.setText(null);
                txUsutSenha.setText(null);
                //cbUsuPerfil.setSelectedItem(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void adicionar() {
        String sql = "insert into tbusuarios (iduser,usuario,contacto,login,senha,perfil) values(?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            pst.setString(2, txtUsuNome.getText());
            pst.setString(3, txtUsuCell.getText());
            pst.setString(4, txtUsuLogin.getText());
            pst.setString(5, txUsutSenha.getText());
            pst.setString(6, cbUsuPerfil.getSelectedItem().toString());

            if ((txtUsuId.getText().isEmpty() || (txtUsuNome.getText().isEmpty() || (txtUsuLogin.getText().isEmpty() || (txUsutSenha.getText().isEmpty()))))) {
                JOptionPane.showMessageDialog(null, "preencha todos os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
                    txtUsuId.setText(null);
                    txtUsuNome.setText(null);
                    txtUsuCell.setText(null);
                    txtUsuLogin.setText(null);
                    txUsutSenha.setText(null);
                    //cbUsuPerfil.setSelectedItem(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        String sql = "update tbusuarios set usuario=?,contacto=?,login=?,senha=?,perfil=? where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, txtUsuNome.getText());
            pst.setString(2, txtUsuCell.getText());
            pst.setString(3, txtUsuLogin.getText());
            pst.setString(4, txUsutSenha.getText());
            pst.setString(5, cbUsuPerfil.getSelectedItem().toString());
            pst.setString(6, txtUsuId.getText());

            if ((txtUsuId.getText().isEmpty() || (txtUsuNome.getText().isEmpty() || (txtUsuLogin.getText().isEmpty() || (txUsutSenha.getText().isEmpty()))))) {
                JOptionPane.showMessageDialog(null, "preencha todos os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Usuário alterados com sucesso");
                    txtUsuId.setText(null);
                    txtUsuNome.setText(null);
                    txtUsuCell.setText(null);
                    txtUsuLogin.setText(null);
                    txUsutSenha.setText(null);
                    //cbUsuPerfil.setSelectedItem(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbusuarios where iduser=?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtUsuId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário Removido com sucesso");
                    txtUsuId.setText(null);
                    txtUsuNome.setText(null);
                    txtUsuCell.setText(null);
                    txtUsuLogin.setText(null);
                    txUsutSenha.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
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

        lbId = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbLogin = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        lbCell = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        txtUsuId = new javax.swing.JTextField();
        txtUsuNome = new javax.swing.JTextField();
        txtUsuLogin = new javax.swing.JTextField();
        txtUsuCell = new javax.swing.JTextField();
        cbUsuPerfil = new javax.swing.JComboBox();
        btUsuGuardar = new javax.swing.JButton();
        btUsuRemover = new javax.swing.JButton();
        btUsuActualizar = new javax.swing.JButton();
        btUsuPesquisar = new javax.swing.JButton();
        txUsutSenha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuários");

        lbId.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbId.setText("      *id");

        lbNome.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbNome.setText("*Nome");

        lbLogin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbLogin.setText("*Login");

        lbSenha.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbSenha.setText("   *Senha");

        lbCell.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbCell.setText("  Contacto");

        lbPerfil.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbPerfil.setText("*Perfil");

        txtUsuId.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtUsuNome.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtUsuLogin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtUsuCell.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        cbUsuPerfil.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbUsuPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "user" }));

        btUsuGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar.png"))); // NOI18N
        btUsuGuardar.setToolTipText("Adicionar");
        btUsuGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btUsuGuardar.setPreferredSize(new java.awt.Dimension(80, 80));
        btUsuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuGuardarActionPerformed(evt);
            }
        });

        btUsuRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Apagar.png"))); // NOI18N
        btUsuRemover.setToolTipText("Remover");
        btUsuRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btUsuRemover.setPreferredSize(new java.awt.Dimension(80, 80));
        btUsuRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuRemoverActionPerformed(evt);
            }
        });

        btUsuActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btUsuActualizar.setToolTipText("Actualizar");
        btUsuActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btUsuActualizar.setPreferredSize(new java.awt.Dimension(80, 80));
        btUsuActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuActualizarActionPerformed(evt);
            }
        });

        btUsuPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        btUsuPesquisar.setToolTipText("Pesquisar");
        btUsuPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btUsuPesquisar.setPreferredSize(new java.awt.Dimension(80, 80));
        btUsuPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuPesquisarActionPerformed(evt);
            }
        });

        txUsutSenha.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btUsuGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(btUsuPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(btUsuActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btUsuRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txUsutSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbUsuPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lbCell)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsuCell, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbLogin)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbId)
                            .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCell)
                    .addComponent(txtUsuCell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLogin)
                    .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSenha)
                    .addComponent(txUsutSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPerfil)
                    .addComponent(cbUsuPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btUsuGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btUsuActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btUsuPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btUsuRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );

        setBounds(0, 0, 728, 608);
    }// </editor-fold>//GEN-END:initComponents

    private void btUsuPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuPesquisarActionPerformed
        consultar();
    }//GEN-LAST:event_btUsuPesquisarActionPerformed

    private void btUsuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuGuardarActionPerformed
        adicionar();
    }//GEN-LAST:event_btUsuGuardarActionPerformed

    private void btUsuActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuActualizarActionPerformed
        alterar();
    }//GEN-LAST:event_btUsuActualizarActionPerformed

    private void btUsuRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuRemoverActionPerformed
        remover();
    }//GEN-LAST:event_btUsuRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btUsuActualizar;
    private javax.swing.JButton btUsuGuardar;
    private javax.swing.JButton btUsuPesquisar;
    private javax.swing.JButton btUsuRemover;
    private javax.swing.JComboBox cbUsuPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbCell;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JTextField txUsutSenha;
    private javax.swing.JTextField txtUsuCell;
    private javax.swing.JTextField txtUsuId;
    private javax.swing.JTextField txtUsuLogin;
    private javax.swing.JTextField txtUsuNome;
    // End of variables declaration//GEN-END:variables
}
