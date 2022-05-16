package com.sg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClass {

    private String status;
    private String responseCode;
    private String responseDetails;
    private Object data;
}
