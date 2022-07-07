package net.springboot.parkings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parkings")
public class Parking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "parkingName")
    private String parkingName;
    
    @Column(name = "zones")
    private String zones;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "zipCode")
    private String zipCode; 
    
    public Parking() {
        super();
    }
    
    public Parking(long id, String parkingName, String zones, String city, String street, String zipCode) {
        super();
        this.id = id;
        this.parkingName = parkingName;
        this.zones = zones;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getParkingName() {
        return parkingName;
    }
    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }
    public String getZones() {
        return zones;
    }
    public void setZones(String zones) {
        this.zones = zones;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
}
