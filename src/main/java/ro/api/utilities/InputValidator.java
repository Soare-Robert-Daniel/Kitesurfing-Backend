package ro.api.utilities;

import org.springframework.util.StringUtils;
import ro.api.errors.ExceptionTemplate;
import ro.api.models.TokenAuthModel;
import ro.api.models.UserModel;

public class InputValidator {
    public static void checkInputForUser(UserModel user) throws ExceptionTemplate {
        if (user == null) {
            throw new ExceptionTemplate("Invalid format!");
        }

        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            throw new ExceptionTemplate("Username or/and Password field are empty or not exists!");
        }

        checkInputForUsernameOrPassword(user.getUsername());
        checkInputForUsernameOrPassword(user.getPassword());
    }

    public static void checkInputForUsernameOrPassword(String value) throws ExceptionTemplate{

        if(value == null) {
            throw new ExceptionTemplate("There is no 'username/password' field!");
        }

        if (!value.matches("[a-zA-Z0-9]+")) {
            throw new ExceptionTemplate("Invalid format for username/password field");
        }
    }

    public static void checkInputForCountry(String country) throws ExceptionTemplate {
        if (!country.matches("[a-zA-Z]+")) {
            throw new ExceptionTemplate("Invalid format for 'country' param");
        }
    }

    public static void checkInputForWind(String windProbability) throws ExceptionTemplate {

        int valueWindProbability = -1;

        try {
            valueWindProbability = Integer.parseInt(windProbability);
        } catch (NumberFormatException ex) {
            throw new ExceptionTemplate("windProbability invalid format! It must be an integer with value from 0 to 100");
        }
        if (valueWindProbability < 0 || valueWindProbability > 100) {
            throw new ExceptionTemplate("windProbability must be an integer with value from 0 to 100");
        }

    }

    public static void checkTokenFormat(TokenAuthModel token) throws ExceptionTemplate {

        if(token == null) {
            throw new ExceptionTemplate("There is no 'token' field!");
        }

        if (token.getToken().isEmpty()) {
            throw new ExceptionTemplate("Token field is empty!");
        }

        if (token.getToken().length() != 12 || StringUtils.countOccurrencesOf(token.getToken(), "-") != 4) {
            throw new ExceptionTemplate("Invalid token format!");
        }


    }
}
