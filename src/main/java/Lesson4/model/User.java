package Lesson4.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType type;
    private List<Order> orders;

    @Id
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_PK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")

    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @Column(name="USER_NAME")
    public String getUserName() {
        return userName;
    }

    @Column(name="PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name="COUNTRY")
    public String getCountry() {
        return country;
    }

    @Column(name="TYPE")
    public UserType getType() {
        return type;
    }

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user",fetch = FetchType.LAZY)
    public List<Order> getOrders() {
        return orders;
    }

    public void setId(long id) {
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

    public void setOrders(ArrayList<Order> orders) {
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

