public class Good {
    private static int cnt = 0;
    private final int ID;
    private String name;
    private double price;
    private String expirationDate;

    public Good(String name, double price, String expirationDate) {
        cnt++;
        this.ID = cnt;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Good{" +
                "ID = " + ID +
                ", name = '" + name + '\'' +
                ", price = " + price +
                ", expirationDate = " + expirationDate +
                '}';
    }
}
