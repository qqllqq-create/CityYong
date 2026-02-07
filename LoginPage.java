import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton resetButton;
    private JLabel messageLabel;

    public LoginPage() {
        // Set up the JFrame
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title Label
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);

        // Username Label
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Username:"), gbc);

        // Username Field
        gbc.gridx = 1;
        usernameField = new JTextField(15);
        mainPanel.add(usernameField, gbc);

        // Password Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Password:"), gbc);

        // Password Field
        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        mainPanel.add(passwordField, gbc);

        // Message Label
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);
        mainPanel.add(messageLabel, gbc);

        // Button Panel
        gbc.gridy = 4;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 240, 240));

        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 30));
        loginButton.addActionListener(new LoginActionListener());
        buttonPanel.add(loginButton);

        resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(100, 30));
        resetButton.addActionListener(e -> resetFields());
        buttonPanel.add(resetButton);

        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
        setVisible(true);
    }

    private void resetFields() {
        usernameField.setText("");
        passwordField.setText("");
        messageLabel.setText("");
    }

    private class LoginActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Simple validation - replace with actual authentication
            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Please enter both username and password");
                messageLabel.setForeground(Color.RED);
            } else if (username.equals("admin") && password.equals("admin123")) {
                messageLabel.setText("Login Successful!");
                messageLabel.setForeground(new Color(0, 128, 0));
                JOptionPane.showMessageDialog(LoginPage.this, "Welcome, " + username + "!");
                resetFields();
            } else {
                messageLabel.setText("Invalid username or password");
                messageLabel.setForeground(Color.RED);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginPage::new);
    }
}