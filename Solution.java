import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
		ArrayList<String> palindromes=new ArrayList();
		public void printPalindromes(String s) {
		    if (s == null || s.length() < 3)
		        return;

		    //System.out.println("Odd Length Palindromes:");
		    // Odd Length Palindromes
		    for (int i=1; i<s.length()-1; i++) {
		        for (int j=i-1,k=i+1; j>=0 && k<s.length(); j--,k++) {
		            if (s.charAt(j) == s.charAt(k)) {
		                if (k-j+1 >= 3)
		                    //System.out.println(s.substring(j, k+1) + " with index " +j+ " and "+k);
		                	palindromes.add(s.substring(j, k+1));
		            }
		            else
		                break;
		        }
		    }

		    //System.out.println("\nEven Length Palindromes:");
		    // Even Length Palindromes
		    for (int i=1; i<s.length()-1; i++) {
		        for (int j=i,k=i+1; j>=0 && k<s.length(); j--,k++) {
		            if (s.charAt(j) == s.charAt(k)) {
		                if (k-j+1 >= 3)
		                    //System.out.println(s.substring(j, k+1) + " with index " +j+ " and "+k);
		                	palindromes.add(s.substring(j, k+1));
		            }
		            else
		                break;
		        }
		    }
		}

	public static void main(String[] args){
		   String s = "lankedinasddsanideknil";
		   Solution ob=new Solution();
		   ob.printPalindromes(s);
		   for(String i:ob.palindromes){
			   System.out.println(i);
		   }
		   
		   String find="linkedin";
		   String dnif="nideknil";
		   //StringBuilder max=new StringBuilder();
		   int maxLength=0;
		   
		   for(String i:ob.palindromes){
			   System.out.println(i);
			   int j=0,k=0;
			   //for(int j=0,k=0;j<i.length()&&k<find.length();j++,k++){
			   while(true){
				   //System.out.println(j);
				   	if(j>i.length()-1||k>7)
				    	break;
				   	if(i.charAt(j)==find.charAt(k)){
				   		System.out.println(i.charAt(j)+"  "+find.charAt(k));
				    	j++;
				    	k++;
				    }
				    else{
				    	j++;
				    	k=0;
				    }
			   }
			   System.out.println("k:  "+k);
			   int jp=0,kp=0;
			   
			   while(true){
				   	if(jp>i.length()-1||kp>7)
				    	break;
				    if(i.charAt(jp)== dnif.charAt(kp)){
				    	System.out.println(i.charAt(jp)+"  "+find.charAt(kp));
				    	jp++;
				    	kp++;
				    }
				    else{
				    	jp++;
				    	kp=0;
				    }
			   }
			   System.out.println("KP:  "+kp);
			   if((k+kp)>maxLength){
				  maxLength=k+kp; 
			   }
		   }
		   System.out.println(16-maxLength);
	}
}


