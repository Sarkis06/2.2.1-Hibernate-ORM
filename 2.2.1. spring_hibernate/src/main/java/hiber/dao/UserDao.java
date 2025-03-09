package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user); // добавляет пользователя в БД
   List<User> listUsers(); // получает список всех пользователей
   User getUserAddCar (String model, int series); // находит пользователя по модели и серии машины

}
