package pandemic.game.player;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private RoleType type;
    private String name;
    private List<Relationship> relationships = new ArrayList<>(2);
    private List<Upgrade> upgrades = new ArrayList<>(2);
    private List<Scar> scars = new ArrayList<>(2);

    // Is this role available for player's to choose?
    private boolean available = true;

    public Role(RoleType type){
        this.type = type;
    }

    public RoleType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    public List<Upgrade> getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(List<Upgrade> upgrades) {
        this.upgrades = upgrades;
    }

    public List<Scar> getScars() {
        return scars;
    }

    public void setScars(List<Scar> scars) {
        this.scars = scars;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
