import java.util.*;

public class PostFixImplementation {
	private static int implementPostFix(String input){
		Stack<Integer> stack=new Stack<Integer>();
		int x,y;
		char operator;
		stack.push(input.charAt(0)-'0');
		int i=1;
		while(i<input.length()){
			if(input.charAt(i)=='*' || input.charAt(i)=='-' || input.charAt(i)=='+' || input.charAt(i)=='/'){
				operator=input.charAt(i);
				x=stack.pop();
				y=stack.pop();
				switch(operator){
					case '+':
						
						stack.push(x+y);
						break;
					case '-':
						stack.push(x-y);
						break;
					case '*':
				
						stack.push(x*y);
						break;
					case '/':
						stack.push(x/y);
						break;
				}
			}
			else{
				stack.push(input.charAt(i)-'0');
			}
			i++;
		}
		return stack.pop();
	}
	
	public static void main(String[] args){
		String str="12*";
		System.out.println("Result:  "+implementPostFix(str));
	}
}
