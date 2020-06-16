package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity=500;
	private int defaultPasswordLength=8;
	private String alternateEmail;
	private String companySuffix = "mycompany.com";
	
	//Constructor
	public Email(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;

		//set Department
		this.department = setDepartment();
		
		//set random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.print("\nRandom Password: "+ this.password );
		
		//set email
		email = this.setEmail();
		System.out.print("\nYour new email is: "+ this.email );
	}
	
	//SET Methods ---------------------------------------------------------------------------
	//Ask for the department
	private String setDepartment() {
		System.out.println("Department Codes:\n1 for Sales\n2 for Developement\n3 for Acccounting\n4 for none");
		System.out.println("Enter Department Code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		
		switch(depChoice)
		{
			case 1: return "sales";
			case 2: return "dev";
			case 3: return "acct";
			default: return "";
		}
	}
	
	private String setEmail() {
		return (this.firstName.toLowerCase() + this.lastName.toLowerCase()+"@"+ this.companySuffix);
	}
	
	private void setMailboxCapacity(int capacity){
		this.mailboxCapacity=capacity;
	}
	
	private void setAternateEmail(String altEmail){
		this.alternateEmail=altEmail;
	}
	
	private void setChangePassword(String password){
		this.password=password;
	}
	
	//GET methods ---------------------------------------------------------------------------
	public String getFullName() {return this.firstName + " " + this.lastName;}
	public String getEmail(){ return this.email; }	
	public int getMailboxCapacity(){ return this.mailboxCapacity; }	
	public String getAlternateEmail(){ return this.alternateEmail; }
	public String getPassword(){ return this.password; }
	
	//METHODS -------------------------------------------------------------------------------
	private String randomPassword(int length) {
		String passwordSet= "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%^&*()";
		char[] password= new char[length];
		for(int i=0;i<length;i++)
		{
			int rand = (int)(Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
	}
	
	public void ShowInfo() {
		
		System.out.println("\nDISPLAY NAME:" + this.getFullName() +"\nCOMPANY EMAIL:"+this.getEmail() + "\nMAILBOX CAPACITY:" + this.getMailboxCapacity() + " MB");
	}
}
