package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
   public void addUser(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getListUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByModelAndSeries(String carModel, int carSeries) {
      return sessionFactory.getCurrentSession()
              .createQuery("FROM User WHERE car.model = :carModel AND car.series = :carSeries", User.class)
              .setParameter("carModel", carModel)
              .setParameter("carSeries", carSeries)
              .getSingleResult();
   }

   @Override
   public void addCar(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<Car> getListCars() {
      TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
      return query.getResultList();
   }

   @Override
   public void update(User user) {
      sessionFactory.getCurrentSession().update(user);
   }
}
