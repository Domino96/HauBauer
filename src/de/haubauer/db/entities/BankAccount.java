package src.de.haubauer.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "BankAccount")
public class BankAccount extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bankAccountid;

    String iban;
    String bic;
    String AccountOwner;
    String bank;
    @OneToOne
    Person person;
}



