package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AdminFunctions extends JFrame implements ActionListener{
    final private JFrame AdminFrame = new JFrame("Login Successful. Welcome Admin");
    final private JButton PrintQueue_but,ViewUser_but,EditUser_but,CostCal_but,Exit_but;
    AdminFunctions() {
        AdminFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;

        gbc.insets = new Insets(5, 5, 5, 5);
        AdminFrame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel l1 = new JLabel("Select a function:");
        AdminFrame.add(l1,gbc);

        gbc.gridx = 0;gbc.gridy = 1;
        gbc.ipadx = 30; gbc.ipady = 120;
        gbc.weightx = 1;gbc.weighty = 1;
        PrintQueue_but = new JButton("View Print Orders");
        PrintQueue_but.setBackground(new Color(0,255,255));
        PrintQueue_but.addActionListener(this);
        AdminFrame.add(PrintQueue_but,gbc);


        gbc.gridx = 1;gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 120;
        CostCal_but = new JButton("Calculate Printing Cost");
        CostCal_but.setBackground(new Color(0,255,128));
        CostCal_but.addActionListener(this);
        AdminFrame.add(CostCal_but,gbc);


        gbc.gridx = 0;gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 120;
        EditUser_but = new JButton("Add new User");
        EditUser_but.setBackground(new Color(250,250,51));
        EditUser_but.addActionListener(this);
        AdminFrame.add(EditUser_but,gbc);

        gbc.gridx = 1;gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 120;
        ViewUser_but = new JButton("View all Users");
        ViewUser_but.setBackground(new Color(244,164,96));
        ViewUser_but.addActionListener(this);
        AdminFrame.add(ViewUser_but,gbc);


        gbc.gridx = 0;gbc.gridy = 3;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.gridwidth = 2;
        Exit_but = new JButton("Logout");
        Exit_but.addActionListener(this);
        AdminFrame.add(Exit_but,gbc);


        AdminFrame.setLocationRelativeTo(null);
        AdminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdminFrame.setSize(450,417);
        AdminFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source =  e.getSource();
        if(Source == PrintQueue_but){
            new Print_Request_Record_GUI_Admin();
            AdminFrame.setVisible(false);
        }else if(Source == CostCal_but){
            new Print_Cost_Aggregation_GUI();
            AdminFrame.setVisible(false);
        }else if(Source == EditUser_but) {
            new User_Add();
            AdminFrame.setVisible(false);
        }else if(Source == ViewUser_but){
            new User_View();
            AdminFrame.setVisible(false);
        }else if(Source == Exit_but){
            new MainWindow();
            AdminFrame.setVisible(false);
        }
    }
}

class UserFunctions extends JFrame implements ActionListener {
    final private JFrame UserFrame;
    final private JButton OrderPrint_but, ViewPrint_but, Exit_but;
    int emp_id;
    String emp_name;
    UserFunctions(String Uname,int id) {
        emp_id = id;
        emp_name = Uname;
        UserFrame = new JFrame("Login Successful. Welcome "+Uname);
        UserFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;

        gbc.insets = new Insets(5, 5, 5, 5);
        UserFrame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        JLabel l1 = new JLabel("Select a function:");
        UserFrame.add(l1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 30;
        gbc.ipady = 120;
        gbc.weightx = 1;
        gbc.weighty = 1;
        OrderPrint_but = new JButton("Order Print");
        OrderPrint_but.setBackground(new Color(124, 252, 0));
        OrderPrint_but.addActionListener(this);
        UserFrame.add(OrderPrint_but, gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 0;
        gbc.ipady = 120;
        ViewPrint_but = new JButton("View Requests");
        ViewPrint_but.setBackground(new Color(250, 128, 114));
        ViewPrint_but.addActionListener(this);
        UserFrame.add(ViewPrint_but, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridwidth = 2;
        Exit_but = new JButton("Logout");
        Exit_but.addActionListener(this);
        UserFrame.add(Exit_but, gbc);

        UserFrame.setLocationRelativeTo(null);
        UserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UserFrame.setSize(450, 260);
        UserFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if (Source == OrderPrint_but) {
            new Print_Request_GUI(emp_name,emp_id);
            UserFrame.setVisible(false);
        } else if (Source == ViewPrint_but) {
            new Print_Request_Record_GUI_User(emp_name,emp_id);
            UserFrame.setVisible(false);
        } else if (Source == Exit_but) {
            new MainWindow();
            UserFrame.setVisible(false);
        }
    }
}


class ClerkFunctions extends JFrame implements ActionListener{
    final private JFrame ClerkFrame = new JFrame("Login Successful. Welcome Clerk");
    final private JButton Verification_but,Exit_but;
    ClerkFunctions() {
        ClerkFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;

        gbc.insets = new Insets(5, 5, 5, 5);
        ClerkFrame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel l1 = new JLabel("Select a function:");
        ClerkFrame.add(l1,gbc);


        gbc.gridx = 0;gbc.gridy = 1;
        gbc.ipadx = 20; gbc.ipady = 120;
        Verification_but = new JButton("Verify Prints");
        Verification_but.setBackground(new Color(0,255,128));
        Verification_but.addActionListener(this);
        ClerkFrame.add(Verification_but,gbc);

        gbc.gridx = 0;gbc.gridy = 2;
        gbc.ipadx = 0;gbc.ipady = 0;
        gbc.gridwidth = 2;
        Exit_but = new JButton("Logout");
        Exit_but.addActionListener(this);
        ClerkFrame.add(Exit_but, gbc);

        ClerkFrame.setLocationRelativeTo(null);
        ClerkFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ClerkFrame.setSize(350,260);
        ClerkFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source =  e.getSource();
        if(Source == Verification_but){
            new Print_Verification_GUI();
            ClerkFrame.setVisible(false);
        }else if(Source == Exit_but){
            new MainWindow();
            ClerkFrame.setVisible(false);
        }

    }

}


class DelivererFunctions extends JFrame implements ActionListener{
    final private JButton Delivery_but,Exit_but;
    final private JFrame DelivererFrame;

    public DelivererFunctions() {
        DelivererFrame = new JFrame("Print Delivery");
        DelivererFrame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        DelivererFrame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel l1 = new JLabel("Select a function:");
        DelivererFrame.add(l1,gbc);


        gbc.gridx = 0;gbc.gridy = 1;
        gbc.ipadx = 20; gbc.ipady = 120;
        Delivery_but = new JButton("Deliver Prints");
        Delivery_but.setBackground(new Color(0,255,128));
        Delivery_but.addActionListener(this);
        DelivererFrame.add(Delivery_but,gbc);

        gbc.gridx = 0;gbc.gridy = 2;
        gbc.ipadx = 0;gbc.ipady = 0;
        gbc.gridwidth = 2;
        Exit_but = new JButton("Logout");
        Exit_but.addActionListener(this);
        DelivererFrame.add(Exit_but, gbc);

        DelivererFrame.setSize(350, 260);
        DelivererFrame.setResizable(false);
        DelivererFrame.setLocationRelativeTo(null);
        DelivererFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DelivererFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source =  e.getSource();
        if(Source == Delivery_but){
            new Print_Delivery_GUI();
            DelivererFrame.setVisible(false);
        }else if(Source == Exit_but){
            new MainWindow();
            DelivererFrame.setVisible(false);
        }
    }
}

