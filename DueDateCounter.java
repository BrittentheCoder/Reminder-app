/*
To do
CSV to store uncompleted assignments/ completed assignments
Add multiple assignment options
    Add Back button/cancel button

Optional
Multiple date formats

*/
import java.lang.Math;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.text.ParseException;
import java.text.SimpleDateFormat;




public class DueDateCounter extends JFrame {
    // Components of the GUI
    private JLabel countdownLabel;
    private JLabel assignmentLabel;
    private JTextField dueDateField;
    private JTextField assignmentNameField;
    private JButton setButton;
//    private JButton backButton;
    private Timer countdownTimer;
    private Date dueDate;
    private String assignmentString;



    public DueDateCounter() {
        // Set up the frame
        super("Due Date Counter");
        setLayout(new FlowLayout());

        // Create variable that accesses stored data


        // Create the label that will be before the name field
        assignmentLabel = new JLabel("Enter the assignments name");
        add(assignmentLabel);
        
        // Add text field for assignment field
        assignmentNameField = new JTextField(20);
        add(assignmentNameField);

        // Create the label that will display the countdown
        countdownLabel = new JLabel("Enter a Valid date in the format of  MM/DD/YYYY");
        add(countdownLabel);

        // Create the text field for entering the due date
        dueDateField = new JTextField(10);
        add(dueDateField);



        
        // Create the button for setting the due date
        setButton = new JButton("Set Due Date");
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Parse the due date from the text field
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                boolean works = false;
                while (!works)
                    works = true;
                    try {
                        dueDate = dateFormat.parse(dueDateField.getText());
                        assignmentString = "Assignment Name: " + assignmentNameField.getText() + "   Due Date: " + dueDateField.getText() + " Time Remaining: ";
                }   catch (ParseException exception){
                    countdownTimer.cancel();
                    countdownLabel.setText("Invalid Date. Please reenter date.");
                }

                // Start the countdown timer
                startCountdownTimer();
            }
        });
        add(setButton);


        // Set the size and location of the frame
        setSize(1000, 1000);
        setLocationRelativeTo(null);

        // Exit the program when the user closes the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void startCountdownTimer() {
        // Cancel the current timer, if there is one
        if (countdownTimer != null) {
            countdownTimer.cancel();
        }

        // Create a new timer that will update the countdown label every second
        countdownTimer = new Timer();
        countdownTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Calculate the time remaining until the due date
                long timeRemaining = dueDate.getTime() - java.lang.System.currentTimeMillis();
                if (timeRemaining < 0) {
                    // The due date has passed, so stop the timer and display "Due date passed"
                    countdownTimer.cancel();
                    countdownLabel.setText("Due date passed");
                } else {
                    // The due date has not passed, so update the countdown label with the time remaining
                    int seconds = Math.abs((int) (timeRemaining / 1000) % 60);
                    int minutes = Math.abs((int) ((timeRemaining / (1000 * 60)) % 60));
                    int hours = Math.abs((int) ((timeRemaining / (1000 * 60 * 60)) % 24));
                    int days = Math.abs((int) (timeRemaining / (1000 * 60 * 60 * 24)));
                    countdownLabel.setText(String.format("%d %s:%d %s:%d %s:%02d %s", days,"Day(s)", hours, "Hour(s)", minutes, "Minute(s)", seconds, "Second(s)"));
                    assignmentLabel.setText(String.format("%s", assignmentString) );
                    remove(assignmentNameField);
                    remove(dueDateField);
                    remove(setButton);
                }
            }
        }, 0, 1000);
    }
    public void turnVisible(){
        setVisible(true);
    }
    public void Invisible(){
        setVisible(false);
    }
}