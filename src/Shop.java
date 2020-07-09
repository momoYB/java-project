import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop implements Revenue {
    public String name;
    private final ArrayList<Good> goods;
    private final ArrayList<Cashier> cashiers;
    private final ArrayList<Receipt> receipts;

    public Shop(String name) {
        this.name = name;
        this.goods = new ArrayList<>();
        this.cashiers = new ArrayList<>();
        this.receipts = new ArrayList<>();
    }


    public void addCashier(Cashier cashier) {
        cashiers.add(cashier);
    }

    public String getName() {
        return name;
    }

    public int goodsInStock(Good good) {
        int cnt = 0;
        for (Good shopGood : goods) {
            if (shopGood.getName().equals(good.getName())) {
                cnt++;
            }
        }
        return cnt;
    }

    public void RemoveFromGoods(Good good, int amount) {
        for (int i = 0; i < amount; i++) {
            goods.remove(good);
        }
    }

    @Override
    public double totalProfit() {
        double sum = 0;
        for (Receipt receipt : receipts) {
            sum += receipt.totalProfit();
        }
        return sum;

    }

    public void addGoods(Good good, int amount) {
        for (int i = 0; i < amount; i++) {
            goods.add(good);
        }
    }


    public synchronized void WriteFiles(Receipt receipt) {
        String outputFilename = receipt.idToString();
        try (FileWriter fout = new FileWriter(new File(outputFilename), false)) {

            if (this != null) {
                fout.append(receipt.toString() + System.lineSeparator());
                fout.close();
            }
        } catch (IOException e) {
            System.out.println("IOException " + e);

        }
    }

    public void ReadFiles(String name) {
        try {
            File input = new File(name);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.err.println("Error");
        }

    }


}
