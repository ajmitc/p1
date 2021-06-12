package pandemic;

import pandemic.game.Disease;
import pandemic.game.Phase;
import pandemic.game.PhaseStep;
import pandemic.game.board.City;
import pandemic.game.board.CityConnection;
import pandemic.game.card.infection.InfectionCard;
import pandemic.game.card.player.PlayerCard;
import pandemic.game.card.player.PlayerCardType;
import pandemic.game.player.RoleType;
import pandemic.view.View;

public class Controller {
    private Model model;
    private View view;

    private int numActionsTaken;
    private int maxActions = 4;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void run(){
        while (model.getGame() != null && model.getGame().getPhase() != Phase.GAMEOVER){
            switch (model.getGame().getPhase()){
                case SETUP: {
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE: {
                            model.getGame().setPhaseStep(PhaseStep.SETUP_PLACE_INITIAL_DISEASES);
                            break;
                        }
                        case SETUP_PLACE_INITIAL_DISEASES: {
                            model.getGame().getInfectionCardDeck().shuffle();
                            // Draw 3 cities to get 3 cubes
                            for (int i = 0; i < 3; ++i){
                                InfectionCard card = model.getGame().getInfectionCardDeck().draw();
                                City city = model.getGame().getBoard().getCity(card.getCityName());
                                addDisease(card.getCityName().getDefaultDisease(), city);
                                addDisease(card.getCityName().getDefaultDisease(), city);
                                addDisease(card.getCityName().getDefaultDisease(), city);
                            }
                            // Draw 3 cities to get 2 cubes
                            for (int i = 0; i < 3; ++i){
                                InfectionCard card = model.getGame().getInfectionCardDeck().draw();
                                City city = model.getGame().getBoard().getCity(card.getCityName());
                                addDisease(card.getCityName().getDefaultDisease(), city);
                                addDisease(card.getCityName().getDefaultDisease(), city);
                            }
                            // Draw 3 cities to get 1 cubes
                            for (int i = 0; i < 3; ++i){
                                InfectionCard card = model.getGame().getInfectionCardDeck().draw();
                                addDisease(card.getCityName().getDefaultDisease(), model.getGame().getBoard().getCity(card.getCityName()));
                            }
                            model.getGame().setPhaseStep(PhaseStep.SETUP_CHOOSE_PLAYER_ROLES);
                            break;
                        }
                        case SETUP_CHOOSE_PLAYER_ROLES: {
                            model.getGame().setPhaseStep(PhaseStep.SETUP_CHOOSE_FUNDED_EVENTS);
                            break;
                        }
                        case SETUP_CHOOSE_FUNDED_EVENTS: {
                            model.getGame().setPhaseStep(PhaseStep.SETUP_BUILD_PLAYER_DECK);
                            break;
                        }
                        case SETUP_BUILD_PLAYER_DECK: {
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        }
                        case END_PHASE: {
                            model.getGame().setPhase(Phase.PLAY);
                            break;
                        }
                    }
                    break;
                }
                case PLAY: {
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE: {
                            numActionsTaken = 0;
                            maxActions = 4;
                            // If player role is Generalist, set maxActions = 5
                            if (model.getGame().getCurrentPlayer().getRole().getType() == RoleType.GENERALIST)
                                maxActions = 5;
                            model.getGame().setPhaseStep(PhaseStep.PLAY_TAKE_ACTIONS);
                            break;
                        }
                        case PLAY_TAKE_ACTIONS:{
                            if (numActionsTaken < maxActions)
                                return;
                            model.getGame().setPhaseStep(PhaseStep.PLAY_DRAW_PLAYER_CARDS);
                            break;
                        }
                        case PLAY_DRAW_PLAYER_CARDS:{
                            for (int i = 0; i < 2 && model.getGame().getPhase() != Phase.GAMEOVER; ++i) {
                                PlayerCard playerCard = model.getGame().getPlayerCardDeck().draw();
                                if (playerCard == null) {
                                    model.getGame().setPhase(Phase.GAMEOVER);
                                    break;
                                }

                                if (playerCard.getType() == PlayerCardType.EPIDEMIC) {
                                    model.getGame().setThreatLevel(model.getGame().getThreatLevel() + 1);
                                    InfectionCard infectionCard = model.getGame().getInfectionCardDeck().drawBottom();
                                    addDisease(infectionCard.getCityName().getDefaultDisease(), model.getGame().getBoard().getCity(infectionCard.getCityName()));
                                    if (model.getGame().getPhase() == Phase.GAMEOVER) break;
                                    addDisease(infectionCard.getCityName().getDefaultDisease(), model.getGame().getBoard().getCity(infectionCard.getCityName()));
                                    if (model.getGame().getPhase() == Phase.GAMEOVER) break;
                                    addDisease(infectionCard.getCityName().getDefaultDisease(), model.getGame().getBoard().getCity(infectionCard.getCityName()));
                                    if (model.getGame().getPhase() == Phase.GAMEOVER) break;
                                    model.getGame().getInfectionCardDeck().discard(infectionCard);
                                    model.getGame().getInfectionCardDeck().shuffleDiscardAndPutOnTopOfDeck();
                                }
                                else
                                    model.getGame().getCurrentPlayer().getCards().add(playerCard);

                            }

                            // Check hand limit
                            if (model.getGame().getCurrentPlayer().getCards().size() > model.getGame().getCurrentPlayer().getHandLimit()) {
                                model.getGame().setPhaseStep(PhaseStep.PLAY_DISCARD_TO_HAND_LIMIT);
                            } else
                                model.getGame().setPhaseStep(PhaseStep.PLAY_INFECT_CITIES);
                            break;
                        }
                        case PLAY_DISCARD_TO_HAND_LIMIT:{
                            // TODO Ask player to discard card
                            if (model.getGame().getCurrentPlayer().getCards().size() > model.getGame().getCurrentPlayer().getHandLimit()){
                                return;
                            }
                            model.getGame().setPhaseStep(PhaseStep.PLAY_INFECT_CITIES);
                            break;
                        }
                        case PLAY_INFECT_CITIES:{
                            int numInfectionCardsToDraw = model.getGame().getNumInfectionCardsToDraw();
                            for (int i = 0; i < numInfectionCardsToDraw; ++i) {
                                InfectionCard infectionCard = model.getGame().getInfectionCardDeck().draw();
                                model.getGame().getInfectionCardDeck().discard(infectionCard);
                                City city = model.getGame().getBoard().getCity(infectionCard.getCityName());
                                addDisease(infectionCard.getCityName().getDefaultDisease(), city);
                            }
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        }
                        case END_PHASE: {
                            model.getGame().setNextPlayer();
                            if (model.getGame().getPhase() != Phase.GAMEOVER)
                                model.getGame().setPhaseStep(PhaseStep.PLAY_TAKE_ACTIONS);
                            break;
                        }
                    }
                    break;
                }
                case GAMEOVER: {
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE: {
                            break;
                        }
                        case END_PHASE: {
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    private void addDisease(Disease disease, City city){
        if (city.getDiseaseCount(disease) == 3){
            // outbreak
            model.getGame().setNumOutbreaks(model.getGame().getNumOutbreaks() + 1);
            if (model.getGame().getNumOutbreaks() == 8){
                model.getGame().setPhase(Phase.GAMEOVER);
                return;
            }

            // Increase crises level
            if (city.getCrisesLevel() < 5)
                city.setCrisesLevel(city.getCrisesLevel() + 1);

            // Add disease to connecting cities
            for (City neighbor: model.getGame().getBoard().getConnectedCities(city.getName())){
                CityConnection connection = model.getGame().getBoard().getConnection(city.getName(), neighbor.getName());
                if (!connection.isRoadblock()) {
                    addDisease(disease, neighbor);
                    if (model.getGame().getPhase() == Phase.GAMEOVER)
                        return;
                }
            }
        }
        else
            city.addDisease(disease);
    }
}
