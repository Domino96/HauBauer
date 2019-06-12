package de.haubauer.db;

import de.haubauer.db.entities.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestDataGenerator {
    private Random randomGenerator = new Random();

    //User generierung
    private ArrayList<String> hash = new ArrayList<>();
    private ArrayList<String> UserName = new ArrayList<>();

    //Address generierung
    private ArrayList<String> street = new ArrayList<String>(Arrays.asList("Koenigstrasse","Ollenhauer Str.","Brandenburgische Strasse","Eichendorffstr.","Luebeckertordamm"));
    private ArrayList<String> zipCode = new ArrayList<String>(Arrays.asList("07641","70176","76889","78567","92262"));
    private ArrayList<String> town = new ArrayList<String>(Arrays.asList("Stadtroda","Stuttgart Mitte","Gleiszellen-Gleishorbach","Fridingen","Birgland"));

    //Mietobjekt generierung
    private ArrayList<String> usageType = new ArrayList<>(Arrays.asList("Wohnung","Haus","Garagenplatz","Parkplatz"));
    private ArrayList<String> objectType = new ArrayList<>(Arrays.asList("Privat","Gewerblich"));
    private String description = "Das hier ist eine beschreibung zu diesem Mietobjekt";
    private String note = "Dies ist eine Notiz von einem User";

    //Personen generierung
    private ArrayList<String> firstName = new ArrayList<String>(Arrays.asList("Günther","Lara","Paul","Marie","Egon","Hans","Manfred","Lukas","Phillip","Laura"));
    private ArrayList<String> lastName = new ArrayList<String>(Arrays.asList("Schmitz","Müller","Fischer","Küster","Engels","Ranz","Weber","Lenk"));
    private ArrayList<String> title = new ArrayList<String>(Arrays.asList("Dr.", "Herr", "Frau", "Prof"));
    private ArrayList<String> email = new ArrayList<String>(Arrays.asList("ErikRitter@cuvox.de","DoreenEiffel@einrot.com","BrigitteWerner@einrot.com","VanessaBieber@cuvox.de"));
    private ArrayList<String> phone = new ArrayList<String>(Arrays.asList("036426 11 33","0711 36 03 28","06343 57 82 27","07463 47 64 09"));

    //Konto generierung
    private ArrayList<String> bic = new ArrayList<String>(Arrays.asList("BELADEBEXXX","NOLADE21WIS","DEUTDEBBXXX","INGDDEFFXXX"));
    private ArrayList<String> bank = new ArrayList<>(Arrays.asList("Sparkasse Berlin","ING-DiBa","Deutsche Bank Berlin"));

    private ArrayList<RentalProperty> rentalProperties = new ArrayList<>();
    private ArrayList<Person> people = new ArrayList<>();
    private ArrayList<Tenancy> tenancies = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    private ArrayList<Payment> payments = new ArrayList<>();
    private ArrayList<Address> addresses = new ArrayList<>();

    //Mietverhältnis generierung

    //Zahlungseingänge generieren
    private String comment = "Dies ist ein Kommentar zu einem Zahlungseingang";


    /**
     * Erstellt eine angegebene Anzahl von Mietobjekten
     * @param iterations Die Anzahl der Mietobjekte
     * @return List of Rentalproperties
     */
    public List<RentalProperty> generateRental(int iterations){
    for(int i = 0;i < iterations; i++) {
        RentalType rentalType = new RentalType();
        UsageType usageType = new UsageType();
        RentalProperty rentalProperty = new RentalProperty();

        rentalType.setName(this.objectType.get(randomGenerator.nextInt(this.objectType.size())));
        usageType.setName(this.usageType.get(randomGenerator.nextInt(this.usageType.size())));

        rentalProperty.setSideCostsMonth(BigDecimal.valueOf(randomGenerator.nextInt(500) + randomGenerator.nextDouble()));
        rentalProperty.setSquareMeterPriceCold(BigDecimal.valueOf(randomGenerator.nextInt(10)));
        rentalProperty.setArea(randomGenerator.nextInt(150) + randomGenerator.nextDouble());
        rentalProperty.setUsageType(usageType);
        rentalProperty.setRentalType(rentalType);
        rentalProperty.setAddress(this.generateAddress(1).get(0));
        rentalProperty.setDescription(this.description);
        rentalProperty.setNote(this.note);
        rentalProperty.setFloor(randomGenerator.nextInt(3));

        rentalProperties.add(rentalProperty);

    }
    return rentalProperties;
    };

    public ArrayList<Person> generatePerson(int iterations, UserRole role){
        for (int i=0;i<iterations;i++){
            Person person = new Person();

            person.setTitle(this.title.get(randomGenerator.nextInt(this.title.size())));
            person.setAddresses(generateAddress(1));
            person.setEmail(this.email.get(randomGenerator.nextInt(this.email.size())));
            person.setFirstName(this.firstName.get(randomGenerator.nextInt(this.firstName.size())));
            person.setLastName(this.lastName.get(randomGenerator.nextInt(this.lastName.size())));
            person.setLandline(this.phone.get(randomGenerator.nextInt(this.phone.size())));
            person.setMobile(this.phone.get(randomGenerator.nextInt(this.phone.size())));
            person.setBankAccount(generateBankAccount(1).get(0));
            person.setRole(role);

            people.add(person);
        }
        return people;
    }


    public List<User> generateUser(int interations){
        for (int i=0;i<interations;i++) {
            User user = new User();

            user.setEmail(this.email.get(randomGenerator.nextInt(this.email.size())));
            user.setFirstName(this.firstName.get(randomGenerator.nextInt(this.firstName.size())));
            user.setLastName(this.lastName.get(randomGenerator.nextInt(this.lastName.size())));
            user.setEmail(this.email.get(randomGenerator.nextInt(this.email.size())));
            user.setPhone(this.phone.get(randomGenerator.nextInt(this.phone.size())));
            user.setUserName(user.getFirstName().substring(0,1) + "_" + user.getLastName());
            user.setHash("erstmal irgendwas zum testen");

            users.add(user);
        }
        return users;
    }

    /**
     * Erstellt eine Anzahl von Bankkonten
     * @param interations
     * @return
     */
    public List<BankAccount> generateBankAccount(int interations){
        for (int i = 0; i < interations;i++){
            BankAccount bankAccount = new BankAccount();

            bankAccount.setAccountOwner(this.firstName.get(randomGenerator.nextInt(this.firstName.size()))+" "+this.lastName.get(randomGenerator.nextInt(this.lastName.size())));
            bankAccount.setIban(generateIban());
            bankAccount.setBic(this.bic.get(randomGenerator.nextInt(this.bic.size())));
            bankAccount.setBank(this.bank.get(randomGenerator.nextInt(this.bank.size())));

            bankAccounts.add(bankAccount);
        }
        return bankAccounts;
    }

    public List<Tenancy> generateTenancy(int interations){
        for (int i=0;i<interations;i++){
            Tenancy tenancy = new Tenancy();

            tenancy.setPerson(this.getRandomListValue(this.people));
            tenancy.setRentalProperty(this.getRandomListValue(this.rentalProperties));
            tenancy.setEndDate(java.sql.Date.valueOf(createRandomDate(2000,2030)));
            tenancy.setStatus(tenancy.getEndDate().before(new Date(System.currentTimeMillis()))? 1 : 2);
            //tenancy.setStartDate(new Date(ThreadLocalRandom.current().nextLong(createRandomDate(2000,2030).getLong(),tenancy.getEndDate())));

            tenancies.add(tenancy);
        }
        return tenancies;
    }

    public List<Payment> generatePayment(int iterations){
        System.out.println("RentalPropertyId: " + this.tenancies.get(0).getRentalProperty().getRentalPropertyId());
        for (int i=0;i<iterations;i++){
            Payment payment = new Payment();

            BigDecimal billed = BigDecimal.valueOf(ThreadLocalRandom.current().nextLong(2000));
            BigDecimal value = BigDecimal.valueOf(ThreadLocalRandom.current().nextLong(billed.longValue()));

            payment.setDate(java.sql.Date.valueOf(createRandomDate(2000,2020)));
            payment.setComment(this.comment);
            payment.setBilled(billed);
            payment.setValue(value);

            if (iterations < 30) {
                payment.setTenancy(this.tenancies.get(0));
            } else {
                payment.setTenancy(this.getRandomListValue(this.tenancies));
            }

            payments.add(payment);
        }
        return payments;
    }

    /**
     * Erstellt eine Anzahl an Adressen
     * @param interations Anzahl der zuerstellden Adressen
     * @return Liste von Adressen
     */
    public List<Address> generateAddress(int interations){
        for (int i=0;i<interations;i++) {
            Address address = new Address();

            address.setStreet(this.street.get(randomGenerator.nextInt(this.street.size())));
            address.setNumber(randomGenerator.nextInt(100));
            address.setZipCode(Integer.valueOf(this.zipCode.get(randomGenerator.nextInt(this.zipCode.size()))));
            address.setTown(this.town.get(randomGenerator.nextInt(this.town.size())));

            addresses.add(address);
        }
        return addresses;
    }

    /**
     * Erstellt eine IBAN-Nummer
     * @return
     */
    private String generateIban(){
        String iban = "DE";
        int number = 0;

        for(int stelle = 0;stelle < 20; stelle++){
            number = randomGenerator.nextInt(9);
            iban += number;
        }
        return iban + number;
    }

    private void stellplatz(){


    }

    /**
     * Erstellt einen Integer zwischen zwei Werten
     * @param start
     * @param end
     * @return
     */
    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    /**
     * Erstellt eine zufälliges Datum zwischen den angegebenen Jahren
     * @param startYear
     * @param endYear
     * @return
     */
    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
    
    private <T> T getRandomListValue(List<T> list) {
        return list.get(this.randomGenerator.nextInt(list.size()));
    }

}
