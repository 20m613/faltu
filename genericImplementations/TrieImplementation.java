package genericImplementations;
public class TrieImplementation {
	char data;
	TrieImplementation[] children;
	boolean is_word;
	
	public TrieImplementation(){
		this.data=0;
		this.children=new TrieImplementation[26];
		this.is_word=false;
	}
	
	public void add(String s){
		if(s.length()==0){
			this.is_word=true;
			return;
		}
		
		char letter=s.charAt(0);
		int index=letter-'a';
		
		if(this.children[index]==null){
			TrieImplementation node=new TrieImplementation();
			node.data=letter;
			this.children[index]=node;
		}
		
		this.children[index].add(s.substring(1));
	}
	
	public boolean find(String s){
		if(s.length()==0){
			if(this.is_word==true)
				return true;
			return false;
		}
		char letter=s.charAt(0);
		int index=letter-'a';
		
		if(this.children[index]!=null)
			return this.children[index].find(s.substring(1));
		return false;
		
	}
	
	public boolean isWordFromDictionary(String s,int index){
		
		for(int i=0;i<s.length();i++){
			
		}
		
	}
	
}