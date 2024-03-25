import java.util.Scanner;

public class HotelRoomBiddingSystem {
    public static void main(String[] args) {
        Handler suiteHandler = new SuiteHandler();
        Handler deluxeHandler = new DeluxeHandler();
        Handler standardHandler = new StandardHandler();

        suiteHandler.setNextHandler(deluxeHandler);
        deluxeHandler.setNextHandler(standardHandler);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter your bid price (or -1 to exit): ");
                double bidPrice = scanner.nextDouble();
                if (bidPrice == -1) break;

                BidRequest request = new BidRequest(bidPrice);
                boolean handled = suiteHandler.handleRequest(request);

                if (!handled) {
                    System.out.println("Bid rejected. Please try again with a different price.");
                }
            }
        }
        System.out.println("Thank you for participating in the hotel room bidding.");
    }
}