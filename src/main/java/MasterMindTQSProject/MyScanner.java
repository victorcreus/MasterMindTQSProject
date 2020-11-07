package MasterMindTQSProject;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner implements ScannerInterface{
	
	Scanner newValues;
	//String values;
	
	MyScanner(){
		newValues = new Scanner(System.in);
	}
	
	/*@Override
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
	}*/
	
	@Override
	public void setNewCode(String values) {}
	
	@Override
	public void setNewInt(int values) {}
	
	
	@Override
	public int nextInt() {
		return newValues.nextInt();
	}
	
	@Override
	public String nextLine() {
		return newValues.nextLine();
	}
}
