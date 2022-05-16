package com.sg.service;

import com.sg.dto.VinDetails;
import com.sg.repository.VDSRepsitory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class VDSService {

    @Inject
    private VDSRepsitory vdsRepsitory;

//  get the vin details for the given vin id
    public VinDetails getVinInfoByVinId(String vinNumber){
        String vinPattren = vinNumberDecoder(vinNumber);
        VinDetails vinInfoByVin = vdsRepsitory.findByVinId(vinPattren);
        String engineType = getEngineType(vinInfoByVin.getEngineName());
        if(vinInfoByVin!=null && engineType!=null){
            vinInfoByVin.setEngineType(engineType);
            return vinInfoByVin;
        }else{
            throw new RuntimeException("No datas found for the give vin number: "+vinNumber);
        }
    }

    public String vinNumberDecoder(String vinNumber){
        char[] vinChar = vinNumber.toCharArray();

        String vinPattren = Character.toString(vinChar[0]);
        if(vinNumber!=null&&vinNumber.length()==17){

            if(vinChar.length==17){
                for(int i=1; i<=10; i++){
                    if(i<=7||i==9||i==10)
                        vinPattren+=vinChar[i];
                }
            }
        }
        return vinPattren;
    }

    public String getEngineType(String engineName){
        if((engineName.contains("TURBO")) && (engineName.contains ("ELECTRIC"))) {
            return "TE";
        }else if ((engineName.contains("TURBO")) && (engineName.contains ("HYBRID"))) {
            return "TH";
        } else if ((engineName.contains ("ELECTRIC"))){
            return "NE";
        } else if ((engineName.contains ("HYBRID"))){
            return "NH";
        }else if ((engineName.contains ("TURBO"))){
            return "T";
        }else{
            return "N";
        }
    }
}
