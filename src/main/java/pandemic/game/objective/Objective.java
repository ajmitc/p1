package pandemic.game.objective;

import java.awt.image.BufferedImage;

public class Objective {
    private String name;
    private BufferedImage image;
    private boolean completed = false;
    private int stars = 1;
    private boolean mandatory = false;

    public Objective(String name, BufferedImage image){
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
}
