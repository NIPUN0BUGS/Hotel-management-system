
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
import javax.swing.JFrame;

/**
 *
 * @author acer
 */
class RoomInfo extends JFrame{

    Connection conn = null;
    private JPanel contentPane;
    private JTable table;
    private JLabel lblAvailability;
    private JLabel lblCleanStatus;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblRoomNumber;
    private JLabel lblId;
        
    public RoomInfo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 1100, 600);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        setTitle("කාමර තොරතුරු/ROOM INFO");
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500, 0, 600, 600);
        add(l1);
        
        table = new JTable();
	table.setBounds(0, 40, 500, 400);
	contentPane.add(table);
        
        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String displayCustomersql = "select * from Room";
                    //PreparedStatement pst = conn.prepareStatement(displayCustomersql);
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        btnLoadData.setBounds(100, 470, 120, 30);
        btnLoadData.setBackground(Color.black);
        btnLoadData.setForeground(Color.white);
        contentPane.add(btnLoadData);
        
        JButton btnNewButton = new JButton("Back");
	btnNewButton.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
		      btnNewButton.setBounds(290, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(119, 15, 69, 14);
        contentPane.add(lblAvailability);

        lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setBounds(216, 15, 76, 14);
        contentPane.add(lblCleanStatus);

        lblNewLabel = new JLabel("Price");
        lblNewLabel.setBounds(330, 15, 46, 14);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Bed Type");
        lblNewLabel_1.setBounds(417, 15, 76, 14);
        contentPane.add(lblNewLabel_1);

        lblId = new JLabel("Room Number");
        lblId.setBounds(12, 15, 90, 14);
        contentPane.add(lblId);

        getContentPane().setBackground(Color.WHITE);
   
    }           

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RoomInfo frame = new RoomInfo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}