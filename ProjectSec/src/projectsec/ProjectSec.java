/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsec;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ProjectSec extends JFrame implements ActionListener{
   
    static JPanel panel =new JPanel(); 
    static JLabel option=new JLabel("What do you want to do?");
    static JButton Encrypt=new JButton("Encrypt a message "); 
    static JButton Decrypt=new JButton("Decrypt a message");
    
    static JFrame childFrm=new JFrame();
    static JPanel panel2 =new JPanel();
     static JLabel label9=new JLabel("OneTimePad encryption:");
    
    static JLabel label1=new JLabel("Enter the plaintext:");
    static JTextArea field1=new JTextArea(7,4);
    static JLabel label2=new JLabel("Enter the key: (must be same length as plaintext)");
    static JTextArea field2=new JTextArea(7,4);
    static JLabel cipher=new JLabel("Ciphertext:");
    static JTextArea textarea1=new JTextArea(10,25);
    static JButton back=new JButton("Back");
    static JButton reset1=new JButton("Reset");
    static JButton done=new JButton("Encrypt");
    
    static JFrame childFrm2=new JFrame();
    static JPanel panel3 =new JPanel();
    static JLabel label10=new JLabel("OneTimePad decryption:");
    static JLabel label3=new JLabel("Enter the ciphertext:");
    static JTextArea field3=new JTextArea(7,25);
    static JLabel label4=new JLabel("Enter the key: (must be same length as ciphertext)");
    static JTextArea field4=new JTextArea(7,25);
    static JLabel plain=new JLabel("Plaintext:");
    static JTextArea textarea2=new JTextArea(10,25);
    static JButton back2=new JButton("Back");
    static JButton reset2=new JButton("Reset");
    static JButton done2=new JButton("Decrypt");
    
    static ImageIcon img1=new ImageIcon("D.png");
    static ImageIcon img2=new ImageIcon("E.png");

    static Font font = new Font("Serif Plain", Font.PLAIN, 18);
    
    public static void main(String[] args)  {
        ProjectSec frm=new ProjectSec();
        frm.setSize(700, 600); 
        frm.setTitle("OneTimePad");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frm.setLayout(new FlowLayout());
        frm.setVisible(true);
        
        frm.getContentPane().setBackground(Color.white);
        panel.setBackground(Color.white);
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

        textarea1.setEditable(false);
        textarea2.setEditable(false);
        
        field1.setLineWrap(true);
        field2.setLineWrap(true);
        field3.setLineWrap(true);
        field4.setLineWrap(true);
        
        done.setAlignmentX(CENTER_ALIGNMENT);
        back.setAlignmentX(CENTER_ALIGNMENT);
        label9.setAlignmentX(CENTER_ALIGNMENT);
        label1.setAlignmentX(CENTER_ALIGNMENT);
        label2.setAlignmentX(CENTER_ALIGNMENT);
        cipher.setAlignmentX(CENTER_ALIGNMENT);
        reset1.setAlignmentX(CENTER_ALIGNMENT);
        
        
        done2.setAlignmentX(CENTER_ALIGNMENT);
        back2.setAlignmentX(CENTER_ALIGNMENT);
        label10.setAlignmentX(CENTER_ALIGNMENT);
        label3.setAlignmentX(CENTER_ALIGNMENT);
        label4.setAlignmentX(CENTER_ALIGNMENT);
        plain.setAlignmentX(CENTER_ALIGNMENT);
        reset2.setAlignmentX(CENTER_ALIGNMENT);
        
        //set font for labels
        option.setFont(font);
        label1.setFont(font);
        label2.setFont(font);
        cipher.setFont(font);
        label3.setFont(font);
        label4.setFont(font);
        plain.setFont(font);
        
        //Set font for buttons
        Encrypt.setFont(font);
        Decrypt.setFont(font);
        done.setFont(font);
        back.setFont(font);
        done2.setFont(font);
        back2.setFont(font);
        reset1.setFont(font);
        reset2.setFont(font);
        
        
        Encrypt.setIcon(img1);
        Decrypt.setIcon(img2);
               
        panel.add(option);
        panel.add(Encrypt); 
        panel.add(Decrypt);
        frm.add(panel);
        
        panel2.add(label9);
        panel2.add(label1);
        panel2.add(field1);
        panel2.add(label2);
        panel2.add(field2);
        panel2.add(done);
        panel2.add(cipher);
        panel2.add(textarea1);
        panel2.add(back);
        panel2.add(reset1);
        
        childFrm.add(panel2);

        panel3.add(label10);
        panel3.add(label3);
        panel3.add(field3);
        panel3.add(label4);
        panel3.add(field4);
        panel3.add(done2);
        panel3.add(plain);
        panel3.add(textarea2);
        panel3.add(back2);
        panel3.add(reset2);
        
        childFrm2.add(panel3);
        
        Encrypt.addActionListener(frm);
        Decrypt.addActionListener(frm);
        back.addActionListener(frm);
        done.addActionListener(frm);
        back2.addActionListener(frm);
        done2.addActionListener(frm);
        reset1.addActionListener(frm);
        reset2.addActionListener(frm);
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==Encrypt) {
        childFrm.setSize(500, 650);
        childFrm.setTitle("Encryption");
        childFrm.setLayout(new FlowLayout());
        childFrm.setVisible(true);
       
    }
        if(e.getSource()==done){
            boolean checkletters=isAlpha(field1.getText());
            if(field1.getText().length() == field2.getText().length() && checkletters== true){
               String temp = field1.getText();
               String temp1 = temp.toUpperCase();
               
               String KeyTemp= field2.getText();
               String KeyTemp2= KeyTemp.toUpperCase();
               
                String alphaU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
               
                int len = temp1.length();
                String result = "";
                
                for(int x=0;x<len;x++){
                    char message = temp1.charAt(x);
                    char Key = KeyTemp2.charAt(x);
                    
                    int index = alphaU.indexOf(message);
                    int keydex = alphaU.indexOf(Key);

                    int total = (index + keydex) % 26;
                     total = (total<0)? total + 26 : total;
                     
                    result = result+ alphaU.charAt(total);
                    textarea1.setText(result);
          }
            
            }
        else{
                if(field1.getText().length() != field2.getText().length()){
             JOptionPane.showMessageDialog(null,"pad key size should be same as message size " ,"Error",
                     JOptionPane.ERROR_MESSAGE);
                }
                  }
        }
        
        if(e.getSource()== back){
            childFrm.dispose();
            field1.setText("");
            field2.setText("");
            textarea1.setText("");
        }
        if(e.getSource()== reset1){
             field1.setText("");
            field2.setText("");
            textarea1.setText("");
        }
        else{
            if(e.getSource()==Decrypt) {
        childFrm2.setSize(500, 650);
        childFrm2.setTitle("Decryption");
        childFrm2.setLayout(new FlowLayout());
        childFrm2.setVisible(true);
        
        }
            if(e.getSource()== done2){
                if(field3.getText().length() == field4.getText().length()){
                    
                    String encTemp = field3.getText();
                    String encTemp2 = encTemp.toUpperCase();
                    String decKey= field4.getText();
                    String decKey2= decKey.toUpperCase();
                    
                    String alphaU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    
                    int len = encTemp2.length();
                    String result = "";
                    for(int x=0;x<len;x++){
                        char message = encTemp2.charAt(x);
                        char Key = decKey2.charAt(x);
                        
                            int index = alphaU.indexOf(message);
                            int keydex = alphaU.indexOf(Key);
                            
                            int total = (index - keydex) % 26;
                            total = (total<0)? total + 26 : total;
                            
                            result = result+ alphaU.charAt(total);
                            textarea2.setText(result);
                                
                            }
                }else{
                    if(field3.getText().length() != field4.getText().length()){
                        JOptionPane.showMessageDialog(null,"pad key size should be same as message size " ,"Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
            }
            }
            if(e.getSource()== back2){
                childFrm2.dispose();
                field3.setText("");
                field4.setText("");
                textarea2.setText("");
            }
            if(e.getSource()== reset2){
             field3.setText("");
            field4.setText("");
            textarea2.setText("");
        }
        }
    }
public boolean isAlpha(String name) {
    char[] chars = name.toCharArray();

    for (char c : chars) {
        if(!Character.isLetter(c)) {
            return false;
        }
    }

    return true;
}
        
    }


