package org.practice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products_inventory")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private int stock;


    public Product(int product_id, String name, Category category, Supplier supplier, int stock) {
        this.product_id = product_id;
        this.name = name;
        this.category = category;
        this.supplier = supplier;
        this.stock = stock;
    }

    public Product(String name, Category category, Supplier supplier, int stock) {
        this.name = name;
        this.category = category;
        this.supplier = supplier;
        this.stock = stock;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", supplier=" + supplier +
                ", stock=" + stock +
                '}';
    }
}
