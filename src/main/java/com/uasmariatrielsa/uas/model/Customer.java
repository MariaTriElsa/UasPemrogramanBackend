
package com.uasmariatrielsa.uas.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_customer")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, name = "customer_name")
    private String name;
    
    @Column(nullable = false, name = "customer_alamat")
    private String alamat;
    
    @Column(nullable = false, name = "customer_email")
    private String email;
    
    @ManyToOne
    private Product product;
}
