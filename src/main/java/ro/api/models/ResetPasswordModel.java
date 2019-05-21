package ro.api.models;

public class ResetPasswordModel {
    private String password;
    private TokenAuthModel resetToken;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TokenAuthModel getResetToken() {
        return resetToken;
    }

    public void setResetToken(TokenAuthModel resetToken) {
        this.resetToken = resetToken;
    }
}
