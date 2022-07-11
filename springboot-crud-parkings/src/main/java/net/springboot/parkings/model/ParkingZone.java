package net.springboot.parkings.model;
 

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "parking_zones")
public class ParkingZone  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name = "zone_id")
    private long id;
    
    @Column(name = "parking_zone_name")
    private String parkingZoneName; 
    
    @OneToMany(mappedBy ="parkingZoneName", cascade = CascadeType.ALL) 
    private Set<ParkingPlace> parkingPlaces = new HashSet<>(); 
    
    @ManyToMany(mappedBy = "zones", cascade = CascadeType.ALL)
    private Set<Parking> parkingName = new HashSet<>();
    
    public ParkingZone() {
        super();
    }
      
    public ParkingZone(long id, String parkingZoneName, Set<ParkingPlace> parkingPlaces, Set<Parking> parkingName) {
        super();
        this.id = id;
        this.parkingZoneName = parkingZoneName;
        this.parkingPlaces = parkingPlaces;
        this.parkingName = parkingName;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getParkingZoneName() {
        return parkingZoneName;
    }

    public void setParkingZoneName(String parkingZoneName) {
        this.parkingZoneName = parkingZoneName;
    }  

    public Set<ParkingPlace> getParkingPlaces() {
        return parkingPlaces;
    }


    public void setParkingPlaces(Set<ParkingPlace> parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    public Set<Parking> getParkingName() {
        return parkingName;
    }

    public void setParkingName(Set<Parking> parkingName) {
        this.parkingName = parkingName;
    }
      
}
