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

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Stefan Nyffenegger
 */
@Entity
@Table(name = "fridges")
public class Fridge {

    // Fridge Table Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="fridge_id")
    private int fridge_id;


    @OneToMany(mappedBy="fridge", fetch = FetchType.EAGER)
    private Set<Item> items;




    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    /**
     * Empty Default Constructor
     */
    public Fridge(){
        
    }
    
    /**
     * 
     * @param fridge_id
     * @param name
     * @param description 
     */
    public Fridge(int fridge_id, Set<Item> items, String name, String description) {
        super();
        this.fridge_id = fridge_id;
        this.items = items;
        this.name = name;
        this.description = description;
    }

    public Fridge(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return fridge_id;
    }

    public void setId(int id) {
        this.fridge_id = fridge_id;
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

    public Set<Item> getItems() {
        return this.items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
