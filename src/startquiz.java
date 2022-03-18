/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securequize;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Anasha Kumari
 */
public class startquiz extends javax.swing.JFrame {
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs =null;
    String user;
    public String questionno="1";
    public String answer;
    public int min=0;
    public int sec=0;
    public int mark=0;
    String rollno;
       Timer time;
       public void answerCheck()
       {
          String studentAnswer="";
          if(jRadioButton1.isSelected())
          {
              studentAnswer= jRadioButton1.getText();
          }
          else if(jRadioButton2.isSelected())
          {
              studentAnswer= jRadioButton2.getText();
          }
           if(jRadioButton3.isSelected())
          {
              studentAnswer= jRadioButton3.getText();
          }
           else
          {
              studentAnswer= jRadioButton4.getText();
          }
           if(studentAnswer.equals(answer))
               
           {
               mark=mark+1;
               String marks1=String.valueOf(mark);
          }
           int questionId = Integer.parseInt(questionno);//question no. change
           questionId=questionId+1;
           questionno=String.valueOf(questionId);
           
           //clear jRadiobutton
           jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(false);
       }
          public void  submit(){
              answerCheck();
              try{
                  String url="jdbc:mysql://localhost:3306/secure_quiz";
            String uname="root";
            String password="";
            con=DriverManager.getConnection(url,uname,password);
//             ps.executeUpdate("update student set mark='"+mark+"'" where rollNo=?");
          
             String query="update student set marks='"+mark+"' where rollNo='"+rollno+"'";
            ps=con.prepareStatement(query);
            rs= ps.executeQuery(query);
             String marks1 =String.valueOf(mark);
            // JOptionPane.showMessageDialog(null,marks1);
            setVisible(false);
            new Submit(marks1). setVisible(false);
              }
              catch(Exception e){
                  
              }
          }
        
         
          
          public void question()
          {
              try{
               String url="jdbc:mysql://localhost:3306/secure_quiz";
            String uname="root";
            String password="";
            con=DriverManager.getConnection(url,uname,password);
//           String query="SELECT * FROM question WHERE Question_no=?";
          // ps=con.prepareStatement();
            ResultSet rs= ps.executeQuery("selesct * from question where Question_no=?");
            while(rs.next()){
            ntxt_questionno.setText(rs.getString(1));
            txt_question1.setText(rs.getString(2));
            jRadioButton1.setText(rs.getString(3));
            jRadioButton2.setText(rs.getString(4));
            jRadioButton3.setText(rs.getString(5));
            jRadioButton4.setText(rs.getString(6));
            answer=rs.getString(7);
            }
            }
             catch(Exception e)
               {
                   JOptionPane.showMessageDialog(null,e);
               }
          }
    /**
     * Creates new form 
     */
    public startquiz() {
        initComponents();
            this.rollno = rollno;
           try{
               String url="jdbc:mysql://localhost:3306/secure_quiz";
            String uname="root";
            String password="";
            con=DriverManager.getConnection(url,uname,password);
//           String query="SELECT * FROM question WHERE Question_no=?";
//            ps=con.prepareStatement(query);
            ResultSet rs= ps.executeQuery("selesct * from question where Question_no=?");
            while(rs.next()){
            ntxt_questionno.setText(rs.getString(1));
            txt_question1.setText(rs.getString(2));
            jRadioButton1.setText(rs.getString(3));
            jRadioButton2.setText(rs.getString(4));
            jRadioButton3.setText(rs.getString(5));
            jRadioButton4.setText(rs.getString(6));
            answer=rs.getString(7);
            }
            }
             catch(Exception e)
               {
                   JOptionPane.showMessageDialog(null,e);
               }
           setLocationRelativeTo(this);
       
        time = new Timer(1000,new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
             jLabel5.setText(String.valueOf(min));
             jLabel6.setText(String.valueOf(sec));
             if(sec==60)
        {
            sec=0;min++;
            if(min==10)
        {
            time.stop();
        
            answerCheck();
            submit();
        }
        }
             sec++;
            }
            
        });
        time.start();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        submit = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txt_question = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ntxt_questionno = new javax.swing.JTextField();
        txt_question1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("START");

        jLabel2.setText("Total Time :");

        jLabel3.setText("Time Taken");

        jLabel4.setText("10 min");

        jLabel5.setText("00");

        jLabel6.setText("00");

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        submit.setText("submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        txt_question.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_question.setText("Question:");

        jLabel8.setText("Question no.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(next)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 456, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ntxt_questionno, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)))
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submit)
                        .addGap(124, 124, 124))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(txt_question, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_question1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ntxt_questionno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_question, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_question1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jRadioButton1)
                .addGap(32, 32, 32)
                .addComponent(jRadioButton2)
                .addGap(39, 39, 39)
                .addComponent(jRadioButton3)
                .addGap(40, 40, 40)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(next))
                .addGap(113, 113, 113))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(jRadioButton2.isSelected())
        {
           jRadioButton1.setSelected(false);
           jRadioButton3.setSelected(false);
           jRadioButton4.setSelected(false);
                                   
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
       answerCheck();
       question();
    }//GEN-LAST:event_nextActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
       
        //a = JOptionPane.showConfirmDialong(null,"want to submit",JOptionPane.YES_NO_OPTION);
         int result = JOptionPane.showConfirmDialog(null,"Do you want to exit?","Warning",JOptionPane.YES_NO_OPTION);
        
        if(result==JOptionPane.YES_OPTION)
        {
            answerCheck();
            submit();
            
        }
    }//GEN-LAST:event_submitActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(jRadioButton1.isSelected())
        {
           jRadioButton2.setSelected(false);
           jRadioButton3.setSelected(false);
           jRadioButton4.setSelected(false);
                                   
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
         if(jRadioButton3.isSelected())
        {
           jRadioButton1.setSelected(false);
           jRadioButton2.setSelected(false);
           jRadioButton4.setSelected(false);
                                   
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
         if(jRadioButton4.isSelected())
        {
           jRadioButton1.setSelected(false);
           jRadioButton3.setSelected(false);
           jRadioButton3.setSelected(false);
                                   
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed
   
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
            java.util.logging.Logger.getLogger(startquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(startquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(startquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(startquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new startquiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton next;
    private javax.swing.JTextField ntxt_questionno;
    private javax.swing.JButton submit;
    private javax.swing.JLabel txt_question;
    private javax.swing.JTextField txt_question1;
    // End of variables declaration//GEN-END:variables
}
