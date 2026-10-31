package com.mycompany.fitnesstrackerapp.view;

import com.mycompany.fitnesstrackerapp.model.Meal;
import com.mycompany.fitnesstrackerapp.model.User;
import com.mycompany.fitnesstrackerapp.model.Workout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserForm extends JFrame {

    private User user;

    private JLabel lblWelcome;
    private JLabel lblWorkoutCount, lblTotalMinutes, lblCaloriesBurned;
    private JLabel lblMealCount, lblCaloriesConsumed, lblNetCalories;

    private DefaultTableModel workoutModel, mealModel;

    private JTextField txtName, txtUsername;
    private JPasswordField txtNewPassword, txtConfirmPassword;
    private JButton btnSave, btnBack;

    public UserForm(User user) {
        this.user = user;

        setTitle("Fitness Tracker - My Profile");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        initComponents();
        loadUserData();
    }


    private void initComponents() {
        lblWelcome = new JLabel("", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 22));
        add(lblWelcome, BorderLayout.NORTH);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Overview", createOverviewPanel());
        tabs.addTab("Workouts", createWorkoutsPanel());
        tabs.addTab("Meals", createMealsPanel());
        tabs.addTab("Account Settings", createSettingsPanel());
        add(tabs, BorderLayout.CENTER);

        btnBack = new JButton("Back to Dashboard");
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(btnBack);
        add(bottomPanel, BorderLayout.SOUTH);
    }

// DASHBOARD
    private JPanel createOverviewPanel() {
        lblWorkoutCount = new JLabel("0");
        lblTotalMinutes = new JLabel("0");
        lblCaloriesBurned = new JLabel("0");
        lblMealCount = new JLabel("0");
        lblCaloriesConsumed = new JLabel("0");
        lblNetCalories = new JLabel("0");

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        addRow(panel, "Total Workouts:", lblWorkoutCount);
        addRow(panel, "Total Workout Minutes:", lblTotalMinutes);
        addRow(panel, "Calories Burned:", lblCaloriesBurned);
        addRow(panel, "Total Meals:", lblMealCount);
        addRow(panel, "Calories Consumed:", lblCaloriesConsumed);
        addRow(panel, "Net Calories:", lblNetCalories);
        return panel;
    }

    private void addRow(JPanel panel, String text, JLabel valueLabel) {
        panel.add(new JLabel(text));
        panel.add(valueLabel);
    }

// WORKOUT PLAN
    private JPanel createWorkoutsPanel() {
        workoutModel = new DefaultTableModel(
                new String[]{"Workout", "Duration (min)", "Calories Burned"}, 0);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(new JTable(workoutModel)), BorderLayout.CENTER);
        return panel;
    }

// MEAL PLAN
    private JPanel createMealsPanel() {
        mealModel = new DefaultTableModel(
                new String[]{"Meal", "Calories", "Nutritional Info"}, 0);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(new JTable(mealModel)), BorderLayout.CENTER);
        return panel;
    }

// ACCOUNT SETTINGS
    private JPanel createSettingsPanel() {
        txtName = new JTextField();
        txtUsername = new JTextField();
        txtNewPassword = new JPasswordField();
        txtConfirmPassword = new JPasswordField();

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(txtName);
        formPanel.add(new JLabel("Username:"));
        formPanel.add(txtUsername);
        formPanel.add(new JLabel("New Password:"));
        formPanel.add(txtNewPassword);
        formPanel.add(new JLabel("Confirm Password:"));
        formPanel.add(txtConfirmPassword);

        btnSave = new JButton("Save Changes");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnSave);

        JPanel panel = new JPanel(new BorderLayout(10, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        return panel;
    }

// USER DATA COLLECTIONS
    private void loadUserData() {
        lblWelcome.setText("Welcome, " + user.getName() + "!");
        txtName.setText(user.getName());
        txtUsername.setText(user.getUsername());

        int totalMinutes = 0;
        double caloriesBurned = 0;
        for (Workout w : user.getWorkouts()) {
            workoutModel.addRow(new Object[]{w.getName(), w.getDuration(), w.getCaloriesBurned()});
            totalMinutes += w.getDuration();
            caloriesBurned += w.getCaloriesBurned();
        }

        double caloriesConsumed = 0;
        for (Meal m : user.getMeals()) {
            mealModel.addRow(new Object[]{m.getName(), m.getCalories(), m.getNutritionalInfo()});
            caloriesConsumed += m.getCalories();
        }

        lblWorkoutCount.setText(String.valueOf(user.getWorkouts().length));
        lblTotalMinutes.setText(String.valueOf(totalMinutes));
        lblCaloriesBurned.setText(String.format("%.1f kcal", caloriesBurned));
        lblMealCount.setText(String.valueOf(user.getMeals().length));
        lblCaloriesConsumed.setText(String.format("%.1f kcal", caloriesConsumed));
        lblNetCalories.setText(String.format("%.1f kcal", caloriesConsumed - caloriesBurned));
    }

//SAMPLE LANG 'TO
   public UserForm() {
    this(new User(0, "guest", "Guest"));
}
}

