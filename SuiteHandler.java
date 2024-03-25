public class SuiteHandler extends Handler {
    private int availableSuites = 10;

    @Override
    public boolean handleRequest(BidRequest request) {
        if (availableSuites > NO_ROOMS_AVAILABLE && request.getPrice() >= 280) {
            availableSuites--;
            System.out.println("Suite room booked. Available suites: " + availableSuites);
            return true;
        } else {
            return next != null && next.handleRequest(request);
        }
    }
}