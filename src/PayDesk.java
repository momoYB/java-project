import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PayDesk implements Runnable {
    private Cashier cashier;
    private final Shop shop;
    private final ArrayList<Good> listOfSold;
    private Receipt receipt;

    public PayDesk(Cashier cashier, Shop shop) {
        this.listOfSold = new ArrayList<>();
        this.cashier = cashier;
        this.shop = shop;
    }

    public void addGoodsToList(Good good, int count) {
        for (int i = 0; i < count; i++)
            listOfSold.add(good);
    }

    public synchronized void Sell(Good good, int requested) throws OutOfStock {

        if (shop.goodsInStock(good) < requested) {
            throw new OutOfStock(requested, shop.goodsInStock(good), good);
        } else {
            shop.RemoveFromGoods(good, requested);
            addGoodsToList(good, requested);
        }
    }

    public void inCart() {
        for (Good good : listOfSold) {
            System.out.println(good.toString());
        }
    }

    public synchronized Receipt makeReceipt(Date date) {
        Receipt receipt = new Receipt(cashier, date);
        for (Good good : listOfSold) {
            receipt.receiptAdd(good);
        }
        shop.WriteFiles(receipt);
        return receipt;
    }


    @Override
    public void run() {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateObj = new Date();
        System.out.println(Thread.currentThread().getName() + " Started ");
        System.out.println(df.format(dateObj));

        System.out.println(shop.getName() + ":Cashier's name is " + cashier.getName() + ". \nTotal sum:  " + makeReceipt(dateObj).totalProfit());
        listOfSold.removeAll(listOfSold);
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
