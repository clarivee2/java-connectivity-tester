package com.personal.clarivee.connectivitytester.controllers.rest;

import org.springframework.web.bind.annotation.RestController;

import com.personal.clarivee.connectivitytester.services.Constants.enumDatabaseTypes;
import com.personal.clarivee.connectivitytester.services.testDNS;
import com.personal.clarivee.connectivitytester.services.testDbConnect;
import com.personal.clarivee.connectivitytester.services.testPort;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class ConnectivityapiController {
	
	@RequestMapping("/api")
	public String index() {
		return "top folder -try a sub-api";
	}
	
	/// run connectivity test
	@RequestMapping("/api/runconnectivitytest")
	public String runconnectivitytest() throws Exception {
		// TODO - change to proper MVC
		String result;
		result = new testDNS("www.google.com").Run();
		result += "\n" + new testPort("127.0.0.1", 80).Run();
		result += "\n" + new testPort("localhost", 5432).Run();
		result += "\n" + new testPort("wwwec7.manulife.com", 80).Run();
		result += "\n" + new testDbConnect("jdbc:postgresql://localhost:5432/postgres","sa","").Run();
		return result;
	}
	
	@RequestMapping("/api/listconnectivitytests")
	public String listconnectivitytests() {
		return "NOT IMPLEMENTED - list of specific connectivity tests";
	}

}
