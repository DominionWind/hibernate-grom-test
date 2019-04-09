package Lesson4.model;

import Lesson4.utils.UserType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {
    private Long id;
    private String userName;
    private String password;
    private String country;
    private UserType type;
    private List<Order> orders;

    @SequenceGenerator(name = "ITEM_S", sequenceName = "ITEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_S")

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    @Column(name = "TYPE")
    public UserType getType() {
        return type;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    public List<Order> getOrders() {
        return orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", type=" + type +
                ", orders=" + orders +
                '}';
    }
}

