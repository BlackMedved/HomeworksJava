package alfa.homework13;

import java.util.ArrayList;
import java.util.List;

public class MissionReport {
    private String missionName;
    private List<Alien> capturedAliens;
    private int squadSize;

    public MissionReport() {
        capturedAliens = new ArrayList<>();
    }

    public MissionReport(String missionName, List<Alien> capturedAliens, int squadSize) {
        this.missionName = missionName;
        this.capturedAliens = capturedAliens;
        this.squadSize = squadSize;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public List<Alien> getCapturedAliens() {
        return capturedAliens;
    }

    public void setCapturedAliens(List<Alien> capturedAliens) {
        this.capturedAliens = capturedAliens;
    }

    public int getSquadSize() {
        return squadSize;
    }

    public void setSquadSize(int squadSize) {
        this.squadSize = squadSize;
    }

    @Override
    public String toString() {
        return String.format("""
                Миссия: %s
                Поймано пришельцев: %d
                Размер отряда: %d
                """, missionName, capturedAliens.size(), squadSize);
    }
}
