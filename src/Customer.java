package src;
import java.util.ArrayList;

public class Customer implements customerInterface{
	private String name;
	private int SSNo;
	private String email;

	public Customer (String Name, int SSN, String Email){
		name = Name;
		SSNo = SSN;
		email = Email;
	}
	@Override
	public void setName(String str) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setName'");
	}

	@Override
	public void setSSN(int x) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setSSN'");
	}

	@Override
	public void setEmail(String str) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
	}

}
