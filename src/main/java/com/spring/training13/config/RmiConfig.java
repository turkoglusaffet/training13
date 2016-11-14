package com.spring.training13.config;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.spring.training13.service.UserService;


@Configuration
public class RmiConfig {

	@Autowired
	@Qualifier("userRmiService")
	UserService userService;
	
	@Bean
	public RmiServiceExporter rmiServiceExporter() throws RemoteException {
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setService(userService);
		exporter.setServiceName("userRmiService");
		exporter.setServiceInterface(UserService.class);
		exporter.setRegistryPort(5000);
		return exporter;
	}
}
