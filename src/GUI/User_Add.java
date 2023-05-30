package GUI;

import Database.Database_Connection;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class User_Add extends JFrame implements ActionListener {

    final private JTextField Emp_Name_text,Contact_text,Department_text,Room_No_text,Username_text;
    final private JPasswordField Pass_text,Conf_Pass_text;
    final private JTextArea Message_ar;
    final private JButton Add_but,Reset_but,Exit_but;
    final private JRadioButton Yes_but,No_but;
    final private ButtonGroup group1;
    final private JFrame Add_user_frame;


    public User_Add(){
        Add_user_frame = new JFrame("New User Registration");
        Add_user_frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        Add_user_frame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel lab1 = new JLabel("Fill all the Details:");
        Add_user_frame.add(lab1,gbc);


        gbc.gridx = 0; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Emp_Name_lab = new JLabel("Employee Name:");
        Add_user_frame.add(Emp_Name_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.ipadx = 350; gbc.ipady = 0;
        Emp_Name_text = new JTextField();
        Emp_Name_text.setColumns(40);
        Add_user_frame.add(Emp_Name_text,gbc);

        gbc.gridx = 2; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 0;
        Reset_but = new JButton("Reset");
        Add_user_frame.add(Reset_but,gbc);
        Reset_but.addActionListener(this);

        gbc.gridx = 2; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        Add_but = new JButton("Add");
        Add_user_frame.add(Add_but,gbc);
        Add_but.addActionListener(this);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Contact_lab = new JLabel("Contact:");
        Add_user_frame.add(Contact_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.ipadx = 350; gbc.ipady = 0;
        Contact_text = new JTextField();
        Contact_text.setColumns(40);
        Add_user_frame.add(Contact_text,gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Department_lab = new JLabel("Department:");
        Add_user_frame.add(Department_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        gbc.ipadx = 0; gbc.ipady = 0;
        Department_text = new JTextField();
        Department_text.setColumns(40);
        Add_user_frame.add(Department_text,gbc);

        
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Room_No_lab = new JLabel("Room No:");
        Add_user_frame.add(Room_No_lab,gbc);
        

        gbc.gridx = 1; gbc.gridy = 4;
        gbc.ipadx = 0; gbc.ipady = 0;
        Room_No_text = new JTextField();
        Room_No_text.setColumns(40);
        Add_user_frame.add(Room_No_text,gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Username_lab = new JLabel("Username:");
        Add_user_frame.add(Username_lab,gbc);


        gbc.gridx = 1; gbc.gridy = 5;
        gbc.ipadx = 0; gbc.ipady = 0;
        Username_text = new JTextField();
        Username_text.setColumns(40);
        Add_user_frame.add(Username_text,gbc);

        gbc.gridx = 0; gbc.gridy = 6;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Pass_lab = new JLabel("Password:");
        Add_user_frame.add(Pass_lab,gbc);


        gbc.gridx = 1; gbc.gridy = 6;
        gbc.ipadx = 0; gbc.ipady = 0;
        Pass_text = new JPasswordField();
        Pass_text.setColumns(40);
        Add_user_frame.add(Pass_text,gbc);


        gbc.gridx = 0; gbc.gridy = 7;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Conf_Pass_lab = new JLabel("Confirm Password:");
        Add_user_frame.add(Conf_Pass_lab,gbc);


        gbc.gridx = 1; gbc.gridy = 7;
        gbc.ipadx = 0; gbc.ipady = 0;
        Conf_Pass_text = new JPasswordField();
        Conf_Pass_text.setColumns(40);
        Add_user_frame.add(Conf_Pass_text,gbc);


        gbc.gridx = 0; gbc.gridy = 8;
        JLabel Elig_Label = new JLabel("Print Eligibility:");
        Add_user_frame.add(Elig_Label,gbc);

        gbc.gridx = 1; gbc.gridy = 8;
        Yes_but = new JRadioButton("Yes");
        Yes_but.setActionCommand("Yes");
        Add_user_frame.add(Yes_but,gbc);

        gbc.gridx = 2; gbc.gridy = 8;
        No_but = new JRadioButton("No");
        No_but.setActionCommand("No");
        Add_user_frame.add(No_but,gbc);

        group1 = new ButtonGroup();
        group1.add(Yes_but);
        group1.add(No_but);

        No_but.setSelected(true);


        gbc.insets = new Insets(25,13,5,0);
        gbc.gridx = 0; gbc.gridy = 9;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Message_lab = new JLabel("Message:");
        Add_user_frame.add(Message_lab,gbc);


        gbc.insets = new Insets(0,13,13,13);
        gbc.gridx = 0; gbc.gridy = 10;
        gbc.ipadx = 0; gbc.ipady = 20;gbc.gridwidth = 3;
        Message_ar = new JTextArea();
        Message_ar.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Message_ar.setBorder(border);
        Add_user_frame.add(Message_ar,gbc);

        gbc.gridx = 0;gbc.gridy = 11;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.gridwidth = 3;
        Exit_but = new JButton("Exit");
        Exit_but.addActionListener(this);
        Add_user_frame.add(Exit_but,gbc);

        Add_user_frame.setSize(600,470);
        Add_user_frame.setResizable(false);
        Add_user_frame.setLocationRelativeTo(null);
        Add_user_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Add_user_frame.setVisible(true);


    }

    private void ClearForm(){
        Emp_Name_text.setText(null);
        Contact_text.setText(null);
        Department_text.setText(null);
        Room_No_text.setText(null);
        Username_text.setText(null);
        Pass_text.setText(null);
        Conf_Pass_text.setText(null);
        group1.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        Connection con = Database_Connection.connect();
        PreparedStatement p;
        ResultSet rs;

        if(Source == Add_but){
            int id = 0;
            String name = Emp_Name_text.getText();
            String phone = Contact_text.getText();
            String department = Department_text.getText();
            String room = Room_No_text.getText();
            String username = Username_text.getText();
            String pass = new String(Conf_Pass_text.getPassword());
            String elig = group1.getSelection().getActionCommand();

            String sql = "Insert into employee_details(name,phone,department,room_no,print_elig) values('" +name+"','"
                    +phone+"','"+department+"','"+room+"','"+elig+"')";
            try {
                Statement stmt = con.createStatement();
                int x = stmt.executeUpdate(sql);
                if (x > 0)
                    System.out.println("Successfully Inserted");
                else
                    System.out.println("Insert Failed");
            }catch (SQLException e1) {
                Message_ar.setText("Error!!! Record Not Added");
            }

            try {
                sql = "select * from employee_details WHERE name =?";
                p = con.prepareStatement(sql);
                p.setString(1,name);
                rs = p.executeQuery();

                while (rs.next()) {
                    id = rs.getInt("empid");
                }
            }catch (SQLException e2) {
                System.out.println(e2.getClass().getName()+": "+e2.getMessage());
            }

            sql = "Insert into login_details(username, password, empid) values('" +username+"','"
                    +pass+"','"+id+"')";
            try {
                Statement stmt = con.createStatement();
                int x = stmt.executeUpdate(sql);
                if (x > 0)
                    System.out.println("Successfully Inserted");
                else
                    System.out.println("Insert Failed");
            }catch (SQLException e1) {
                Message_ar.setText("Error!!! Record Not Added");
            }
            ClearForm();
            Message_ar.setText("Successfully Added New User");

        }else if(Source == Reset_but){
            ClearForm();
        }else if(Source == Exit_but){
            Add_user_frame.setVisible(false);
            new AdminFunctions();
        }
    }

}

