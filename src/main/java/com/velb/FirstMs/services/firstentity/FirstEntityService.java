package com.velb.FirstMs.services.firstentity;

import com.velb.FirstMs.controllers.dto.SaveFirstEntityRequest;
import com.velb.FirstMs.model.dto.FirstEntityDto;
import com.velb.FirstMs.model.entity.FirstEntity;

import java.util.List;

public interface FirstEntityService {

    FirstEntityDto save(SaveFirstEntityRequest request);

    FirstEntityDto getById(Long id);

    List<FirstEntityDto> getAll();

    void deleteById(Long id);
}
