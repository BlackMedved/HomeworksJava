package alfa.homework8;

import java.util.ArrayList;
import java.util.Collections;

public class Winamp {
    static void main() {
        ArrayList<String> listOfSongs = new ArrayList<>();
        Collections.addAll(listOfSongs, "Dire Straits - Money for Nothing", "Billy Idol - Rebel Yell",
                "Airbourne - Blonde, Bad and Beautiful");
        Playlist playlist = new Playlist("В дороге", listOfSongs);

        playlist.addTrack("Journey - Don't Stop Believin'");
        playlist.removeTrack(1);
        playlist.updateTrack(0, "Dire Straits - Sultans of Swing");
        playlist.getTrack(1);

        System.out.println(playlist);
    }
}
