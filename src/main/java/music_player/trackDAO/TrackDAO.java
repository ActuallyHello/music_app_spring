package music_player.trackDAO;

import music_player.models.Track;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrackDAO {
    private static int PEOPLE_COUNT;
    List<Track> tracks;

    {
        tracks = new ArrayList<>();

        tracks.add(new Track(++PEOPLE_COUNT, "Tom"));
        tracks.add(new Track(++PEOPLE_COUNT, "Jacky"));
        tracks.add(new Track(++PEOPLE_COUNT, "Frank"));
        tracks.add(new Track(++PEOPLE_COUNT, "Dawson"));
    }

    public List<Track> music() {
        return tracks;
    }

    public Track show(int id) {
        return tracks.stream().filter(tracks -> tracks.getId() == id).findAny().orElse(null);
    }
}
