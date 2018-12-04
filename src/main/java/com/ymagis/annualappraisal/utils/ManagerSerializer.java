package com.ymagis.annualappraisal.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.Employee;

public class ManagerSerializer extends StdSerializer<Employee> {

	public ManagerSerializer() {
		this(null);
	}

	public ManagerSerializer(Class<Employee> t) {
		super(t);
	}

	@Override
	public void serialize(Employee item, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeObject(item);
	}
}
