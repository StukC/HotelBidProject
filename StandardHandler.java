public class StandardHandler extends Handler {
    private int availableStandardRooms = 45;

    @Override
    public boolean handleRequest(BidRequest request) {
        if (availableStandardRooms > NO_ROOMS_AVAILABLE && request.getPrice() >= 80) {
            availableStandardRooms--;
            System.out.println("Standard room booked. Available standard rooms: " + availableStandardRooms);
            return true;
        }
        return false; // StandardHandler is the last in the chain.
    }
}