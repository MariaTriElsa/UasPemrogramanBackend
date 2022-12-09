/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uasmariatrielsa.uas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
     @Column(nullable = false, name = "product_name")
    private String name;
     
     @Column(nullable = false, name = "product_quantity")
    private int quantity;
     
     @Column(nullable = false, name = "product_price")
      private int price;

     @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
     @OneToMany(mappedBy = "customer")
     private List<Customer> customers;
}
