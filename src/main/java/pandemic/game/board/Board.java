package pandemic.game.board;

import pandemic.game.CityName;
import pandemic.game.ResearchStation;

import java.util.*;
import java.util.stream.Collectors;

public class Board {
    private Map<CityName, City> cities = new HashMap<>();
    private List<CityConnection> connections = new ArrayList<>();

    public Board(){
        for (CityName cityName: CityName.values()){
            cities.put(cityName, new City(cityName));
        }

        // Set Connections
        addConnections(CityName.ALGIERS, CityName.MADRID, CityName.PARIS, CityName.ISTANBUL, CityName.CAIRO);
        addConnections(CityName.ATLANTA, CityName.WASHINGTON, CityName.MIAMI, CityName.CHICAGO);
        addConnections(CityName.BAGHDAD, CityName.ISTANBUL, CityName.TEHRAN, CityName.KARACHI, CityName.RIYADH, CityName.CAIRO);
        addConnections(CityName.BANGKOK, CityName.KOLKATA, CityName.HONG_KONG, CityName.HO_CHI_MINH_CITY, CityName.JAKARTA, CityName.CHENNAI);
        addConnections(CityName.BEIJING, CityName.SEOUL, CityName.SHANGHAI);
        addConnections(CityName.BOGATA, CityName.MIAMI, CityName.MEXICO_CITY, CityName.LIMA, CityName.BUENOS_AIRES, CityName.SAO_PAULO);
        addConnections(CityName.BUENOS_AIRES, CityName.BOGATA, CityName.SAO_PAULO);
        addConnections(CityName.CAIRO, CityName.ALGIERS, CityName.ISTANBUL, CityName.BAGHDAD, CityName.RIYADH, CityName.KHARTOUM);
        addConnections(CityName.CHENNAI, CityName.MUMBAI, CityName.DELHI, CityName.KOLKATA, CityName.BANGKOK, CityName.JAKARTA);
        addConnections(CityName.CHICAGO, CityName.SAN_FRANCISCO, CityName.LOS_ANGELES, CityName.MEXICO_CITY, CityName.ATLANTA, CityName.MONTREAL);
        addConnections(CityName.DELHI, CityName.TEHRAN, CityName.KARACHI, CityName.MUMBAI, CityName.CHENNAI, CityName.KOLKATA);
        addConnections(CityName.ESSEN, CityName.LONDON, CityName.PARIS, CityName.MILAN, CityName.ST_PETERSBURG);
        addConnections(CityName.HO_CHI_MINH_CITY, CityName.JAKARTA, CityName.BANGKOK, CityName.HONG_KONG, CityName.MANILA);
        addConnections(CityName.HONG_KONG, CityName.SHANGHAI, CityName.TAIPEI, CityName.MANILA, CityName.HO_CHI_MINH_CITY, CityName.BANGKOK, CityName.KOLKATA);
        addConnections(CityName.ISTANBUL, CityName.MOSCOW, CityName.BAGHDAD, CityName.CAIRO, CityName.ALGIERS, CityName.MILAN, CityName.ST_PETERSBURG);
        addConnections(CityName.JAKARTA, CityName.CHENNAI, CityName.BANGKOK, CityName.HO_CHI_MINH_CITY, CityName.SYDNEY);
        addConnections(CityName.JOHANNESBURG, CityName.KINSASHA, CityName.KHARTOUM);
        addConnections(CityName.KARACHI, CityName.RIYADH, CityName.BAGHDAD, CityName.TEHRAN, CityName.DELHI, CityName.MUMBAI);
        addConnections(CityName.KHARTOUM, CityName.CAIRO, CityName.LAGOS, CityName.KINSASHA, CityName.JOHANNESBURG);
        addConnections(CityName.KINSASHA, CityName.KHARTOUM, CityName.LAGOS, CityName.JOHANNESBURG);
        addConnections(CityName.KOLKATA, CityName.DELHI, CityName.CHENNAI, CityName.BANGKOK, CityName.HONG_KONG);
        addConnections(CityName.LAGOS, CityName.KHARTOUM, CityName.KINSASHA, CityName.SAO_PAULO);
        addConnections(CityName.LIMA, CityName.MEXICO_CITY, CityName.BOGATA, CityName.SANTIAGO);
        addConnections(CityName.LONDON, CityName.NEW_YORK, CityName.MADRID, CityName.PARIS, CityName.ESSEN);
        addConnections(CityName.LOS_ANGELES, CityName.SAN_FRANCISCO, CityName.CHICAGO, CityName.MEXICO_CITY, CityName.SYDNEY);
        addConnections(CityName.MADRID, CityName.SAO_PAULO, CityName.NEW_YORK, CityName.LONDON, CityName.PARIS, CityName.ALGIERS);
        addConnections(CityName.MANILA, CityName.TAIPEI, CityName.HONG_KONG, CityName.HO_CHI_MINH_CITY, CityName.SYDNEY);
        addConnections(CityName.MEXICO_CITY, CityName.LOS_ANGELES, CityName.CHICAGO, CityName.MIAMI, CityName.BOGATA, CityName.LIMA);
        addConnections(CityName.MIAMI, CityName.WASHINGTON, CityName.ATLANTA, CityName.MEXICO_CITY, CityName.BOGATA);
        addConnections(CityName.MILAN, CityName.ESSEN, CityName.PARIS, CityName.ISTANBUL);
        addConnections(CityName.MONTREAL, CityName.CHICAGO, CityName.WASHINGTON, CityName.NEW_YORK);
        addConnections(CityName.MOSCOW, CityName.ST_PETERSBURG, CityName.ISTANBUL, CityName.TEHRAN);
        addConnections(CityName.MUMBAI, CityName.KARACHI, CityName.DELHI, CityName.CHENNAI);
        addConnections(CityName.NEW_YORK, CityName.WASHINGTON, CityName.MONTREAL, CityName.LONDON, CityName.MADRID);
        addConnections(CityName.OSAKA, CityName.TOKYO, CityName.TAIPEI);
        addConnections(CityName.PARIS, CityName.ALGIERS, CityName.MADRID, CityName.LONDON, CityName.ESSEN, CityName.MILAN);
        addConnections(CityName.RIYADH, CityName.CAIRO, CityName.BAGHDAD, CityName.KARACHI);
        addConnections(CityName.SAN_FRANCISCO, CityName.CHICAGO, CityName.LOS_ANGELES, CityName.TOKYO, CityName.MANILA);
        addConnections(CityName.SANTIAGO, CityName.LIMA);
        addConnections(CityName.SAO_PAULO, CityName.BUENOS_AIRES, CityName.BOGATA, CityName.MADRID, CityName.LAGOS);
        addConnections(CityName.SEOUL, CityName.BEIJING, CityName.SHANGHAI, CityName.TOKYO);
        addConnections(CityName.SHANGHAI, CityName.BEIJING, CityName.SEOUL, CityName.TOKYO, CityName.TAIPEI, CityName.HONG_KONG);
        addConnections(CityName.ST_PETERSBURG, CityName.ESSEN, CityName.MOSCOW);
        addConnections(CityName.SYDNEY, CityName.JAKARTA, CityName.MANILA, CityName.LOS_ANGELES);
        addConnections(CityName.TAIPEI, CityName.MANILA, CityName.HONG_KONG, CityName.SHANGHAI, CityName.OSAKA);
        addConnections(CityName.TEHRAN, CityName.MOSCOW, CityName.BAGHDAD, CityName.KARACHI, CityName.DELHI);
        addConnections(CityName.TOKYO, CityName.SEOUL, CityName.SHANGHAI, CityName.OSAKA, CityName.SAN_FRANCISCO);
        addConnections(CityName.WASHINGTON, CityName.NEW_YORK, CityName.ATLANTA, CityName.MONTREAL, CityName.MIAMI);

        cities.get(CityName.ATLANTA).setResearchStation(ResearchStation.RESEARCH_STATION);
    }

    private void addConnections(CityName from, CityName ... connections){
        for (CityName connection: connections){
            if (getConnection(from, connection) == null)
                this.connections.add(new CityConnection(from, connection));
        }
    }

    public City getCity(CityName name) {
        return cities.get(name);
    }

    public Collection<City> getCities(){
        return cities.values();
    }

    public CityConnection getConnection(CityName city1, CityName city2){
        for (CityConnection connection: connections){
            if (connection.hasCity(city1) && connection.hasCity(city2))
                return connection;
        }
        return null;
    }

    public boolean hasConnection(CityName city1, CityName city2){
        return getConnection(city1, city2) != null;
    }

    public Set<CityName> getConnectedCityNames(CityName city){
        return connections.stream().filter(connection -> connection.hasCity(city)).map(connection -> connection.getOtherCity(city)).collect(Collectors.toSet());
    }

    public Set<City> getConnectedCities(CityName city){
        Set<CityName> names = getConnectedCityNames(city);
        return getCities().stream().filter(c -> names.contains(c.getName())).collect(Collectors.toSet());
    }
}
