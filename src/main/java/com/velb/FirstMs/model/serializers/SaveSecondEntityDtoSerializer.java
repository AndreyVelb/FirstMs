package com.velb.FirstMs.model.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velb.FirstMs.model.dto.SaveSecondEntityDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SaveSecondEntityDtoSerializer implements Serializer<SaveSecondEntityDto> {

//    @Autowired
//    private final ObjectMapper objectMapper;

    @Override
    public byte[] serialize(String s, SaveSecondEntityDto dto) {
        var objectMapper = new ObjectMapper();
        try {
            if (dto == null){
                return null;
            }
            return objectMapper.writeValueAsBytes(dto);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing SaveSecondEntityDto to byte[]");
        }
    }
}
