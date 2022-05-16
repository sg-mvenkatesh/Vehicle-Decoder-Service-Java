package com.sg.controller;

import com.sg.dto.ResponseClass;
import com.sg.dto.VinDetails;
import com.sg.service.VDSService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/vin")
public class VDSResource {

    @Inject
    private VDSService vdsService;


//   API for Decoding the given VIN number to VinPattren
    @GET
    @Path("/{vin}")
    public String getVinPattren(@PathParam("vin") String vinNumber){
        String vinPattren = null;
        if(vinNumber.length()==17){
             vinPattren = vdsService.vinNumberDecoder(vinNumber);
        }
        return vinPattren;
    }

//    get all the vinInfo for the given vin number
    @GET
    @Path("/vininfo/{vinNumber}")
    public ResponseClass getVinInfoForVinId(@PathParam("vinNumber") String vinNumber){
        ResponseClass responseClass =new ResponseClass();
        VinDetails vinInfoByVinId = vdsService.getVinInfoByVinId(vinNumber);
        if(vinInfoByVinId!=null){
            responseClass.setResponseCode("200");
            responseClass.setStatus("SUCCESS");
            responseClass.setResponseDetails("vin info by vinID is successfully execuited");
            responseClass.setData(vinInfoByVinId);
            return responseClass;
        }else {
            responseClass.setResponseCode("400");
            responseClass.setStatus("BAD REQUEST");
            responseClass.setResponseDetails("Please pass the valid vinID");
            return responseClass;
        }
    }

    @GET
    @Path("/vinNumber")
    public ResponseClass getVinInfoByVinId(@QueryParam("vinNumber") String vinNumber){
        ResponseClass responseClass =new ResponseClass();
        VinDetails vinInfoByVinId = vdsService.getVinInfoByVinId(vinNumber); // try catch
        if(vinInfoByVinId!=null){
            responseClass.setResponseCode("200");
            responseClass.setStatus("SUCCESS");
            responseClass.setResponseDetails("vin info by vinID is successfully execuited");
            responseClass.setData(vinInfoByVinId);
            return responseClass;
        }else {
            responseClass.setResponseCode("400");
            responseClass.setStatus("BAD REQUEST");
            responseClass.setResponseDetails("Please pass the valid vinID");
            return responseClass;
        }
    }
}