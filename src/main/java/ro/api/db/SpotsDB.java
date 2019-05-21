package ro.api.db;

import ro.api.errors.ExceptionTemplate;
import ro.api.models.DetailsModel;
import ro.api.models.SpotsModel;
import ro.api.utilities.FilterTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpotsDB {

    public static List<SpotsModel> getAllSpots(List<FilterTemplate> filters) throws ExceptionTemplate {


        List<SpotsModel> spotsModelList = new ArrayList<SpotsModel>();

        try {

            String default_query = "SELECT id, name, country FROM location_id";
            ResultSet resultSet;

            if (filters.isEmpty()) {
                resultSet = ConnectDB.executeQuery(
                        default_query
                );
            } else {
                resultSet = ConnectDB.executeQuery(
                        default_query + buildFilterQueryConditions(filters)
                );
            }
            while (resultSet.next()) {
                spotsModelList.add(new SpotsModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return spotsModelList;
    }

    public static String buildFilterQueryConditions(List<FilterTemplate> filters) {

        List<String> condition_list = new ArrayList<String>();

        for (FilterTemplate filter : filters) {
            switch (filter.getType()) {
                case COUNTRY:
                    condition_list.add(String.format("country = \"%s\"", (String) filter.getValue()));
                    break;
                case WIND_PROBABILITY:
                    condition_list.add(String.format("windProbability = %d", Integer.parseInt((String) filter.getValue())));
                    break;
            }
        }

        return String.format(" WHERE %s", String.join(" AND ", condition_list));
    }

    public static DetailsModel getSpotById(int id) {

        DetailsModel detailsModel = null;

        try {

            ResultSet resultSet = ConnectDB.executeQuery(
                    "SELECT longitude, latitude, windProbability, whenToGo FROM location_id WHERE id = ?",
                    id
            );

            if (resultSet.next()) {
                detailsModel = new DetailsModel(
                        resultSet.getFloat("longitude"),
                        resultSet.getFloat("latitude"),
                        resultSet.getInt("windProbability"),
                        resultSet.getString("whenToGo")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return detailsModel;
    }

    public static List<String> getCountries() throws ExceptionTemplate, IllegalArgumentException {

        List<String> countries = new ArrayList<String>();

        try {

            ResultSet resultSet = ConnectDB.executeQuery(
                    "SELECT DISTINCT country FROM location_id"
            );

            while (resultSet.next()) {
                countries.add(resultSet.getString("country"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return countries;
    }
}
