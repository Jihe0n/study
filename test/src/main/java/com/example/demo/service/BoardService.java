package com.example.demo.service;

import com.example.demo.model.dto.boardtb;
import com.example.demo.model.dto.formData;

import java.util.List;

public interface BoardService {
	public List<boardtb> selectNow(formData formdata);
}
