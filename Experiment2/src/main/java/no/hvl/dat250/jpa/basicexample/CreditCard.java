package no.hvl.dat250.jpa.basicexample;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer number;
    private Integer limit;
    private Integer balance;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="pincode_id")
    private Pincode pincode;

    @ManyToOne
    private Bank bank;
    
    
}
