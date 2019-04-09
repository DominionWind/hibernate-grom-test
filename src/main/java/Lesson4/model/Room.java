package Lesson4.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ROOM")
public class Room {
    private Long id;
    private int numbersOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    @Id
    @SequenceGenerator(name = "ITEM_S", sequenceName = "ITEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_S")

    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name = "NUMBER_OF_GUESTS")
    public int getNumbersOfGuests() {
        return numbersOfGuests;
    }

    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    @Column(name = "BREAKFAST_INCLUDED")
    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    @Column(name = "PETS_ALLOWED")
    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    @Column(name = "DATE_FROM")
    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID", nullable = false)
    public Hotel getHotel() {
        return hotel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumbersOfGuests(int numbersOfGuests) {
        this.numbersOfGuests = numbersOfGuests;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}