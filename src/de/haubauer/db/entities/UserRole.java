package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "UserRole")
public class UserRole extends DatedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userRoleId;

    String userRoleName;
    String userRoleDescription;
    @OneToMany
    @JoinColumn(name = "userId")
    List<User> Users;

    public int getUserRoleId() {
        return userRoleId;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleNameName) {
        this.userRoleName = userRoleName;
    }

    public String getUserRoleDescription() {
        return userRoleDescription;
    }

    public void setUserRoleDescription(String userRoleDescription) {
        this.userRoleDescription = userRoleDescription;
    }

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> Users) {
        this.Users = Users;
    }
}