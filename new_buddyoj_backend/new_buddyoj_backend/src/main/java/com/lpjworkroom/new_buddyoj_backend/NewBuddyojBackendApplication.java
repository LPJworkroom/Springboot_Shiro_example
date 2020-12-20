package com.lpjworkroom.new_buddyoj_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lpjworkroom.new_buddyoj_backend.dao")
@SpringBootApplication
public class NewBuddyojBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewBuddyojBackendApplication.class, args);
	}

}
