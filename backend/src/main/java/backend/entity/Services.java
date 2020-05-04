package backend.entity;


import javax.persistence.*;
import java.util.Set;

import lombok.Data;

@Entity
@Data
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String serviceName;

    @Lob
    private String information;

    private Integer price;

    protected Services() {
    }

    @OneToMany(mappedBy = "services", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Subscriptions> subscriptions;


    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", information='" + information + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
