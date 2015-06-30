package com.trainerworkout.trainee.helper;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.squareup.okhttp.OkHttpClient;

import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.client.Request;
import retrofit.client.Response;

public class HttpClientSingleton {
	
	private static OkClient instance = null;
	
	public HttpClientSingleton(){
		if(null == instance){
			//First create a new okhttpClient (this is okhttpnative)
			OkHttpClient client = new OkHttpClient(); //create OKHTTPClient
			//create a cookieManager so your client can be cookie persistant
			CookieManager cookieManager = new CookieManager();
			cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
			client.setCookieHandler(cookieManager); //finally set the cookie handler on client

			//OkClient is retrofit default client, ofcourse since is based on OkHttClient
			//you can decorate your existing okhttpclient with retrofit's okClient
			OkClient serviceClient = new OkClient(client);
			
			this.instance = serviceClient;
		}
	}
	
	public static OkClient getInstance(){
		return instance;
	}

}
