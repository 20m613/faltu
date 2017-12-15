import java.util.*;


//Wrong
import java.io.*;
public class Swiggy1 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        while(true){
         String N = br.readLine();
         
         String out_ = PrimeDigitNumber(N);
         System.out.println(out_);
        }
        // wr.close();
        // br.close();
    }
    static String PrimeDigitNumber(String N){
        int[] hash={7,0,2,3,3,5,5,7,7,7};
        double returnVal=0;
        int zero=0;
        for(int i=N.length()-1;i>=0;i--){
        	int number=N.charAt(i)-'0';
        	returnVal=hash[number]*pow(10,zero)+returnVal;
        	zero++;
        }
        String returnValStr=returnVal+"";
        return returnValStr;
    }
    public static int pow(int base, int power){
    	if(power==0)
    		return 1;
    	int temp=base;
    	for(int i=0;i<power-1;i++)
    		base*=temp;
    	return base;
    }
}
