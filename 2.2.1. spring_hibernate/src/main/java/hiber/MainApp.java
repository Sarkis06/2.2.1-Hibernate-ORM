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
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            UserService userService = context.getBean(UserService.class);

            userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
            userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
            userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
            userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


            User[] userArr = {
                    new User("Андрей", "Иванов", "user5@mail.ru", new Car("KIA", 15)),
                    new User("Константин", "Петров", "user6@mail.ru", new Car("BMV", 34)),
                    new User("Петр", "Сидоров", "user7@mail.ru", new Car("WV", 600))
            };
            for (User user : userArr) {
                userService.add(user);
            }
            List<User> users = userService.listUsers();

            users.forEach(user -> {
                System.out.printf("Id = %d\nFirst Name = %s\nLast Name = %s\nEmail = %s\n\n",
                        user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
                if (user.getCar() != null) {
                    System.out.printf("Car = %s\n\n", user.getCar());
                } else {
                    System.out.println("Car = None\n");
                }
            });
            User userWithCar = userService.getUserAddCar("KIA", 15);
            if (userWithCar != null) {
                System.out.println(userWithCar);
            } else {
                System.out.println("Нет пользователя с такой машиной: "+ userWithCar);
            }
            // context.close();
        }
    }
}