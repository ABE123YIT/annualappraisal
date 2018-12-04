package com.ymagis.annualappraisal.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.Skill;

public class SkillSerializer extends StdSerializer<Skill> {

	public SkillSerializer() {
		this(null);
	}

	public SkillSerializer(Class<Skill> t) {
		super(t);
	}

	@Override
	public void serialize(Skill item, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeObject(item);
	}
}
