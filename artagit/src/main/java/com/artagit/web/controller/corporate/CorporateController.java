package com.artagit.web.controller.corporate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artagit.web.service.CorporateService;

@ResponseBody
@RequestMapping("/")
public class CorporateController {

	@Autowired
	private CorporateService service;
}
