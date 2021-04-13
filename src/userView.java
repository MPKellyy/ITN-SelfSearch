import javax.swing.*;
import java.awt.*;

public class userView extends JPanel
{
    private JLabel password;
    private JLabel info;
    private JPasswordField userPassword;
    private JButton enterButton;
    private JButton backButton;



    public userView()
    {
        createPanel();
    }

    private void createPanel()
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        // Create our variables for our GUI components
        password = new JLabel("Password:");
        userPassword = new JPasswordField();
        info =new JLabel("Password Required for Administrator Access");
        enterButton = new JButton("Enter");
        backButton = new JButton("Back");

        // Set the settings for our JLabel password
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(0,125,49,0);
        this.add(password, c);

        // Set the settings for our textbox
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(0,0,44,0);
        userPassword.setPreferredSize(new Dimension(200,25));
        this.add(userPassword, c);

        // Set the settings for our header
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(50,30,0,0);
        info.setPreferredSize(new Dimension(400,25));
        info.setFont(new Font("Verdana", Font.BOLD, 15));
        this.add(info, c);

        // Set the settings for the enter button
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.insets = new Insets(0,0,150,0);
        this.add(enterButton, c);

        // Set the settings for the back button
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.insets = new Insets(0,0,0,0);
        this.add(backButton, c);

        // Set the color
        this.setBackground(Color.LIGHT_GRAY);


    }

    public JButton getEnterButton()
    {
        return enterButton;
    }

    public JButton getBackButton()
    {
        return backButton;
    }

    public void setUserPassword(JPasswordField userPassword)
    {
        this.userPassword = userPassword;
    }

    public JTextField getUserPassword()
    {
        return userPassword;
    }

    public static void main(String args[])
    {
        new userView();
    }
}