package br.com.spring.boot.teste;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.spring.boot.teste.repository.PlanetaRepository;

@ComponentScan
@EnableMongoRepositories
@SpringBootApplication
public class Application {

	@Resource
	private PlanetaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

//	@PostConstruct
//	public void loadData() {
//		List<Product> products = new ArrayList<>();
//		int id = 1;
//		products.add(new Notebook(id++, "Apple", "MacBook Pro", 15));
//		products.add(new SmartPhone(id++, "Motorola", "Moto X", 5, true, true));
//		products.add(new SmartPhone(id++, "Apple", "Iphone 6 Plus", 6, true, true));
//		products.add(new Pendrive(id++, "Kingston", "Data Traveler ", 16));
//		products.add(new Pendrive(id++, "Sandisk", "Cruzer Fit", 32));
//		products.add(new SmartPhone(id++, "Nokia", "6230", 6, true, false));
//		repository.save(products);
//	}

}