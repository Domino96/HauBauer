package src.de.haubauer.db.entities;

import src.de.haubauer.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int personId;

    String title;
    String firstName;
    String lastName;
    String landline;
    String mobile;
    String email;
    Role role;
}