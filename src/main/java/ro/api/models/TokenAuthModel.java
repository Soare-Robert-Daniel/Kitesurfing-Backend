package ro.api.models;

public class TokenAuthModel {
    private String token;

    public TokenAuthModel() {
    }

    public TokenAuthModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
