package pruebatecnica.Comfama.Anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pruebatecnica.Comfama.Anime.Jikan.Anime;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController()
@RequestMapping(path = "/anime")
public class AnimeController {
    private final AnimeService animeService;

    @Autowired
    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping()
    public Page<Anime> getAnime(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        try {
            return animeService.getAnime(title, pageable);
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/average-score")
    public double getAverageScore(String title, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        try {
            return animeService.getAverageScore(title, pageable);
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
