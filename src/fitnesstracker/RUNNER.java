package fitnesstracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KING
 */
public class RUNNER extends JFrame implements ActionListener {
    
    private JLabel lblfittrack,lblDashboard,lblwellcomebackuser,lblrecentworkout;
    private JButton btndashboard,btnworkouts,btmeals,btngoals,btnprogress,btnsettings;
    private JTextArea txaworkouts,txacalories,txagoals,txarecentworkout;
    
    RUNNER(){
        setLayout(null);
        setSize(1000, 1000);
        setTitle("FITNESS TRACKER APP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblfittrack = new JLabel("FITNESS TRACKER");
        lblfittrack.setBounds(450, 5, 150, 75);
        add(lblfittrack);
        
        lblDashboard = new JLabel("Dashboard");
        lblDashboard.setBounds(450, 50, 100, 75);
        add(lblDashboard);
        
        lblwellcomebackuser = new JLabel("Welcome back, user");
        lblwellcomebackuser.setBounds(200, 100, 150, 75);
        add(lblwellcomebackuser);
        
        lblrecentworkout = new JLabel("Recent Workout");
        lblrecentworkout.setBounds(200, 450, 150, 75);
        add(lblrecentworkout);
        
        ///BUTTON///
        btndashboard = new JButton("Dashboard");
        btndashboard.setBounds(50, 150, 100, 75);
        add(btndashboard);
        
        btnworkouts = new JButton("Workouts");
        btnworkouts.setBounds(50, 250, 100, 75);
        add(btnworkouts);
        
        btmeals = new JButton("Meals");
        btmeals.setBounds(50, 350, 100, 75);
        add(btmeals);
        
        btnprogress = new JButton("Progress");
        btnprogress.setBounds(50, 450, 100, 75);
        add(btnprogress);
        
        btngoals = new JButton("Goals");
        btngoals.setBounds(50, 550, 100, 75);
        add(btngoals);
        
        btnsettings = new JButton("Settings");
        btnsettings.setBounds(50, 650, 100, 75);
        add(btnsettings);
        
        
        ///BUTTON///
                
        ///TEXT AREA///
        txaworkouts = new JTextArea();
        txaworkouts.setBounds(200, 200, 200, 150);
        add(txaworkouts);
        
        txacalories = new JTextArea();
        txacalories.setBounds(450, 200, 200, 150);
        add(txacalories);
        
        txagoals = new JTextArea();
        txagoals.setBounds(700, 200, 200, 150);
        add(txagoals);
        
        txarecentworkout = new JTextArea();
        txarecentworkout.setBounds(200, 550, 600, 150);
        add(txarecentworkout);
        
        ///TEXT AREA///
        btnworkouts.addActionListener(this);
        btmeals.addActionListener(this);
        btnprogress.addActionListener(this);
        btngoals.addActionListener(this);
        btnsettings.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
