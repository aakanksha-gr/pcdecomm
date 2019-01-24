package com.pcdgroup.cms.PcdEcom.Dealor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealorController {

	@Autowired
	DealorServiceImpl dealorServiceImpl;
	
}
