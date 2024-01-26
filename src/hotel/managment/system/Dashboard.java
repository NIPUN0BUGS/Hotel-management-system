
package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener{

    public Dashboard() {
        
        setBounds(0,0,1500,800);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1500, 800); 
        add(NewLabel);
        
        JLabel HotelManagementSystem = new JLabel("THE NIPUN SAMARAKOON GROUP WELCOMES YOU");
	HotelManagementSystem.setForeground(Color.WHITE);
        HotelManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 40));
	HotelManagementSystem.setBounds(350, 60, 1000, 85);
	NewLabel.add(HotelManagementSystem);
        
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu HotelSystem = new JMenu("HOTEL MANAGEMENT");
        HotelSystem.setForeground(Color.BLUE);
	menuBar.add(HotelSystem);
        JMenuItem HotelDetails = new JMenuItem("RECEPTION");
        HotelDetails.addActionListener( this);
	HotelSystem.add(HotelDetails);
		
	JMenu HotelAdmin = new JMenu("ADMIN");
        HotelAdmin.setForeground(Color.RED);
	menuBar.add(HotelAdmin);
        JMenuItem HotelAddEmp = new JMenuItem("ADD EMPLOYEE");
        HotelAddEmp.addActionListener(this);
	HotelAdmin.add(HotelAddEmp);
        setVisible(true);
        
        JMenuItem HotelAddRoom = new JMenuItem("ADD ROOMS");
	HotelAdmin.add(HotelAddRoom);
        HotelAddRoom.addActionListener(this);
        setVisible(true);
        JMenuItem HotelAddDrivers = new JMenuItem("ADD DRIVERS");
	HotelAdmin.add(HotelAddDrivers);
        HotelAddDrivers.addActionListener( this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {//POP UP WINDOW
        if(e.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }else if(e.getActionCommand().equals("ADD ROOMS")){
            new AddRoom();
        }else if(e.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
        }else if(e.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    
    //main
    public static void main(String[] args){

          new Dashboard().setVisible(true);
    }

    
}
