package de.haubauer.business.models;

import de.haubauer.helpers.DatedObject;

import java.util.List;

public class UserRole extends DatedObject {
    private int id;

    private String name;
    private String description;
    private List<User> users;

    public int getId() {
        return id;
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
}
