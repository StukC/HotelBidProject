public class DeluxeHandler extends Handler {
    private int availableDeluxeRooms = 15;

    @Override
    public boolean handleRequest(BidRequest request) {
        if (availableDeluxeRooms > NO_ROOMS_AVAILABLE && request.getPrice() >= 150) {
            availableDeluxeRooms--;
            System.out.println("Deluxe room booked. Available deluxe rooms: " + availableDeluxeRooms);
            return true;
        } else {
            return next != null && next.handleRequest(request);
        }
    }
}