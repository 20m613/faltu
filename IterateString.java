
public class IterateString {
	public static void main(String[] args){
		IterateString ob=new  IterateString();
		ob.StringIterator(new StringBuffer("32449"));
	}
	
	private StringBuffer StringIterator(StringBuffer str){
		int len=str.length();
		System.out.println(str);
		while((str.equals("0"))==false){
			int i=len-1;
			while(str.charAt(i)=='0'){
				i--;
				if(i==-1)
					return new StringBuffer("0");
			}
		
			int ch=str.charAt(i);
			ch-=1;
			str.setCharAt(i,(char)ch);
		
			for(int j=i+1;j<=len-1;j++)
				str.setCharAt(j, '9');
			System.out.println(str);
		}
		return str;
	}
}
