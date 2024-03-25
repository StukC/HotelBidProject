public abstract class Handler {
    protected Handler next;
    protected static final int NO_ROOMS_AVAILABLE = 0;

    public void setNextHandler(Handler next) {
        this.next = next;
    }

    public abstract boolean handleRequest(BidRequest request);
}