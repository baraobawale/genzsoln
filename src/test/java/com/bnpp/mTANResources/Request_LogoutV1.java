package com.bnpp.mTANResources;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

public class Request_LogoutV1 {

	@Test
	public  void requestLogoutV1() throws ClientProtocolException, IOException {
	
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
		prop.load(fis);
			
		String sBaseURL = prop.getProperty("baseURL_Calvin");
		
		String endpoint = sBaseURL + "/ws/Logout_v1";
		File requestFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\bnpp\\mTANResources\\Logout_v1.xml");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(endpoint);
		post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));
		post.setHeader("Content-Type", "text/xml");
		HttpResponse response = client.execute(post);
		
		//System.out.println(response.getStatusLine().getStatusCode());
		assertEquals(response.getStatusLine().getStatusCode(), 200); 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line ="";
		StringBuffer sb = new StringBuffer();
		while((line=br.readLine())!=null)
		{
			sb.append(line);
		}
		
		PrintWriter pw = new PrintWriter(System.getProperty("user.dir")+"\\src\\test\\java\\com\\bnpp\\mTANResources\\logoutResponse.xml");
		pw.write(sb.toString());
		pw.close();
		pw.flush();	      
	}
}
