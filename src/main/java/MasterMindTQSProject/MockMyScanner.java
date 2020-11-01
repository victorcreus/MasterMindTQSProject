package MasterMindTQSProject;

import java.util.InputMismatchException;

public class MockMyScanner implements ScannerInterface{
	
	
	String values;
	
	MockMyScanner(){
	}
	
	@Override
	public String introduceNewCode() {
		return "";
	}
	
	
	/*@Override
	public String introduceNewCode(String values) {
		try {
			this.values = values;
		} catch (InputMismatchException exception) {}
		
		return this.values;
	}*/
	
	@Override
	public int nextInt(int values) {
		return values;
	}
	
	public void addValues(String values) {
		this.values = values;
	}

	@Override
	public String introduceNewCode(String values) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
