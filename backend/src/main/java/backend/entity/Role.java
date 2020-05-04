package backend.entity;


import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roleName;


    @OneToOne(mappedBy = "role")
    private Customer customer;


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + roleName + '\'' +
                '}';
    }
}
