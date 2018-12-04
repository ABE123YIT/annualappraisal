package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.Rating;

public class RatingListSerializer extends StdSerializer<List<Rating>> {

	public RatingListSerializer() {
		this(null);
	}

	public RatingListSerializer(Class<List<Rating>> t) {
		super(t);
	}

	@Override
	public void serialize(List<Rating> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeStartArray();
		for (Rating item : items) {
			generator.writeStartObject();
			generator.writeNumberField(Constants.COL_ID, item.getId());
			generator.writeStringField(Constants.COL_CODE, item.getCode());
			generator.writeStringField(Constants.COL_LABEL, item.getLabel());
			generator.writeObjectField(Constants.COL_CREATED, item.getCreated());
			generator.writeObjectField(Constants.COL_UPDATED, item.getUpdated());
			generator.writeEndObject();
		}
		generator.writeEndArray();
	}
}
