package ro.api.models;

public class DetailsModel {
    private float longitude;
    private float latitude;
    private int windProbability;
    private String whenToGo;

    public DetailsModel() {

    }

    public DetailsModel(float longitude, float latitude, int windProbability, String whenToGo) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.windProbability = windProbability;
        this.whenToGo = whenToGo;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getWindProbability() {
        return windProbability;
    }

    public void setWindProbability(int windProbability) {
        this.windProbability = windProbability;
    }

    public String getWhenToGo() {
        return whenToGo;
    }

    public void setWhenToGo(String whenToGo) {
        this.whenToGo = whenToGo;
    }
}
