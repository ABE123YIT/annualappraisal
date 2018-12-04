package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ymagis.annualappraisal.model.SkillEvaluation;

public class SkillEvaluationListDeserializer extends StdDeserializer<List<SkillEvaluation>> {

	public SkillEvaluationListDeserializer() {
		this(null);
	}

	public SkillEvaluationListDeserializer(Class<List<SkillEvaluation>> t) {
		super(t);
	}

	@Override
	public List<SkillEvaluation> deserialize(JsonParser jsonparser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		return new ArrayList<>();
	}
}
