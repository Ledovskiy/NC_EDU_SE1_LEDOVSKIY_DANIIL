package backend.entity;


import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Subscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer subscribeDays;


    protected Subscriptions() {
    }

    @ManyToOne
    @JoinColumn(name = "wallets_id")
    private Wallets wallets;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "services_id")
    private Services services;

    @Override
    public String toString() {
        return " Subscriptions{" +
                "id=" + id +
                ", subscribeDays='" + subscribeDays + '\'' +
                '}';
    }
}
