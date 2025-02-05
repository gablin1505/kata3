package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user = new User("admin", "admin", "admin");
      Car car = new Car(user,"BMW",1900);
      user.setCar(car);
      userService.add(user);
      User user2 = new User("admin2", "admin2", "admin2");
      Car car2= new Car(user2,"BMW",1900);
      user2.setCar(car2);
      userService.add(user2);
      User user3 = new User("admin3", "admin3", "admin3");
      Car car3 = new Car(user3,"BMW3",19003);
      user3.setCar(car3);
      userService.add(user3);
      System.out.println(userService.getUser(1));
      System.out.println(userService.getCar(1));
      System.out.println(userService.getUser(2));
      System.out.println(userService.getCar(2));
      System.out.println(userService.getUser(3));
      System.out.println(userService.getCar(3));
     System.out.println(userService.getUserByCarModelAndSeries("BMW3",19003));
      context.close();
   }
}
