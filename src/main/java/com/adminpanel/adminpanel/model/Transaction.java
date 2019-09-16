package model;

import lombok.Data;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "")
    private User user;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;
}
