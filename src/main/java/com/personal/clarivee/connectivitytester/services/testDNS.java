package com.personal.clarivee.connectivitytester.services;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class testDNS implements ItestDNS {
	
	private String dnsentry;

	public void setDNSEntry(String DNSEntry) {
		dnsentry = DNSEntry;
	}
	
	public String getDNSEntry() {
		return dnsentry;
	}
	
	@Override
	public String Run() throws Exception{
    String result;
		
		// setup and run the DNS test
		try {
			InetAddress inetHost = InetAddress.getByName(dnsentry);
		    String hostName = inetHost.getHostName();
		    String hostAddress = inetHost.getHostAddress();
		    result = "DNS test for host: " + hostName + " resolved to address: " + hostAddress;
		    System.out.println("DNS Test - " + result); 
			
		} catch(UnknownHostException e) {
			result = "unkown host " + dnsentry;
			System.out.println("DNS Test - " + result);
		}
		
		return result;
	}
	
	/// test runner for DNS - takes in a string to override the one already in place
	public String Run(String DNSEntry) throws Exception {
				
		dnsentry = DNSEntry;
		return Run();
	}
	
	// string constructor
	public testDNS(String DNSEntry) {
		this.dnsentry = DNSEntry;
	}

}
