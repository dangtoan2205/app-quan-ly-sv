package lms;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FormDT extends javax.swing.JFrame {

    DefaultTableModel dftb = new DefaultTableModel();

    public FormDT() {
        initComponents();
        loadData();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(204, 255, 255));
    }

    private void loadData() {

        try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "SELECT * FROM SINHVIEN";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int n = meta.getColumnCount();
            Vector col = new Vector();
            for (int i = 0; i < n; i++) {
                col.add(meta.getColumnName(i + 1));
            }
            dftb.setColumnIdentifiers(col);
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 0; i < n; i++) {
                    if (i < n) {
                        row.addElement(rs.getString(i + 1));
                    } else {
                    }
                }
                dftb.addRow(row);

            }
            tblSV.setModel(dftb);
            tblSV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (tblSV.getSelectedRow() >= 0) {
                        tfmasv.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 0).toString());
                        tftensv.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 1).toString());
                        tfngaysinh.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 2).toString());
                        String s = tblSV.getValueAt(tblSV.getSelectedRow(), 3).toString();
                        if (s.equals("1")) {
                            rdbnam.setSelected(true);
                        } else {
                            rdbnu.setSelected(true);
                        }
                        tfdiachi.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 4).toString());
                    }
                }
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi : " + ex);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfmasv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tftensv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfngaysinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdbnam = new javax.swing.JRadioButton();
        rdbnu = new javax.swing.JRadioButton();
        tfdiachi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnthemsv = new javax.swing.JButton();
        btnsuasv = new javax.swing.JButton();
        btnxoasv = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        btnexit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnabout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lí sinh viên lớp 18CN2");
        setBackground(new java.awt.Color(204, 255, 255));

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Tên sinh viên", "Ngày sinh", "Giới tính", "Địa chỉ"
            }
        ));
        jScrollPane1.setViewportView(tblSV);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SINH VIÊN LỚP 18CN2");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Mã sinh viên");

        tfmasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfmasvActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Tên sinh viên");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Ngày sinh");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Giới tính");

        rdbnam.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1.add(rdbnam);
        rdbnam.setText("Nam");

        rdbnu.setBackground(new java.awt.Color(204, 255, 255));
        buttonGroup1.add(rdbnu);
        rdbnu.setText("Nữ");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Địa chỉ");

        btnthemsv.setText("Thêm sinh viên");
        btnthemsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemsvActionPerformed(evt);
            }
        });

        btnsuasv.setText("Chỉnh sửa");
        btnsuasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuasvActionPerformed(evt);
            }
        });

        btnxoasv.setText("Xóa sinh viên");
        btnxoasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoasvActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel7.setText("Notes : 1-Nam ; 2-Nữ");

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        btnexit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        jMenu1.add(btnexit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        btnabout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnabout.setText("About");
        btnabout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaboutActionPerformed(evt);
            }
        });
        jMenu2.add(btnabout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1309, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(rdbnam, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(rdbnu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(tfdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tftensv, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                                        .addComponent(tfmasv, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
                                    .addComponent(tfngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnthemsv, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnsuasv, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnxoasv, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(147, 147, 147))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbnam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbnu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tftensv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnthemsv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnsuasv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addComponent(btnxoasv, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(1, 1, 1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfmasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfmasvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfmasvActionPerformed

    private void btnthemsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemsvActionPerformed
        try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "INSERT INTO SINHVIEN values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfmasv.getText());
            ps.setString(2, tftensv.getText());
            ps.setString(3, tfngaysinh.getText());
            ps.setBoolean(4, rdbnam.isSelected() ? true : false);
            ps.setString(5, tfdiachi.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thể thêm sinh viên");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnthemsvActionPerformed

    private void btnxoasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoasvActionPerformed
        try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "DELETE FROM SINHVIEN WHERE MASV=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfmasv.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không xóa được sinh viên");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnxoasvActionPerformed

    private void btnsuasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuasvActionPerformed
        try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "UPDATE SINHVIEN SET HoTen = ?,NgaySinh = ?,GioiTinh = ?,DiaChi= ? where MaSV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tftensv.getText());
            ps.setString(2, tfngaysinh.getText());
            ps.setBoolean(3, rdbnam.isSelected() ? true : false);
            ps.setString(4, tfdiachi.getText());
            ps.setString(5, tfmasv.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không update được sinh viên");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsuasvActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?") == 0) {
            JOptionPane.showMessageDialog(null, "Bạn đã thoát");
            System.exit(0);
        }
    }//GEN-LAST:event_btnexitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        LoginForm Lg = new LoginForm();
        Lg.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnaboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaboutActionPerformed
        JOptionPane.showMessageDialog(null, "Người thiết kế: Đặng Ngọc Toàn");
    }//GEN-LAST:event_btnaboutActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        tfmasv.setText("");
        tftensv.setText("");
        tfngaysinh.setText("");
        tfdiachi.setText("");
        
    }//GEN-LAST:event_resetActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnabout;
    private javax.swing.JMenuItem btnexit;
    private javax.swing.JButton btnsuasv;
    private javax.swing.JButton btnthemsv;
    private javax.swing.JButton btnxoasv;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JRadioButton rdbnam;
    private javax.swing.JRadioButton rdbnu;
    private javax.swing.JButton reset;
    private javax.swing.JTable tblSV;
    private javax.swing.JTextField tfdiachi;
    private javax.swing.JTextField tfmasv;
    private javax.swing.JTextField tfngaysinh;
    private javax.swing.JTextField tftensv;
    // End of variables declaration//GEN-END:variables
}
