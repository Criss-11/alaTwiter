import dao.UserDao;
import dao.impl.AppUserDao;
import model.AppUser;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        UserDao userDao = new AppUserDao();
        AppUser user1 = new AppUser();
        AppUser user2 = new AppUser();

        user1.setDateOfRegistration(new Date());
        user1.setEmail("user1@gmai.com");
        user1.setLastName("Mikolajski");
        user1.setName("Krzysztof");
        user1.setLogin("Krzysztof");
        user1.setPassword("123");
        userDao.saveUser(user1);

        user2.setDateOfRegistration(new Date());
        user2.setEmail("user2@gmai.com");
        user2.setLastName("Bale");
        user2.setName("Gareth");
        user2.setLogin("Gareth");
        user2.setPassword("456");
        userDao.saveUser(user2);


        userDao.follow("Krzysztof", "Gareth");
        AppUser gareth = userDao.getUserByLogin("Gareth");
        Set<AppUser> followers = gareth.getFollowers();
        userDao.stopFollowing("Krzysztof", "Gareth");
        AppUser gareth1 = userDao.getUserByLogin("Gareth");
        HashSet<AppUser> followers1 = userDao.getFollowers(gareth1.getLogin());

        System.out.println(followers.size());
        userDao.saveUser(gareth1);
    }
}
