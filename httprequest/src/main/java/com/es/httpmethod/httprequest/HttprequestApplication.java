package com.es.httpmethod.httprequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;

public class HttprequestApplication {

    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, HttpException, IOException  {
    	HttprequestApplication httprequestApplication = new HttprequestApplication();
    	
    	httprequestApplication.fetchDataFromServer();
    }
    	
    	public static String fetchDataFromServer() throws HttpException, IOException, NoSuchAlgorithmException, KeyManagementException
    	{
    	
    	try {
            URL u = new URL("https://localhost:9200");
            HttpsURLConnection http = (HttpsURLConnection)u.openConnection();
            Authenticator.setDefault( new MyAuthenticator() );
            http.setAllowUserInteraction(true);
            http.setRequestMethod("GET");
            http.connect();

            InputStream is = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                stringBuilder.append(line + "\n");
                System.out.println("working");
            }
            return stringBuilder.toString();    
        }
        catch (IOException ioe) {

            return null;
        }
    	}
    

    }
