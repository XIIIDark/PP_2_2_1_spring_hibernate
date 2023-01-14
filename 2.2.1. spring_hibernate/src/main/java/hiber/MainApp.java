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

      Car car1 = new Car("RXS",301);
      Car car2 = new Car("RX",300);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      User user3 = new User("User1", "Lastname1", "user1@mail.ru");
      User user4 = new User("User1", "Lastname1", "user1@mail.ru", car2);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      User userByCar = userService.getUserByCar("RXS",301);
      List<User> users = userService.listUsers();

      System.out.println();
      for (User user : users) {
         System.out.println(user);
      }

      System.out.println("\nUser by Car:");
      System.out.println(userByCar);

      context.close();
   }
}
