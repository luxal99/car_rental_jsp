package app.dto;

public class MostReservedVehicleDTO {
    private String carBrandTitle;
    private String carModelTitle;
    private Integer amount;
    private String image;

    public MostReservedVehicleDTO() {
    }

    public String getCarBrandTitle() {
        return carBrandTitle;
    }

    public void setCarBrandTitle(String carBrandTitle) {
        this.carBrandTitle = carBrandTitle;
    }

    public String getCarModelTitle() {
        return carModelTitle;
    }

    public void setCarModelTitle(String carModelTitle) {
        this.carModelTitle = carModelTitle;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
