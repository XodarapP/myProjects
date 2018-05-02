import com.springinaction.juggers.performers.Magician;
import com.springinaction.juggers.performers.Volunteer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.TestCase.assertEquals;

public class Test {

    @org.junit.Test
    public void magicianShouldReadVolunteersMind(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jugglers.xml");
        Volunteer volunteer = (Volunteer) context.getBean("volunteer");
        Magician magician = (Magician) context.getBean("magician");
        volunteer.thinkOfSomething("Queen of hearts");
        assertEquals("Queen of hearts", magician.getThoughts());
    }
}
