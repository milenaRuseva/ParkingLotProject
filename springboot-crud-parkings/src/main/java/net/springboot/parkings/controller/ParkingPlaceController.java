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
import net.springboot.parkings.model.ParkingPlace;
import net.springboot.parkings.model.ParkingZone;
import net.springboot.parkings.repository.ParkingPlaceRepository;
 

@RestController

public class ParkingPlaceController {
    
    @Autowired
    private ParkingPlaceRepository parkingPlaceRepository;
     
  //create parking place 
    @PostMapping("/parkingPlace/save")
    public String saveParking(@RequestBody ParkingPlace parkingPlace) {
        parkingPlaceRepository.save(parkingPlace);
        return "Saved parking place...";
    }
    
  //update parking place
    @PutMapping(value = "updatePlace/{id}")
    public String updateParkingPlace(@PathVariable long id, 
            @RequestBody ParkingPlace parkingPlace) {  
        ParkingPlace updatedParkingPlace = parkingPlaceRepository.findById(id).get();
        if(updatedParkingPlace != null) {  
            
            updatedParkingPlace.setNumber(parkingPlace.getNumber());
            updatedParkingPlace.setParkingZoneName(parkingPlace.getParkingZoneName());
            updatedParkingPlace.setHasCar(parkingPlace.isHasCar());
            updatedParkingPlace.setCarId(parkingPlace.getCarId()); 
            
            parkingPlaceRepository.save(updatedParkingPlace);
        }
        return "updated parking place...";
    } 
     
    //delete parking place
    @DeleteMapping("/deleteParkingPlace/{id}")
    public String deleteParkingPlace(@PathVariable long id){
       ParkingPlace deleteParkingPlace = parkingPlaceRepository.findById(id).get();
        parkingPlaceRepository.delete(deleteParkingPlace);
        return "deleted parking place with id: "+ id;
    } 
    
 // find all parking places 
    @GetMapping("/parkingPlaces")
    public List<ParkingPlace> getAllParkingPlaces(){
       return  parkingPlaceRepository.findAll();
    }
    
  //show parking place by id
    @GetMapping("/parkingPlaces/{id}")
    public ResponseEntity<ParkingPlace> showParkingPlaceById(@PathVariable(value = "id") long parkingPlaceId) throws ParkingNotFoundException{
        ParkingPlace parkingPlace = parkingPlaceRepository.findById(parkingPlaceId).orElseThrow(()-> new ParkingNotFoundException("Not found parking place with id: " + parkingPlaceId));
        return ResponseEntity.ok().body(parkingPlace);
    }
   
    //show car by parking place id
    @GetMapping("/showCarByParkingPlaceId/{id}")
    public String showCarByParkingPlaceId(@PathVariable(value = "id") long parkingPlaceId) throws ParkingNotFoundException{ 
         parkingPlaceRepository.findById(parkingPlaceId).orElseThrow(()-> new ParkingNotFoundException("Not found parking place with id: " + parkingPlaceId));
         if(parkingPlaceRepository.getCarByPlaceId(parkingPlaceId).get(0).isHasCar() == false){
             return "Empty place";
         }
         else {
             return "Car id is:" + parkingPlaceRepository.getCarByPlaceId(parkingPlaceId).get(0).getCarId();
         }
          
   }
     
    //show zone by parking place id
    @GetMapping("/parkingZone/{id}")
    public ParkingZone showParkingZoneByPlaceId(@PathVariable(value = "id") long placeId) throws ParkingNotFoundException{
        ParkingPlace parkingPlace = parkingPlaceRepository.findById(placeId).orElseThrow(()-> new ParkingNotFoundException("Not found parking with id: " + placeId));
        return parkingPlace.getParkingZoneName();
    }
    
    
}
