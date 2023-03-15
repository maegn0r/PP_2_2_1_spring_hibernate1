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

        userService.saveUserAndCar(new User("User1", "Lastname1", "user1@mail.ru"), new Car("BMW", "202"));
        userService.saveUserAndCar(new User("User2", "Lastname2", "user2@mail.ru"), new Car("Kia", "302"));
        userService.saveUserAndCar(new User("User3", "Lastname3", "user3@mail.ru"), new Car("Audi", "402"));
        userService.saveUserAndCar(new User("User4", "Lastname4", "user1@mail.ru"), new Car("Haval", "602"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        System.out.println(userService.getUserByCarModelAndSeries("Audi", "402"));

        context.close();
    }
}
