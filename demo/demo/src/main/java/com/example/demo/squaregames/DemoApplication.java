package com.example.demo.squaregames;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication{
	private  static Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

		LOGGER.info("(ง'̀-'́)ง BEEP BOOP, WE ARE ONLINE SJ, TIME TO GET BUSY! (づ｡◕‿‿◕｡)づ ");
	}

}
