import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
// import javax.swing.JLabel;
import java.awt.FlowLayout;
public class HomeScreen extends JFrame {

//    private JLabel label;
    private JButton AssignmentButton;
    private FlowLayout layout;
    private DueDateCounter setAssignment;
    public HomeScreen() {
        // Set up the frame
        super("HomeScreen");
        layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        
        // Set up due date timer
        setAssignment = new DueDateCounter();

        // Create the button for going to different screen
        AssignmentButton = new JButton("Add Assignment");

        AssignmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            setVisible(false);
            setAssignment.turnVisible();
            }
        });
        add(AssignmentButton);

        // Set the Size and location of the frame
        setSize(1000, 1000);
        setLocationRelativeTo(null);

        // Exit the Program when user closes the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
