import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class surveyForm{

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    String c;
    String sex;
    boolean f=false;
    public surveyForm() throws SQLException {
        initialize();
    }

    private void initialize() throws SQLException {
        frame = new JFrame("Survey Form");
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        textField = new JTextField();
        textField.setBounds(128, 28, 86, 20);
        frame.add(textField);
        textField.setColumns(10);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(65, 31, 46, 14);
        frame.add(lblName);

        JLabel lblPhone = new JLabel("Phone No");
        lblPhone.setBounds(65, 68, 46, 14);
        frame.add(lblPhone);

        textField_1 = new JTextField();
        textField_1.setBounds(128, 65, 86, 20);
        frame.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblEmailId = new JLabel("Email Id");
        lblEmailId.setBounds(65, 115, 46, 14);
        frame.add(lblEmailId);

        textField_2 = new JTextField();
        textField_2.setBounds(128, 112, 247, 17);
        frame.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(65, 162, 46, 14);
        frame.add(lblAddress);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(126, 157, 212, 40);
        frame.add(textArea_1);



        JButton btnClear = new JButton("Clear");

        btnClear.setBounds(312, 387, 89, 23);
        frame.add(btnClear);

        JLabel lblSex = new JLabel("Sex");
        lblSex.setBounds(65, 228, 46, 14);
        frame.add(lblSex);

        JLabel lblMale = new JLabel("Male");
        lblMale.setBounds(128, 228, 46, 14);
        frame.add(lblMale);

        JLabel lblFemale = new JLabel("Female");
        lblFemale.setBounds(292, 228, 46, 14);
        frame.add(lblFemale);

        JRadioButton radioButton = new JRadioButton("");
        radioButton.setBounds(337, 224, 109, 23);
        frame.add(radioButton);

        JRadioButton radioButton_1 = new JRadioButton("");
        radioButton_1.setBounds(162, 224, 109, 23);
        frame.add(radioButton_1);

        JLabel lblOccupation = new JLabel("Occupation");
        lblOccupation.setBounds(65, 288, 67, 14);
        frame.add(lblOccupation);

        String list[] = {"Select","Business","Engineer","Doctor","Student","Other"};
        JComboBox comboBox = new JComboBox(list);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c=comboBox.getSelectedItem().toString();
            }
        });
        comboBox.setBounds(180, 285, 91, 20);
        frame.add(comboBox);


        JButton btnSubmit = new JButton("submit");

        btnSubmit.setBackground(Color.BLUE);
        btnSubmit.setForeground(Color.MAGENTA);
        btnSubmit.setBounds(65, 387, 89, 23);
        frame.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String sex=(radioButton_1.isSelected())?"Male":"Female";
                Data d = new Data(textField.getText(),textField_1.getText(),textField_2.getText(),textArea_1.getText(),sex,c);
                if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textArea_1.getText().isEmpty())||((radioButton_1.isSelected())&&(radioButton.isSelected()))||(comboBox.getSelectedItem().equals("Select")))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else
                {
                    try {
                        new insert(d);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                    f=true;
                    JOptionPane.showMessageDialog(null,"Name: "+textField.getText()+"\n"+"Phone No: "+textField_1.getText()+"\n"+"Email Address: "+textField_2.getText()+"\n"+"Address: "+textArea_1.getText()+"\n"+"Sex: "+sex+"\n"+"Occupation: "+comboBox.getSelectedItem());
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField_1.setText(null);
                textField_2.setText(null);
                textField.setText(null);
                textArea_1.setText(null);
                radioButton.setSelected(false);
                radioButton_1.setSelected(false);
                comboBox.setSelectedItem("Select");


            }
        });
    }

}