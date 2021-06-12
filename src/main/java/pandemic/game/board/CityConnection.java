package pandemic.game.board;

import pandemic.game.CityName;

public class CityConnection {
    private CityName cityName1;
    private CityName cityName2;
    private boolean permanentRoadblock = false;
    private boolean roadblock = false;

    public CityConnection(CityName cityName1, CityName cityName2){
        this.cityName1 = cityName1;
        this.cityName2 = cityName2;
    }

    public CityName getCityName1() {
        return cityName1;
    }

    public CityName getCityName2() {
        return cityName2;
    }

    public boolean isPermanentRoadblock() {
        return permanentRoadblock;
    }

    public boolean isRoadblock() {
        return roadblock;
    }

    public void setCityName1(CityName cityName1) {
        this.cityName1 = cityName1;
    }

    public void setCityName2(CityName cityName2) {
        this.cityName2 = cityName2;
    }

    public boolean hasCity(CityName cityName){
        return cityName == cityName1 || cityName == cityName2;
    }

    public CityName getOtherCity(CityName cityName){
        return this.cityName1 == cityName? cityName2: cityName1;
    }
}
