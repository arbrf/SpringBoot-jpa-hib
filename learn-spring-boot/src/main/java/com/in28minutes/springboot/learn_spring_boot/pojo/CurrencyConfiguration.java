package com.in28minutes.springboot.learn_spring_boot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "currency-service")
public class CurrencyConfiguration {
	private String url;
	private String username;
	private String key;

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getKey() {
		return key;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "CurrencyConfiguration [url=" + url + ", username=" + username + ", key=" + key + "]";
	}

}
