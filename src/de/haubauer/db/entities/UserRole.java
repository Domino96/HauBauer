package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "UserRole")
public class UserRole extends DatedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRoleId;

    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "userId")
    private List<User> users;

    public int getUserRoleId() {
        return userRoleId;
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