package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.dao.BoardMapper;
import com.example.demo.model.dto.boardtb;
import com.example.demo.model.dto.formData;
import com.example.demo.model.dto.insertForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper boardMapper;

	
	
    @Override
    public List<boardtb> selectNow(formData formdata) {

    	
        return boardMapper.selectNow(formdata);
    }



	@Override
	public void insertNow(insertForm insertForm) {
		boardMapper.insertNow(insertForm);
		
	}

	
}