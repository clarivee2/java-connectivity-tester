/**
 * 
 */
package com.personal.clarivee.connectivitytester.services;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Christian
 *
 */
public class testPort implements ItestPort {
	
	private String ip;
	private int port;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	@Override
	public String Run() throws Exception {
    String result;
		
		// setup and run the DNS test
		try {
			Socket socket = new Socket(ip, port);
		    result = "PORT Test for host:port " + ip + ":" + port + " connected OK";
		    System.out.println("PORT Test - " + result); 
		    socket.close();
			
		} catch(UnknownHostException e) {
			result = "unkown host:port " + ip + ":" + port;
			System.out.println("PORT Test - " + result);
		} catch (IOException e) {
		    result = "IP Test for host:port " + ip + ":" + port + " connected FAIL";
		}
		
		return result;
	}
	
	// build constructor
	public testPort(String Ip, int Port) {
		this.ip = Ip;
		this.port = Port;
	}

}
