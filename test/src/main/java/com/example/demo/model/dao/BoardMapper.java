package com.example.demo.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.dto.boardtb;
import com.example.demo.model.dto.formData;
import com.example.demo.model.dto.insertForm;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
	List<boardtb> selectNow(formData formdata);
	
	void insertNow(insertForm insertForm);
}
