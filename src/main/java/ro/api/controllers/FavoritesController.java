package ro.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.api.db.FavoritesDB;
import ro.api.db.UserDB;
import ro.api.errors.ExceptionTemplate;
import ro.api.models.TokenAuthModel;
import ro.api.utilities.InputValidator;
import ro.api.utilities.ResponseTemplate;

@RestController
@RequestMapping("/api/favorites/spots")
public class FavoritesController {

    @RequestMapping(value = "/add/{spotId}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseTemplate> addSpotToFavorite(@PathVariable int spotId, @RequestBody TokenAuthModel token) {
        try {
            checker(spotId, token);

            FavoritesDB.addSpotToFavorite(UserDB.getUsernameWithToken(token), spotId);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new ResponseTemplate("success", "The spot has been added!"));

        } catch (ExceptionTemplate ex) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new ResponseTemplate("failed", ex.getMessage()));
        }
    }

    @RequestMapping(value = "/delete/{spotId}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseTemplate> deleteSpotFromFavorite(@PathVariable int spotId, @RequestBody TokenAuthModel token) {
        try {
            checker(spotId, token);

            FavoritesDB.deleteSpotFromFavorite(UserDB.getUsernameWithToken(token), spotId);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new ResponseTemplate("success", "The spot has been deleted!"));

        } catch (ExceptionTemplate ex) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new ResponseTemplate("failed", ex.getMessage()));
        }
    }

    private void checker(int spotId, TokenAuthModel token) throws ExceptionTemplate {
        InputValidator.checkTokenFormat(token);

        if (UserDB.isTokenValid(token)) {
            if (!FavoritesDB.checkIfSpotExist(spotId)) {
                throw new ExceptionTemplate("The spot does not exists!");
            }

            String username = UserDB.getUsernameWithToken(token);
            if(username.isEmpty()) {
                throw new ExceptionTemplate("The token is not bound by a username!");
            }
        } else {
           throw new ExceptionTemplate("Invalid token!");
        }
    }
}
