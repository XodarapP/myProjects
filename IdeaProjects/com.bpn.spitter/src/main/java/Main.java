import dao.UsersInformationDAO;
import model.UsersInformation;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //UsersInformation usersInformation = new UsersInformation();
        //usersInformation.setId(5);
        //usersInformation.setLogin("Lola");
        //usersInformation.setName("Lolita");
        //usersInformation.setPassword("Lol225412");
        //usersInformation.setFullName("Lolita Messandey");
        //ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        //UsersInformationDAO usersInformationDAO = (UsersInformationDAO) context.getBean("usersInformationDAO");
        //usersInformationDAO.insert(usersInformation);
        //usersInformationDAO.insert("Ulia","Ulia024455","Julia","Ulia");
        //usersInformationDAO.delete("Twu");
        //usersInformationDAO.selectByLogin("StandUp");
        //usersInformationDAO.lambdaQuery();
        //usersInformationDAO.update("Oleg", "Ulia");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    }
}
