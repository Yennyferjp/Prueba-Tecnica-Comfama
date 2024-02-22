package pruebatecnica.Comfama;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class AnimeService {

    private final HttpClient httpClient;
    private static  final String url = "https://api.jikan.moe/v4/anime";
    public AnimeService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public Page<Anime> getAnime(String title, Pageable pageable) throws ExecutionException, InterruptedException, TimeoutException {
        String uri = url + "?q=" + title + "&page=" + (pageable.getPageNumber() + 1) + "&limit=" + pageable.getPageSize();
        String animeJson = getAnimeJsonFromUrl(uri).get(15, TimeUnit.SECONDS);

        ObjectMapper mapper = new ObjectMapper();
        try {
            DataAnimeJikan dataAnimeJikan = mapper.readValue(animeJson, DataAnimeJikan.class);
            return new PageImpl<>(dataAnimeJikan.getData(), pageable, dataAnimeJikan.pagination.getItems().getTotal());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
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
