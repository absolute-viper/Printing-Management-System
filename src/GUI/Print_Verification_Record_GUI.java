package GUI;

import Database.Database_Connection;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Print_Verification_Record_GUI extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Print Request Verification");
    JTextField Request_Id_text,Paper_Size_text, Emp_Id_text, Paper_Color_text,Print_Elig_text,Task_text,Paper_Sides_text,
            Paper_Orientation_text,Paper_Copies_text,File_Name_text;
    JLabel L1,L2,L3,L4,L5,L6,L7,L8;
    JTextArea Message_ar;
    JButton verify,reject,view,exit;
    Connection con = Database_Connection.connect();
    PreparedStatement p;
    ResultSet rs;
    int req_id;


    public Print_Verification_Record_GUI(int id)
    {
        req_id = id;
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.insets = new Insets(5,10,5,5);
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 1;
        JLabel Request_Id_lab = new JLabel("Request Id:");
        frame.add(Request_Id_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 3;
        Request_Id_text = new JTextField(String.valueOf(req_id));
        Request_Id_text.setEditable(false);
        frame.add(Request_Id_text,gbc);

        gbc.gridx = 2; gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        view = new JButton("Select");
        view.addActionListener(this);
        frame.add(view,gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Emp_Id_lab = new JLabel("Employee Id");
        frame.add(Emp_Id_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        Emp_Id_text = new JTextField();
        Emp_Id_text.setEditable(false);
        frame.add(Emp_Id_text,gbc);


        gbc.gridx = 0; gbc.gridy = 2;
        gbc.ipadx = 2; gbc.ipady = 0;
        JLabel Print_Elig_lab = new JLabel("Print Eligibility:");
        frame.add(Print_Elig_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 2;
        Print_Elig_text = new JTextField();
        Print_Elig_text.setEditable(false);
        frame.add(Print_Elig_text,gbc);

        gbc.insets = new Insets(25,5,5,5);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.ipadx = 0; gbc.ipady = 0;
        L1 = new JLabel("File Name:");
        frame.add(L1,gbc);

        gbc.gridx = 1; gbc.gridy =3;
        gbc.ipadx = 0; gbc.ipady = 0;
        File_Name_text = new JTextField();
        File_Name_text.setEditable(false);
        frame.add(File_Name_text,gbc);



        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0; gbc.gridy = 4;
        L2 = new JLabel("Paper Size:");
        frame.add(L2,gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        gbc.ipadx = 0;gbc.ipady = 0;
        Paper_Size_text = new JTextField();
        Paper_Size_text.setEditable(false);
        frame.add(Paper_Size_text,gbc);


        gbc.gridx = 0; gbc.gridy = 5;
        gbc.ipadx = 0;gbc.ipady = 0;
        L3 = new JLabel("Orientation:");
        frame.add(L3,gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        gbc.ipadx = 0;gbc.ipady = 0;
        Paper_Orientation_text = new JTextField();
        Paper_Orientation_text.setEditable(false);
        frame.add(Paper_Orientation_text,gbc);


        gbc.gridx = 0; gbc.gridy = 6;
        gbc.ipadx = 0;gbc.ipady = 0;
        L4 = new JLabel("Colour:");
        frame.add(L4,gbc);

        gbc.gridx = 1; gbc.gridy = 6;
        gbc.ipadx = 0;gbc.ipady = 0;
        Paper_Color_text = new JTextField();
        Paper_Color_text.setEditable(false);
        frame.add(Paper_Color_text,gbc);



        gbc.gridx = 0; gbc.gridy = 7;
        gbc.ipadx = 0;gbc.ipady = 0;
        L5 = new JLabel("2 Sided Printing:");
        frame.add(L5,gbc);

        gbc.gridx = 1; gbc.gridy = 7;
        gbc.ipadx = 0;gbc.ipady = 0;
        Paper_Sides_text = new JTextField();
        Paper_Sides_text.setEditable(false);
        frame.add(Paper_Sides_text,gbc);


        gbc.gridx = 0; gbc.gridy = 8;
        gbc.ipadx = 0;gbc.ipady = 0;
        L6 = new JLabel("Copies:");
        frame.add(L6,gbc);

        gbc.gridx = 1; gbc.gridy = 8;
        gbc.ipadx = 0;gbc.ipady = 0;
        Paper_Copies_text = new JTextField();
        Paper_Copies_text.setEditable(false);
        frame.add(Paper_Copies_text,gbc);


        gbc.gridx = 0; gbc.gridy = 9;
        gbc.ipadx = 0;gbc.ipady = 0;
        L7 = new JLabel("Task Type:");
        frame.add(L7,gbc);

        gbc.gridx = 1; gbc.gridy = 9;
        gbc.ipadx = 0;gbc.ipady = 0;
        Task_text = new JTextField();
        Task_text.setEditable(false);
        frame.add(Task_text,gbc);

        gbc.insets = new Insets(25,50,5,5);
        gbc.gridx = 1; gbc.gridy = 10;
        gbc.ipadx = 0;gbc.ipady = 0;
        verify = new JButton("Verify");
        verify.addActionListener(this);
        frame.add(verify,gbc);

        gbc.insets = new Insets(25,10,5,5);
        gbc.gridx = 2; gbc.gridy = 10;
        gbc.ipadx = 0;gbc.ipady = 0;
        reject = new JButton("Reject");
        reject.addActionListener(this);
        frame.add(reject,gbc);


        gbc.insets = new Insets(25,15,5,5);
        gbc.gridx = 0; gbc.gridy = 11;
        L8 = new JLabel("Message:");
        frame.add(L8,gbc);


        gbc.insets = new Insets(5,13,0,13);
        gbc.gridx = 0; gbc.gridy = 12;
        gbc.ipadx = 0; gbc.ipady = 30;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        Message_ar = new JTextArea();
        Message_ar.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Message_ar.setBorder(border);
        frame.add(Message_ar,gbc);


        gbc.gridx = 0;gbc.gridy = 13;
        gbc.ipadx = 0;gbc.ipady = 0;
        gbc.gridwidth = 3;
        exit = new JButton("Exit");
        exit.addActionListener(this);
        frame.add(exit, gbc);

        frame.setSize(480,580);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Elig = "";
        try {
            String sql = "select print_elig from employee_details,print_details where print_details.reqid = ? " +
                    "and employee_details.empid=print_details.reqid";
            assert con != null;
            p = con.prepareStatement(sql);
            p.setInt(1, req_id);
            rs = p.executeQuery();
            while (rs.next()){
                Elig = rs.getString("print_elig");
            }
        }catch (SQLException e1) {
        System.out.println("Error");
    }

        try {
            String sql = "select * from print_details where reqid = ?";
            assert con != null;
            p = con.prepareStatement(sql);
            p.setInt(1, req_id);
            rs = p.executeQuery();


            while (rs.next()) {
                String empid = rs.getString("empid");
                String Paper_Size = rs.getString("papersize");
                String Orientation = rs.getString("orientation");
                String File = rs.getString("filename");
                String Color = rs.getString("color");
                String Sides = rs.getString("doublesided");
                String copies = rs.getString("copies");
                String Task_type = rs.getString("tasktype");


                Emp_Id_text.setText(empid);
                Print_Elig_text.setText(Elig);
                File_Name_text.setText(File);
                Paper_Size_text.setText(Paper_Size);
                Paper_Orientation_text.setText(Orientation);
                Paper_Color_text.setText(Color);
                Paper_Sides_text.setText(Sides);
                Paper_Copies_text.setText(copies);
                Task_text.setText(Task_type);

            }
        }catch (SQLException e1) {
            System.out.println("Error");
        }
        if (e.getSource() == verify) {
            JOptionPane.showMessageDialog(frame, "Successfully Verified");

            String sql = "Insert into delivery_details(reqid, filename) values('" +req_id+"','" +File_Name_text.getText()+"')";
            try {
                Statement stmt = con.createStatement();
                int x = stmt.executeUpdate(sql);
                if (x > 0)
                    System.out.println("Successfully Verified");
                else
                    System.out.println("Insert Failed");
            }catch (SQLException e1) {
                System.out.println("Error!!! Record Verification Failed");
            }

            try {
                sql = "UPDATE print_details set status = 'Verified' WHERE reqid =" + req_id;
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                Message_ar.setText("Successfully Delivered");

            }catch (SQLException e1) {
                Message_ar.setText("Error!!! Record Not Updated");
            }
            new Print_Verification_GUI();
            frame.setVisible(false);
        }else if (e.getSource() == reject) {
            JOptionPane.showMessageDialog(frame, "Request Rejected");
            try {
                String sql = "UPDATE print_details set status = 'Rejected' WHERE reqid =" + req_id;
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                Message_ar.setText("Successfully Rejected");

            }catch (SQLException e1) {
                Message_ar.setText("Error!!! Record Not Updated");
            }
            new Print_Verification_GUI();
            frame.setVisible(false);
        }else if(e.getSource() == exit){
            frame.setVisible(false);
            new Print_Verification_GUI();
        }

    }
}

