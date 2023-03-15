package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    void saveUserAndCar(User user, Car car);

    User getUserByCarModelAndSeries(String model, String series);
}
