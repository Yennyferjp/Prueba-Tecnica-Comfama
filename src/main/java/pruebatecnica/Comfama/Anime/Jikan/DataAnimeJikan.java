package pruebatecnica.Comfama.Anime.Jikan;

import java.util.ArrayList;

public class DataAnimeJikan {

    ArrayList<Anime> data;
    PaginationJikan pagination;

    public DataAnimeJikan() {
    }

    public DataAnimeJikan(ArrayList<Anime> data, PaginationJikan pagination) {
        this.data = data;
        this.pagination = pagination;
    }

    public ArrayList<Anime> getData() {
        return data;
    }

    public void setData(ArrayList<Anime> data) {
        this.data = data;
    }

    public PaginationJikan getPagination() {
        return pagination;
    }

    public void setPagination(PaginationJikan pagination) {
        this.pagination = pagination;
    }

    public double getSeasonsScore(){
        if(data.isEmpty()){
            return 0;
        }
        double seasonsScoreSum = 0;
        for (Anime datum : data) {
            seasonsScoreSum += datum.getScore();
        }
        return seasonsScoreSum / data.size();
    }
}