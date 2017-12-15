import java.util.*;

public class Ranking {
	ArrayList<Country> list=new ArrayList<Country>();
	public static void main (String [] args){
		Ranking ob=new Ranking();
		
		Country country=ob.new Country();
		country.addCountryToList("India",3,2,1);
		country.addCountryToList("Aus",30,2,19);
		country.addCountryToList("England",30,20,1);
		country.addCountryToList("Pakistan", 0,0,16);
		
		ArrayList<Country> sortedList=ob.sort(ob.list);
		//country.print(ob.list);
		

	}
	
	private int size(ArrayList<Country> list){
		int size=0;
		
		return size;
		
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
	
	
	class Country{
		String name;
		MedalCount count=null;
		public Country(){
			
		}
		public Country(String name,int gold,int silver,int bronze){
			this.name=name;
			count=new MedalCount(gold,silver,bronze);
		}
		public void addCountryToList(String CountryName,int gold,int silver,int bronze){
			Country newCountry=new Country(CountryName,gold,silver,bronze);
			list.add(newCountry);
		}
	}
	class MedalCount{
		int gold,silver,bronze;
		public MedalCount(int gold,int silver,int bronze){
			this.gold=gold;
			this.silver=silver;
			this.bronze=bronze;
		}
	}
	
}

