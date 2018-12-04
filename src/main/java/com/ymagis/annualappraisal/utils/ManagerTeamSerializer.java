package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.Employee;

public class ManagerTeamSerializer extends StdSerializer<Set<Employee>> {

	public ManagerTeamSerializer() {
		this(null);
	}

	public ManagerTeamSerializer(Class<Set<Employee>> t) {
		super(t);
	}

	@Override
	public void serialize(Set<Employee> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		Set<Long> ids = new HashSet<>();
		for (Employee item : items) {
			ids.add(item.getId());
		}
		generator.writeObject(ids);
	}
}
