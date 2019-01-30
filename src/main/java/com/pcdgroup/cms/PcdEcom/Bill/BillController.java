package com.pcdgroup.cms.PcdEcom.Bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {

	@Autowired
	BillServiceImpl billServiceImpl;
	
}
