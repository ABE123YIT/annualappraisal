package com.ymagis.annualappraisal.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.SkillEvaluation;

public class SkillEvaluationSerializer extends StdSerializer<SkillEvaluation> {

	public SkillEvaluationSerializer() {
		this(null);
	}

	public SkillEvaluationSerializer(Class<SkillEvaluation> t) {
		super(t);
	}

	@Override
	public void serialize(SkillEvaluation item, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeObject(item);
	}
}
