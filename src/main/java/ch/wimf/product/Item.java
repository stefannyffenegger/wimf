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

/**
 *
 * @author Stefan Nyffenegger
 */
public class Item {

    // User Table Attributes
    private int id;
    private int id_fridge;
    private String name;
    private String description;
    private String barcode;
    private int barcode_type;
    private int category;
    private String expiry_date;
    private String creation_date;
    private int quantity;
    private int quantity_unit;

    /**
     * Empty Default Constructor
     */
    public Item() {

    }

    /**
     *
     * @param id
     * @param id_fridge
     * @param name
     * @param description
     * @param barcode
     * @param barcode_type
     * @param category
     * @param expiry_date
     * @param creation_date
     * @param quantity
     * @param quantity_unit
     */
    public Item(int id, int id_fridge, String name, String description, String barcode, int barcode_type, int category, String expiry_date, String creation_date, int quantity, int quantity_unit) {
        this.id = id;
        this.id_fridge = id_fridge;
        this.name = name;
        this.description = description;
        this.barcode = barcode;
        this.barcode_type = barcode_type;
        this.category = category;
        this.expiry_date = expiry_date;
        this.creation_date = creation_date;
        this.quantity = quantity;
        this.quantity_unit = quantity_unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_fridge() {
        return id_fridge;
    }

    public void setId_fridge(int id_fridge) {
        this.id_fridge = id_fridge;
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

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
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

}
