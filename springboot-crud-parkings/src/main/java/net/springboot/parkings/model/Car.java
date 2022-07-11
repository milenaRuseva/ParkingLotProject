package net.springboot.parkings.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "plate_number")
    private String plateNumber;
     
    @OneToOne(mappedBy = "car", cascade =  CascadeType.ALL)
    private ParkingPlace parkingPlace;
    
    public Car() {
        super();
    } 

    public Car(String plateNumber) {
        super();
        this.plateNumber = plateNumber; 
    }
     
    public Car(String plateNumber, ParkingPlace parkingPlace) {
        super();
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

    public ParkingPlace getParkingPlace() {
        return parkingPlace;
    }

    public void setParkingPlace(ParkingPlace parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    
}
