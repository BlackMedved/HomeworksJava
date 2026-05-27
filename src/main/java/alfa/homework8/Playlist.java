package alfa.homework8;

import java.util.ArrayList;

public class Playlist {
    public String playlistName;
    public ArrayList<String> trackList;

    public Playlist() {}

    public Playlist (String playlistName, ArrayList<String> trackList) {
        this.playlistName = playlistName;
        this.trackList = trackList;
    }

    public void addTrack(String track) {
        trackList.add(track);
        System.out.println("В плейлист добавлен новый трек: " + track);
    }

    public void removeTrack(int index) {
        String removedTrack = trackList.remove(index);
        System.out.println("Из плейлиста был удален трек: " + removedTrack);
    }

    public void updateTrack(int index, String trackName) {
        String lastTrack = trackList.set(index, trackName);
        System.out.println("В плейлисте был изменен трек c: " + lastTrack + " на: " + trackName);
    }

    public String getTrack(int index) {
        String track = trackList.get(index);
        System.out.println("Из плейлиста был получен трек: " + track);
        return track;
    }

    @Override
    public String toString() {
        StringBuilder printPlaylist = new StringBuilder("\n___\nНазвание плейлиста: " + playlistName
                + "\nСписок песен:\n");
        trackList.forEach(trackName -> printPlaylist.append("• " + trackName + "\n"));
        return printPlaylist.toString();
    }
}
