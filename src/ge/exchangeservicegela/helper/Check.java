package ge.exchangeservicegela.helper;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by GIO on 6/10/2015.
 */
public class Check {
    public static boolean isValidEmail(String email) {
        if (email == null) return false;

        boolean result = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException ex) {
            result = false;
        }

        if(email.length() < "@freeuni.edu.ge".length()) result = false;
        else if(!email.substring(email.length() - "@freeuni.edu.ge".length()).equals("@freeuni.edu.ge") )
            result = false;

        return result;
    }
}
