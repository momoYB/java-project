import java.util.ArrayList;
import java.util.Date;

public class Receipt implements Revenue {
    private static int cnt;
    private final int ID;
    private final Cashier cashier;
    private final Date dateHour;
    private final ArrayList<Good> soldGoods;


    public Receipt(Cashier cashier, Date dateHour) {
        cnt++;
        this.ID = cnt;
        this.cashier = cashier;
        this.dateHour = dateHour;
        this.soldGoods = new ArrayList<>();
    }

    public void receiptAdd(Good good) {

        soldGoods.add(good);

    }

    public ArrayList<Good> getSoldGoods() {
        return soldGoods;
    }

    public int getID() {
        return ID;
    }

    public String idToString() {
        return String.valueOf(getID());
    }

    public Cashier getCashier() {
        return cashier;
    }

    public Date getDateHour() {
        return dateHour;
    }

    public double totalProfit() {
        double sum = 0;
        for (Good good : soldGoods) {
            sum += good.getPrice();
        }
        return sum;
    }


    @Override
    public String toString() {
        return "Receipt{" +
                "ID=" + ID +
                ", " + cashier +
                ", date='" + dateHour + "\n" + "List of Goods in receipt: " + getSoldGoods() + "\nTotal sum of the receipt: " + totalProfit() + '\'' +
                '}';
    }
}
