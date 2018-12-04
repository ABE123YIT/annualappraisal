package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.Competencie;
import com.ymagis.annualappraisal.model.Objective;

public class ObjectiveListSerializer extends StdSerializer<List<Objective>> {

	public ObjectiveListSerializer() {
		this(null);
	}

	public ObjectiveListSerializer(Class<List<Objective>> t) {
		super(t);
	}

	@Override
	public void serialize(List<Objective> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeStartArray();
		for (Objective item : items) {
			generator.writeStartObject();
			generator.writeNumberField(Constants.COL_ID, item.getId());
			generator.writeStringField(Constants.COL_CODE, item.getCode());
			generator.writeStringField(Constants.COL_LABEL, item.getLabel());
			generator.writeStringField(Constants.COL_INDICATOR, item.getIndicator());
			generator.writeStringField(Constants.COL_MEAN, item.getMean());
			generator.writeObjectField(Constants.COL_DEADLINE, item.getDeadline());
			generator.writeStringField(Constants.COL_COMMENT, item.getComment());
			generator.writeObjectField(Constants.COL_CREATED, item.getCreated());
			generator.writeObjectField(Constants.COL_UPDATED, item.getUpdated());
			generator.writeEndObject();
		}
		generator.writeEndArray();
	}
}
