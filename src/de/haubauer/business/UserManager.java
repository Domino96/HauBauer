package de.haubauer.business;

import de.haubauer.db.entities.User;

public class UserManager {
    private User loggedInUser;

    private static UserManager instance;

    public static UserManager getInstance() {
        if (instance == null) {
            try {
                instance = new UserManager();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e.getCause());
            }
        }

        return instance;
    }

    private UserManager() {}

    /**
     * Versucht, den User mit dem gewählten Benutzername und Passwort einzuloggen.
     * @param userName Der Benutzername, in den eingeloggt werden soll.
     * @param password Das Passwort, mit dem ein Login versucht werden soll.
     * @return Ein Boolean, der angibt, ob der Login erfolgreich oder fehlgeschlagen war.
     * */
    public boolean tryLogin(String userName, String password) {
        return false;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public boolean isUserLoggedIn() {
        return this.loggedInUser != null;
    }
}
