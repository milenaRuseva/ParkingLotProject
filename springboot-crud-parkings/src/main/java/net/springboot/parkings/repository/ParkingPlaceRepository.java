package net.springboot.parkings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.springboot.parkings.model.ParkingPlace;

@Repository
public interface ParkingPlaceRepository  extends JpaRepository<ParkingPlace, Long>{
    @Query(value = "select * from parking_places where id=?1", nativeQuery = true)
    public List<ParkingPlace> getCarByPlaceId(Long id);
    @Query(value = "select * from parking_places where car_id =?1", nativeQuery = true)
    public String getCarParkingZoneName(Long id);
 
}
