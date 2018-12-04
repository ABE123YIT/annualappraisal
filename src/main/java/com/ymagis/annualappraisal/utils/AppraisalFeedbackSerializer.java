package com.ymagis.annualappraisal.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.AppraisalFeedback;

public class AppraisalFeedbackSerializer extends StdSerializer<AppraisalFeedback> {

	public AppraisalFeedbackSerializer() {
		this(null);
	}

	public AppraisalFeedbackSerializer(Class<AppraisalFeedback> t) {
		super(t);
	}

	@Override
	public void serialize(AppraisalFeedback item, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeObject(item);
	}
}
