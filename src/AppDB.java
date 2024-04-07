package src;

public class AppDB {
    private UserDB userDB;
    private BookingDB bookingDB;

    public AppDB() {
        this.userDB = new UserDB();
        this.bookingDB = new BookingDB();
    }

    public UserDB getUserDB() {
        return userDB;
    }

    public BookingDB getBookingDB() {
        return bookingDB;
    }
}



