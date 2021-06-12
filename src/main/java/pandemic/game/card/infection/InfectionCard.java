package pandemic.game.card.infection;

import pandemic.game.CityName;

import java.awt.image.BufferedImage;

public class InfectionCard {
    private CityName cityName;
    private BufferedImage image;

    public InfectionCard(CityName cityName, BufferedImage image){
        this.cityName = cityName;
        this.image = image;
    }

    public CityName getCityName() {
        return cityName;
    }

    public BufferedImage getImage() {
        return image;
    }
}
