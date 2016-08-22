package com.tunnel.web;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by jbelligund001 on 4/16/2016.
 */
@Component
public class WhiteSpaceTrimmer extends SimpleModule {

    public WhiteSpaceTrimmer() {
        addDeserializer(String.class, new StdScalarDeserializer<String>(String.class) {
            @Override
            public String deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
                final String valueAsString = jsonParser.getValueAsString();
                return (valueAsString != null) ? valueAsString.trim() : valueAsString;
            }
        });
    }
}