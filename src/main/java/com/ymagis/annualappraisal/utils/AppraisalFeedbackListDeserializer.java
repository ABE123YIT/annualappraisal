package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ymagis.annualappraisal.model.AppraisalFeedback;

public class AppraisalFeedbackListDeserializer extends StdDeserializer<List<AppraisalFeedback>> {

	public AppraisalFeedbackListDeserializer() {
		this(null);
	}

	public AppraisalFeedbackListDeserializer(Class<List<AppraisalFeedback>> t) {
		super(t);
	}

	@Override
	public List<AppraisalFeedback> deserialize(JsonParser jsonparser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		return new ArrayList<>();
	}
}
