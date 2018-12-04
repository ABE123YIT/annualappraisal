package com.ymagis.annualappraisal.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ymagis.annualappraisal.model.Employee;

public class ManagerDeserializer extends StdDeserializer<Employee> {

	public ManagerDeserializer() {
		this(null);
	}

	public ManagerDeserializer(Class<Employee> t) {
		super(t);
	}

	@Override
	public Employee deserialize(JsonParser jsonparser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		return new Employee();
	}
}
