package Lesson4.model;

import java.util.Date;

    public class Filter {
    private Long id;
    private int numbersOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public int getNumbersOfGuests() {
            return numbersOfGuests;
        }

        public void setNumbersOfGuests(int numbersOfGuests) {
            this.numbersOfGuests = numbersOfGuests;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean isBreakfastIncluded() {
            return breakfastIncluded;
        }

        public void setBreakfastIncluded(boolean breakfastIncluded) {
            this.breakfastIncluded = breakfastIncluded;
        }

        public boolean isPetsAllowed() {
            return petsAllowed;
        }

        public void setPetsAllowed(boolean petsAllowed) {
            this.petsAllowed = petsAllowed;
        }

        public Date getDateAvailableFrom() {
            return dateAvailableFrom;
        }

        public void setDateAvailableFrom(Date dateAvailableFrom) {
            this.dateAvailableFrom = dateAvailableFrom;
        }

        public Hotel getHotel() {
            return hotel;
        }

        public void setHotel(Hotel hotel) {
            this.hotel = hotel;
        }

        @Override
        public String toString() {
            return "Filter{" +
                    "id=" + id +
                    ", numbersOfGuests=" + numbersOfGuests +
                    ", price=" + price +
                    ", breakfastIncluded=" + breakfastIncluded +
                    ", petsAllowed=" + petsAllowed +
                    ", dateAvailableFrom=" + dateAvailableFrom +
                    ", hotel=" + hotel +
                    '}';
        }
    }
