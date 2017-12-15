import java.util.*;

public class PascalTriangle {
	public static void main(String[] args){
		int[] prev,curr={1};
		
		Scanner sc=new Scanner(System.in);
		prev=curr;
		int n=sc.nextInt();
		int space=n;
		
		for(int k=space;k>0;k--)
			System.out.print(" ");
		space--;
		System.out.println(curr[0]);
		
		for(int i=2;i<=n;i++){
			for(int k=space;k>0;k--)
				System.out.print(" ");
				
			space--;
			curr=new int[i];
			curr[0]=1;
			curr[i-1]=1;
			for(int j=1;j<=i-2;j++)
				curr[j]=prev[j-1]+prev[j];
			for(int k=0;k<i;k++)
				System.out.print(curr[k]+" ");
			System.out.println("");
			prev=curr;
		}
		sc.close();
		
	}
}
