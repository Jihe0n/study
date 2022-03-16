package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.demo.model.dto.boardtb;
import com.example.demo.model.dto.formData;
import com.example.demo.service.BoardService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardtbController {
	
	private final BoardService boardService;


	  @PostMapping("/test")
	  public List<boardtb> none(@RequestBody formData formdata) {
	    return boardService.selectNow(formdata);
	  }
	  
	  
	 
	  
}











