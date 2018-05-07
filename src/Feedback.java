/**
 * Created by hp on 25-03-2018.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.FileWriter;
import java.io.IOException;

import static java.awt.SystemColor.window;


public class Feedback implements ActionListener
{
    JFrame frame = new JFrame("FEEDBACK IS IMPORTANT");
    JTextField feed =  new JTextField();
    JButton submitButton = new JButton("Submit");
    FileWriter fw;

    public void receiver() throws IOException
    {


        frame.getContentPane();
        GridLayout gl = new GridLayout();
        gl.setColumns(1);
        gl.setRows(2);
        frame.setLayout(gl);
        frame.add(feed);

        frame.add(submitButton);

        submitButton.addActionListener(this);

        frame.setSize(300,400);
        frame.getDefaultCloseOperation();
        frame.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent ex)
    {
        if(ex.getActionCommand()==submitButton.getActionCommand())
        {
            try{
                FileWriter fw=new FileWriter("C:\\Users\\hp\\IdeaProjects\\Hybrid RSA client Side Encryption Sec Digi Lock\\server\\Feedback.txt");
                fw.write(feed.getText());
                fw.close();
                JOptionPane.showMessageDialog(null, "Feedback Submitted");

            }catch(IOException e)
            {
                JOptionPane.showMessageDialog(null, "error");
            }
        }

    }

    /*public static void main(String[] args) throws IOException
    {
        Feedback f = new Feedback();
        try
        {
            f.receiver();

        }catch(IOException e)
        {
            System.out.println("Error in Receiving Feedback");
        }
    }*/
}