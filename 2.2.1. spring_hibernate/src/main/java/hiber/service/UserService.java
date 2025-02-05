package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void addcar(Car car);

    List<User> listUsers();

    User getUser(long id);

    Car getCar(long id);

    List<Car> carList();

    public User getUserByCarModelAndSeries(String model, int series);

}
