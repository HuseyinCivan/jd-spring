import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.FullTimeMentor;

public class CybertekApp {
    public static void main(String[] args) {

        //Mentor mentor = new FullTimeMentor(); classic way

        //BeanFactory container = new ClassPathXmlApplicationContext("config.xml");

        //same as above
        ApplicationContext container =  new ClassPathXmlApplicationContext("config.xml");



        Mentor mentor = (Mentor) container.getBean("fullTimeMentor");
        mentor.createAccount();

        //Mentor mentor2 = (Mentor) container.getBean("partTimeMentor");
        Mentor mentor2 = container.getBean("partTimeMentor",Mentor.class);
        mentor2.createAccount();

    }
}
