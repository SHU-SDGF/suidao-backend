package com.tunnel.model.converters;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<Date, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(Date attribute) {
		 return (attribute!=null)?new Timestamp(attribute.getTime()):null;
	}

	@Override
	public Date convertToEntityAttribute(Timestamp dbData) {
		 return (dbData!=null)?new Date(dbData.getTime()):null;
	}

}
