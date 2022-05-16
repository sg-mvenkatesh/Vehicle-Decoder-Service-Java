package com.sg;

import com.sg.controller.VDSResource;
import com.sg.dto.ResponseClass;
import com.sg.dto.VinDetails;
import com.sg.repository.VDSRepsitory;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class VDSTestClass {
    @InjectMock
    VDSRepsitory vdsRepsitory;

    @Inject
    VDSResource vdsResource;

    @Inject
    VinDetails vinDetails;

    @Inject
    ResponseClass responseClass;

    @BeforeEach
    void setUp(){
        responseClass = new ResponseClass();
        responseClass.setResponseCode("200");
        responseClass.setStatus("SUCCESS");
        vinDetails.setVinPattern("137PH9036E");
    }

    @Test
    void testVinInfoForVinId(){
        Mockito.when(vdsRepsitory.findByVinId("137PH9036E")).thenReturn(vinDetails);
        ResponseClass vinInfoForVinId = vdsResource.getVinInfoForVinId("137PH903W6E008378");
        assertNotNull(vinInfoForVinId);
        assertEquals(Response.Status.OK.getStatusCode(), vinInfoForVinId.getResponseCode());
    }
}
