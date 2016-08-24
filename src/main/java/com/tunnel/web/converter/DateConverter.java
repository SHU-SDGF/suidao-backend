package com.tunnel.web.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.tunnel.util.AppConstants;

import java.io.IOException;
import java.text.DateFormat;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Converts the local date time to standard date time format
 */
public class DateConverter {
	
	final static DateFormat format = new SimpleDateFormat(AppConstants.DATE_FORMAT);

    private DateConverter() {
        //Init not required
    }

    /**
     * Serializes the LocalDateTime to string
     */
    public static class DateSerialize extends JsonSerializer<Date> {

        @Override
        public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException {
            if (value == null) {
                jgen.writeNull();
            } else {
//                jgen.writeString(format.format(value));
                jgen.writeNumber(value.getTime());
            }
        }
    }

    /**
     * DeSerializes the string to LocalDateTime
     */
    public static class DateDeserialize extends JsonDeserializer<Date> {

        @Override
        public Date deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException {
        	Long dateAsLong = jp.getValueAsLong();
            return new Date(dateAsLong);
//            String dateAsString = jp.getText();
//            if (isBlank(dateAsString)) {
//                return null;
//            } else {
//                try {
//					return format.parse(dateAsString);
//				} catch (ParseException e) {
//					throw new IOException(e);
//				}
//            }
        }
    }
}