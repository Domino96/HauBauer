package src.de.haubauer.db.entities;

import javax.persistence.*;
@Entity
@Table(name = "User")
public class User extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    String userName;
    String hash;
    String fistName;
    String lastName;
    String phone;
    String email;
}
