package com.pcdgroup.cms.PcdEcom.BasicRegistration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.pcdgroup.cms.PcdEcom.MyAccount.MyaccountService;
import com.pcdgroup.cms.PcdEcom.MyAccount.Myaccountmaster;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	RegisterRepository registerRepository; 
	
	@Autowired
	MyaccountService myaccountService;
	
	@Autowired
	private JavaMailSender sender;
	
	Passwordsecurity passwordsecurity;

	List<?> emailList;
	List<Registermaster> duplicateEmailList;
	List<Registermaster> loginUserDetailsList;
	
	protected Integer loguserid;
	public String email = null;
	
	/*
	 * Login Check.. 
	 */
	public Registermaster checkLogin(Registermaster registermaster) {
		
		try {
			
			passwordsecurity = new Passwordsecurity();
			Registermaster loginUserDetailsList = registerRepository.loginid(registermaster.getEmail(), passwordsecurity.encrypt(registermaster.getPassword()));
			
			if(loginUserDetailsList != null) {
			
				return loginUserDetailsList;
				
			} else {

				return null;
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
		
		}
	
		return null;
		
	}
	
	/*public Integer getUserId() {
		
		return loguserid;
	}*/
	
	/*
	 * View All Users with Details..
	 */
	public List<Registermaster> getAllRegisteredUsers(int startindx) {

		try {
			
			return registerRepository.getUsersList(startindx);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
		
		}
		
		return null;
	
	}

	/*
	 * Find User By ID..
	 */
	public Optional<Registermaster> getUserById(Integer id) {
		
		try {
		
			return registerRepository.findById(id);
		
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println(e);
		
		}
		
		return null;
	
	}

	/*
	 * Add New User..
	 */
	public Registermaster addUser(Registermaster registermaster, EmailMessageBean emailMessageBean) {
		
		Myaccountmaster myaccountmaster;
		Integer idForMyAccount;
		String emailBody = "";
		String messageBody = "";
		
		try {
			
			passwordsecurity = new Passwordsecurity();
			emailList = new ArrayList<>();
			emailList = registerRepository.findEmail(registermaster.getEmail());
			//String tmp = registerRepository.findEmail(registermaster.getEmail());
			System.out.println(emailList);
		
			if(null != emailList && emailList.size() > 0) {
				
				return null;
			
			} else {
				
				if(!registermaster.getPassword().equalsIgnoreCase(registermaster.getConfirmpassword())) {
						
					return null;
				
				} else {
					
					if(null != registermaster.getMobileno() || "" != registermaster.getMobileno().trim() 
							&& null != registermaster.getEmail() || "" != registermaster.getEmail().trim() ) {
						
						email = registermaster.getEmail();
						
						registermaster.setId(registerRepository.getMaxId()+1);
						registermaster.setPassword(passwordsecurity.encrypt(registermaster.getPassword()));
						registermaster.setConfirmpassword(passwordsecurity.encrypt(registermaster.getConfirmpassword()));
							
						registerRepository.save(registermaster);
						
						myaccountmaster = new Myaccountmaster();
						idForMyAccount = registermaster.getId();
						myaccountService.addMyDetails(myaccountmaster, idForMyAccount);
						
						emailBody = "Your registration with PCD Group is successsful..!";
						sendEmail(registermaster.getEmail(), emailBody);
						
						messageBody = "Your registration with PCD Group is successsful..!";
						sendSms(registermaster.getMobileno(), messageBody);
						
						if(null != registermaster.getId()) {
							
							return registerRepository.getUserDetailsById(registermaster.getId());
							
						}
					
					}
				
				}
			
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println(e);
		
		}
		
		return null;
		
	}

	/*
	 * Update Users Sending.. 
	 */
	public String updateUser(Integer rid, Registermaster registermaster) {
		
		try {
			
			registermaster.setId(rid);
			registerRepository.save(registermaster);
			
			return "User Updated..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}
	
	/*
	 * Check for duplicate Email.. 
	 */
	public String checkDuplicateEmail(Integer id, Registermaster registermaster) {
		
		duplicateEmailList = new ArrayList<>();
		duplicateEmailList = registerRepository.duplicateEmailList(registermaster.getEmail(), id);
		
		System.out.println("duplicateEmailList: "+duplicateEmailList);
		
		try {
			
			if(duplicateEmailList.size() > 0) {
				
				System.out.println("The provided Email is already exist, please try different..!");
				
				return "Error - Duplicate Email, Please try new one..!";
				
			} else {
				
				updateUser(id, registermaster);
				return "User Updated..!";
			
			}	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
		
		}
		
		return "Something went wrong..!";
		
	}

	/*
	 * Delete Users..
	 */
	public String deleteUser(Integer id) {
		Integer deletedId;
		
		try {
		
			if(id != null) {
			
				deletedId = registerRepository.getDeletedUserId(id);
				
				if(null != deletedId) {
					
					myaccountService.deleteMyAccountDetails(id);
					registerRepository.deleteById(deletedId);
				
				} else {
					
					System.out.println("User already deleted before..!");
					return "User already deleted before..!";
				
				}
				
				return "User Removed";
			
			} 
		
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println(e);
		
		}
		
		return "Something wents wrong..!";
	
	}
	
	public String sendEmail(String email, String emailBody) {
	        MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        
	        try {
			        
				 	helper.setTo(email);
				    helper.setText(emailBody);
				    helper.setSubject("PCD GROUP");
				    sender.send(message);

				    return "Email sent";
				                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
			 } catch (Exception e) {
				 
				e.printStackTrace();
				System.out.println(e);
				
			}
	        
	        return "Something wents wrong..!";
	}
	
	/*
	 * Set the Body Message for Email Body Message.. 
	 */
	/*public String emailMessageBody(EmailMessageBean emailMessageBean) {
		
		try {
			
			sendEmail(emailMessageBean.getEmail(), emailMessageBean.getEmailBody());
			
			return "OTP Send Successfully..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}*/
	
	/*
	 * Text Message Sending.. 
	 */
	public String sendSms(String mobilenumber, String messageBody) {
	
		try {
			
			String apiKey = "apikey=" + "ImUiJ75DQZ4-1mwFZXQYHC2aXVx75d8YHoEBjo2rpZ";
			String message = "&message=" + messageBody;
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers="+"91"+mobilenumber;
			System.out.println("number is "+numbers);
			String username= "&username=" + "blossomtalks@gmail.com";
			String hash = "&hash=" + "5245db29ede0bc16918f74030cb29af62859d758953a1a7e1195c4d2228afdf8";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender + username + hash;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
		
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			
			rd.close();
			
			System.out.println(stringBuffer.toString());
			
			return stringBuffer.toString();
		
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Error SMS "+e);
		
		}
	
		return "Something wents wrong..!";
		
	}
	
	/*
	 * Set the Body Message for Text Message.. 
	 */
	public String messageBody(EmailMessageBean emailMessageBean) {
			
			try {
				
				System.out.println(emailMessageBean.getEmailBody());
				
				//sendEmail(emailMessageBean.getEmail(), emailMessageBean.getEmailBody());
				
				//sendSms(emailMessageBean.getMobileno(), emailMessageBean.getMobileMessageBody());
				
				System.out.println("mobile number=> "+emailMessageBean.getMobileno() +"Mobile Body=> "+emailMessageBean.getMobileMessageBody());
				
				return "OTP Send Successfully..!";
				
			} catch (Exception e) {
				
				e.printStackTrace();
				System.out.println(e);
				
			}
			
			return "Something wents wrong..!";
			
		}

	public void getList(EmailMessageBean emailMessageBean) {
		
		System.out.println(emailMessageBean.getEmail());
		System.out.println(emailMessageBean.getEmailBody());
		System.out.println(emailMessageBean.getMobileno());
		System.out.println(emailMessageBean.getMobileMessageBody());
		
		System.out.println(emailMessageBean.getListval());
		
	}
	
}
