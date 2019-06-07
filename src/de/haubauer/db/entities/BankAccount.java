package de.haubauer.db.entities;

import de.haubauer.helpers.DatedObject;

import javax.persistence.*;

@Entity
@Table(name = "BankAccount")
public class BankAccount extends DatedObject {
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

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getAccountOwner() {
        return owner;
    }

    public void setAccountOwner(String accountOwner) {
        owner = accountOwner;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}



