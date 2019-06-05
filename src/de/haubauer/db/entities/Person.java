package src.de.haubauer.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int personId;

    String title;
    String fistName;
    String lastName;
    String telefon;
    String phone;
    String email;
    String role;
}