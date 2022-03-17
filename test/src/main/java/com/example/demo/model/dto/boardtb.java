package com.example.demo.model.dto;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@NoAutoStart
public class boardtb {
	private String board_id;
	private String title;
	private String contents;
	private String create_id;
	private String create_dtime;
	private String last_id;
	private String last_dtime;
	private String user_nm; 
}
