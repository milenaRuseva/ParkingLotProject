package net.springboot.parkings.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.springboot.parkings.model.Parking; 

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long>{ 
    
    @Query(value = "select * from parkings where id=?1", nativeQuery = true)
    public List<Parking> getParkingZonesByParkingId(Long id);
    
    @Query(value = "select * from parkings where id=?1", nativeQuery = true)
    public String getParkingNameByParkingId(Long id);
}
