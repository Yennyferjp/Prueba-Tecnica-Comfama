package pruebatecnica.Comfama;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaginationJikan {
    @JsonProperty("last_visible_page")
    private int lastVisiblePage;

    @JsonProperty("has_next_page")
    private boolean hasNextPage;

    @JsonProperty("current_page")
    private int currentPage;

    @JsonProperty("items")
    private Items items;

    public PaginationJikan() {
    }

    public PaginationJikan(int last_visible_page, boolean has_next_page, int current_page, Items items) {
        this.lastVisiblePage = last_visible_page;
        this.hasNextPage = has_next_page;
        this.currentPage = current_page;
        this.items = items;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}

