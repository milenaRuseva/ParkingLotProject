package net.springboot.parkings.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController; 
import net.springboot.parkings.exception.ParkingNotFoundException; 
import net.springboot.parkings.model.Parking; 
import net.springboot.parkings.repository.ParkingRepository; 

@RestController

public class ParkingController {
    
    @Autowired
    private ParkingRepository parkingRepository;
     
    //insert parking
    @PostMapping("/saveParking") 
    public ResponseEntity<Parking> saveParking(@RequestBody Parking parking)  {
        Parking savedParking = parkingRepository.save(parking);
        return new ResponseEntity<>(savedParking, HttpStatus.CREATED); 
    }
    //update parking
    @PutMapping(value = "update/{id}")
    public String updateParking(@PathVariable long id, 
            @RequestBody Parking parking) {  
        Parking updatedParking = parkingRepository.findById(id).get();
        if(updatedParking != null) {
            updatedParking.setParkingName(parking.getParkingName()); 
            updatedParking.setCity(parking.getCity());
            updatedParking.setStreet(parking.getStreet());
            updatedParking.setZipCode(parking.getZipCode());
            parkingRepository.save(updatedParking); 
        } 
        return "updated";
    } 
    
    //delete parking 
    @DeleteMapping(value = "/delete/{id}")
    public String deleteParking(@PathVariable long id){
       Parking deleteParking = parkingRepository.findById(id).get();
        parkingRepository.delete(deleteParking);
        return "deleted parking with id: "+ id;
    } 
    
  //find all parkings
    @GetMapping("/parkings")
    public List<Parking> getAllParkings(){
       return  parkingRepository.findAll();
    }
    
    //show full info by parking id
    @GetMapping("/parkings/{id}")
    public ResponseEntity<Parking> showParkingById(@PathVariable(value = "id") long parkingId) throws ParkingNotFoundException{
        Parking parking = parkingRepository.findById(parkingId).orElseThrow(()-> new ParkingNotFoundException("Not found parking with id: " + parkingId));
        return ResponseEntity.ok().body(parking);
    }
  //show only parking name by parking id 
    @GetMapping("/parkingName/{id}")
    public ResponseEntity<String> showParkingNameById(@PathVariable(value = "id") long parkingId) throws ParkingNotFoundException{
        Parking parking = parkingRepository.findById(parkingId).orElseThrow(()-> new ParkingNotFoundException("Not found parking with id: " + parkingId));
        return ResponseEntity.ok().body(parking.getParkingName());
    }
    
   // show parking zones by parking id
    @GetMapping("/showParkingZonesByParkingId/{id}")
    public String showParkingZonesByParkingId(@PathVariable(value = "id") long parkingId) { 
         parkingRepository.findById(parkingId);
          return "Parking zone is: " + parkingRepository.getParkingZonesByParkingId(parkingId).get(0).getZones();
   }
     
    
}
