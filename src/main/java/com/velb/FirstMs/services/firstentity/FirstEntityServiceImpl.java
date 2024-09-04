package com.velb.FirstMs.services.firstentity;

import com.velb.FirstMs.controllers.dto.SaveFirstEntityRequest;
import com.velb.FirstMs.model.dto.FirstEntityDto;
import com.velb.FirstMs.model.entity.FirstEntity;
import com.velb.FirstMs.repositories.FirstEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FirstEntityServiceImpl implements FirstEntityService {

    private final FirstEntityRepository firstEntityRepository;

    @Override
    @Transactional
    @CachePut(value = "first-entity", key = "#result.id")
    @CacheEvict(value = "first-entity-all", allEntries = true)
    public FirstEntityDto save(SaveFirstEntityRequest request) {
        var entity = new FirstEntity();
                entity.setFirstName(request.getFirstName());
                entity.setLastName(request.getLastName());
                entity.setPhoneNumber(request.getPhoneNumber());

        var savedEntity = firstEntityRepository.save(entity);

        return FirstEntityDto.builder()
                .id(savedEntity.getId())
                .lastName(savedEntity.getLastName())
                .firstName(savedEntity.getFirstName())
                .phoneNumber(savedEntity.getPhoneNumber())
                .build();
    }

    @Override
    @Transactional
    @Cacheable(value = "first-entity", key = "#id")
    public FirstEntityDto getById(Long id) {
        var entity = firstEntityRepository.getReferenceById(id);
        return FirstEntityDto.builder()
                .id(entity.getId())
                .lastName(entity.getLastName())
                .firstName(entity.getFirstName())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }

    @Override
    @Cacheable(value = "first-entity-all")
    public List<FirstEntityDto> getAll() {
        var allEntities = firstEntityRepository.findAll();
        return allEntities.stream()
                .map(entity -> FirstEntityDto.builder()
                        .id(entity.getId())
                        .lastName(entity.getLastName())
                        .firstName(entity.getFirstName())
                        .phoneNumber(entity.getPhoneNumber())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    @Caching(
            evict = {
                    @CacheEvict(value = "first-entity-all", allEntries = true),
                    @CacheEvict(value = "first-entity", key = "#id")
            }
    )
    public void deleteById(Long id) {
        firstEntityRepository.deleteById(id);
    }
}
