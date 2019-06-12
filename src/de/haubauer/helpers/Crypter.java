package src.de.haubauer.helpers;

public class Crypter {


    public String EntCryption(String input)
    {
        String CryptedString = "";
        for (int i = 0; i < input.length(); i++){

            int toASCII = input.charAt(i);
            toASCII += 4;
            char toCHAR = (char)toASCII;
            CryptedString += toCHAR;
        }


        return CryptedString;
    }

    public String Decryption(String input)
    {
        String DecryptedString = "";
        for (int i = 0; i < input.length(); i++){

            int toASCII = input.charAt(i);
            toASCII -= 4;
            char toCHAR = (char)toASCII;
            DecryptedString += toCHAR;
        }


        return DecryptedString;
    }
}
