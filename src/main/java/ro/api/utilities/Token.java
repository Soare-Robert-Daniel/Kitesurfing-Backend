package ro.api.utilities;

import java.util.UUID;

public class Token {

    public static String generateToken() {
        return UUID.randomUUID().toString();
    }
}
