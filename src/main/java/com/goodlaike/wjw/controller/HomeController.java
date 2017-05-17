package com.goodlaike.wjw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("helloworld")
	protected String helloworld() {
		return "helloworld";
	}
}
