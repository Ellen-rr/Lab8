//import swing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import randon number
import java.util.Random;

public class GuessingGame implements ActionListener {
  //one textfield
  JTextField field;
  //two buttons
  JButton buttonGuess, buttonPlayAgain;
  //three labels
  JLabel jlabEnterGuess, jlabLowHigh, jlabLastGuess;
  //random number object
  Random r;
  //int to store random number
  int storeRandomNumber;



  //GuessingGame constructor
  GuessingGame() {
    //new Random number ovject
    r = new Random();
    //random number int between 1-100
    storeRandomNumber = r.nextInt(100)+1;
    
    //Create a new JFrame container
    JFrame frame = new JFrame("Guessing Game"); 
    // Specify FlowLayout for the layout manager. 
    frame.setLayout(new FlowLayout()); 
    // Give the frame an initial size. 
    frame.setSize(240, 120); 
    // Create a text field. 
    field = new JTextField(10); 
    // Set the action commands for the text field. 
    field.setActionCommand("myTF"); 
    //Set the guess button to let user guess
    buttonGuess = new JButton("Guess");
    buttonPlayAgain = new JButton("Play Again");
    // Add action listeners. 
    field.addActionListener(this); 
    buttonGuess.addActionListener(this); 
    buttonPlayAgain.addActionListener(this); 
    // Create the labels. 
    jlabEnterGuess = new JLabel("Enter your guess: "); 
    jlabLowHigh = new JLabel(""); 
    jlabLastGuess = new JLabel("");
    // Add the components to the content pane. 
    frame.add(jlabEnterGuess);
    frame.add(field); 
    frame.add(buttonGuess); 
    frame.add(jlabLowHigh); 
    frame.add(jlabLastGuess);
    frame.add(buttonPlayAgain); 
    // Display the frame. 
    frame.setVisible(true); 
 }
  public void actionPerformed(ActionEvent ae) {
  
  if (ae.getActionCommand().equals("Guess")) {
    //When the user type random number (string) into the textfield(we neamed field) -->we switch the string into integer named guess. 
    int guess = Integer.parseInt(field.getText());
    if (guess < storeRandomNumber) {
      jlabLowHigh.setText("Too low!");
      
    }
    else if (guess > storeRandomNumber) {
      jlabLowHigh.setText("Too High");
    }
    else {
      jlabLowHigh.setText("You got it!");
    }

    jlabLastGuess.setText("LastGuess was: " + guess);

  }

  else if(ae.getActionCommand().equals("Play Again")) {
    //The playAgain button was pressed
    //generate a new random number
    storeRandomNumber = r.nextInt(100)+1;
    //reset 3 labels
    jlabEnterGuess.setText("Enter your guess: ");
    jlabLastGuess.setText("");
    jlabLowHigh.setText("");
    //reset the text field
    field.setText("");
  }

  else {
  // Enter was pressed while focus was in the 
  // text field. 
    jlabLowHigh.setText("You pressed ENTER. Text is: " + 
    field.getText()); 

  }
  }
}
  