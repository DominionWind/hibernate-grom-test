package Lesson4.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Order {
    private long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    @Id
    @SequenceGenerator(name = "ORDER_SEQ", sequenceName = "ORDER_PK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")

    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    public User getUser() {
        return user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID", referencedColumnName = "ID")
    public Room getRoom() {
        return room;
    }

    @Column(name = "DATE_FROM")
    public Date getDateFrom() {
        return dateFrom;
    }

    @Column(name = "DATE_TO")
    public Date getDateTo() {
        return dateTo;
    }

    @Column(name = "MONEY_PAID")
    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", room=" + room +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", moneyPaid=" + moneyPaid +
                '}';
    }
}