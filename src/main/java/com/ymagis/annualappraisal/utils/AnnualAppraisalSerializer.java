package com.ymagis.annualappraisal.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.AnnualAppraisal;

public class AnnualAppraisalSerializer extends StdSerializer<AnnualAppraisal> {

	public AnnualAppraisalSerializer() {
		this(null);
	}

	public AnnualAppraisalSerializer(Class<AnnualAppraisal> t) {
		super(t);
	}

	@Override
	public void serialize(AnnualAppraisal item, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeObject(item);
	}
}
