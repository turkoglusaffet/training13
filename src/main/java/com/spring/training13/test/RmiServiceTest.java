package com.spring.training13.test;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.spring.training13.entity.TblUser;
import com.spring.training13.service.UserService;

public class RmiServiceTest {

	public static void main(String[] args) {
		RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
		proxy.setServiceInterface(UserService.class);
		proxy.setServiceUrl("rmi://localhost:5000/userRmiService");
		proxy.afterPropertiesSet();
		UserService service = (UserService) proxy.getObject();
		TblUser user = service.getUser(1);
		
		System.out.println(user);
		
	}

}
