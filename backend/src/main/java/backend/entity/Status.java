package backend.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    @OneToOne(mappedBy = "status")
    private Customer customer;

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", role='" + status + '\'' +
                '}';
    }
}
