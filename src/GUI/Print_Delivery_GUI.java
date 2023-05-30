package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

import BasicClasses.Print_Delivery;
import Database.Database_Connection;
import TableModel.DeliveryTableModel;

public class Print_Delivery_GUI extends JFrame implements ActionListener {
    final private JTextField Request_Id_text,Emp_Name_text,Room_No_text,Contact_text;
    final private JTextArea Message_ar;
    final private JButton Search_but,Deliver_but,Exit_but;
    final private JTable Print_Delivery_Table;
    final private JFrame frame;
    Connection con = Database_Connection.connect();
    PreparedStatement p;
    ResultSet rs;

    public Print_Delivery_GUI(){
        frame = new JFrame("Print Delivery");
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5,10,25,5);
        frame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Main Search
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Request_Id_lab = new JLabel("Request Id:");
        frame.add(Request_Id_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.ipadx = 350; gbc.ipady = 3;
        Request_Id_text = new JTextField();
        frame.add(Request_Id_text,gbc);

        gbc.gridx = 2; gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        Search_but = new JButton("Search");
        frame.add(Search_but,gbc);
        Search_but.addActionListener(this);


        gbc.insets = new Insets(5,10,5,5);
        // Search Output
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Emp_Name_lab = new JLabel("Staff Name:");
        frame.add(Emp_Name_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.ipadx = 350; gbc.ipady = 0;
        Emp_Name_text = new JTextField();
        Emp_Name_text.setEditable(false);
        Emp_Name_text.setColumns(40);
        frame.add(Emp_Name_text,gbc);


        gbc.gridx = 0; gbc.gridy = 2;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Room_No_lab = new JLabel("Room No:");
        frame.add(Room_No_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.ipadx = 350; gbc.ipady = 0;
        Room_No_text = new JTextField();
        Room_No_text.setEditable(false);
        Room_No_text.setColumns(40);
        frame.add(Room_No_text,gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Contact_lab = new JLabel("Contact:");
        frame.add(Contact_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        gbc.ipadx = 350; gbc.ipady = 0;
        Contact_text = new JTextField();
        Contact_text.setEditable(false);
        Contact_text.setColumns(40);
        frame.add(Contact_text,gbc);


        gbc.gridx = 0; gbc.gridy = 4;gbc.gridwidth = 0;
        gbc.ipadx = 500; gbc.ipady = 150;

        ArrayList<Print_Delivery> myList = getPrints();
        DeliveryTableModel tablemodel = new DeliveryTableModel(myList);
        Print_Delivery_Table = new JTable(tablemodel);
        Print_Delivery_Table.setRowSelectionAllowed(true);
        JScrollPane pane1 = new JScrollPane(Print_Delivery_Table);
        frame.add(pane1, gbc);


        gbc.gridx = 2; gbc.gridy = 5;
        gbc.ipadx = 0; gbc.ipady = 0;
        Deliver_but = new JButton("Deliver");
        Deliver_but.setEnabled(false);
        Deliver_but.addActionListener(this);
        frame.add(Deliver_but,gbc);

        gbc.insets = new Insets(25,13,5,0);
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Message_lab = new JLabel("Message:");
        frame.add(Message_lab,gbc);


        gbc.insets = new Insets(0,13,0,13);
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.ipadx = 0; gbc.ipady = 20;
        gbc.weightx = 1;gbc.weighty=1;
        Message_ar = new JTextArea();
        Message_ar.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Message_ar.setBorder(border);
        frame.add(Message_ar,gbc);

        gbc.gridx = 0; gbc.gridy = 8;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.gridwidth = 3;
        Exit_but = new JButton("Exit");
        Exit_but.addActionListener(this);
        frame.add(Exit_but,gbc);

        frame.setSize(560,520);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public void ClearForm(){
        Request_Id_text.setText(null);
        Emp_Name_text.setText(null);
        Room_No_text.setText(null);
        Contact_text.setText(null);
    }
    public ArrayList<Print_Delivery> getPrints() {
        ArrayList<Print_Delivery> myList = new ArrayList<>();
        try {
            rs = con.createStatement().executeQuery("select * from delivery_details");
            while (rs.next()) {
                myList.add(new Print_Delivery(rs.getInt("reqid"), rs.getString("filename"),
                        rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myList;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        int Request_id = 0;

        if(Source == Search_but){
            Request_id = Integer.parseInt(Request_Id_text.getText()) ;
            try {
                String sql = "select name,room_no,phone from employee_details,print_details WHERE " +
                        "print_details.empid = employee_details.empid and print_details.reqid = ?";
                p = con.prepareStatement(sql);
                p.setInt(1,Request_id);
                rs = p.executeQuery();

                while (rs.next()) {
                    String Name = rs.getString("name");
                    String Room = rs.getString("room_no");
                    String Contact = rs.getString("phone");
                    Emp_Name_text.setText(Name);
                    Room_No_text.setText(Room);
                    Contact_text.setText(Contact);
                }
                Deliver_but.setEnabled(true);
            }
            catch (SQLException e1) {
                Message_ar.setText("Request Id not found");
            }
        }else if(Source == Deliver_but){
            Request_id = Integer.parseInt(Request_Id_text.getText()) ;
            try {
                String sql = "UPDATE delivery_details set status = 'Delivered' WHERE reqid =" + Request_id;
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                Message_ar.setText("Successfully Delivered");
                ClearForm();
                Deliver_but.setEnabled(false);

            }catch (SQLException e1) {
                Message_ar.setText("Error!!! Record Not Updated");
            }
            frame.setVisible(true);
            this.dispose();
        }else if(Source == Exit_but){
            frame.setVisible(false);
            new DelivererFunctions();
        }
    }
    public static void main(String[] args){
        new Print_Delivery_GUI();
    }
}
