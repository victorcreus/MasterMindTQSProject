package MasterMindTQSProject;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner implements ScannerInterface{
	
	Scanner newValues;
	
	MyScanner(){
		newValues = new Scanner(System.in);
	}
	
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
