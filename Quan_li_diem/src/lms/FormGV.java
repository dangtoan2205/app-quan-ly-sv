package lms;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FormGV extends javax.swing.JFrame {

    DefaultTableModel dftb = new DefaultTableModel();

    public FormGV() {
        initComponents();
        loadData();
        loadtop3();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(204, 255, 255));
    }

    private void tinhdiemtb() {
        try {
            float ta = Float.parseFloat(tfdiem1.getText());
            float th = Float.parseFloat(tfdiem2.getText());
            float gdtc = Float.parseFloat(tfdiem3.getText());
            float diemtb = (ta + th + gdtc) / 3;
            String abc = String.valueOf(diemtb);
            tfdiemtb.setText(abc);
        } catch (Exception ex) {
            if (tfdiem1.getText().equals("") || tfdiem3.getText().equals("") || tfdiem3.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Không được bỏ trống điểm");
            } else {
                JOptionPane.showMessageDialog(null, "Nhập sai giá trị điểm");
            }
        }
    }

    private void loadData() {

        try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "SELECT * FROM BANGDIEM";
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
                        tfdiem1.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 1).toString());
                        tfdiem2.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 2).toString());
                        tfdiem3.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 3).toString());
                        tinhdiemtb();
                    }
                }
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi : " + ex);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadtop3() {
        try {
            DefaultTableModel dftb2 = new DefaultTableModel();
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "SELECT TOP 3 BANGDIEM.MASV,DIEMTB FROM BANGDIEM JOIN SINHVIEN ON SINHVIEN.MASV=BANGDIEM.MASV ORDER BY DIEMTB DESC";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta2 = rs.getMetaData();
            int n = meta2.getColumnCount();
            Vector col2 = new Vector();
            for (int i = 0; i < n; i++) {
                col2.add(meta2.getColumnName(i + 1));
            }
            dftb2.setColumnIdentifiers(col2);
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 0; i < n; i++) {
                    if (i < n) {
                        row.addElement(rs.getString(i + 1));
                    } else {
                    }
                }
                dftb2.addRow(row);

            }
            lblSV2.setModel(dftb2);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi : " + ex);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnnhapdiem = new javax.swing.JButton();
        btnsuadiem = new javax.swing.JButton();
        btnxoadiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfmasv = new javax.swing.JTextField();
        tfdiem1 = new javax.swing.JTextField();
        tfdiem2 = new javax.swing.JTextField();
        tfdiem3 = new javax.swing.JTextField();
        tfdiemtb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblSV2 = new javax.swing.JTable();
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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ ĐIỂM SINH VIÊN");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Mã sinh viên");

        btnnhapdiem.setText("Nhập điểm");
        btnnhapdiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnhapdiemActionPerformed(evt);
            }
        });

        btnsuadiem.setText("Sửa điểm");
        btnsuadiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuadiemActionPerformed(evt);
            }
        });

        btnxoadiem.setText("Xóa điểm");
        btnxoadiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoadiemActionPerformed(evt);
            }
        });

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "               Mã sinh viên", "               Điểm", "               Điểm", "               Điểm", "               Điểm trung bình "
            }
        ));
        jScrollPane2.setViewportView(tblSV);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Điểm Lí 1");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Điểm Toán 1");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Điểm Triết");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Điểm TB");

        tfdiemtb.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thông tin điểm sinh viên");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("3 sinh viên có điểm trung bình cao");

        lblSV2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Sinh viên", "Điểm TB"
            }
        ));
        jScrollPane1.setViewportView(lblSV2);

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

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
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdiem3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdiemtb, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnnhapdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(btnsuadiem, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnxoadiem, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(309, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(384, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(391, 391, 391))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(355, 355, 355))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdiem3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdiemtb, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnhapdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsuadiem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnxoadiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnnhapdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnhapdiemActionPerformed
        try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "INSERT INTO BANGDIEM values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfmasv.getText());
            ps.setString(2, tfdiem1.getText());
            ps.setString(3, tfdiem2.getText());
            ps.setString(4, tfdiem3.getText());
            tinhdiemtb();
            ps.setString(5, tfdiemtb.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không nhập được điểm");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnnhapdiemActionPerformed

    private void btnxoadiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoadiemActionPerformed
        try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "DELETE FROM BANGDIEM WHERE MASV=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfmasv.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không xóa được nữa !");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnxoadiemActionPerformed

    private void btnsuadiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuadiemActionPerformed
        try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "UPDATE BANGDIEM SET DIEMTA = ?,DIEMTH = ?,DIEMGDQP = ?,DIEMTB= ? WHERE MASV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfdiem1.getText());
            ps.setString(2, tfdiem2.getText());
            ps.setString(3, tfdiem3.getText());
            tinhdiemtb();
            ps.setString(4, tfdiemtb.getText());
            ps.setString(5, tfmasv.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
            loadtop3();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không update được điểm");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsuadiemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        LoginForm Lg = new LoginForm();
        Lg.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?") == 0) {
            JOptionPane.showMessageDialog(null, "Bạn đã thoát");
            System.exit(0);
        }
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnaboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaboutActionPerformed
        JOptionPane.showMessageDialog(null, "Người thiết kế: Đặng Ngọc Toàn");
    }//GEN-LAST:event_btnaboutActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        tfmasv.setText("");
        tfdiem1.setText("");
        tfdiem2.setText("");
        tfdiem3.setText("");
        tfdiemtb.setText("");
            
    }//GEN-LAST:event_resetActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormGV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnabout;
    private javax.swing.JMenuItem btnexit;
    private javax.swing.JButton btnnhapdiem;
    private javax.swing.JButton btnsuadiem;
    private javax.swing.JButton btnxoadiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable lblSV2;
    private javax.swing.JButton reset;
    private javax.swing.JTable tblSV;
    private javax.swing.JTextField tfdiem1;
    private javax.swing.JTextField tfdiem2;
    private javax.swing.JTextField tfdiem3;
    private javax.swing.JTextField tfdiemtb;
    private javax.swing.JTextField tfmasv;
    // End of variables declaration//GEN-END:variables
}
