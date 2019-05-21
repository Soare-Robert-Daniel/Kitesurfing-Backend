package ro.api.utilities;

public class ResponseTemplate {
    private Object response;
    private String status;
    private String message;

    public ResponseTemplate() {

    }

    public ResponseTemplate(Object response) {
        this.status = "success";
        this.response = response;
        this.message = "";
    }

    public ResponseTemplate(String status, String message) {
        this.status = status;
        this.response = null;
        this.message = message;
    }

    public ResponseTemplate(Object response, String status, String message) {
        this.response = response;
        this.status = status;
        this.message = message;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
