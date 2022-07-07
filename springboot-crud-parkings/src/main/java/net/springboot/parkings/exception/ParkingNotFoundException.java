package net.springboot.parkings.exception;

public class ParkingNotFoundException extends RuntimeException{
     
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ParkingNotFoundException(String message)
    {
        super(message); 
    }
}
