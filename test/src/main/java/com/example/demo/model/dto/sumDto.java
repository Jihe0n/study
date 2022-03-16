package com.example.demo.model.dto;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoAutoStart
public class sumDto {
	private String text;
	private int int1;
	private int int2;
}
