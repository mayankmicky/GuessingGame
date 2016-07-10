import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuessingGame extends JFrame {
	private JTextField textGuess;  //textField for the user's guess
	private JLabel lblOutput;   //label for too high/too low output
	private int theNumber ;  //the no. we are trying to guess
	private int triesLeft=7;      //give the user 7 tries to guess
	
	
	public void checkGuess(){   //method to check too high/too low
		//get the user's guess
		String guessText=textGuess.getText();
		String message="";
		
		try{
		
			//check the guess for too high/low
			int guess=Integer.parseInt(guessText);
			//count this as one try
			triesLeft--;
			
			//too high
			if(guess>theNumber){
				message=guess+" was too high  ";
				message+=" you have "+ triesLeft +" tries left.";
				lblOutput.setText(message);
			}
			else if(guess<theNumber){
				message=guess+" was too low  ";
				message+=" you have "+ triesLeft +" tries left.";
				lblOutput.setText(message);
			}
			else
			{
				message=guess+" was right!You win ! Let's play again";
			    lblOutput.setText(message);
			    newGame();
			}
		}
		catch(Exception e){
			lblOutput.setText("enter only whole no.  ");
			
		}
		finally{
			textGuess.requestFocus();  //optional 
			textGuess.selectAll();
			}	
		if(triesLeft<=0)
		{
			javax.swing.JOptionPane.showConfirmDialog(null,
					"Sorry you run out of tries.The number was "+ theNumber + " .Play Again!");
			
			newGame();
		}
		
	}
	
	public void newGame(){   // a new random no. 1 ..... 100
		theNumber=(int)(Math.random()*100+1);   //random*100 will do  0 to  99.9999999  + 1  
													//then   1 to 100 	
		triesLeft=7;
		
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hi-Lo Guess Game");
		getContentPane().setBackground(new Color(51, 204, 153));
		getContentPane().setLayout(null);
		
		JLabel lblMayanksHiloGuessing = new JLabel("Mayank's Hi-Lo Guessing Game");
		lblMayanksHiloGuessing.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMayanksHiloGuessing.setBounds(10, 30, 434, 24);
		lblMayanksHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblMayanksHiloGuessing);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 153));
		panel.setBounds(35, 84, 353, 37);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGuessANo = new JLabel("Guess a no. between 1 and 100 :");
		lblGuessANo.setBounds(18, 8, 199, 14);
		panel.add(lblGuessANo);
		lblGuessANo.setHorizontalAlignment(SwingConstants.CENTER);
		
		textGuess = new JTextField();
		textGuess.setHorizontalAlignment(SwingConstants.CENTER);
		textGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		textGuess.setBounds(238, 5, 86, 20);
		panel.add(textGuess);
		textGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(171, 151, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above. You have 7 tries!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(35, 204, 379, 24);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(430,330));   //dimension takes x and y  width and height
		theGame.setVisible(true);
		
	}
}
