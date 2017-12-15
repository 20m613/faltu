
public class KeepAwake {
	public static void main(String[] args){
		while(true){
			try{
				System.out.println("I Am Awake!!");
				Thread.sleep(30000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
