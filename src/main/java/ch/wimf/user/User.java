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
package main.java.ch.wimf.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User Object
 * @author Stefan Nyffenegger
 */
@Entity
@Table(name = "users")
public class User {

    // User Table Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date registration_date;
    private String password;

    /**
     * Empty Default Constructor
     */
    public User() {

    }

    /**
     *
     * @param id
     * @param username
     * @param firstname
     * @param lastname
     * @param email
     * @param phone
     * @param birthdate
     * @param registration_date
     * @param password
     */
    public User(int id, String username, String firstname, String lastname, String email, String phone, String birthdate, Date registration_date, String password) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        setBirthdate(birthdate);
        this.registration_date = registration_date;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthdate() {
        return birthdate.toString();
    }

    public void setBirthdate(String birthdate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
            Date parsed = format.parse(birthdate); //Parse birthdate form String to Date
            this.birthdate = parsed;
        } catch (ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getRegistration_date() {
        return registration_date.toString();
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
