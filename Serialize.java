
import java.io.*;
public class Serialize implements Serializable{

    private String name;
    public Serialize(String name)
    {
        this.name = name;
    }
    
    public static void main(String[] args)
    {
    	//Serialize
        try
        {
        	Serialize d =new Serialize("GeeksForGeeks");
            FileOutputStream f = new FileOutputStream("file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(d);
            oos.close();
            f.close();
            System.out.println("Serialized!!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //Deserialize
        try{
			Serialize ob;
			FileInputStream fin=new FileInputStream("file.txt");
			ObjectInputStream ois=new ObjectInputStream(fin);
			ob=(Serialize)ois.readObject();
			System.out.println("Name:  "+ob.name);
			System.out.println("done!!");
        }
		catch(Exception e){
			e.printStackTrace();
		}
    }
}
