package pruebatecnica.Comfama;

public class Items {
    private int count;
    private int total;
    private int perPage;

    public Items() {
    }

    public Items(int count, int total, int perPage) {
        this.count = count;
        this.total = total;
        this.perPage = perPage;
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
