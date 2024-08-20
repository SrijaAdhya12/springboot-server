package com.example.springboot_server;

import io.github.cdimascio.dotenv.Dotenv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import io.github.cdimascio.dotenv.DotenvException;

@SpringBootApplication
public class SpringbootServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PATCH", "PUT", "DELETE");
			}
		};
	}

	@Configuration
	public static class EnvConfig {
		@Bean
		public Dotenv dotenv() {
			try {
				return Dotenv.configure().directory("/app").load();
			} catch (DotenvException e) {
				throw new RuntimeException("Failed to load .env file", e);
			}
		}
		
	}

		@ConfigurationProperties(prefix = "spring.datasource")
		@Bean
		public DatabaseConfig databaseConfig(Environment environment) {
			return new DatabaseConfig(
					environment.getProperty("username"),
					environment.getProperty("password"),
					environment.getProperty("url"));
		}
	}

	class DatabaseConfig {
		private String username;
		private String password;
		private String url;

		public DatabaseConfig(String username, String password, String url) {
			this.username = username;
			this.password = password;
			this.url = url;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

}
