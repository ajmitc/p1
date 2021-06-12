package pandemic.game.card.player;

public class PlayerCardUpgrade {
    private PlayerCardUpgradeType type;

    public PlayerCardUpgrade(PlayerCardUpgradeType type){
        this.type = type;
    }

    public PlayerCardUpgradeType getType() {
        return type;
    }
}
