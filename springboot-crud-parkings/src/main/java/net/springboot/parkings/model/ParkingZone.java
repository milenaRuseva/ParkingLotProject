package net.springboot.parkings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_zones")
public class ParkingZone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "parking_zone_name")
    private String parkingZoneName;
    
    @Column(name = "parking_name")
    private String parkingName;
    
    @Column(name = "parking_places")
    private String parkingPlaces;
    
    public ParkingZone() {
        super();
    }
    
    public ParkingZone(long id, String parkingZoneName, String parkingName, String parkingPlaces) {
        super();
        this.id = id;
        this.parkingZoneName = parkingZoneName;
        this.parkingName = parkingName;
        this.parkingPlaces = parkingPlaces;
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

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public String getParkingPlaces() {
        return parkingPlaces;
    }

    public void setParkingPlaces(String parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }
    
    
}
