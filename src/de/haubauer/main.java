package src.de.haubauer;

import src.de.haubauer.db.BaseDao;
import src.de.haubauer.db.entities.User;

public class main {
    public static void main(String[] args) {
        BaseDao<User> userDao = new BaseDao<>(User.class);

        userDao.getAll();
    }
}
