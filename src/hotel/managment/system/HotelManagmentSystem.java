package hotel.managment.system;

import java.awt.Color;
import java.awt.Font;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HotelManagmentSystem extends JFrame implements ActionListener{

   public HotelManagmentSystem() {
        
        setBounds(150, 10, 1300, 768);
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("icons/exped.jpg"));
        JLabel hotelImage = new JLabel(ii);
        hotelImage.setBounds(0, 0, 1300, 700);
        add(hotelImage);
        
        JLabel text = new JLabel("HOTEL MANAGMENT SYSTEM");
        text.setBounds(360, 350, 1000, 30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif",Font.BOLD,30));
        hotelImage.add(text);
        
        JButton next = new JButton("Login");
        next.setBounds(1050, 550, 150, 50);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);//load login form
        next.setFont(new Font("serif",Font.PLAIN,20));
        hotelImage.add(next);
        
        setVisible(true);
        //Threads can be used to perform complicated tasks in the background 
        //without interrupting the main program.
          while(true){
                        text.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(500); //1000 = 1 second
                    }catch(Exception e){} 
                        text.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }
    }

    public void actionPerformed(ActionEvent e) {
               new Login();
                
    }
    public static void main(String[] args) {
        
       new HotelManagmentSystem();
    }
 
    
}
