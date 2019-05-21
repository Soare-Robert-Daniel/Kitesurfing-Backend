package ro.api.db;

import ro.api.errors.ExceptionTemplate;
import ro.api.models.TokenAuthModel;
import ro.api.utilities.Token;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {

    public static boolean isRegistered(String username, String password) {

        boolean isRegistered = false;

        try {

            ResultSet resultSet = ConnectDB.executeQuery(
                    "SELECT * FROM users WHERE EXISTS( SELECT 1 FROM users WHERE username = ? AND password = ? LIMIT 1)",
                    username,
                    password
            );

            if (resultSet.next()) {
                int result = resultSet.getInt(1);

                if (result > 0) {
                    isRegistered = true;
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return isRegistered;
    }

    public static boolean isTokenValid(TokenAuthModel token) {

        boolean isValid = false;

        try {
            ResultSet resultSet = ConnectDB.executeQuery(
                    "SELECT * FROM users WHERE EXISTS( SELECT 1 FROM users WHERE token = ? LIMIT 1)",
                    token.getToken()
            );

            if (resultSet.next()) {
                int result = resultSet.getInt(1);

                if (result > 0) {
                    isValid = true;
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return isValid;
    }

    public static void registerUser(String username, String password) throws ExceptionTemplate {

        try {
            ResultSet resultSet = ConnectDB.executeQuery(
                    "INSERT INTO users(username, password, token) VALUES (?, ?, ?)",
                    username,
                    password,
                    Token.generateToken()
            );
        } catch (Exception ex) {
            throw new ExceptionTemplate("User could not be registered");
        }
    }

    public static TokenAuthModel getUserToken(String username, String password) throws ExceptionTemplate {

        TokenAuthModel token = null;

        try {

            ResultSet resultSet = ConnectDB.executeQuery(
                    "SELECT token FROM users WHERE username = ? AND password = ?",
                    username,
                    password
            );

            if (resultSet.next()) {
                token = new TokenAuthModel(resultSet.getString("token"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (token == null) {
            throw new ExceptionTemplate("The user is unregistered!");
        }

        return token;

    }

    public static String getUsernameWithToken(TokenAuthModel token) {

        String username = "";

        try {

            ResultSet resultSet = ConnectDB.executeQuery(
                    "SELECT username FROM users WHERE token = ?",
                    token.getToken()
            );

            if (resultSet.next()) {
                username = resultSet.getString("username");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return username;
    }

    public static boolean checkIfUsernameIsTaken(String username) {
        boolean isTaken = false;

        try {

            ResultSet resultSet = ConnectDB.executeQuery(
                    "SELECT * FROM users WHERE EXISTS( SELECT 1 FROM users WHERE username = ? LIMIT 1)",
                    username
            );

            if (resultSet.next()) {
                int result = resultSet.getInt(1);

                if (result > 0) {
                    isTaken = true;
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return isTaken;
    }

    public static void signOut(TokenAuthModel token) {
        ResultSet resultSet = ConnectDB.executeQuery(
                "UPDATE users SET token = ? WHERE token = ?",
                Token.generateToken(),
                token.getToken()
        );
    }

    public static TokenAuthModel generateAndGetResetPasswordToken(String username) {
        TokenAuthModel resetToken = new TokenAuthModel(Token.generateToken());
        System.out.println(username);
        ResultSet resultSet = ConnectDB.executeQuery(
                "UPDATE users SET reset_password_token = ? WHERE username = ?",
                resetToken.getToken(),
                username
        );

        return resetToken;
    }

    public static void resetPasswordWithToken(TokenAuthModel resetToken, String newPassword) {

        ResultSet resultSet = ConnectDB.executeQuery(
                "UPDATE users SET password = ? WHERE reset_password_token = ?",
                newPassword,
                resetToken.getToken()
        );

        resultSet = ConnectDB.executeQuery(
                "UPDATE users SET reset_password_token = NULL WHERE reset_password_token = ?",
                resetToken.getToken()
        );
    }

    public static boolean isResetTokenValid(TokenAuthModel token) {

        boolean isValid = false;

        try {
            ResultSet resultSet = ConnectDB.executeQuery(
                    "SELECT * FROM users WHERE EXISTS( SELECT 1 FROM users WHERE reset_password_token = ? LIMIT 1)",
                    token.getToken()
            );

            if (resultSet.next()) {
                int result = resultSet.getInt(1);

                if (result > 0) {
                    isValid = true;
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return isValid;
    }
}
