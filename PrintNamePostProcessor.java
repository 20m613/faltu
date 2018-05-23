import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PrintNamePostProcessor implements BeanPostProcessor{
	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException{
		//called b4 initializing a bean
		System.out.println("postProcessorBefore called for "+name);
		if(name.equals("pointA")){
			Point p=(Point)bean;
			p.setX(11);
			p.setY(22);
			bean=p;
		}
		return bean;
	}
	public Object postProcessAfterInitialization(Object bean, String name)throws BeansException{
		//called after initializing a bean
		System.out.println("postProcessorAfter called for "+name);
//		if(name.equals("pointA")){
//			Point p=(Point)bean;
//			p.setX(10);
//			p.setY(20);
//			bean=p;
//		}
		return bean;
	}
}
