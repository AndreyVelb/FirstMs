package com.velb.FirstMs.services.secondmscall;

import com.velb.FirstMs.controllers.dto.SaveSecondEntityRequest;
import com.velb.FirstMs.controllers.dto.SaveSecondEntityResponse;

public interface SecondMsCallService {

    SaveSecondEntityResponse saveInSecondTable(SaveSecondEntityRequest request);
}
