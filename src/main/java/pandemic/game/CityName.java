package pandemic.game;

public enum CityName {
    ALGIERS("Algiers", Disease.BLACK, "Card Black Algiers.jpg", "Infection Black Algiers.jpg"),
    ATLANTA("Atlanta", Disease.BLUE, "Card Black Algiers.jpg", "Infection Blue Atlanta.jpg"),
    BAGHDAD("Baghdad", Disease.BLACK, "Card Black Algiers.jpg", "Infection Black Baghdad.jpg"),
    BANGKOK("Bangkok", Disease.RED, "Card Red Bangkok.jpg", "Infection Red Bangkok.jpg"),
    BEIJING("Beijing", Disease.RED, "Card Red Beijing.jpg", "Infection Red Beijing.jpg"),
    BOGATA("Bogata", Disease.YELLOW, "Card Yellow Bogata.jpg", "Infection Yellow Bogata.jpg"),
    BUENOS_AIRES("Buenos Aires", Disease.YELLOW, "Card Yellow Buenos Aires.jpg", "Infection Yellow Buenos Aires.jpg"),
    CAIRO("Cairo", Disease.BLACK, "Card Black Cairo.jpg", "Infection Black Cairo.jpg"),
    CHENNAI("Chennai", Disease.BLACK, "Card Black Chennai.jpg", "Infection Black Chennai.jpg"),
    CHICAGO("Chicago", Disease.BLUE, "Card Blue Chicago.jpg", "Infection Blue Chicago.jpg"),
    DELHI("Delhi", Disease.BLACK, "Card Black Delhi.jpg", "Infection Black Delhi.jpg"),
    ESSEN("Essen", Disease.BLUE, "Card Blue Essen.jpg", "Infection Blue Essen.jpg"),
    HO_CHI_MINH_CITY("Ho Chi Minh City", Disease.RED, "Card Red Ho Chi Minh City.jpg", "Infection Red Ho Chi Minh City.jpg"),
    HONG_KONG("Hong Kong", Disease.RED, "Card Red Hong Kong.jpg", "Infection Red Hong Kong.jpg"),
    ISTANBUL("Istanbul", Disease.BLACK, "Card Black Istanbul.jpg", "Infection Black Istanbul.jpg"),
    JAKARTA("Jakarta", Disease.RED, "Card Red Jakarta.jpg", "Infection Red Jakarta.jpg"),
    JOHANNESBURG("Johannesburg", Disease.YELLOW, "Card Yellow Johannesburg.jpg", "Infection Yellow Johannesburg.jpg"),
    KARACHI("Karachi", Disease.BLACK, "Card Black Karachi.jpg", "Infection Black Karachi.jpg"),
    KHARTOUM("Khartoum", Disease.YELLOW, "Card Yellow Khartoum.jpg", "Infection Yellow Khartoum.jpg"),
    KINSASHA("Kinsasha", Disease.YELLOW, "Card Yellow Kinsasha.jpg", "Infection Yellow Kinsasha.jpg"),
    KOLKATA("Kolkata", Disease.BLACK, "Card Black Kolkata.jpg", "Infection Black Kolkata.jpg"),
    LAGOS("Lagos", Disease.YELLOW, "Card Yellow Lagos.jpg", "Infection Yellow Lagos.jpg"),
    LIMA("Lima", Disease.YELLOW, "Card Yellow Lima.jpg", "Infection Yellow Lima.jpg"),
    LONDON("London", Disease.BLUE, "Card Blue London.jpg", "Infection Blue London.jpg"),
    LOS_ANGELES("Los Angelos", Disease.YELLOW, "Card Yellow Los Angeles.jpg", "Infection Yellow Los Angeles.jpg"),
    MADRID("Madrid", Disease.BLUE, "Card Blue Madrid.jpg", "Infection Blue Madrid.jpg"),
    MANILA("Manila", Disease.RED, "Card Red Manila.jpg", "Infection Red Manila.jpg"),
    MEXICO_CITY("Mexico City", Disease.YELLOW, "Card Yellow Mexico City.jpg", "Infection Yellow Mexico City.jpg"),
    MIAMI("Miami", Disease.YELLOW, "Card Yellow Miami.jpg", "Infection Yellow Miami.jpg"),
    MILAN("Milan", Disease.BLUE, "Card Blue Milan.jpg", "Infection Blue Milan.jpg"),
    MONTREAL("Montreal", Disease.BLUE, "Card Blue Montreal.jpg", "Infection Blue Montreal.jpg"),
    MOSCOW("Moscow", Disease.BLACK, "Card Black Moscow.jpg", "Infection Black Moscow.jpg"),
    MUMBAI("Mumbai", Disease.BLACK, "Card Black Mumbai.jpg", "Infection Black Mumbai.jpg"),
    NEW_YORK("New York", Disease.BLUE, "Card Blue New York.jpg", "Infection Blue New York.jpg"),
    OSAKA("Osaka", Disease.RED, "Card Red Osaka.jpg", "Infection Red Osaka.jpg"),
    PARIS("Paris", Disease.BLUE, "Card Blue Paris.jpg", "Infection Blue Paris.jpg"),
    RIYADH("Riyadh", Disease.BLACK, "Card Black Riyadh.jpg", "Infection Black Riyadh.jpg"),
    SAN_FRANCISCO("San Francisco", Disease.BLUE, "Card Blue San Francisco.jpg", "Infection Blue San Francisco.jpg"),
    SANTIAGO("Santiago", Disease.YELLOW, "Card Yellow Santiago.jpg", "Infection Yellow Santiago.jpg"),
    SAO_PAULO("Sao Paulo", Disease.YELLOW, "Card Yellow Sao Paulo.jpg", "Infection Yellow Sao Paulo.jpg"),
    SEOUL("Seoul", Disease.RED, "Card Red Seoul.jpg", "Infection Red Seoul.jpg"),
    SHANGHAI("Shanghai", Disease.RED, "Card Red Shanghai.jpg", "Infection Red Shanghai.jpg"),
    ST_PETERSBURG("St. Petersburg", Disease.BLUE, "Card Blue St. Petersburg.jpg", "Infection Blue St. Petersburg.jpg"),
    SYDNEY("Sydney", Disease.RED, "Card Red Sydney.jpg", "Infection Red Sydney.jpg"),
    TAIPEI("Taipei", Disease.RED, "Card Red Taipei.jpg", "Infection Red Taipei.jpg"),
    TEHRAN("Tehran", Disease.BLACK, "Card Black Tehran.jpg", "Infection Black Tehran.jpg"),
    TOKYO("Tokyo", Disease.RED, "Card Red Tokyo.jpg", "Infection Red Tokyo.jpg"),
    WASHINGTON("Washington", Disease.BLUE, "Card Blue Washington.jpg", "Infection Blue Washington.jpg")
    ;

    private String name;
    private Disease defaultDisease;
    private String playerCardImageFilename;
    private String infectionCardImageFilename;
    CityName(String name, Disease defaultDisease, String playerCardImageFilename, String infectionCardImageFilename){
        this.name = name;
        this.defaultDisease = defaultDisease;
        this.playerCardImageFilename = playerCardImageFilename;
        this.infectionCardImageFilename = infectionCardImageFilename;
    }

    public String getName() {
        return name;
    }

    public Disease getDefaultDisease() {
        return defaultDisease;
    }

    public String getPlayerCardImageFilename() {
        return playerCardImageFilename;
    }

    public String getInfectionCardImageFilename() {
        return infectionCardImageFilename;
    }

    public String toString(){
        return name;
    }
}
