package com.example.demo.service;

import com.example.demo.model.dto.boardtb;
import com.example.demo.model.dto.formData;
import com.example.demo.model.dto.insertForm;

import java.util.List;

public interface BoardService {
	public List<boardtb> selectNow(formData formdata);
	
	public void insertNow(insertForm insertForm);
}
