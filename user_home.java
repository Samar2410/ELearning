
import java.util.StringTokenizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author samar
 */
public class user_home extends javax.swing.JFrame {

    /**
     * Creates new form user_home
     */
    public user_home(String email) {
        initComponents();
        setSize(500,500);
        lb.setText("Welcome "+email);
        loadcategory();
    }
    
    void loadcategory(){
        String ans=myClient.fetchcat();
        //System.out.println(ans);
        StringTokenizer st=new StringTokenizer(ans,";;");
        int n=st.countTokens();
        JButton arr[]=new JButton[n];
        int x=10,y=10;
        for(int i=0;i<n;i++){
            String row=st.nextToken();
            StringTokenizer st1=new StringTokenizer(row,"$");
            String name=st1.nextToken();
            String photo=st1.nextToken();
            arr[i]=new JButton(name);
            arr[i].setBounds(x,y,200,100);
            arr[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    courses obj=new courses(name);
                    obj.setVisible(true);
                    dispose();
                }
            
            });
            ImageIcon ic=new ImageIcon(photo);
            Image img=ic.getImage().getScaledInstance(100, 100,Image.SCALE_SMOOTH);
            ImageIcon ic1=new ImageIcon(img);
            arr[i].setIcon(ic1);
            mainpanel.add(arr[i]);
            mainpanel.repaint();
          x=x+210;
            if(x==430){
                x=10;
                y+=100+10;
            }
            
            
        
        }
        mainpanel.setPreferredSize(new Dimension(3*210,y+150));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lb.setForeground(new java.awt.Color(51, 51, 255));
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lb);
        lb.setBounds(0, 20, 500, 40);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 450, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_home("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
