package MasterMindTQSProject;
import java.util.InputMismatchException;
import java.util.Scanner;

public class myScanner implements ScannerInterface{
	
	Scanner newValues;
	String values;
	
	myScanner(){
		newValues = new Scanner(System.in);
	}
	
	@Override
	public String introduceNewCode() {
		try {
			this.values = newValues.nextLine();
		} catch (InputMismatchException exception) {}
		
		return this.values;
	}
	
	@Override
	public String introduceNewCode(String values) {
		return "";
	}
	
	@Override
	public int nextInt(int values) {
		return newValues.nextInt();
	}
}
