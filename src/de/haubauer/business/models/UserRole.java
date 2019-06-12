package de.haubauer.business.models;

import de.haubauer.helpers.DatedObject;
import javafx.util.StringConverter;

import java.util.List;

public class UserRole extends DatedObject {
    private int id;

    private String name;
    private String description;
    private List<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String userRoleNameName) {
        this.name = userRoleNameName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> Users) {
        this.users = Users;
    }

    public static class StringConverter extends javafx.util.StringConverter<UserRole> {
        @Override
        public String toString(UserRole object) {
            return object.getName();
        }

        @Override
        public UserRole fromString(String string) {
            UserRole newUserRole = new UserRole();
            newUserRole.setName(string);
            return newUserRole;
        }
    }
}
