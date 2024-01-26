
package hotel.managment.system;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Department extends JFrame{
    
    Connection conn = null;
    private JPanel contentpane;
    private JTable table;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;


    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Department frame = new Department();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close() {this.dispose(); }
    
    
    public Department() {
        
        setTitle("DEPARTMENT INFO/ දෙපාර්තුමේන්තු තොරතුරු");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 700, 500);
        contentpane = new JPanel();
        contentpane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentpane);
        contentpane.setLayout(null);
        
        table = new JTable();
        table.setBounds(0, 40, 700, 350);
        contentpane.add(table);
        
        JButton btnNewButton = new JButton("Load Data");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();

                    String displayCustomersql = "select * from department";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        btnNewButton.setBounds(170, 410, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentpane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton_1.setBounds(400, 410, 120, 30);
        btnNewButton_1.setBackground(Color.BLACK);
        btnNewButton_1.setForeground(Color.WHITE);
        contentpane.add(btnNewButton_1);

        lblNewLabel = new JLabel("Department");
        lblNewLabel.setBounds(145, 11, 105, 14);
        contentpane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Budget");
        lblNewLabel_1.setBounds(431, 11, 75, 14);
        contentpane.add(lblNewLabel_1);

        getContentPane().setBackground(Color.WHITE);
    }
  
}

