package net.springboot.parkings.model;

 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parking_places")
public class ParkingPlace {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "number")
    private long number;
     
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_zone_id", referencedColumnName = "zone_id")
    private ParkingZone parkingZoneName;
     
    @Column(name = "has_car")
    private boolean hasCar;
    
    @Column(name = "car")
    private long carId;
     
   @OneToOne(cascade = CascadeType.ALL) 
   @JoinTable(name = "place_car", 
            joinColumns = 
              { @JoinColumn(name = "place_id", referencedColumnName = "id") },
            inverseJoinColumns = 
              { @JoinColumn(name = "car_id", referencedColumnName = "id") })
    private Car car;

    
    public ParkingPlace() {
        super();
    }

 
    public ParkingPlace(long number, boolean hasCar, long carId) {
        super();
        this.number = number;
        //this.parkingZoneName = parkingZoneName;
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

 
    public ParkingZone getParkingZoneName() {
        return parkingZoneName;
    }


    public void setParkingZoneName(ParkingZone parkingZoneName) {
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


    public Car getCar() {
        return car;
    }


    public void setCar(Car car) {
        this.car = car;
    }
    
     
     
    
 
}
