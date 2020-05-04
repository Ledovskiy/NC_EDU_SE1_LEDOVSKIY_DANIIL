package backend.entity;


import javax.persistence.*;
import java.util.Set;

import lombok.Data;

@Entity
@Data
public class Wallets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer balance;
    private String walletName;


    protected Wallets() {
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "wallets", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Subscriptions> subscriptions;


    @Override
    public String toString() {
        return "Wallets{" +
                "id=" + id +
                ", balance='" + balance + '\'' +
                ", wallet='" + walletName + '\'' +
                '}';
    }
}
