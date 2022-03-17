package com.example.demo.model.dto;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@NoAutoStart
public class boardtb {
	private String boardId;
	private String title;
	private String contents;
	private String createId;
	private String createDtime;
	private String lastId;
	private String lastDtime;
	private String userNm; 
}
