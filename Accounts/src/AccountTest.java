import edu.vccs.vdh275.banking.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class AccountTest extends JApplet implements ActionListener{


private JTextField enterName, enterBalance, enterDeposit, enterWithdraw;	
private JPanel panel;
private JLabel namePrompt, balancePrompt, depositPrompt, withdrawPrompt;
private JTextArea theText;
private String balance;
private String name;	
private String deposit;
private String withdraw;
private JButton enter1Button, enter2Button, enter3Button, resetButton;
private JButton adminButton, userButton;
private JButton inquiryButton, depositButton, withdrawButton, accountSummaryButton;
private JButton checkAccountsButton, createAccountButton;
private int n=-1;
private static Account[] accounts = new Account[10000];


	public void init(){ 
		
		this.setSize(325,200);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		panel.setBackground(Color.WHITE);
		this.add(panel);
		
		adminButton = new JButton("Admin");
		adminButton.addActionListener(this);
		panel.add(adminButton);
		
		userButton = new JButton("User");
		userButton.addActionListener(this);
		panel.add(userButton);
	
		checkAccountsButton =new JButton("Check Number of Accounts");
		checkAccountsButton.addActionListener(this);
		panel.add(checkAccountsButton);
		checkAccountsButton.setVisible(false);
		
		createAccountButton = new JButton ("Create New Account");
		createAccountButton.addActionListener(this);
		panel.add(createAccountButton);
		createAccountButton.setVisible(false);
		
		inquiryButton= new JButton ("Inquiry"); 
		inquiryButton.addActionListener(this);
		panel.add(inquiryButton);
		inquiryButton.setVisible(false);
		
		depositButton= new JButton ("Deposit");
		depositButton.addActionListener(this);
		panel.add(depositButton);
		depositButton.setVisible(false);
		
		withdrawButton = new JButton ("Withdraw");
		withdrawButton.addActionListener(this);
		panel.add(withdrawButton);
		withdrawButton.setVisible(false);
		
		accountSummaryButton = new JButton ("Account Summary");
		accountSummaryButton.addActionListener(this);
		panel.add(accountSummaryButton);
		accountSummaryButton.setVisible(false);
		
		resetButton = new JButton ("Log Out");
		resetButton.addActionListener(this);
		panel.add(resetButton);
		resetButton.setVisible(false);
		
		namePrompt = new JLabel("Please enter your name:");
		panel.add(namePrompt);
		namePrompt.setVisible(false);
		
		enterName= new JTextField("Name",5);
		enterName.addActionListener(this);
		panel.add(enterName);
		enterName.setVisible(false);
		
		balancePrompt = new JLabel("Please enter your initial balance:");
		panel.add(balancePrompt);
		balancePrompt.setVisible(false);
		
		enterBalance= new JTextField("$0.00",5);
		enterBalance.addActionListener(this);
		panel.add(enterBalance);
		enterBalance.setVisible(false);
		
		depositPrompt = new JLabel("How much would you like to deposit?");
		panel.add(depositPrompt);
		depositPrompt.setVisible(false);
		
		enterDeposit= new JTextField("$0.00",5);
		enterDeposit.addActionListener(this);
		panel.add(enterDeposit);
		enterDeposit.setVisible(false);
		
		withdrawPrompt = new JLabel("How much would you like to withdraw?");
		panel.add(withdrawPrompt);
		withdrawPrompt.setVisible(false);
		
		enterWithdraw= new JTextField("$0.00",5);
		enterWithdraw.addActionListener(this);
		panel.add(enterWithdraw);
		enterWithdraw.setVisible(false);
		
		theText= new JTextArea(2,25);
		theText.setText("");
		panel.add(theText);
		theText.setVisible(false);
		
		enter1Button= new JButton("Create");
		enter1Button.addActionListener(this);
		panel.add(enter1Button);
		enter1Button.setVisible(false);
		
		enter2Button= new JButton("Enter ");
		enter2Button.addActionListener(this);
		panel.add(enter2Button);
		enter2Button.setVisible(false);
		
		enter3Button= new JButton(" Enter");
		enter3Button.addActionListener(this);
		panel.add(enter3Button);
		enter3Button.setVisible(false);
		
	
	}
	
	public void actionPerformed (ActionEvent e){
		String actionCommand = e.getActionCommand();

		if(actionCommand.equals("Admin")){
			setAllFalse();
			panel.setBackground(Color.GRAY);
			checkAccountsButton.setVisible(true);
		}
		
		else if (actionCommand.equals("User")){
			setAllFalse();
			panel.setBackground(Color.CYAN);
			createAccountButton.setVisible(true);
			
		}
		else if(actionCommand.equals("Check Number of Accounts")){
			resetButton.setVisible(true);
			enterName.setVisible(false);
			namePrompt.setVisible(false);
			enterBalance.setVisible(false);
			balancePrompt.setVisible(false);
			theText.setVisible(true);
			theText.setText("Total number of accounts: " + Account.numAccounts());
		}
		else if (actionCommand.equals("Create New Account")){
			setAllFalse();
			resetFields();
			createAccountButton.setVisible(true);
			resetButton.setVisible(true);
			theText.setVisible(false);
			enterName.setVisible(true);
			namePrompt.setVisible(true);
			enterBalance.setVisible(true);
			balancePrompt.setVisible(true);
			enter1Button.setVisible(true);
			}
		else if (actionCommand.equals("Create")){
			n++;
			setAllFalse();
			setAccountButtonsTrue();	
			theText.setVisible(true);
			name = enterName.getText();
			balance= enterBalance.getText();
			balance = balance.replaceAll("Enter initial balance:", "");
			balance = balance.replaceAll(",", "");
			balance = balance.replaceAll("\\$", "");
			accounts[n]=new Account(name, balance);
			theText.setText("Congratulations on your new account");
			
			if(name.equals("")){
				theText.append("\n" + "A name was not entered");
			}
			if(accounts[n].getBalance() == 0.0){
				theText.append("\n" + "Default balance of " +
						"$0.00");
			}
		}
		else if (actionCommand.equals("Inquiry")){
			setAllFalse();
			setAccountButtonsTrue();
			theText.setVisible(true);
			theText.setText("Current Balance: " + accounts[n].inquiry());
		}
		else if (actionCommand.equals("Deposit")){
		setAllFalse();
		setAccountButtonsTrue();
		resetFields();
		depositPrompt.setVisible(true);
		enterDeposit.setVisible(true);
		enter2Button.setVisible(true);
		}	
		else if (actionCommand.equals("Enter ")){
			setAllFalse();
			setAccountButtonsTrue();
			theText.setVisible(true);
			deposit = enterDeposit.getText();
			deposit = deposit.replaceAll(",", "");
			deposit = deposit.replaceAll("\\$", "");
			theText.setText("New Balance: " + accounts[n].deposit(deposit));
		}
		else if (actionCommand.equals("Withdraw")){
			setAllFalse();
			setAccountButtonsTrue();
			resetFields();
			withdrawPrompt.setVisible(true);
			enterWithdraw.setVisible(true);
			theText.setVisible(false);
			enter3Button.setVisible(true);
		}
		else if (actionCommand.equals(" Enter")){
			setAllFalse();
			setAccountButtonsTrue();
			theText.setVisible(true);
			withdraw = enterWithdraw.getText();
			withdraw = withdraw.replaceAll("Enter withdrawal amount:", "");
			withdraw = withdraw.replaceAll(",", "");
			withdraw = withdraw.replaceAll("\\$", "");
			theText.setText(accounts[n].withdraw(withdraw));
		}
		else if (actionCommand.equals("Account Summary")){
			setAllFalse();
			setAccountButtonsTrue();
			theText.setVisible(true);
			theText.setText(accounts[n].toString());
		}
		else if (actionCommand.equals("Log Out")){
			setAllFalse();
			panel.setBackground(Color.WHITE);
			resetButton.setVisible(false);
			adminButton.setVisible(true);
			userButton.setVisible(true);
			
		}
	
		}
	public void setAllFalse(){
		namePrompt.setVisible(false);
		enterName.setVisible(false);
		balancePrompt.setVisible(false);
		enterBalance.setVisible(false);
		checkAccountsButton.setVisible(false);
		createAccountButton.setVisible(false);
		enter1Button.setVisible(false);
		enter2Button.setVisible(false);
		enter3Button.setVisible(false);
		theText.setVisible(false);
		inquiryButton.setVisible(false);
		depositButton.setVisible(false);
		withdrawButton.setVisible(false);
		accountSummaryButton.setVisible(false);
		depositPrompt.setVisible(false);
		enterDeposit.setVisible(false);
		withdrawPrompt.setVisible(false);
		enterWithdraw.setVisible(false);
		adminButton.setVisible(false);
		userButton.setVisible(false);
	}
	 
	public void setAccountButtonsTrue(){
		inquiryButton.setVisible(true);
		depositButton.setVisible(true);
		withdrawButton.setVisible(true);
		accountSummaryButton.setVisible(true);
		resetButton.setVisible(true);
		createAccountButton.setVisible(true);
	}
	
	public void resetFields(){
		enterName.setText("Name");
		enterBalance.setText("$0.00");
		enterDeposit.setText("$0.00");
		enterWithdraw.setText("$0.00");		
	}
	

	
	
}
	
