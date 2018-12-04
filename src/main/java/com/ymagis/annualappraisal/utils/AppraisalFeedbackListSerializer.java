package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.AppraisalFeedback;

public class AppraisalFeedbackListSerializer extends StdSerializer<List<AppraisalFeedback>> {

	public AppraisalFeedbackListSerializer() {
		this(null);
	}

	public AppraisalFeedbackListSerializer(Class<List<AppraisalFeedback>> t) {
		super(t);
	}

	@Override
	public void serialize(List<AppraisalFeedback> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeStartArray();
		for (AppraisalFeedback item : items) {
			generator.writeStartObject();
			generator.writeNumberField(Constants.COL_ID, item.getId());
			generator.writeStringField(Constants.COL_COMMENT, item.getComment());
			generator.writeObjectField(Constants.COL_CREATED, item.getCreated());
			generator.writeObjectField(Constants.COL_UPDATED, item.getUpdated());
			generator.writeEndObject();
		}
		generator.writeEndArray();
	}
}
