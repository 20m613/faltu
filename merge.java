
public class merge {

	public static void main(String[] args) {
		int[] unsorted={50,10,20,30,0,2,8,55,3,21,43};
		merge ob=new merge();
		int result[]=new int[unsorted.length];
		result=ob.sort(unsorted);
		for(int i=0;i<result.length;i++)
			System.out.println(result[i]+" ");
		System.out.println("DONE!!");
	}
	
	public int[] sort(int[] unsorted){
		int mid=unsorted.length/2;
		if(unsorted.length<=1)
			return unsorted;
		
		int[] left=new int[unsorted.length/2];
		int[] right=new int[unsorted.length-mid];
		
		for(int i=0;i<mid;i++)
			left[i]=unsorted[i];
		int k=0;
		for(int i=mid;i<unsorted.length;i++)
			right[k++]=unsorted[i];

		left=sort(left);
		right=sort(right);
		return merge(left,right);

	}
	
	public int[] merge(int[] left,int[] right){
		int[] result=new int [left.length+right.length];
		int leftIterator=0,rightIterator=0;
		int mid=result.length/2;
		int resultIterator=0;
		while(leftIterator<left.length||rightIterator<right.length){
			
			if(leftIterator<left.length&&rightIterator<right.length){
				if(left[leftIterator]<right[rightIterator])
					result[resultIterator++]=left[leftIterator++];
				else
					result[resultIterator++]=right[rightIterator++];
				
			}
			
			else if(leftIterator<left.length)
				result[resultIterator++]=left[leftIterator++];
			
			else
				result[resultIterator++]=right[rightIterator++];	
		}
		return result;
	}
	
	
}
