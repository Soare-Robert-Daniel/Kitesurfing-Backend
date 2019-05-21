package ro.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.api.db.SpotsDB;
import ro.api.db.UserDB;
import ro.api.errors.ExceptionTemplate;
import ro.api.models.DetailsModel;
import ro.api.models.SpotsModel;
import ro.api.models.TokenAuthModel;
import ro.api.utilities.FilterTemplate;
import ro.api.utilities.FilterType;
import ro.api.utilities.InputValidator;
import ro.api.utilities.ResponseTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SpotsController {

    @RequestMapping(value = "/spots", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseTemplate> getAllSpots(@RequestBody TokenAuthModel token,
                                                        @RequestParam(value = "country", required = false, defaultValue = "") String country,
                                                        @RequestParam(value = "windProbability", required = false, defaultValue = "") String windProbability) {
        try {

            InputValidator.checkTokenFormat(token);

            if (!UserDB.isTokenValid(token)) {
                throw new ExceptionTemplate( "Invalid token!");
            }

            List<FilterTemplate> filters = new ArrayList<FilterTemplate>();

            if (!country.isEmpty()) {
                InputValidator.checkInputForCountry(country);
                filters.add(new FilterTemplate(FilterType.COUNTRY, country));
            }

            if (!windProbability.isEmpty()) {
                InputValidator.checkInputForWind(windProbability);
                filters.add(new FilterTemplate(FilterType.WIND_PROBABILITY, windProbability));
            }

            List<SpotsModel> spotsModelList = SpotsDB.getAllSpots(filters);

            if (spotsModelList.isEmpty()) {
                throw new ExceptionTemplate("The are no kitesurfing spots available!");
            }

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate(spotsModelList));

        } catch (Exception ex) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("failed", ex.getMessage()));
        }
    }

    @RequestMapping(value = "/spots/{spotId}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseTemplate> getDetailsForSpot(@PathVariable int spotId, @RequestBody TokenAuthModel token) {
        try {
            InputValidator.checkTokenFormat(token);
            if (!UserDB.isTokenValid(token)) {
                throw new ExceptionTemplate( "Invalid token!");
            }

            DetailsModel detailsModel = SpotsDB.getSpotById(spotId);

            if(detailsModel == null) {
                throw new ExceptionTemplate( "The 'id' of the spot does not exist!");
            }

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate(SpotsDB.getSpotById(spotId)));
        } catch (Exception ex) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("failed", ex.getMessage()));
        }
    }

    @RequestMapping(value = "/spots/countries", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseTemplate> getCountries(@RequestBody TokenAuthModel token) {
        try {
            InputValidator.checkTokenFormat(token);
            if (!UserDB.isTokenValid(token)) {
                throw new ExceptionTemplate( "Invalid token!");

            }

            List<String> countries = SpotsDB.getCountries();

            if (countries.isEmpty()) {
                throw new ExceptionTemplate("The are no countries available!");
            }

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate(countries));

        } catch (Exception ex) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("failed", ex.getMessage()));
        }
    }
}
