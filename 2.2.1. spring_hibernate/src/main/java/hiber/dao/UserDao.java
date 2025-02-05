package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User getUser(long id);
   Car getCar(long id);
   List<Car> listCars();
   void addCar(Car car);

}
