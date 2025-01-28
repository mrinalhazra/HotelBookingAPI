package com.basicApi.hotel.Controller;

import com.basicApi.hotel.dto.HotelRequestDTO;
import com.basicApi.hotel.exceptions.BadRequestException;
import com.basicApi.hotel.entity.Hotel;
import com.basicApi.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public void createHotel(@RequestBody HotelRequestDTO hotel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException("Request is not valid");
        }
        hotelService.createHotel(hotel);
    }

    @GetMapping("/id/{id}")
    public Hotel getHotelDetails(@PathVariable Long id){
       return hotelService.getDetails(id);
    }

    @GetMapping("/getAll")
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @DeleteMapping("remove/id/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteHotelById(@PathVariable Long id){
        hotelService.deleteHotelById(id);
    }

}
