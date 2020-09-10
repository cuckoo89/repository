package test;

import java.util.Scanner;
public class Kimjunghyun {
 static int aNum=5;  	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
      int a[] ={1,2,3,4,5};
      for(int i =0; i<3; i++) {
    	  for(int j=i+1;j<4;j++) {
    		  if(a[i]<a[j]) {
    			  int temp=a[i];
    			  a[i]=a[j];
    			  a[j]=temp;
    		  }
    	  }
      }
       for(int i=0;i<4;i++) {
    	   System.out.println(a[i]);
       }
 }
}