package de.haubauer.business;

import de.haubauer.business.models.User;

/**
 * User-Verwaltung.
 */
public class UserManager {
    private User loggedInUser;

    private static UserManager instance;

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }

        return instance;
    }

    private UserManager() {
        // Testdaten
        this.loggedInUser = new User();
        this.loggedInUser.setUserName("stefan-schmitz");
        this.loggedInUser.setFirstName("Stefan");
        this.loggedInUser.setLastName("Schmitz");
    }

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
