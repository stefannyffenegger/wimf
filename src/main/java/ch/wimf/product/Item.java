/*
 * Copyright (C) 2019 Stefan Nyffenegger
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main.java.ch.wimf.product;

import main.java.ch.wimf.usermanagement.dao.UserDao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Stefan Nyffenegger
 */
@Entity
@Table(name = "items")
public class Item {

    // Item Table Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="item_id")
    private int item_id;


    @ManyToOne
    @JoinColumn(name="fridge_id", nullable=false)
    private Fridge fridge;



    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="barcode")
    private String barcode;

    @Column(name="barcode_type")
    private int barcode_type;

    @Column(name="category")
    private int category;

    //@Column(name="expiry_date")
    //private java.sql.Date expiry_date;

    //@Column(name="creation_date")
    //private java.sql.Date creation_date;

    @Column(name="quantity")
    private int quantity;

    @Column(name="quantity_unit")
    private int quantity_unit;

    /**
     * Empty Default Constructor
     */
    public Item() {

    }

    /**
     *
     * @param item_id
     * @param fridge
     * @param name
     * @param description
     * @param barcode
     * @param barcode_type
     * @param category
     * @param quantity
     * @param quantity_unit
     */
    public Item(int item_id, Fridge fridge, String name, String description, String barcode, int barcode_type, int category, int quantity, int quantity_unit) {
        super();
        this.item_id = item_id;
        this.fridge = fridge;
        this.name = name;
        this.description = description;
        this.barcode = barcode;
        this.barcode_type = barcode_type;
        this.category = category;
        this.quantity = quantity;
        this.quantity_unit = quantity_unit;
    }

    public Item( String name, String description, String barcode, int barcode_type, int category, int quantity, int quantity_unit) {
        super();

        UserDao<Fridge> userDao = new UserDao<>(Fridge.class);
        Fridge fridge = userDao.getUser(1);

        this.fridge = fridge;
        this.name = name;
        this.description = description;
        this.barcode = barcode;
        this.barcode_type = barcode_type;
        this.category = category;
        this.quantity = quantity;
        this.quantity_unit = quantity_unit;
    }

    public int getId() {
        return item_id;
    }

    public void setId(int id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getBarcode_type() {
        return barcode_type;
    }

    public void setBarcode_type(int barcode_type) {
        this.barcode_type = barcode_type;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity_unit() {
        return quantity_unit;
    }

    public void setQuantity_unit(int quantity_unit) {
        this.quantity_unit = quantity_unit;
    }


    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }
}
