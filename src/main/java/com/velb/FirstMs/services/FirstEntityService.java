package com.velb.FirstMs.services;

import com.velb.FirstMs.controllers.dto.SaveFirstEntityRequest;

public interface FirstEntityService {

    Long save(SaveFirstEntityRequest request);
}
