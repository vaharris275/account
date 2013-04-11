package edu.vccs.vdh275.banking;
import java.util.*;
import java.text.*;
import java.io.*;
/**
 * Use this class to simulate a bank account
 * <br>with withdraw, deposit, and inquiry methods
 * 
 * @author Vanessa Harris
 * 
 */
public class Account implements Serializable {
	
private String name;
private int number;
private double balance;
private static int numAccounts=0;
private static int index=0;
private static int[] accountNums = new int[1000];
private DecimalFormat formatter = new DecimalFormat("0.00");

/**
 * Default constructor 
 */
public Account(){
	
	this.name="";
	Random rand = new Random();
	this.number= rand.nextInt(899999999)+ 100000000;
	while (contain(this.number))
		this.number= rand.nextInt(899999999)+ 100000000;
	accountNums[index]=this.number;;
	this.balance= 0.0;
	numAccounts++;
	index++;
}
/**
 * Creates an account from name and the double value of an account
 * @param name the account member's name
 * @param balance the account member's initial balance
 */
	public Account(String name, double balance){
		
		this.name = name;
		Random rand = new Random();
		this.number= rand.nextInt(899999999)+100000000;
		while (contain(this.number))
				this.number= rand.nextInt(899999999)+ 100000000;
		accountNums[index]=this.number;
		this.balance= balance;
		numAccounts++;
		index++;
	}
	/**
	 * Creates an account from name and the double value of an account
	 * @param name the account member's name
	 * @param number the assigned account number
	 * @param balance the account member's initial balance
	 */
	public Account(String name, int number, double balance){
		this.name = name;
		this.number= number;
		accountNums[index]=this.number;;
		this.balance= balance;
		numAccounts++;
		index++; 
	}
	/**
	 * Creates an account from String name and balance
	 * @param name the account member's name
	 * @param balance the account member's initial balance
	 */
	public Account(String name, String balance){
	
		this.name = name;
		Random rand = new Random();
		this.number= rand.nextInt(899999999)+100000000;
		while (contain(this.number))
				this.number= rand.nextInt(899999999)+ 100000000;
		accountNums[index]=this.number;;
		try{
		this.balance= Double.parseDouble(balance);}
		catch (NumberFormatException nfe){
			this.balance= 0.0;
		}
		numAccounts++;
		index++;
	}
	/**
	 * Creates an account from String versions of name, number and balance
	 * @param name the account member's name
	 * @param number the assigned account number
	 * @param balance the account member's initial balance
	 */
	public Account(String name, String number, String balance){
		
		this.name = name;
		try{
		this.number = Integer.parseInt(number);
		accountNums[index]=this.number;;
		}
		catch(NumberFormatException nfe){
				Random rand = new Random();
		this.number= rand.nextInt(899999999)+100000000;
		while (contain(this.number))
				this.number= rand.nextInt(899999999)+ 100000000;
		accountNums[index]=this.number;;
		}
	
		try{
		this.balance= Double.parseDouble(balance);}
		catch (NumberFormatException nfe){
			this.balance= 0.0;
		}
		numAccounts++;
		index++;
	}

	/**
	 * withdraw method to withdraw money from balance
	 * @param withdrawal amount to withdraw
	 * @return newBalance the balance after withdrawal is subtracted from initial balance
	 */
	public String withdraw(String withdrawal){
		String newBalance="";
		try{
			double withdraw = Double.parseDouble(withdrawal);
			if (withdraw<=balance){
				balance -= withdraw;
				newBalance = "New balance: $" + formatter.format(balance);
		}
		else 
			newBalance= "Insufficient Funds"  + "\n" + "Balance remains: $" + formatter.format(balance);
			}
			catch(NumberFormatException nfe){
			newBalance = "Please input numeric values only" + "\n" + "Balance remains: $" + formatter.format(balance);
			}
		
	
		return newBalance;
	}
	
	/**
	 * deposit method to add funds to the balance
	 * @param moneyDeposit amount to deposit
	 * @return newBalance the balance after deposit is added to the initial balance
	 */
	public String deposit(String moneyDeposit){
		String newBalance="";
		try{
			double deposit = Double.parseDouble(moneyDeposit);
			balance += deposit;
			newBalance ="$" + formatter.format(balance);
			}
			catch(NumberFormatException nfe){
			newBalance = "Please input numeric values only" + "\n" + "Balance remains: $" + formatter.format(balance);
			}
		
		
		return newBalance;
	}
	/**
	 * inquiry method to get the balance
	 * @return String formatted version of the balance
	 */
	public String inquiry(){
		String currentBalance = "$" + formatter.format(this.balance);
		return currentBalance;
	}
	/**
	 * toString method to create a string version of the account
	 * @return value 
	 */
	
	public String toString(){
		String value="";
		value += "Name: " + this.name + "\n";
		value += "Number: " + this.number + "\n";
		value += "Balance: $" + formatter.format(this.balance) + "\n";
		return value; 
		}
	/**
	 * contain method to check whether the current number already exists
	 * @param item the number being tested
	 * @return found boolean value that is true if an instance of the number is found
	 */
	public static boolean contain(int item){
		boolean found = false;
		int i = 0;
		while (!found && (i<index)){
			if (item==accountNums[i])
				found=true;
			else
				i++;
		}
		return found;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setBalance(String balance) {
		double newBalance = Double.parseDouble(balance);
		this.balance = newBalance;
	}
	
	public double getBalance(){
		return balance;
	}

	public static int numAccounts(){
		return numAccounts;
	}

	public static void setNumAccounts(int numAccounts) {
		Account.numAccounts = numAccounts;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int n) {
		Account.index = n;
	}




}

