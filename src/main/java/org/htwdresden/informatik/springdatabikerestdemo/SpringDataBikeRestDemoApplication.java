package org.htwdresden.informatik.springdatabikerestdemo;

import org.htwdresden.informatik.springdatabikerestdemo.model.Bike;
import org.htwdresden.informatik.springdatabikerestdemo.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class SpringDataBikeRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataBikeRestDemoApplication.class, args);
	}

}

@Component
class BikeRestCommandLineRunner implements CommandLineRunner {

	// this will inject the bike repository
	@Autowired
	BikeRepository bikeRepository;

	@Override
	public void run(String... args) throws Exception {

		List<Bike> allBikes = (List<Bike>) bikeRepository.findAll();

		System.out.println("There are "+allBikes.size()+" bikes in the repository.");
		for(Bike bike : allBikes) {
			System.out.println(bike.toString());
		}
	}
}
