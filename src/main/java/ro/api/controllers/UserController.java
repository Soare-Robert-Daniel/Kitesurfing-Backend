package ro.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.api.db.UserDB;
import ro.api.models.ForgotPasswordModel;
import ro.api.models.ResetPasswordModel;
import ro.api.models.TokenAuthModel;
import ro.api.models.UserModel;
import ro.api.utilities.InputValidator;
import ro.api.utilities.ResponseTemplate;

@RestController
@RequestMapping("/api")
public class UserController {

    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseTemplate> signUp(@RequestBody UserModel user) {
        try {

            InputValidator.checkInputForUser(user);

            if (!UserDB.checkIfUsernameIsTaken(user.getUsername())) {
                UserDB.registerUser(user.getUsername(), user.getPassword());
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("success", "User has been registered!"));
            } else {
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("failed", "Username already exists!"));
            }
        } catch (Exception ex) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("failed", ex.getMessage()));
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseTemplate> login(@RequestBody UserModel user) {
        try {

            InputValidator.checkInputForUser(user);

            TokenAuthModel token = UserDB.getUserToken(user.getUsername(), user.getPassword());

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate(token));
        } catch (Exception ex) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("failed", ex.getMessage()));
        }
    }

    @RequestMapping(value = "/signout", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseTemplate> signOut(@RequestBody TokenAuthModel token) {
        try {

            InputValidator.checkTokenFormat(token);

            if (!UserDB.isTokenValid(token)) {
                new ResponseTemplate("failed", "Invalid token!");
            }

            UserDB.signOut(token);

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("success", "The token has been changed!"));
        } catch (Exception ex) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("failed", ex.getMessage()));
        }
    }

    @RequestMapping(value = "/users/me/forgot-password", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseTemplate> forgotPassword(@RequestBody ForgotPasswordModel forgotPasswordModel) {
        try {

            InputValidator.checkInputForUsernameOrPassword(forgotPasswordModel.getUsername());

            if (!UserDB.checkIfUsernameIsTaken(forgotPasswordModel.getUsername())) {
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new ResponseTemplate("failed", "Invalid user!"));
            }

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate(UserDB.generateAndGetResetPasswordToken(forgotPasswordModel.getUsername())));
        } catch (Exception ex) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("failed", ex.getMessage()));
        }
    }

    @RequestMapping(value = "/users/me/reset-password", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseTemplate> resetPassword(@RequestBody ResetPasswordModel passwordTemplate) {
        System.out.println(passwordTemplate.getResetToken());
        try {

            InputValidator.checkInputForUsernameOrPassword(passwordTemplate.getPassword());
            InputValidator.checkTokenFormat(passwordTemplate.getResetToken());

            if (!UserDB.isResetTokenValid(passwordTemplate.getResetToken())) {
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("failed", "Invalid user!"));
            }

            UserDB.resetPasswordWithToken(passwordTemplate.getResetToken(), passwordTemplate.getPassword());

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("success", "Password has been changed!"));
        } catch (Exception ex) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body( new ResponseTemplate("failed", ex.getMessage()));
        }
    }
}
