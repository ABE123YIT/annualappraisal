package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.SkillLevel;

public class SkillLevelListSerializer extends StdSerializer<List<SkillLevel>> {

	public SkillLevelListSerializer() {
		this(null);
	}

	public SkillLevelListSerializer(Class<List<SkillLevel>> t) {
		super(t);
	}

	@Override
	public void serialize(List<SkillLevel> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeStartArray();
		for (SkillLevel item : items) {
			generator.writeStartObject();
			generator.writeNumberField(Constants.COL_ID, item.getId());
			generator.writeNumberField(Constants.COL_RANKING, item.getRanking());
			generator.writeStringField(Constants.COL_MEANING, item.getMeaning());
			generator.writeObjectField(Constants.COL_CREATED, item.getCreated());
			generator.writeObjectField(Constants.COL_UPDATED, item.getUpdated());
			generator.writeEndObject();
		}
		generator.writeEndArray();
	}
}
