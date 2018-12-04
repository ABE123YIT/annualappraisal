package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ymagis.annualappraisal.model.Competencie;

public class CompetencieListDeserializer extends StdDeserializer<List<Competencie>> {

	public CompetencieListDeserializer() {
		this(null);
	}

	public CompetencieListDeserializer(Class<List<Competencie>> t) {
		super(t);
	}

	@Override
	public List<Competencie> deserialize(JsonParser jsonparser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		return new ArrayList<>();
	}
}
