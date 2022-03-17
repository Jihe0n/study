package com.example.demo.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.dto.boardtb;
import com.example.demo.model.dto.formData;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
	List<boardtb> selectNow(formData formdata);
}
