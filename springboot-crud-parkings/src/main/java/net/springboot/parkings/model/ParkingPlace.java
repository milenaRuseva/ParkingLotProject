package net.springboot.parkings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_places")
public class ParkingPlace {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "number")
    private long number;
    
    @Column(name = "parking_zone_name")
    private String parkingZoneName;
    
    @Column(name = "has_car")
    private boolean hasCar;
    
    @Column(name = "carId")
    private long carId;
    
    public ParkingPlace() {
        super();
    }
    
   
    public ParkingPlace(long id, long number, String parkingZoneName, boolean hasCar, long carId) {
        super();
        this.id = id;
        this.number = number;
        this.parkingZoneName = parkingZoneName;
        this.hasCar = hasCar;
        this.carId = carId;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getParkingZoneName() {
        return parkingZoneName;
    }

    public void setParkingZoneName(String parkingZoneName) {
        this.parkingZoneName = parkingZoneName;
    }

    public boolean isHasCar() {
        return hasCar;
    }

    public void setHasCar(boolean hasCar) {
        this.hasCar = hasCar;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }
 
}
