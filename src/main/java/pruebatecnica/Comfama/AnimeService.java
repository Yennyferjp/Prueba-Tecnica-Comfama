package pruebatecnica.Comfama;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimeService {

    Page<Anime> getAnime(String title, Pageable pageable) {

        //retornamos null por ahora para que no salga un error al compilar
        throw new NotImplementedException("Esto será implementado en el futuro");
    }
}
