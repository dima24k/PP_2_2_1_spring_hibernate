package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getListUsers();

    User getUserByModelAndSeries(String carModel, int carSeries);
    void addCar(Car car);
    List<Car> getListCars();
    void update(User user);
}
