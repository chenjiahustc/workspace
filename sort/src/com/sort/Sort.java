package com.sort;

public class Sort {
	static private int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51}; 
	
	static public void insertSort(){
		int temp = 0;
		for(int i = 1; i < a.length;i++){
			int j = i - 1;
			temp = a[i];
			for(; j >= 0 && temp < a[j]; j--){
				a[j + 1] = a[j];
			}
			a[j+1] = temp;
		}
	}
	
	static public void shellSort(){
		double d1 = a.length;
		int temp = 0;
		
		while(true){
			d1 = Math.ceil(d1 / 2);
			int d = (int)d1;
			for(int x = 0; x < d; x++){
				for(int i = x + d; i < a.length; i += d){
					int j = i - d;  
					temp = a[i];
					for(;j >= 0 && temp < a[j]; j -= d){
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}
			
			if(1 == d){
				break;
			}
		}
	}
	
	static public void print(){
		for(int i = 0;i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
	public static void main(String[] args) {
		//insertSort();
		shellSort();
		print();

	}

}
