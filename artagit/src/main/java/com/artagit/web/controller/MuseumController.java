package com.artagit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artagit.web.service.MuseumService;

@ResponseBody
@RequestMapping("/")
public class MuseumController {

	@Autowired
	private MuseumService service;
	
	
}
