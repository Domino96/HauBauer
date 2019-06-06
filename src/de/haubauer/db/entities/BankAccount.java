package src.de.haubauer.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "BankAccount")
public class BankAccount extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankAccountId;

    private String iban;
    private String bic;
    private String owner;
    private String bank;
    @OneToOne
    @JoinColumn(name = "personId")
    private Person person;
}



