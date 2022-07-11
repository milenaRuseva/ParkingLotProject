package net.springboot.parkings.model;  

  
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data; 

@Entity
@Data 
@Table(name = "parkings")
public class Parking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    @Column(name = "parking_id")
    private long id;
    
    @Column(name = "parkingName")
    private String parkingName; 
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "zipCode")
    private String zipCode;  
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "parking_parking_zone", 
            joinColumns =  @JoinColumn(name = "parking_id") ,
            inverseJoinColumns = @JoinColumn(name = "zone_id")) 
    private Set<ParkingZone> zones = new HashSet<>();
    
    public Parking() {
        super();
    }
         
    public Parking(String parkingName, String city, String street, String zipCode, Set<ParkingZone> zones) {
        super();
        this.parkingName = parkingName;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.zones = zones;
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

    public Set<ParkingZone> getZones() {
        return zones;
    }

    public void setZones(Set<ParkingZone> zones) {
        this.zones = zones;
    }

     
}
