//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class abbreviationGenerator extends JFrame implements ActionListener{ // Implementing action listener will allow my buttons to work
    private JTextField firstWord, secondWord, thirdWord;
    private JLabel wordAbbreviation, originalWord;


    public abbreviationGenerator() {
        setTitle("Acronym generator");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//positions gui INTERFACE AT THE CENTER OF THE SCREEN

        //Initialise labels of text fields
        JLabel firstWordLabel = new JLabel("First Word");
        JLabel secondWordLabel = new JLabel("Second Word");
        JLabel thirdWordLabel = new JLabel("Third Word");

        //Create text field for input
        firstWord = new JTextField(5);
        secondWord = new JTextField(5);
        thirdWord = new JTextField(5);

        //create button that will generate abbreviation
        JButton abbreviationButton = new JButton("Generate Acronym");
        abbreviationButton.addActionListener(this); // Add action listener to the button



        //Create labels for the acronym and original word
        wordAbbreviation = new JLabel();
        originalWord = new JLabel();

        //Create layouts for input fields
        JPanel inputPanel = new JPanel(new GridLayout(3, 5, 10, 10));
        inputPanel.add(firstWordLabel);
        inputPanel.add(firstWord);
        inputPanel.add(secondWordLabel);
        inputPanel.add(secondWord);
        inputPanel.add(thirdWordLabel);
        inputPanel.add(thirdWord);

        // Create layout for abbreviation and original word
        JPanel resultPanel = new JPanel(new GridLayout(3, 5, 10, 10));
        resultPanel.add(new JLabel("Acronym:"));
        resultPanel.add(wordAbbreviation);
        resultPanel.add(new JLabel("Original Phrase:"));
        resultPanel.add(originalWord);

        // Create main layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        mainPanel.add(inputPanel);
        mainPanel.add(abbreviationButton);
        mainPanel.add(resultPanel);


        //method to create abbreviation

        add(mainPanel);
        setVisible(true);
        //call within class


        }
       
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Generate Acronym")) {//processes which button is clicked
            generateAbbreviation(); // Call generateAbbreviation() method when the button is clicked
        }
    }
    private void generateAbbreviation() {
        String first = firstWord.getText().trim();
        String second = secondWord.getText().trim();
        String third = thirdWord.getText().trim();

        if (!first.isEmpty() && !second.isEmpty() && !third.isEmpty()) {
            String abbreviation = "" + first.charAt(0) + second.charAt(0) + third.charAt(0);
            wordAbbreviation.setText(abbreviation);
            originalWord.setText(first + " " + second + " " + third);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter all three words.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater (abbreviationGenerator::new);// Helps with calling both the class and the method
    }
}

