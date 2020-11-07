package MasterMindTQSProject;

import java.util.ArrayList;
import java.util.List;

//import java.util.InputMismatchException;

public class MockMyScanner implements ScannerInterface{
	
	
	String stringValue;
	List<Integer> intList = new ArrayList<>();
	int usados = 0;
	
	MockMyScanner(){
	}
	
	@Override
	public void setNewInt(int value) {
		this.intList.add(value);
	}
	
	@Override
	public void setNewCode(String values) {
		this.stringValue = values;
	}

	@Override
	public int nextInt() {
		return this.intList.get(usados++);
	}

	@Override
	public String nextLine() {
		return this.stringValue;
	}
}
