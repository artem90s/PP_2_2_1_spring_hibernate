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

      User user1 = new User("Artem", "Shcherbakov", "mmm@mmm.ru");
      Car car = new Car("bmw", 5);
      User user2 = new User("Ivan", "Pertov", "mssm@mmm.omu");
      Car car1 = new Car("audi", 80);
      User user3 = new User("Olga", "Ivanova", "mssm@dfdmmm.com");
      Car car2 = new Car("mers", 600);

      user1.setCar(car);
      user2.setCar(car1);
      user3.setCar(car2);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      userService.findUserByCar("mers", 600);




//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//

//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
      context.close();
   }
}
