package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    final private JButton User_but,Clerk_but,Delivery_but,Admin_but, Exit_but;
    final private JFrame MainFrame;
    
    public MainWindow() {
        MainFrame = new JFrame("Welcome");
        MainFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;

        gbc.insets = new Insets(5, 5, 10, 5);
        MainFrame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel l1 = new JLabel("Select User:");
        MainFrame.add(l1, gbc);

        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.weightx = 1;gbc.weighty = 1;
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.ipadx = 23; gbc.ipady = 70;
        User_but = new JButton("User");
        User_but.setBackground(new Color(250,128,114));
        User_but.addActionListener(this);
        MainFrame.add(User_but,gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 70;
        Admin_but = new JButton("Admin");
        Admin_but.addActionListener(this);
        Admin_but.setBackground(new Color(241,78,35));
        MainFrame.add(Admin_but,gbc);


        gbc.gridx = 0; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 70;
        gbc.weighty = 1;
        Clerk_but = new JButton("Clerk");
        Clerk_but.setBackground(new Color(241,78,35));
        Clerk_but.addActionListener(this);
        MainFrame.add(Clerk_but,gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 70;
        gbc.weighty = 1;
        Delivery_but = new JButton("Deliverer");
        Delivery_but.setBackground(new Color(250,128,114));
        Delivery_but.addActionListener(this);
        MainFrame.add(Delivery_but,gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;gbc.gridwidth = 2;
        Exit_but = new JButton("Exit");
        Exit_but.addActionListener(this);
        MainFrame.add(Exit_but,gbc);

        MainFrame.setSize(400, 300);
        MainFrame.setResizable(false);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if(Source == Admin_but){
            new LoginAdmin();
            MainFrame.setVisible(false);
        }else if(Source == User_but){
            new LoginUser();
            MainFrame.setVisible(false);
        }else if(Source == Clerk_but){
            new LoginClerk();
            MainFrame.setVisible(false);
        }else if(Source == Delivery_but){
            new LoginDeliverer();
            MainFrame.setVisible(false);
        } else if(Source == Exit_but){
            System.exit(0);
        }
    }

}

