package net.springboot.parkings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "plate_number")
    private String plateNumber;
    
    @Column(name = "parking_place")
    private String parkingPlace;
    
    public Car() {
        super();
    }
    
    public Car(long id, String plateNumber, String parkingPlace) {
        super();
        this.id = id;
        this.plateNumber = plateNumber;
        this.parkingPlace = parkingPlace;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getParkingPlace() {
        return parkingPlace;
    }

    public void setParkingPlace(String parkingPlace) {
        this.parkingPlace = parkingPlace;
    }
    
    
    
}
