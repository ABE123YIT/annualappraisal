package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ymagis.annualappraisal.model.SkillLevel;

public class SkillLevelListDeserializer extends StdDeserializer<List<SkillLevel>> {

	public SkillLevelListDeserializer() {
		this(null);
	}

	public SkillLevelListDeserializer(Class<List<SkillLevel>> t) {
		super(t);
	}

	@Override
	public List<SkillLevel> deserialize(JsonParser jsonparser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		return new ArrayList<>();
	}
}
