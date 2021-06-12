package pandemic.game.player;

import pandemic.game.card.player.PlayerCard;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Role role;
    private PlayerColor color;
    private List<PlayerCard> cards = new ArrayList<>();

    public Player(){

    }

    public Player(PlayerColor color){
        this.color = color;
    }

    public Player(PlayerColor color, Role role){
        this.color = color;
        this.role = role;
    }

    public int getHandLimit(){
        // TODO Check if upgrade to hold more cards
        return 7;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public PlayerColor getColor() {
        return color;
    }

    public void setColor(PlayerColor color) {
        this.color = color;
    }

    public List<PlayerCard> getCards() {
        return cards;
    }

    public void setCards(List<PlayerCard> cards) {
        this.cards = cards;
    }
}
