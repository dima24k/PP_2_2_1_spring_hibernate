package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      List<User> usersList = new ArrayList<>();
      List<Car> carsList = new ArrayList<>();

      usersList.add(new User("User1", "Lastname1", "user1@mail.ru") );
      usersList.add(new User("User2", "Lastname2", "user2@mail.ru") );
      usersList.add(new User("User3", "Lastname3", "user3@mail.ru") );
      usersList.add(new User("User4", "Lastname4", "user4@mail.ru") );

      carsList.add(new Car("Mod-1", 123) );
      carsList.add(new Car("Mod-2", 456) );
      carsList.add(new Car("Mod-3", 789) );
      carsList.add(new Car("Mod-4", 321) );

      for (User user : usersList) {
         userService.addUser(user);
      }

      for (Car car : carsList) {
         userService.addCar(car);
      }

      List<User> users = userService.getListUsers();
      List<Car> cars = userService.getListCars();

      for(int i = 0; i < usersList.size(); i++) {
         users.get(i).setCar(cars.get(i) );
         userService.update(users.get(i) );
      }

      for (User user : users) {
         System.out.println("Id = "+user.getId() );
         System.out.println("First Name = "+user.getFirstName() );
         System.out.println("Last Name = "+user.getLastName() );
         System.out.println("Email = "+user.getEmail() );
         System.out.println("Car Model = " + user.getCar().getModel() );
         System.out.println("Car Series = " + user.getCar().getSeries() );
         System.out.println();
      }

      System.out.println(userService.getUserByModelAndSeries("Mod-2", 456) );

      context.close();
   }
}
