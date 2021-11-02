package no.hvl.dat250.jpa.basicexample;


import javax.persistence.*;

import lombok.*;

@Entity
@Data
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int pincode;

    private int count;
    

    
}
