package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ymagis.annualappraisal.model.Objective;

public class ObjectiveListDeserializer extends StdDeserializer<List<Objective>> {

	public ObjectiveListDeserializer() {
		this(null);
	}

	public ObjectiveListDeserializer(Class<List<Objective>> t) {
		super(t);
	}

	@Override
	public List<Objective> deserialize(JsonParser jsonparser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		return new ArrayList<>();
	}
}
