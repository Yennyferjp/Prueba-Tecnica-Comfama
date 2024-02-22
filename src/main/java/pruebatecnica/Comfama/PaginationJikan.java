package pruebatecnica.Comfama;

public class PaginationJikan {
    private int lastVisiblePage;
    private boolean hasNextPage;
    private int currentPage;
    private Items items;

    public PaginationJikan() {
    }

    public PaginationJikan(int lastVisiblePage, boolean hasNextPage, int currentPage, Items items) {
        this.lastVisiblePage = lastVisiblePage;
        this.hasNextPage = hasNextPage;
        this.currentPage = currentPage;
        this.items = items;
    }

    public int getLastVisiblePage() {
        return lastVisiblePage;
    }

    public void setLastVisiblePage(int lastVisiblePage) {
        this.lastVisiblePage = lastVisiblePage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}

