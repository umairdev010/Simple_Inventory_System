package org.practice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "suppliers_inventory")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplier_id;

    private String name;

    private String phone;

    public Supplier(int supplier_id, String name, String phone) {
        this.supplier_id = supplier_id;
        this.name = name;
        this.phone = phone;
    }

    public Supplier(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Supplier(){}

    @Override
    public String toString() {
        return "Supplier{" +
                "supplier_id=" + supplier_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
