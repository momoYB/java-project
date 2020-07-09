public class Main {
    public static void main(String[] args) {
        Good grapes = new Good("Grapes", 3.0, "25/08/2020");
        Good cheese = new Good("Cheese", 6.5, "10/03/2021");
        Good wine = new Good("Wine", 25.99, "18/7/2025");
        Shop billa = new Shop("Billa");
        Cashier Frodo = new Cashier("Frodo Baggins");
        Cashier Sam = new Cashier("Samwise Gamgee");
        billa.addCashier(Frodo);
        billa.addCashier(Sam);
        billa.addGoods(grapes, 13);
        billa.addGoods(cheese, 14);
        billa.addGoods(wine, 7);
        PayDesk first = new PayDesk(Frodo, billa);
        PayDesk second = new PayDesk(Sam, billa);
        Thread one = new Thread(first, "First");
        Thread two = new Thread(second, "Second");


        try {
            first.Sell(wine, 6);
            first.Sell(grapes, 2);
            first.Sell(cheese, 2);
            one.start();
            second.Sell(grapes, 4);
            //second.Sell(wine, 2);
            two.start();


        } catch (OutOfStock e) {
            System.err.println("Error: " + e);
        }
        String FileName = "1";
        billa.ReadFiles(FileName);
        String FileName2 = "2";
        billa.ReadFiles(FileName2);


    }


}