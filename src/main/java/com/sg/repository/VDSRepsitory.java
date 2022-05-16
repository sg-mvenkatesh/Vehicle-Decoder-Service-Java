package com.sg.repository;

import com.sg.dto.Trim;
import com.sg.dto.VinDetails;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import io.quarkus.mongodb.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class VDSRepsitory implements PanacheMongoRepository<VinDetails> {

    public VinDetails findByVinId(String vinPattren){
        VinDetails vinDetails = null;
        if(vinPattren.length()==10){
            PanacheQuery<VinDetails> vinInfo = find(
                    "vinPattern", vinPattren);
            VinDetails vinDetailsInfo = vinInfo.firstResult();
            System.out.println(vinDetailsInfo.getVinPattern());
            if(vinDetailsInfo!=null)
                return vinDetailsInfo;
        }
            throw new RuntimeException("No data's found in given VIN number");
    }

}
