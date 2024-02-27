package com.example.demo.squaregames;


import com.example.demo.squaregames.DAO.DBAccess;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//		@Override
//		public void run(String... args) throws Exception{
//			DBAccess dbAccess = DBAccess.getInstance();
//			if (dbAccess.getConnection() != null){
//				System.out.println("It worked");
//			} else {
//				System.out.println("NOOO");
//			}
//		}


}
