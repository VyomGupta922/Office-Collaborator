package Employee_Project;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
public class empdetail extends javax.swing.JFrame {
    public Connection con=null;
    public Statement stmt=null;
    public ResultSet rst=null,rst2=null;
    public empdetail() {
        initComponents();
        showdata();
    }
    void showdata()
    {
        try{
            con=connection.ConnectDB();
            stmt=con.createStatement();
            rst = stmt.executeQuery("select name,email,phno,designation,band,reportingmng,llocatedproject,skill,address from adminemp");
            
              jTable1.setModel(DbUtils.resultSetToTableModel(rst));
                JOptionPane.showMessageDialog(null, "Data show");
           
           }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Go = new javax.swing.JButton();

        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Search");

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        Go.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Go.setText("Go");
        Go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Go)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Go)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoActionPerformed
        try{
            DefaultTableModel model = new DefaultTableModel() { 
            String[] employee = {"emp 1", "emp 2"}; 

            @Override 
            public int getColumnCount() { 
                return employee.length; 
            } 

            @Override 
            public String getColumnName(int index) { 
                return employee[index]; 
            } 
        }; 

        JTable jTable1 = new JTable(model); 

            con=connection.ConnectDB();
            stmt=con.createStatement();
            //rst2 = stmt.executeQuery("SELECT column_name FROM user_tab_cols WHERE table_name = 'adminemp' ");
            //jTable1.setModel(DbUtils.resultSetToTableModel(rst2));
            rst2 = stmt.executeQuery("Select name,email,phno,designation,band,reportingmng,llocatedproject,skill,address from adminemp where name='"+jTextField1.getText()+"'");
            rst2 = stmt.executeQuery("Select name,email,phno,designation,band,reportingmng,llocatedproject,skill,address from adminemp where designation='"+jTextField1.getText()+"'");
            rst2 = stmt.executeQuery("Select name,email,phno,designation,band,reportingmng,llocatedproject,skill,address from adminemp where llocatedproject='"+jTextField1.getText()+"'");
            jTable1.setModel(DbUtils.resultSetToTableModel(rst2));
            JOptionPane.showMessageDialog(null, "Data show");
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_GoActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new empdetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Go;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
