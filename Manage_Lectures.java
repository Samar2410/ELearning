
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author samar
 */
public class Manage_Lectures extends javax.swing.JFrame {

    /**
     * Creates new form Manage_Lectures
     */
    File ph,lecture;
    JFileChooser jfc;
    ArrayList<Lecture>al=new ArrayList<>();
    myTableModel tm;
    public Manage_Lectures() {
        initComponents();
        setSize(800,700);
        load_courses();
        tm=new myTableModel();
        mytable.setModel(tm);
    }
    
    void load_courses(){
        String ans=myClient.loadCourses();
        StringTokenizer st=new StringTokenizer(ans,";;");
        while(st.hasMoreTokens()){
            String row=st.nextToken();
            StringTokenizer st1=new StringTokenizer(row,"$");
            int id=Integer.parseInt(st1.nextToken());
            String name=st1.nextToken();
            cb.addItem(id+" "+name);
             cb1.addItem(id+" "+name);
        }
    }
    
    void fetchlectures(){
         al.clear();
        String course=(String)cb1.getSelectedItem();
        StringTokenizer st=new StringTokenizer(course);
        int course_id=Integer.parseInt(st.nextToken());
        String ans=myClient.fetch_lectures(course_id);
       
        StringTokenizer st1=new StringTokenizer(ans,";;");
        while(st1.hasMoreTokens()){
            String row=st1.nextToken();
            StringTokenizer st2=new StringTokenizer(row,"$");
            int id=Integer.parseInt(st2.nextToken());
             String name=st2.nextToken();
              String desc=st2.nextToken();
               String photo=st2.nextToken();
               al.add(new Lecture(id,name,desc,photo));
        }
        tm.fireTableDataChanged();
        
    }
    
    class myTableModel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if(columnIndex==0)return al.get(rowIndex).name;
            else if(columnIndex==1)return al.get(rowIndex).description;
            else return al.get(rowIndex).photo;
        }

        @Override
        public String getColumnName(int column) {
            String name[]={"Name","Description","Photo"};
            return name[column];
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        nametf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionta = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        durationtf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        trailertf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        photolb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mytable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Lectures");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 40);

        jLabel2.setText("Add Lectures");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 80, 120, 16);

        jLabel3.setText("View Lectures");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(590, 80, 130, 16);

        jLabel4.setText("Course");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 120, 50, 16);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        getContentPane().add(cb);
        cb.setBounds(90, 120, 180, 22);

        jLabel5.setText("Course");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(450, 120, 40, 16);

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        getContentPane().add(cb1);
        cb1.setBounds(500, 120, 190, 22);

        jLabel6.setText("Name");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 170, 130, 16);

        nametf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametfActionPerformed(evt);
            }
        });
        getContentPane().add(nametf);
        nametf.setBounds(30, 190, 170, 22);

        jLabel7.setText("Description");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 230, 130, 16);

        descriptionta.setColumns(20);
        descriptionta.setRows(5);
        jScrollPane1.setViewportView(descriptionta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 250, 110, 70);

        jLabel8.setText("Duration");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 340, 100, 16);

        durationtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationtfActionPerformed(evt);
            }
        });
        getContentPane().add(durationtf);
        durationtf.setBounds(30, 360, 140, 22);

        jLabel9.setText("Trailer");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 390, 90, 16);

        trailertf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trailertfActionPerformed(evt);
            }
        });
        getContentPane().add(trailertf);
        trailertf.setBounds(30, 410, 150, 22);

        jLabel10.setText("Lecture");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 440, 70, 20);

        jButton1.setText("Choose Lecture");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 470, 190, 23);

        jLabel11.setText("Photo");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 520, 110, 16);
        getContentPane().add(photolb);
        photolb.setBounds(30, 550, 110, 100);

        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 590, 100, 23);

        jButton3.setText("Add Lecture");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(170, 640, 120, 23);

        mytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(mytable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(420, 170, 360, 290);

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(560, 490, 100, 23);

        jButton5.setText("View");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(710, 120, 72, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb1ActionPerformed

    private void nametfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametfActionPerformed

    private void durationtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durationtfActionPerformed

    private void trailertfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trailertfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trailertfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jfc=new JFileChooser();
        int ans=jfc.showOpenDialog(this);
        if(ans==JFileChooser.APPROVE_OPTION){
            lecture=jfc.getSelectedFile();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jfc=new JFileChooser();
        int ans=jfc.showOpenDialog(this);
        if(ans==JFileChooser.APPROVE_OPTION){
            ph=jfc.getSelectedFile();
            ImageIcon ic=new ImageIcon(ph.getPath());
            Image img=ic.getImage().getScaledInstance(photolb.getWidth(), photolb.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic1=new ImageIcon(img);
            photolb.setIcon(ic1);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String name=nametf.getText();
        String desc=descriptionta.getText();
        String duration=durationtf.getText();
        String trailer=trailertf.getText();
        String course=(String)cb.getSelectedItem();
        StringTokenizer st=new StringTokenizer(course);
        int course_id=Integer.parseInt(st.nextToken());
        if(name.isEmpty() ||  desc.isEmpty() || duration.isEmpty() || trailer.isEmpty() || lecture==null || ph==null ){
            JOptionPane.showMessageDialog(rootPane, "All fields are mandatory");
        }
        else{
            String ans=myClient.addLecture(name, desc, duration, trailer, course_id, lecture, ph);
            if(ans.trim().equals("success"))JOptionPane.showMessageDialog(rootPane, "Lecture added.");
            else JOptionPane.showMessageDialog(rootPane, ans);
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row=mytable.getSelectedRow();
        if(row==-1)JOptionPane.showMessageDialog(rootPane, "Please select a row");
        else{
            int id=al.get(row).id;
            String ans=myClient.deleteLecture(id);
             if(ans.trim().equals("success")){
                 JOptionPane.showMessageDialog(rootPane, "Lecture deleted.");
                 fetchlectures();
             }
            else JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       
        fetchlectures();
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Manage_Lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Lectures().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JTextArea descriptionta;
    private javax.swing.JTextField durationtf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable mytable;
    private javax.swing.JTextField nametf;
    private javax.swing.JLabel photolb;
    private javax.swing.JTextField trailertf;
    // End of variables declaration//GEN-END:variables
}