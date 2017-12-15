public class Wrapper{
	public static void main(String[] args) {
		int c=10;
		int d=11;
		WrapperClass ob1=new WrapperClass(c);
		WrapperClass ob2=new WrapperClass(d);
		System.out.println(ob1.c+"  "+ob2.c);
		swapInt(ob1, ob2);
		System.out.println(ob1.c+"  "+ob2.c);
		
		Car c1=new Car(1,'a');
		Car c2=new Car(2,'b');
		swapCarNoWrapper(c1, c2);//in java actual arguments are passed by value not reference
		//in case of objects the copies of the object references are passed to the formal arguments .
		//this reference points to the same location as the actual arguments but are not same as the actual arguments
		// eg. actual arg--> a,b
		//	   formal arg--> c,d 
		// memory location pointed by a-->x, by b-->y
		//now when we pass a,b to the swap function, the copy of the reference to x,y is passed to the function not reference to a,b
		//now since c,d will contain the copies of the reference, any changes done on the copies will not get reflected in the calling (main) function
		
		//for this purpose we use wrapper classes to wrap the class in the wrapper and then send the wrapper object as actual parameters to the formal parameters of tht function
		//and then swap the contents of the wrapper objects.
		
		
		System.out.println(c1.no+"  "+c1.model+"  "+c2.no+"  "+c2.model);
		carWrapperClass cw1=new carWrapperClass(c1);
		carWrapperClass cw2=new carWrapperClass(c2);
		swapCar(cw1, cw2);
		System.out.println(cw1.c.no+"  "+cw1.c.model+"  "+cw2.c.no+"  "+cw2.c.model);
	}
	public static void swapInt(WrapperClass ob1, WrapperClass ob2){
		int temp=ob1.c;
		ob1.c=ob2.c;
		ob2.c=temp;
	}
	public static void swapCar(carWrapperClass c1, carWrapperClass c2){
		Car temp=c1.c;
		c1.c=c2.c;
		c2.c=temp;
	}
	//In java everything is passed as value
	//here location of c1 and c2 are passed as values to this function
	//hence the changes are reflected locally only
	public static void swapCarNoWrapper(Car c1, Car c2){
		System.out.println("In CarSwapNoWrapper:  before");
		System.out.println(c1.no+"  "+c1.model+"  "+c2.no+"  "+c2.model);
		Car temp=c1;
		c1=c2;
		c2=temp;
		System.out.println("In CarSwapNoWrapper:  after");
		System.out.println(c1.no+"  "+c1.model+"  "+c2.no+"  "+c2.model);
	}
	
}
class carWrapperClass{
	Car c;
	public carWrapperClass(Car c) {
		this.c=c;
	}
}

class WrapperClass{
	int c;
	public WrapperClass(int c){
		this.c=c;
	}
}
class Car{
	int no;
	char model;
	public Car(int no, char model){
		this.no=no;
		this.model=model;
	}
	public Car(){}
}


