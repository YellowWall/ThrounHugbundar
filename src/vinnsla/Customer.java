package src.vinnsla;
//import java.util.ArrayList;

public class Customer implements customerInterface{
	private String name;
	private int SSN;
	private String email;

	public Customer (String name, int SSN, String email){
		this.name = name;
		this.SSN = SSN;
		this.email=email;
	}
	//@Override
	public String getName() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'setName'");
		return name;
	}

	//@Override
	public int getSSN() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'setSSN'");
		return SSN;
	}

	//@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
		return email;
	}

}
