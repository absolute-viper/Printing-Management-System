package GUI;
import Database.Database_Connection;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;
import java.util.Objects;

public class Print_Request_GUI extends JFrame implements ActionListener{

    JLabel L1,L2,L3,L4,L5,L6,L7,L8,FileName;
    JButton SelectFile,reset,submit,exit;
    JRadioButton portrait,landscape,colour,grayscale,official,personal;
    ButtonGroup group1,group2,group3;
    JComboBox comboBox1,comboBox2,comboBox3;
    JTextArea Message_ar;
    JFrame frame;
    Connection con = Database_Connection.connect();
    int empid;
    String emp_name;
    public Print_Request_GUI(String empname, int id)
    {
        empid = id;
        emp_name = empname;
        frame = new JFrame("Print Request");
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5,10,25,5);
        frame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;gbc.weighty = 1;
        L1 = new JLabel("File:");
        frame.add(L1,gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.weightx = 0;gbc.weighty = 0;
        SelectFile = new JButton("Select file");
        SelectFile.addActionListener(this);
        frame.add(SelectFile,gbc);

        gbc.gridx = 2; gbc.gridy = 0;
        gbc.weightx = 1;gbc.weighty = 1;
        FileName = new JLabel(" ");
        frame.add(FileName,gbc);

        gbc.insets = new Insets(5,5,0,5);
        gbc.gridx = 0; gbc.gridy = 1;
        L2 = new JLabel("Paper Size:");
        frame.add(L2,gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        String[] papersize = {"A0:841x1189 mm","A1:594x841 mm","A2:420x594 mm","A3:297x420 mm","A4:210x297 mm"};
        comboBox1 = new JComboBox<>(papersize);
        comboBox1.addActionListener(this);
        frame.add(comboBox1,gbc);


        gbc.gridx = 0; gbc.gridy = 2;
        L3 = new JLabel("Orientation:");
        frame.add(L3,gbc);


        gbc.insets = new Insets(5,5,0,5);
        gbc.gridx = 1; gbc.gridy = 2;
        portrait = new JRadioButton("Portrait");
        portrait.setActionCommand("Portrait");
        frame.add(portrait,gbc);

        gbc.gridx = 2; gbc.gridy = 2;
        landscape = new JRadioButton("Landscape");
        landscape.setActionCommand("landscape");
        frame.add(landscape,gbc);

        group1 = new ButtonGroup();
        group1.add(portrait);
        group1.add(landscape);

        portrait.addActionListener(this);
        landscape.addActionListener(this);


        gbc.gridx = 0; gbc.gridy = 3;
        L4 = new JLabel("Colour:");
        frame.add(L4,gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        colour = new JRadioButton("Colour");
        colour.setActionCommand("Yes");
        frame.add(colour,gbc);

        gbc.gridx = 2; gbc.gridy = 3;
        grayscale = new JRadioButton("Grayscale");
        grayscale.setActionCommand("No");
        frame.add(grayscale,gbc);

        group2 = new ButtonGroup();
        group2.add(colour);
        group2.add(grayscale);

        colour.addActionListener(this);
        grayscale.addActionListener(this);



        gbc.gridx = 0; gbc.gridy = 4;
        L5 = new JLabel("2 Sided Printing:");
        frame.add(L5,gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        String[] print_side = {"OFF","ON"};
        comboBox2 = new JComboBox<>(print_side);
        comboBox2.addActionListener(this);
        frame.add(comboBox2,gbc);


        gbc.gridx = 0; gbc.gridy = 5;
        L6 = new JLabel("Copies:");
        frame.add(L6,gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        String[] copies = {"1","2","3","4","5","6","7","8","9","10"};
        comboBox3 = new JComboBox<>(copies);
        comboBox3.addActionListener(this);
        frame.add(comboBox3,gbc);


        gbc.gridx = 0; gbc.gridy = 6;
        L7 = new JLabel("Task Type:");
        frame.add(L7,gbc);

        gbc.gridx = 1; gbc.gridy = 6;
        official = new JRadioButton("Official");
        official.setActionCommand("Official");
        frame.add(official,gbc);

        gbc.gridx = 2; gbc.gridy = 6;
        personal = new JRadioButton("Personal");
        personal.setActionCommand("Personal");
        frame.add(personal,gbc);

        group3 = new ButtonGroup();
        group3.add(official);
        group3.add(personal);

        official.addActionListener(this);
        personal.addActionListener(this);

        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 1; gbc.gridy = 7;
        reset = new JButton("Reset");
        reset.addActionListener(this);
        frame.add(reset,gbc);

        gbc.ipadx = 0; gbc.ipady = 0;
        gbc.gridx = 2; gbc.gridy = 7;
        gbc.weightx = 1;
        submit = new JButton("Submit");
        submit.addActionListener(this);
        frame.add(submit,gbc);


        gbc.insets = new Insets(25,15,5,5);
        gbc.gridx = 0; gbc.gridy = 8;
        L8 = new JLabel("Message:");
        frame.add(L8,gbc);


        gbc.insets = new Insets(0,13,10,13);
        gbc.gridx = 0; gbc.gridy = 9;
        gbc.ipadx = 0; gbc.ipady = 20;
        gbc.weightx = 1;gbc.weighty=1;
        gbc.gridwidth = 3;
        Message_ar = new JTextArea();
        Message_ar.setEditable(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Message_ar.setBorder(border);
        frame.add(Message_ar,gbc);


        gbc.gridx = 0; gbc.gridy = 10;
        gbc.ipadx = 0; gbc.ipady = 0;
        exit = new JButton("Exit");
        exit.addActionListener(this);
        frame.add(exit,gbc);

        frame.setSize(400,460);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private void ClearForm(){
        FileName.setText(null);
        comboBox1.setSelectedIndex(0);
        comboBox2.setSelectedIndex(0);
        comboBox3.setSelectedIndex(0);
        Message_ar.setText(null);
        group1.clearSelection();
        group2.clearSelection();
        group3.clearSelection();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        Object Source = e.getSource();
        File f;
        JFileChooser fc;
        if(Source == SelectFile){
            fc=new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES","txt", "doc", "docx",
                    "pdf","ppt","pptx");
            fc.setFileFilter(filter);
            int i=fc.showOpenDialog(this);
            if(i==JFileChooser.APPROVE_OPTION){
                f=fc.getSelectedFile();
                FileName.setText(fc.getName(f));

            }
        }else if(Source == reset){
            ClearForm();
        }else if(Source == submit){
            int result = JOptionPane.showConfirmDialog(frame, "Submit Print Request?","Confirmation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                String filename = FileName.getText();
                String papersize = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
                String orientation = group1.getSelection().getActionCommand();
                String color = group2.getSelection().getActionCommand();
                String sides = Objects.requireNonNull(comboBox2.getSelectedItem()).toString();
                int copies = Integer.parseInt(Objects.requireNonNull(comboBox3.getSelectedItem()).toString());
                String type = group3.getSelection().getActionCommand();

                String sql = "Insert into print_details(empid, filename, papersize, orientation, color, doublesided, " +
                        "copies,tasktype) " + "values('" +empid+"','" +filename+"','"+papersize+"','"+orientation+"'," +
                        "'"+color+"'," + "'"+sides+"','"+copies+"','"+type+"')";
                try {
                    Statement stmt = con.createStatement();
                    int x = stmt.executeUpdate(sql);
                    if (x > 0)
                        System.out.println("Successfully Inserted");
                    else
                        System.out.println("Insert Failed");
                }catch (SQLException e1) {
                    Message_ar.setText("Error!!! Request Not Forwarded");
                }
                frame.setVisible(false);
                new Print_Request_GUI(emp_name,empid);
            }else if (result == JOptionPane.NO_OPTION){
                frame.setVisible(true);
            }
        }else if(Source == exit){
            frame.setVisible(false);
            new UserFunctions(emp_name,empid);
        }
    }

}

