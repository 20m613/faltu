import java.util.*;

public class RemoveSpaces {
	public static void main(String[] args){
		String input="   H o  war     e y o  u ! !    ";
		System.out.println(removeSpaces(input));
	}
	
	public static char[] removeSpaces(String in){
		int start=1,end=0;
		char[] inArray=in.toCharArray();
		int spaces=0;
		int moveToLeft=0;
		for(int i=0;i<inArray.length;i++){
			//start=1;end=0;
			if(inArray[i]==' '){
			    //System.out.println("i:  "+i);
				start=i;
				while(i<inArray.length && inArray[i]==' '){i++;}
				end=i-1;
				moveToLeft=(end-start+1);
				//System.out.println(inArray);
				int k=i;
				//System.out.println("i:  "+i);
				//System.out.println("moveToLeft:  "+moveToLeft);
				if(moveToLeft>0){
					while(k<inArray.length && inArray[k]!=' '){
						inArray[k-moveToLeft]=inArray[k];
						k++;
					}
				}
				for(int l=1;l<=moveToLeft;l++){
					inArray[k-l]=' ';
				}
				//System.out.println(inArray);
				i-=moveToLeft;
			}
		}
		return inArray;
	}
}
