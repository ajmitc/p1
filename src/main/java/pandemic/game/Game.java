package pandemic.game;

import pandemic.game.board.Board;
import pandemic.game.card.Deck;
import pandemic.game.card.infection.InfectionCard;
import pandemic.game.card.player.PlayerCard;
import pandemic.game.card.player.PlayerCardType;
import pandemic.game.objective.Objective;
import pandemic.game.player.Player;
import pandemic.util.ImageUtil;
import pandemic.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Phase phase;
    private PhaseStep phaseStep;

    private Board board;
    private Month month = Month.JANUARY;
    private int monthAttempt = 1;
    private List<Objective> objectives = new ArrayList<>();
    private int threatLevel = 1;
    private int numOutbreaks = 0;
    private Deck<InfectionCard> infectionCardDeck = new Deck<>();
    private Deck<PlayerCard> playerCardDeck = new Deck<>();
    private int numEpidemics = 5;
    private List<Player> players = new ArrayList<>(4);
    private int currentPlayerIndex = 0;

    public Game(){
        phase = Phase.SETUP;
        phaseStep = PhaseStep.START_PHASE;

        board = new Board();

        for (CityName cityName: CityName.values()) {
            infectionCardDeck.add(new InfectionCard(cityName, ImageUtil.get(cityName.getInfectionCardImageFilename())));
            playerCardDeck.add(new PlayerCard(PlayerCardType.CITY, cityName, ImageUtil.get(cityName.getPlayerCardImageFilename())));
        }
    }

    public Phase getPhase() {
        return phase;
    }

    public PhaseStep getPhaseStep() {
        return phaseStep;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
        this.phaseStep = PhaseStep.START_PHASE;
    }

    public void setPhaseStep(PhaseStep phaseStep) {
        this.phaseStep = phaseStep;
    }

    /**
     * This should be called after players choose Funded Events and they are added to the player card deck, but
     * before Epidemic cards are added
     */
    public void setupDealPlayerCards(){
        playerCardDeck.shuffle();
        // 4 players
        int numCardsPerPlayer = 2;
        if (players.size() == 3)
            numCardsPerPlayer = 3;
        else if (players.size() == 2)
            numCardsPerPlayer = 4;

        for (Player player: players){
            player.getCards().add(playerCardDeck.draw());
        }
    }

    public void setupAddEpidemicCards(){
        int cardsInStack = playerCardDeck.getCards().size() / numEpidemics;
        // Work our way backward through deck so we don't mess up the math
        int endIndex = playerCardDeck.getCards().size();
        int startIndex = endIndex - cardsInStack;
        for (int i = 0; i < numEpidemics; ++i){
            PlayerCard card = new PlayerCard(PlayerCardType.EPIDEMIC, "Epidemic", ImageUtil.get("Epidemic.jpg"));
            int index = Util.getRandInt(startIndex, endIndex);
            playerCardDeck.getCards().add(index, card);
            endIndex = startIndex;
            startIndex -= cardsInStack;
        }
    }

    public Board getBoard() {
        return board;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getMonthAttempt() {
        return monthAttempt;
    }

    public void setMonthAttempt(int monthAttempt) {
        this.monthAttempt = monthAttempt;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public int getThreatLevel() {
        return threatLevel;
    }

    public void setThreatLevel(int threatLevel) {
        this.threatLevel = threatLevel;
    }

    public int getNumInfectionCardsToDraw(){
        if (threatLevel <= 3)
            return 2;
        if (threatLevel <= 5)
            return 3;
        return 4;
    }

    public int getNumOutbreaks() {
        return numOutbreaks;
    }

    public void setNumOutbreaks(int numOutbreaks) {
        this.numOutbreaks = numOutbreaks;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }

    public void setNextPlayer(){
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public Deck<InfectionCard> getInfectionCardDeck() {
        return infectionCardDeck;
    }

    public Deck<PlayerCard> getPlayerCardDeck() {
        return playerCardDeck;
    }
}
