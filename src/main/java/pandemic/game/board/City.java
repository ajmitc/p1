package pandemic.game.board;

import pandemic.game.CityName;
import pandemic.game.Disease;
import pandemic.game.MilitaryBase;
import pandemic.game.ResearchStation;

import java.util.HashMap;
import java.util.Map;

public class City {
    private CityName name;
    private Map<Disease, Integer> diseaseCount = new HashMap<>();
    private ResearchStation researchStation = ResearchStation.NONE;
    private MilitaryBase militaryBase = MilitaryBase.NONE;
    private int crisesLevel = 0;

    public City(CityName name){
        this.name = name;
        for (Disease disease: Disease.values())
            diseaseCount.put(disease, 0);
    }

    public CityName getName() {
        return name;
    }

    public Map<Disease, Integer> getDiseaseCount() {
        return diseaseCount;
    }

    public void addDisease(Disease disease){
        diseaseCount.put(disease, diseaseCount.get(disease) + 1);
    }

    public void removeDisease(Disease disease){
        if (diseaseCount.get(disease) > 0)
            diseaseCount.put(disease, diseaseCount.get(disease) - 1);
    }

    public void removeAllDisease(Disease disease){
        diseaseCount.put(disease, 0);
    }

    public int getDiseaseCount(Disease disease){
        return diseaseCount.get(disease);
    }

    public ResearchStation getResearchStation() {
        return researchStation;
    }

    public void setResearchStation(ResearchStation researchStation) {
        this.researchStation = researchStation;
    }

    public MilitaryBase getMilitaryBase() {
        return militaryBase;
    }

    public void setMilitaryBase(MilitaryBase militaryBase) {
        this.militaryBase = militaryBase;
    }

    public int getCrisesLevel() {
        return crisesLevel;
    }

    public void setCrisesLevel(int crisesLevel) {
        this.crisesLevel = crisesLevel;
    }
}
