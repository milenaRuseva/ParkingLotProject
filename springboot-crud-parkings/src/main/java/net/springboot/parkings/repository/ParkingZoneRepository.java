package net.springboot.parkings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
import net.springboot.parkings.model.ParkingZone;

@Repository
public interface ParkingZoneRepository extends JpaRepository<ParkingZone, Long>{
    
    @Query(value = "select * from parking_zones where id=?1", nativeQuery = true)
    public List<ParkingZone> getParkingPlacesByParkingZoneId(Long id);
}
