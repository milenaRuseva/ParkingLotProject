package net.springboot.parkings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.springboot.parkings.model.Car;
import net.springboot.parkings.model.Parking;
import net.springboot.parkings.model.ParkingPlace;
@Repository
public interface CarRepository  extends JpaRepository<Car, Long>{
    
    
    @Query(value = "select * from car where id=?1", nativeQuery = true)
    public List<Car> getCarParkingPlace(Long id);
    
    /*@Query(value = "select * from car join parking_places on car.id = parking_places.car_id where parking_places.car_id=?1", nativeQuery = true)
    public List<ParkingPlace> getCarParkingZoneName(Long id);*/
    
    @Query(value = "select * from parking_places where car_id =?1", nativeQuery = true)
    public List<ParkingPlace> getCarParkingZoneName(Long id);
     
    @Query(value = "select p.id from parkings p inner join parking_places pp "
            + "on p.zones = pp.parking_zone_name "
            + "where pp.car_id=?1", nativeQuery = true)
    public List<Integer> getParkingByCarId(Long id);
    
    //show zone
    @Query(value = "select * from parking_places where car_id=?1", nativeQuery = true)
    public List<Integer> getZoneNameByCarId(Long id);
    
    @Query(value = "select * from parkings where id=?1", nativeQuery = true)
    public List<Parking> getParkingNameByParkingId(Long id);
    
}
