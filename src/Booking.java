package src;

import java.util.UUID;

public class Booking {
    private String bookingId;
    private String userId;
    private String parkingSpaceId;
    private String day;
    private String timeSlot;

    public Booking(String userId, String parkingSpaceId, String day, String timeSlot) {
        this.bookingId = generateBookingId();
        this.userId = userId;
        this.parkingSpaceId = parkingSpaceId;
        this.day = day;
        this.timeSlot = timeSlot;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getParkingSpaceId() {
        return parkingSpaceId;
    }

    public String getDay() {
        return day;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    private String generateBookingId() {
        return UUID.randomUUID().toString();
    }
}

