/**
 * Created by hp on 30-03-2018.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login implements ActionListener
{
    JFrame frame2 = new JFrame("Login Form:");
    JTextField namefieldL =  new JTextField();
    JPasswordField passfieldL=  new JPasswordField();
    JButton validateButton = new JButton("Login");
    SecDigiLock us;
    Login(SecDigiLock is)
    {
        us = is;
    }
    int val=3;
    @Override
    public void actionPerformed(ActionEvent ex) {
        if (ex.getActionCommand() == validateButton.getActionCommand()) {
            String uname = namefieldL.getText();
            int ps = Integer.parseInt(passfieldL.getText());
            int i;
            for (i = 0; i < us.count; i++) {
                if (uname == us.name[i]) {
                    if (us.getpassword(i) == ps) {
                        val = 1;
                        JOptionPane.showMessageDialog(null, "Validation successful");
                        frame2.getDefaultCloseOperation();

                        break;
                    } else {
                        val = 0;
                    }
                }
            }
            if (val == 0) {

                JOptionPane.showMessageDialog(null, "Invalid User name or Password");
                frame2.getDefaultCloseOperation();
                frame2.setVisible(false);
            }

        }
    }
    int validateUser()
    {

        JLabel l1 = new JLabel("Login Form:");
        JLabel l2 = new JLabel("****************");
        JLabel l3 = new JLabel("User Name: ");
        JLabel l4 = new JLabel("Password: ");
        frame2.getContentPane();
        GridLayout gn = new GridLayout();
        gn.setColumns(2);
        gn.setRows(9);
        frame2.setLayout(gn);
        frame2.add(l1);
        frame2.add(l2);
        frame2.add(l3);
        frame2.add(namefieldL);
        frame2.add(l4);
        frame2.add(passfieldL);
        frame2.add(validateButton);


        frame2.setSize(200,300);
        //frame2.getDefaultCloseOperation();
        frame2.setVisible(true);

        validateButton.addActionListener(this);

        return val;

    }
}
