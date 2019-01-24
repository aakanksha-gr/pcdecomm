package com.pcdgroup.cms.PcdEcom.BasicRegistration;

import java.util.List;

public class EmailMessageBean {

	String emailBody;
	String mobileMessageBody;
	String email;
	String mobileno;
	List<EmailMessageBean> listval;
	
	public EmailMessageBean() {
		System.out.println(emailBody);
	}

	public EmailMessageBean(String emailBody, String mobileMessageBody, String email, String mobileno, List<EmailMessageBean> listval) {
		super();
		this.emailBody = emailBody;
		System.out.println(emailBody);
		this.mobileMessageBody = mobileMessageBody;
		this.email = email;
		this.mobileno = mobileno;
		this.listval = listval;
	}

	public String getEmailBody() {
		System.out.println(emailBody);
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		System.out.println("Set"+emailBody);
		this.emailBody = emailBody;
	}

	public String getMobileMessageBody() {
		return mobileMessageBody;
	}

	public void setMobileMessageBody(String mobileMessageBody) {
		this.mobileMessageBody = mobileMessageBody;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public List<EmailMessageBean> getListval() {
		return listval;
	}

	public void setListval(List<EmailMessageBean> listval) {
		this.listval = listval;
	}
	
}
