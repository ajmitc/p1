package pandemic.game.card.player;

import pandemic.game.CityName;

import java.awt.image.BufferedImage;

public class PlayerCard {
    private PlayerCardType type;
    // City Card city
    private CityName cityName;
    // Event name or "Epidemic"
    private String name;
    // Upgrade
    private PlayerCardUpgrade upgrade;

    private BufferedImage image;

    public PlayerCard(PlayerCardType type, CityName cityName, BufferedImage image){
        this.type = type;
        this.cityName = cityName;
        this.image = image;
    }

    public PlayerCard(PlayerCardType type, String name, BufferedImage image){
        this.type = type;
        this.name = name;
        this.image = image;
    }

    public PlayerCardType getType() {
        return type;
    }

    public CityName getCityName() {
        return cityName;
    }

    public void setCityName(CityName cityName) {
        this.cityName = cityName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public PlayerCardUpgrade getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(PlayerCardUpgrade upgrade) {
        this.upgrade = upgrade;
    }
}
