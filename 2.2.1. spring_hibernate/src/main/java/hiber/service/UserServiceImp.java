package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private SessionFactory sessionFactory;


    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(long id) {
        User user = userDao.getUser(id);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с id " + id + " не найден");
        }
        return user;
    }

    @Transactional
    @Override
    public Car getCar(long id) {
        Car car = userDao.getCar(id);
        if (car == null) {
            throw new IllegalArgumentException("Машина с id " + id + " не найдена");
        }
        return car;
    }

    @Transactional
    @Override
    public List<Car> carList() {
        return userDao.listCars();
    }

    @Transactional
    public User getUserByCarModelAndSeries(String model, int series) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT u FROM User u JOIN u.car c " +
                "WHERE c.model = :model AND c.series = :series";
        return session.createQuery(hql, User.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .getSingleResult();
    }

    @Override
    public void addcar(Car car) {
        userDao.addCar(car);
    }


}
