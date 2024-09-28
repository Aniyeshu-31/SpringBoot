package demo;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;
// import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {

        //   ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
         Doctor obj = context.getBean(Doctor.class);
         obj.assist();
         obj.setQualification("MBBS");  
        //   Doctor obj = (Doctor) context.getBean("doctor");
        //   Staff staff = context.getBean(Doctor.class);
        //   Staff staff2 = context.getBean(Nurse.class);
        //   staff.assist();
        //   staff2.assist();
    }
}
// AOP -> Aspect Oriented Programming -> is used to remove cross cutting concerns from the business logic