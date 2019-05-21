package ro.api.db;

import ro.api.errors.ExceptionTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoritesDB {

    public static void addSpotToFavorite(String username, int spotId) throws ExceptionTemplate, IllegalArgumentException {

        ResultSet resultSet = ConnectDB.executeQuery(
                "INSERT INTO favorites(username, spotId) VALUES (?, ?)",
                username,
                spotId
        );
    }

    public static void deleteSpotFromFavorite(String username, int spotId) throws ExceptionTemplate, IllegalArgumentException {

        ResultSet resultSet = ConnectDB.executeQuery(
                "DELETE FROM favorites WHERE username = ? AND spotId = ?",
                username,
                spotId
        );
    }

    public static boolean checkIfSpotExist(int spotId) throws ExceptionTemplate {
        boolean isValid = false;

        try {
            ResultSet resultSet = ConnectDB.executeQuery(
                    "SELECT * FROM location_id WHERE EXISTS( SELECT 1 FROM location_id WHERE id = ? LIMIT 1)",
                    spotId
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
