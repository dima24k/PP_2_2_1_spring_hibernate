package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
   @Override
   public void addUser(User user) {
      userDao.addUser(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getListUsers() {
      return userDao.getListUsers();
   }

   @Transactional
   @Override
   public User getUserByModelAndSeries(String carModel, int carSeries) {
      return userDao.getUserByModelAndSeries(carModel, carSeries);
   }

   @Transactional
   @Override
   public void addCar(Car car) {
      userDao.addCar(car);
   }

   @Transactional(readOnly = true)
   @Override
   public List<Car> getListCars() {
      return userDao.getListCars();
   }

   @Transactional
   @Override
   public void update(User user) {
      userDao.update(user);
   }
}
