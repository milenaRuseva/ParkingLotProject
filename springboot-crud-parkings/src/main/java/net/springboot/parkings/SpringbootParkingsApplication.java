package net.springboot.parkings; 

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.springboot.parkings.model.Car;
import net.springboot.parkings.model.ParkingPlace;  
import net.springboot.parkings.repository.ParkingPlaceRepository; 

 

@SpringBootApplication 
public class SpringbootParkingsApplication implements CommandLineRunner{
     
    @Autowired
    private ParkingPlaceRepository parkingPlaceRepository;
	public static void main(String[] args) {
	    
		SpringApplication.run(SpringbootParkingsApplication.class, args);
		 
	}

    @Override
    public void run(String... args) throws Exception {
        ParkingPlace place1 = new ParkingPlace((long)123, true, (long)15);
        Car car1 = new Car("12345");
        place1.setCar(car1);
        car1.setParkingPlace(place1);
        parkingPlaceRepository.getCarByPlaceId(car1.getId());
    }
	 
}
 