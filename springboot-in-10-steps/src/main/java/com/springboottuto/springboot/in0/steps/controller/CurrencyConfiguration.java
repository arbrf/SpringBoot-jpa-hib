package com.springboottuto.springboot.in0.steps.controller;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyConfiguration {
	private String url;
	private String userName;
	private String key;

	/*public CurrencyConfiguration(String url, String userName, String key) {
		super();
		this.url = url;
		this.userName = userName;
		this.key = key;
	}*/

	public String getUrl() {
		return url;
	}

	public String getUserName() {
		return userName;
	}

	public String getKey() {
		return key;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
