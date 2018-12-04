package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ymagis.annualappraisal.model.Rating;

public class RatingListDeserializer extends StdDeserializer<List<Rating>> {

	public RatingListDeserializer() {
		this(null);
	}

	public RatingListDeserializer(Class<List<Rating>> t) {
		super(t);
	}

	@Override
	public List<Rating> deserialize(JsonParser jsonparser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		return new ArrayList<>();
	}
}
