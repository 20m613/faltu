//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.FileSystemResource;

public class Application {

	public static void main(String[] args) {
		//BeanFactory context=new XmlBeanFactory(new FileSystemResource("spring.xml"));//uses the one that is there at the end
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");//use this when to register a shutdown hook
		//uses the one that is there in the application classpath
		context.registerShutdownHook();//destroy method will not be called if we don't register a shutdown hook.
		System.out.println("Main context.hashCode:  "+context.hashCode());
		Triangle t=(Triangle)context.getBean(Triangle.class);
		System.out.println(t);
		t.draw();
		Triangle t2=(Triangle)context.getBean("triangle");
		System.out.println("t.hashCode():  "+t.hashCode());
		System.out.println("t2.hashCode():  "+t2.hashCode());
		
		
//		System.out.println("t.pointA.hashCode():  "+t.getA().hashCode());// even though the point bean is a protptype then also only single bean for pointA,B,C will be created as triangle bean is a singleton
//		System.out.println("t2.pointA.hashCode():  "+t2.getA().hashCode());
//		ApplicationContext context2=new ClassPathXmlApplicationContext("spring.xml");
//		Triangle t3=(Triangle)context2.getBean("triangle");
//		System.out.println("t3.hashCode():  "+t3.hashCode());
	}

}
