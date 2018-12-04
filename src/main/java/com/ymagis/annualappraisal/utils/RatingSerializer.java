package com.ymagis.annualappraisal.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.Rating;

public class RatingSerializer extends StdSerializer<Rating> {

	public RatingSerializer() {
		this(null);
	}

	public RatingSerializer(Class<Rating> t) {
		super(t);
	}

	@Override
	public void serialize(Rating item, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeObject(item);
	}
}
