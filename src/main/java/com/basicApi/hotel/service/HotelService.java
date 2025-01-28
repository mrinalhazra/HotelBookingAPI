package com.basicApi.hotel.service;

import com.basicApi.hotel.dto.HotelRequestDTO;
import com.basicApi.hotel.exceptions.HotelNotFoundException;
import com.basicApi.hotel.entity.Hotel;
import com.basicApi.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;


    public void createHotel(HotelRequestDTO hotel) {
        Hotel hotelObj = new Hotel();
        hotelObj.setCity(hotel.getCity());
        hotelObj.setName(hotel.getName());
        hotelObj.setRating(hotel.getRating());

        hotelRepository.save(hotelObj);

    }

    public Hotel getDetails(Long id) {
       return hotelRepository.findById(id).get();
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public void deleteHotelById(Long id) {
       hotelRepository.delete(this.getDetails(id));
    }

}
