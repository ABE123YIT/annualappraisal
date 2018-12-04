package com.ymagis.annualappraisal.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.SkillLevel;

public class SkillLevelSerializer extends StdSerializer<SkillLevel> {

	public SkillLevelSerializer() {
		this(null);
	}

	public SkillLevelSerializer(Class<SkillLevel> t) {
		super(t);
	}

	@Override
	public void serialize(SkillLevel item, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeObject(item);
	}
}
