public class OutOfStock extends Exception {

    private final int requested;
    private final int available;
    private final Good good;

    public OutOfStock(int requested, int available, Good good) {

        this.requested = requested;
        this.available = available;
        this.good = good;
    }


    public int getRequested() {
        return requested;
    }

    public int getAvailable() {
        return available;
    }

    public Good getGood() {
        return good;
    }

    @Override
    public String toString() {
        return "Not enough good of type " + good.getName() + "(ID=" + good.getID() + ")"
                + "; available: " + available + " requested: " + requested;
    }
}
