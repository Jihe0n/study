package com.example.demo.model.dto;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoAutoStart
public class formData {
	public formData() {
		
	}
	private String selectOption;
	private String inputValue;
}
