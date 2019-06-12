package src.de.haubauer.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import src.de.haubauer.db.BaseDao;
import src.de.haubauer.db.entities.Tenancy;
import src.de.haubauer.db.entities.User;
import src.de.haubauer.helpers.Crypter;
import src.de.haubauer.helpers.DESEncrypter;

import java.util.List;

public class LoginController {

    @FXML
    private Label benutzername = new Label();
    @FXML
    private PasswordField passwort = new PasswordField();

    BaseDao dao = new BaseDao<>(User.class);


    BaseDao tenancyDao = new BaseDao<>(Tenancy.class);

    public boolean ExistsInDataBase(String name)
    {
        return !dao.queryBuilder().where("userName", "= :placeholderName")
                .setParameter("placeholderName", name)
                .build()
                .list().isEmpty();

    }

    public boolean DoesPasswordExistsInDataBase(String name)
    {
        return !dao.queryBuilder().where("hash", "= :placeholderName")
                .setParameter("placeholderName", name)
                .build()
                .list().isEmpty();
    }

    public void onEinloggenClicked(ActionEvent actionEvent) {

        String name = benutzername.getText();
        String strPasswort = passwort.getText();


        Crypter crypter = new Crypter();
        strPasswort = crypter.EntCryption(strPasswort);




        if(ExistsInDataBase(name) && DoesPasswordExistsInDataBase(strPasswort)){

        }
        else{

        }

    }
}
