package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ymagis.annualappraisal.model.AnnualAppraisal;

public class AnnualAppraisalListDeserializer extends StdDeserializer<List<AnnualAppraisal>> {

	public AnnualAppraisalListDeserializer() {
		this(null);
	}

	public AnnualAppraisalListDeserializer(Class<List<AnnualAppraisal>> t) {
		super(t);
	}

	@Override
	public List<AnnualAppraisal> deserialize(JsonParser jsonparser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		return new ArrayList<>();
	}
}
