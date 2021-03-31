package music_player.сontrollers;

import music_player.trackDAO.TrackDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MusicController {

    private final TrackDAO trackDAO;

    @Autowired
    public MusicController(TrackDAO trackDAO) {
        this.trackDAO = trackDAO;
    }

    @GetMapping()
    public String music (Model model) {
        model.addAttribute("music", trackDAO.music());
        return "tracks";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("music", trackDAO.show(id));
        return "show";
    }
}
