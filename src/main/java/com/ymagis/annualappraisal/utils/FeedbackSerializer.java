package com.ymagis.annualappraisal.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.Feedback;

public class FeedbackSerializer extends StdSerializer<Feedback> {

	public FeedbackSerializer() {
		this(null);
	}

	public FeedbackSerializer(Class<Feedback> t) {
		super(t);
	}

	@Override
	public void serialize(Feedback item, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeObject(item);
	}
}
