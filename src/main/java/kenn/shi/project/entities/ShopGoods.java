package kenn.shi.project.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "good_name" , length = 255)
    private String name;

    @Column(name = "description" , columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "amount")
    private int amount;
}
