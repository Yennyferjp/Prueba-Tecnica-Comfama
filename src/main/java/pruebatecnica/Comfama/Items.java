package pruebatecnica.Comfama;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {
    private int count;
    private int total;

    @JsonProperty("per_page")
    private int perPage;

    public Items() {
    }

    public Items(int count, int total, int per_page) {
        this.count = count;
        this.total = total;
        this.perPage = per_page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }
}
