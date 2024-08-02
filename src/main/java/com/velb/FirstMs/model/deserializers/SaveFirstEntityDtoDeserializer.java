package com.velb.FirstMs.model.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velb.FirstMs.model.dto.SaveFirstEntityDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SaveFirstEntityDtoDeserializer implements Deserializer<SaveFirstEntityDto> {

//    @Autowired
//    private final ObjectMapper objectMapper;

    @Override
    public SaveFirstEntityDto deserialize(String s, byte[] bytes) {
        var objectMapper = new ObjectMapper();
        try {
            if (bytes == null){
                return null;
            }
            return objectMapper.readValue(new String(bytes), SaveFirstEntityDto.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to SaveFirstEntityDto");
        }
    }
}
