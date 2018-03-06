package com.fatserver.helpers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Victor on 06.03.2018.
 */
public class JsonDateSerializer extends JsonSerializer<Timestamp> {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void serialize(Timestamp arg0, JsonGenerator arg1, SerializerProvider arg2)
            throws IOException, JsonProcessingException {
        String formattedDate = dateFormat.format(arg0);
        arg1.writeString(formattedDate);
    }

}