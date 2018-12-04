package com.ymagis.annualappraisal.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.AnnualSession;

public class AnnualSessionSerializer extends StdSerializer<AnnualSession> {

	public AnnualSessionSerializer() {
		this(null);
	}

	public AnnualSessionSerializer(Class<AnnualSession> t) {
		super(t);
	}

	@Override
	public void serialize(AnnualSession item, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeObject(item);
	}
}
