package GUI;

import BasicClasses.Print_Verification;
import Database.Database_Connection;
import TableModel.VerificationTableModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.transform.Source;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Print_Verification_GUI extends JFrame implements ActionListener {
    final private JTextField Request_Id_text;
    final private JTextArea Message_ar;
    final private JButton Search_but,Exit_but;
    final private JTable Verification_Table;
    final private JFrame ClerkFrame;
    Connection con = Database_Connection.connect();
    PreparedStatement p;
    ResultSet rs;

    public Print_Verification_GUI() {
        ClerkFrame = new JFrame("Print Verification");
        ClerkFrame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 25, 5);
        ClerkFrame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0; gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 1;
        JLabel Request_Id_lab = new JLabel("Request Id:");
        ClerkFrame.add(Request_Id_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.ipadx = 290; gbc.ipady = 3;

        Request_Id_text = new JTextField("");
        ClerkFrame.add(Request_Id_text,gbc);

        gbc.gridx = 2; gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;
        Search_but = new JButton("Search");
        ClerkFrame.add(Search_but,gbc);
        Search_but.addActionListener(this);

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;gbc.gridy = 1;
        gbc.ipadx = 0;gbc.ipady = 0;
        gbc.weightx = 1;gbc.weighty = 1;
        JLabel Print_Id_lab = new JLabel("Print Records:");
        ClerkFrame.add(Print_Id_lab, gbc);
        ArrayList<Print_Verification> myList = getPrints();
        VerificationTableModel tablemodel = new VerificationTableModel(myList);

        gbc.gridx = 0;gbc.gridy = 2;
        gbc.ipadx = 0;gbc.ipady = 180;
        gbc.gridwidth = 3;
        Verification_Table = new JTable(tablemodel);
        Verification_Table.setRowSelectionAllowed(true);
        JScrollPane pane1 = new JScrollPane(Verification_Table);
        ClerkFrame.add(pane1, gbc);

        gbc.insets = new Insets(25,13,5,0);
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Message_lab = new JLabel("Message:");
        ClerkFrame.add(Message_lab,gbc);

        gbc.insets = new Insets(0,13,0,13);
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.ipadx = 0; gbc.ipady = 20;
        gbc.weightx = 1;gbc.weighty=1;
        Message_ar = new JTextArea();
        Message_ar.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Message_ar.setBorder(border);
        ClerkFrame.add(Message_ar,gbc);

        gbc.gridx = 0;gbc.gridy = 5;
        gbc.ipadx = 0;gbc.ipady = 0;
        Exit_but = new JButton("Exit");
        Exit_but.addActionListener(this);
        ClerkFrame.add(Exit_but, gbc);


        ClerkFrame.setSize(500, 470);
        ClerkFrame.setResizable(false);
        ClerkFrame.setLocationRelativeTo(null);
        ClerkFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ClerkFrame.setVisible(true);
    }

    public ArrayList<Print_Verification> getPrints() {
        ArrayList<Print_Verification> myList = new ArrayList<>();
        try {
            rs = con.createStatement().executeQuery("select * from print_details");
            while (rs.next()) {
                myList.add(new Print_Verification(rs.getInt("reqid"),rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if(Source == Search_but){
            int req_id = Integer.parseInt(Request_Id_text.getText());
            new Print_Verification_Record_GUI(req_id);
            ClerkFrame.setVisible(false);
        }else if (Source == Exit_but) {
            ClerkFrame.setVisible(false);
            new ClerkFunctions();
        }
    }
}
