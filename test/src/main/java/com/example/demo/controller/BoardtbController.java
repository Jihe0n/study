package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.demo.model.dto.boardtb;
import com.example.demo.model.dto.formData;
import com.example.demo.model.dto.sumDto;
import com.example.demo.service.BoardService;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardtbController {
	
	private final BoardService boardService;

		
	  @PostMapping("/post")
	  public int testPost(@RequestBody sumDto sumDto) {
		  log.info(sumDto.toString());
		  return sumDto.getInt1() + sumDto.getInt2();
	  }
	  
	  @GetMapping("/get")
	  public int testGet(sumDto sumDto) {
		  log.info(sumDto.toString());
		  return sumDto.getInt1() + sumDto.getInt2();
	  }
	  

	  @PostMapping("/boardPost")
	  public List<boardtb> none(@RequestBody formData formdata) {
	    return boardService.selectNow(formdata);
	  }
	  
	  @PostMapping("/board")
	  public String none2(@RequestBody formData formdata) {
	    return formdata.toString();
	  }
	  
	  
	 
	  
}











