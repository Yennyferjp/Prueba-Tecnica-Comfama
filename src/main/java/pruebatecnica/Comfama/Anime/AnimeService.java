package pruebatecnica.Comfama.Anime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pruebatecnica.Comfama.Anime.Jikan.Anime;
import pruebatecnica.Comfama.Anime.Jikan.DataAnimeJikan;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class AnimeService {

    private final HttpClient httpClient;
    private static final String url = "https://api.jikan.moe/v4/anime";

    public AnimeService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public Page<Anime> getAnime(String title, Pageable pageable) throws ExecutionException, InterruptedException, TimeoutException {
        String uri = getAnimeUrl(title, pageable);
        String animeJson = getAnimeJsonFromUrl(uri).get(15, TimeUnit.SECONDS);

        ObjectMapper mapper = new ObjectMapper();
        try {
            DataAnimeJikan dataAnimeJikan = mapper.readValue(animeJson, DataAnimeJikan.class);

            return new PageImpl<>(dataAnimeJikan.getData(), pageable, dataAnimeJikan.getPagination().getItems().getTotal());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public double getAverageScore(String title, Pageable pageable) throws ExecutionException, InterruptedException, TimeoutException {
        String uri = getAnimeUrl(title, pageable);
        String animeJson = getAnimeJsonFromUrl(uri).get(15, TimeUnit.SECONDS);

        ObjectMapper mapper = new ObjectMapper();
        try {
            DataAnimeJikan dataAnimeJikan = mapper.readValue(animeJson, DataAnimeJikan.class);

            return dataAnimeJikan.getSeasonsScore();

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getAnimeUrl(String title, Pageable pageable) {
        String uri = url + "?page=" + (pageable.getPageNumber() + 1) + "&limit=" + pageable.getPageSize();

        if (title != null && !title.trim().isEmpty()) {
            uri += "&q=" + URLEncoder.encode(title, StandardCharsets.UTF_8);
        }
        return uri;
    }

    private CompletableFuture<String> getAnimeJsonFromUrl(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }



}

