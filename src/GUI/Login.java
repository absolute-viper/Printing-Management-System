package GUI;
import BasicClasses.User;
import Database.Database_Connection;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class LoginAdmin extends JFrame implements ActionListener {
    final private JFrame Lframe = new JFrame("Admin Login");
    final private JButton Submit_but,Exit_but;
    final private JTextField User_text;
    final private JPasswordField Pass_text;
    LoginAdmin(){
        Lframe.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;

        gbc.insets = new Insets(5, 5, 10, 5);
        Lframe.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;gbc.weighty = 1;
        JLabel l1 = new JLabel("Login Page:");
        Lframe.add(l1, gbc);

        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel User_label = new JLabel("Username: ");
        Lframe.add(User_label,gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 1;gbc.weighty = 0;
        User_text = new JTextField();
        Lframe.add(User_text,gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;gbc.weighty = 1;
        JLabel Pass_label = new JLabel("Password: ");
        Lframe.add(Pass_label,gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 0;
        Pass_text = new JPasswordField();
        Lframe.add(Pass_text,gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.ipadx = 0; gbc.ipady = 25;
        gbc.weightx = 0; gbc.gridwidth = 2;
        Submit_but = new JButton("Login");
        Submit_but.addActionListener(this);
        Lframe.add(Submit_but,gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.ipadx = 0; gbc.ipady = 0;
        Exit_but = new JButton("Exit");
        Exit_but.addActionListener(this);
        Lframe.add(Exit_but,gbc);

        Lframe.setSize(400, 240);
        Lframe.setResizable(false);
        Lframe.setLocationRelativeTo(null);
        Lframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lframe.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if(Source == Submit_but){
            new AdminFunctions();
            Lframe.setVisible(false);
        }else if(Source == Exit_but){
            new MainWindow();
            Lframe.setVisible(false);
        }
    }
}


class LoginUser extends JFrame implements ActionListener {
    final private JFrame Lframe = new JFrame("User Login");
    final private JButton Submit_but,Exit_but;
    final private JLabel Error_lab;
    final private JTextField User_text;
    final private JPasswordField Pass_text;
    Connection con = Database_Connection.connect();
    PreparedStatement p;
    ResultSet rs;
    LoginUser(){

        Lframe.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;

        gbc.insets = new Insets(5, 5, 10, 5);
        Lframe.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;gbc.weighty = 1;
        JLabel l1 = new JLabel("Login Page:");
        Lframe.add(l1, gbc);

        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel User_label = new JLabel("Username: ");
        Lframe.add(User_label,gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 1;gbc.weighty = 1;
        User_text = new JTextField();
        Lframe.add(User_text,gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;gbc.weighty = 1;
        JLabel Pass_label = new JLabel("Password: ");
        Lframe.add(Pass_label,gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 0;
        Pass_text = new JPasswordField();
        Lframe.add(Pass_text,gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;gbc.gridwidth = 2;
        Error_lab = new JLabel("");
        Lframe.add(Error_lab,gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.ipadx = 0; gbc.ipady = 25;
        gbc.weightx = 0;gbc.gridwidth = 2;
        Submit_but = new JButton("Login");
        Submit_but.addActionListener(this);
        Lframe.add(Submit_but,gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        gbc.ipadx = 0; gbc.ipady = 0;
        Exit_but = new JButton("Exit");
        Exit_but.addActionListener(this);
        Lframe.add(Exit_but,gbc);


        Lframe.setSize(400, 240);
        Lframe.setResizable(false);
        Lframe.setLocationRelativeTo(null);
        Lframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lframe.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        boolean flag = false;
        int id = 0;

        if(Source == Submit_but){
            ArrayList<User> myList = new ArrayList<>();
            try{
                String sql ="select * from login_details";
                p = con.prepareStatement(sql);
                rs = p.executeQuery();
                while(rs.next()) {
                    myList.add(new User(rs.getString("username"),rs.getString("password"),
                            rs.getInt("empid")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            for (User user : myList) {
                if (user.getUsername().equals(User_text.getText()) &&
                        user.getPassword().equals(new String(Pass_text.getPassword()))) {
                    id = user.getEmpid();
                    flag = true;
                }else{
                    Error_lab.setText("Wrong Username or Password");
                    Error_lab.setForeground(new Color(245, 6, 6));
                }
            }
            if(flag) {
                System.out.println(id);
                new UserFunctions(User_text.getText(),id);
                Lframe.setVisible(false);
            }

        }else if(Source == Exit_but){
            new MainWindow();
            Lframe.setVisible(false);
        }
    }
}


class LoginClerk extends JFrame implements ActionListener {
    final private JFrame Lframe = new JFrame("Clerk Login");
    final private JButton Submit_but,Exit_but;
    final private JTextField User_text;
    final private JPasswordField Pass_text;
    LoginClerk(){
        Lframe.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;

        gbc.insets = new Insets(5, 5, 10, 5);
        Lframe.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;gbc.weighty = 1;
        JLabel l1 = new JLabel("Login Page:");
        Lframe.add(l1, gbc);

        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel User_label = new JLabel("Username: ");
        Lframe.add(User_label,gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 1;gbc.weighty = 0;
        User_text = new JTextField();
        Lframe.add(User_text,gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;gbc.weighty = 1;
        JLabel Pass_label = new JLabel("Password: ");
        Lframe.add(Pass_label,gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 0;
        Pass_text = new JPasswordField();
        Lframe.add(Pass_text,gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.ipadx = 0; gbc.ipady = 25;
        gbc.weightx = 0; gbc.gridwidth = 2;
        Submit_but = new JButton("Login");
        Submit_but.addActionListener(this);
        Lframe.add(Submit_but,gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.ipadx = 0; gbc.ipady = 0;
        Exit_but = new JButton("Exit");
        Exit_but.addActionListener(this);
        Lframe.add(Exit_but,gbc);

        Lframe.setSize(400, 240);
        Lframe.setResizable(false);
        Lframe.setLocationRelativeTo(null);
        Lframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lframe.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if(Source == Submit_but){
            new ClerkFunctions();
            Lframe.setVisible(false);
        }else if(Source == Exit_but){
            new MainWindow();
            Lframe.setVisible(false);
        }

    }
}

class LoginDeliverer extends JFrame implements ActionListener {
    final private JFrame Lframe = new JFrame("Deliverer Login");
    final private JButton Submit_but,Exit_but;
    final private JTextField User_text;
    final private JPasswordField Pass_text;
    LoginDeliverer(){
        Lframe.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;

        gbc.insets = new Insets(5, 5, 10, 5);
        Lframe.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;gbc.weighty = 1;
        JLabel l1 = new JLabel("Login Page:");
        Lframe.add(l1, gbc);

        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel User_label = new JLabel("Username: ");
        Lframe.add(User_label,gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 1;gbc.weighty = 0;
        User_text = new JTextField();
        Lframe.add(User_text,gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;gbc.weighty = 1;
        JLabel Pass_label = new JLabel("Password: ");
        Lframe.add(Pass_label,gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 0;
        Pass_text = new JPasswordField();
        Lframe.add(Pass_text,gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.ipadx = 0; gbc.ipady = 25;
        gbc.weightx = 0; gbc.gridwidth = 2;
        Submit_but = new JButton("Login");
        Submit_but.addActionListener(this);
        Lframe.add(Submit_but,gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.ipadx = 0; gbc.ipady = 0;
        Exit_but = new JButton("Exit");
        Exit_but.addActionListener(this);
        Lframe.add(Exit_but,gbc);

        Lframe.setSize(400, 240);
        Lframe.setResizable(false);
        Lframe.setLocationRelativeTo(null);
        Lframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lframe.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if(Source == Submit_but){
            new DelivererFunctions();
            Lframe.setVisible(false);
        }else if(Source == Exit_but){
            new MainWindow();
            Lframe.setVisible(false);
        }
    }
}

