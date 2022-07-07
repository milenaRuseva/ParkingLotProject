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
import net.springboot.parkings.model.Car; 
import net.springboot.parkings.repository.CarRepository;
import net.springboot.parkings.repository.ParkingPlaceRepository;
import net.springboot.parkings.repository.ParkingRepository;
 

@RestController
public class CarController  {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private ParkingPlaceRepository parkingPlaceRepository;
     
    
  //insert car
    @PostMapping("/saveCar")
    public String saveCar(@RequestBody Car car) {
        carRepository.save(car);
        return "Saved car...";
    }
    
    //update car
    @PutMapping(value = "/updateCar/{id}")
    public String updateCar(@PathVariable long id, @RequestBody Car car){
        Car updatedCar = carRepository.findById(id).get();
        if(updatedCar != null) {
        updatedCar.setPlateNumber(car.getPlateNumber());
        updatedCar.setParkingPlace(car.getParkingPlace());
        carRepository.save(updatedCar);
        }
        return "updated car with id: " + id;
    }
    
    //delete car 
    @DeleteMapping(value = "/deleteCar/{id}")
    public String deleteCar(@PathVariable long id){
       Car deleteCar = carRepository.findById(id).get();
        carRepository.delete(deleteCar);
        return "deleted car with id: "+ id;
    } 
    // find all cars
    @GetMapping("/cars")
    public List<Car> getAllCars(){
       return  carRepository.findAll();
    }
  //show car by id
    @GetMapping("/car/{id}")
    public ResponseEntity<Car> showCarById(@PathVariable(value = "id") long carId) throws ParkingNotFoundException{
        Car car = carRepository.findById(carId).orElseThrow(()-> new ParkingNotFoundException("Not found car with id: " + carId));
        return ResponseEntity.ok().body(car);
    }
    
  //show car plate number by id
    @GetMapping("/carNumber/{id}")
    public ResponseEntity<String> showCarPlateById(@PathVariable(value = "id") long carId) throws ParkingNotFoundException{
        Car car = carRepository.findById(carId).orElseThrow(()-> new ParkingNotFoundException("Not found car with id: " + carId));
        return ResponseEntity.ok().body(car.getPlateNumber());
    }
    
    //show in which parking place is the car 
    @GetMapping("/showCarParkingPlace/{id}")
    public String showCarParingPlace(@PathVariable(value = "id") long carId) { 
         carRepository.findById(carId);
          return "Car parking place is: " + carRepository.getCarParkingPlace(carId).get(0).getParkingPlace();
           
   }
    
    //show parking zone is the car
    public int a; 
    @GetMapping("/showZoneByCarId/{id}")
    public String showZoneByCarId(@PathVariable(value = "id") long carId) { 
         carRepository.findById(carId);
         a = carRepository.getZoneNameByCarId(carId).get(0);
          return parkingPlaceRepository.getCarParkingZoneName((long) a); 
   }
    
  //show in which parking is the car
    public int b; 
    @GetMapping("/showParkingByCarId/{id}")
    public String showParkingByCarId(@PathVariable(value = "id") long carId) { 
         carRepository.findById(carId);
          b = carRepository.getParkingByCarId(carId).get(0);
          return parkingRepository.getParkingNameByParkingId((long) b); 
   }
     
}
