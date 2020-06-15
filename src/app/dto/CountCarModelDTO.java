package app.dto;

public class CountCarModelDTO {
    private String carModelTitle;
    private Integer value;

    public CountCarModelDTO(String carModelTitle, Integer value) {
        this.carModelTitle = carModelTitle;
        this.value = value;
    }

    public CountCarModelDTO() {

    }

    public String getCarModelTitle() {
        return carModelTitle;
    }

    public void setCarModelTitle(String carModelTitle) {
        this.carModelTitle = carModelTitle;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
