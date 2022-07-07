package net.springboot.parkings.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.parkings.exception.ParkingNotFoundException; 
import net.springboot.parkings.model.ParkingZone;
import net.springboot.parkings.repository.ParkingZoneRepository;

@RestController
public class ParkingZoneController {
    @Autowired
    private ParkingZoneRepository parkingZoneRepository;
     
  //save parking zone
    @PostMapping("/saveParkingZone")
    public String saveParkingZone(@RequestBody ParkingZone parkingZone) {
        parkingZoneRepository.save(parkingZone);
        return "Saved zone...";
    }
  //update parking zone
    @PutMapping("/updateParkingZones/{id}")
    public String updateParkingZone(@PathVariable long id, 
            @RequestBody ParkingZone parkingZone){
        ParkingZone updatedParkingZone = parkingZoneRepository.findById(id).get();
        if(updatedParkingZone != null) {
        updatedParkingZone.setParkingZoneName(parkingZone.getParkingZoneName());
        updatedParkingZone.setParkingName(parkingZone.getParkingName());
        updatedParkingZone.setParkingPlaces(parkingZone.getParkingPlaces());
        parkingZoneRepository.save(parkingZone);
        }
        return "parking zone updated";
    }
  //delete parking zone
    @DeleteMapping(value = "/deleteParkingZone/{id}")
    public String deleteParkingZone(@PathVariable long id){
       ParkingZone deleteParkingZone = parkingZoneRepository.findById(id).get();
        parkingZoneRepository.delete(deleteParkingZone);
        return "deleted parking zone with id: "+ id;
    } 
    
  //find all parking zones
    @GetMapping("/parkingZones")
    public List<ParkingZone> getAllParkingZones(){
       return  parkingZoneRepository.findAll();
    }
    
  //show zone by id
    @GetMapping("/showParkingZonesById/{id}")
    public ResponseEntity<ParkingZone> showParkingZoneById(@PathVariable(value = "id") long parkingZoneId) throws ParkingNotFoundException{
        ParkingZone parkingZone = parkingZoneRepository.findById(parkingZoneId).orElseThrow(()-> new ParkingNotFoundException("Not found parking zone with id: " + parkingZoneId));
        return ResponseEntity.ok().body(parkingZone);
    }
  //show zone name by id
    @GetMapping("/showParkingZoneNameById/{id}")
    public ResponseEntity<String> showParkingZoneNameById(@PathVariable(value = "id") long parkingZoneId) throws ParkingNotFoundException{
        ParkingZone parkingZone = parkingZoneRepository.findById(parkingZoneId).orElseThrow(()-> new ParkingNotFoundException("Not found parking zone with id: " + parkingZoneId));
        return ResponseEntity.ok().body(parkingZone.getParkingZoneName());
    }
    //show parking places by parking zone id
    @GetMapping("/showParkingPlacesByParkingZoneId/{id}")
    public String showParkingPlacesByParkingZoneId(@PathVariable(value = "id") long parkingZoneId) { 
         parkingZoneRepository.findById(parkingZoneId);
         return "Parking places are: " + parkingZoneRepository.getParkingPlacesByParkingZoneId(parkingZoneId).get(0).getParkingPlaces();
           
   }
}
