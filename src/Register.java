import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register implements ActionListener
{
    JFrame frame = new JFrame("Registration Form:");

    JTextField namefield =  new JTextField();

    JTextField idfield =  new JTextField();
    JTextField mailfield =  new JTextField();
    JPasswordField passfield=  new JPasswordField();
    JPasswordField cpassfield =  new JPasswordField();
    JButton submitButton = new JButton("Register");

    //arr us = new arr();
    SecDigiLock us;
    Register(SecDigiLock is)
    {
        us = is;
    }

    void insertUser()
    {
        JLabel l2 = new JLabel("Registration Form:");
        JLabel l3 = new JLabel("****************");
        JLabel l4 = new JLabel("User Name: ");
        JLabel l5 = new JLabel("User Id: ");
        JLabel l6 = new JLabel("Email: ");
        JLabel l7 = new JLabel("Password: ");
        JLabel l8 = new JLabel("Confirm Password: ");
        frame.getContentPane();
        GridLayout gl = new GridLayout();
        gl.setColumns(2);
        gl.setRows(9);
        frame.setLayout(gl);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(namefield);
        frame.add(l5);
        frame.add(idfield);
        frame.add(l6);
        frame.add(mailfield);
        frame.add(l7);
        frame.add(passfield);
        frame.add(l8);
        frame.add(cpassfield);
        frame.add(submitButton);

        frame.setSize(1000,1500);
        //frame.getDefaultCloseOperation();
        frame.setVisible(true);

        submitButton.addActionListener(this);

    }

        @Override
        public void actionPerformed(ActionEvent ex) {

            if (ex.getActionCommand() == submitButton.getActionCommand()) {

                us.name[us.count] = namefield.getText();
                us.id[us.count] = idfield.getText();
                us.mail[us.count] = mailfield.getText();
                int ps = Integer.parseInt(passfield.getText());
                int psc = Integer.parseInt(cpassfield.getText());
                if (ps == psc) {
                    us.givepassword(ps);
                }
                us.count++;
                System.out.println("Inserted Entry:");
                JOptionPane.showMessageDialog(null, "Entry Added Successfully");
                frame.getDefaultCloseOperation();
                frame.setVisible(false);

            }


        }




}