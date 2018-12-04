package com.ymagis.annualappraisal.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.Objective;

public class ObjectiveSerializer extends StdSerializer<Objective> {

	public ObjectiveSerializer() {
		this(null);
	}

	public ObjectiveSerializer(Class<Objective> t) {
		super(t);
	}

	@Override
	public void serialize(Objective item, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeObject(item);
	}
}
