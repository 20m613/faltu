import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle {//implements InitializingBean, DisposableBean, ApplicationContextAware {
	private Point a;
	private Point b;
	private Point c;
	private ApplicationContext context=null;
	public Triangle(){
		System.out.println("Triangle constructor called");
	}
	
	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		//this.a =(Point) context.getBean("pointA");
		this.a=a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}

	
	
	
	
	//	private int height;
//	private String type;
//	public Triangle(){};
//	public Triangle(int height, String type){
//		this.height=height;
//		this.type=type;
//	}
//	public Triangle(int height){
//		this.height=height;
//	}
//	public Triangle(String type){
//		this.type=type;
//	}
//	public int getHeight() {
//		return height;
//	}
//	public void setHeight(int height) {
//		this.height = height;
//	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public String toString(){
//		return this.getType()+"  "+this.getHeight();
//	}
	public String toString(){
		return "("+a.getX()+", "+a.getY()+"), ("+b.getX()+", "+b.getY()+"), ("+c.getX()+", "+c.getY()+")";
	}
	public void draw(){
		System.out.println("draw triangle!!");
	}
//
//	@Override
//	public void setApplicationContext(ApplicationContext context) throws BeansException {
//		this.context=context;
//		System.out.println("triangle:  context.hashCode: "+context.hashCode());
//	}
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("afterPropertiesSet method called!!");
//		
//	}
//
	public void init() throws Exception {
		System.out.println("init method called!");
		
	}
	public void destroy() throws Exception {
		System.out.println("destroy method called!");
		
	}
}
