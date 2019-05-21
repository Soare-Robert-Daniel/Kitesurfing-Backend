package ro.api.utilities;


public class FilterTemplate {
    FilterType type;
    Object value;

    public FilterTemplate(FilterType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public FilterTemplate(FilterType type) {
        this.type = type;
    }

    public FilterType getType() {
        return type;
    }

    public void setType(FilterType type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
