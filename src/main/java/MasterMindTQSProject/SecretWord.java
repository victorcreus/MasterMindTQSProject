package MasterMindTQSProject;

import java.util.Random;

public class SecretWord {
	
	private int word_length;
	private int min_number;
	private int secretWord[];
	
	public SecretWord() {
		word_length = 5;
		min_number = 1;
	}
	
	public SecretWord(int length, int min) {
		word_length = length;
		min_number = min;
	}

	public int getWord_length() {
		return word_length;
	}

	public void setWord_length(int word_length) {
		this.word_length = word_length;
	}

	public int getMin_number() {
		return min_number;
	}

	public void setMin_number(int min_number) {
		this.min_number = min_number;
	}

	public int[] getSecretWord() {
		return secretWord;
	}

	public void setSecretWord(int[] secretWord) {
		this.secretWord = secretWord;
	}
	
	//TODO: Finish the generateSecretWord function
	private int[] generateSecretWord(int length, int minValue) {
		Random r = new Random();
		int code[] = new int[length];
		int numbers[] = new int[length];
		for (int i = 0; i < length; i++) {
			numbers[i] = minValue + i;
		}
		for (int i = 0; i < length; i++) {
			int value = r.nextInt(length-1);
			while(numbers[value] != -1) {
				if (numbers[value]!=-1) {
					code[i]=numbers[value];
					numbers[value]=-1;
				}else {
					value = r.nextInt(length-1);
				}
			}
		}	
		/*
		int low = minValue;
		int high = (low + length)-1;
		boolean hasDuplicated = true;
		//System.out.println("Antes del while");

		while(hasDuplicated) {
			for(int i = 0; i < length; i++){
		        code[i] = r.nextInt(high-low) + low;
		        //System.out.println("Estoy en el for");
		    }
			System.out.println("_");
			for(int i = 0; i < length; i++){
		        System.out.println(code[i]);
		    }
			System.out.println("_");
			
			hasDuplicated = hasDuplicated(code);
			//System.out.println("Estoy en el while");
		}
		
		//System.out.println("Despues del while");*/
		return code;
	}
	
	private boolean hasDuplicated(int[] secret) {
		int i, j;
		boolean duplicated = false;
		for(i = 0; i<5; i++) {
			for(j= 0; j<5; j++) {
				if((i != j) && (secret[i]==secret[j])) {
					duplicated = true;
				}
			}
		}
		
		
		return duplicated;
	}
	
	public boolean proxyHasDuplicated(int[] secretWord) 
	{
		return hasDuplicated(secretWord);
	}
	
	public int[] proxyGenerateSecretWord(int length, int minValue) 
	{
		return generateSecretWord(length, minValue);
	}
	
	
}
