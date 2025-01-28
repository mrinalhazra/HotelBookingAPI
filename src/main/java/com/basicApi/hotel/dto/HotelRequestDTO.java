package com.basicApi.hotel.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HotelRequestDTO {

    private String name;

    private String city;

    private Long rating;


}
