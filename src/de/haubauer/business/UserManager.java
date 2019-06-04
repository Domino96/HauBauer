package src.de.haubauer.business;

import src.de.haubauer.db.entities.User;

public class UserManager extends Singleton {
    private User loggedInUser;

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
