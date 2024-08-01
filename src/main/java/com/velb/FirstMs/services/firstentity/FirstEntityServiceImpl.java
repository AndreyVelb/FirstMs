package com.velb.FirstMs.services.firstentity;

import com.velb.FirstMs.controllers.dto.SaveFirstEntityRequest;
import com.velb.FirstMs.model.entity.FirstEntity;
import com.velb.FirstMs.repositories.FirstEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FirstEntityServiceImpl implements FirstEntityService {

    private final FirstEntityRepository firstEntityRepository;

    @Override
    @Transactional
    public Long save(SaveFirstEntityRequest request) {
        var entity = FirstEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .build();

        return firstEntityRepository.save(entity).getId();
    }
}
