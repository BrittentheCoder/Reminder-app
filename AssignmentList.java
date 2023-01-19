import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout; 

public class AssignmentList extends JFrame{
    //Variables
    private JLabel assignmentName;
    private JLabel assignmentDueDate;
    private JButton addAssignment;
    private FlowLayout layout;
    private DueDateCounter prompt;

    AssignmentList(){

    
    // Set up the frame
    super("HomeScreen");
    layout = new FlowLayout();
    layout.setAlignment(FlowLayout.LEFT);
    setLayout(layout);

    prompt = new DueDateCounter();
    addAssignment = new JButton();
    addAssignment.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            prompt.turnVisible();
            setVisible(false);
        }
    });    

    // Create the label that will be before the name field
    assignmentName = new JLabel("Enter the assignments name");
    add(assignmentName);



    // Create the label that will display the countdown
    assignmentDueDate = new JLabel("Enter a Valid date in the format of  MM/DD/YYYY");
    add(assignmentDueDate);

    }
}