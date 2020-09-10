package test;
import java.util.Scanner;
public class Scanner1 {
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		int [] data= {51,23,6,17,11};
		int target=50;
		int near= 0;
		int abs=0;
		int min=999;
		
		for(int i=0; i<data.length;i++) {
			abs=((data[i] - target)<0)? -(data[i]-target):(data[i]-target);
			
			if(abs<min) {
				
				min=abs;
				near=data[i];
			
			}
				
				
			
			
		}
		System.out.println(near);
 } 
	
}