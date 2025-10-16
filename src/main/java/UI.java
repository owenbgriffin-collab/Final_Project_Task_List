import javax.swing.*;
import java.awt.*;

//user input & the user interface
public class UI {

    public void Run() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(createNorthPanel(), BorderLayout.NORTH);
        frame.setVisible(true);
    }

        private JPanel createNorthPanel(){
            JPanel panel = new JPanel(new BorderLayout());
            JMenuBar menuBar = new JMenuBar();
            JMenu file = new JMenu("File");
            JMenu help = new JMenu("Help");
            menuBar.add(file);
            menuBar.add(help);
            JMenuItem fileSave = new JMenuItem("Save as");
            file.add(fileSave);
            panel.add(menuBar, BorderLayout.NORTH);



            JPanel panel2 = new JPanel();
            JLabel label = new JLabel("Enter here: ");
            JTextField field = new JTextField(10);
            JButton enter = new JButton("Enter");
            JButton reset = new JButton("Reset");
            panel2.add(label);
            panel2.add(field);
            panel2.add(enter);
            panel2.add(reset);
            JTextArea textarea = new JTextArea();
            panel.add(panel2, BorderLayout.SOUTH);

            return panel;
        }

}

