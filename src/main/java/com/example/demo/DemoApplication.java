package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	DemoRepository demoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:h2:mem:testdb");
		dataSourceBuilder.username("sa");
		dataSourceBuilder.password("");
		return dataSourceBuilder.build();
	}

	@Bean
	CommandLineRunner init(JdbcTemplate jdbcTemplate) {
		return args -> {
			Util.initDbSchema(jdbcTemplate);

			Parent parent = new Parent();
			parent.setCount(10);

			OneToOne oneToOne = new OneToOne();
			oneToOne.setMin(11);
			parent.setOneToOne(oneToOne);

			Set<Day> days = new HashSet<>();
			Day monday = new Day();
			monday.setName("Monday");
			days.add(monday);
			Day thursday = new Day();
			thursday.setName("Thursday");
			days.add(thursday);
			parent.setDays(days);

			Map<String, Color> colorPallete = new HashMap<>();
			parent.setColors(colorPallete);
			Color lightRed = new Color();
			lightRed.setDescription("Light Red");
			lightRed.setHexValue("#FFCCCB");
			colorPallete.put("light-red", lightRed);
			Color pureRed = new Color();
			pureRed.setDescription("Pure Red");
			pureRed.setHexValue("#FF0000");
			colorPallete.put("red", pureRed);

			List<Car> cars = new LinkedList<>();
			parent.setCars(cars);
			Car beatle = new Car();
			beatle.setName("VW Beatle");
			cars.add(beatle);
			Car jeep = new Car();
			jeep.setName("Jeep Wrangler");
			cars.add(jeep);

			List<Orderr> orders = new LinkedList<>();
			parent.setOrders(orders);

			Orderr order = new Orderr();
			orders.add(order);
			order.setOrderNum(456);
			List<Item> items = new LinkedList<>();
			order.setItems(items);
			Item item = new Item();
			item.setName("thing 1");
			items.add(item);
			item = new Item();
			item.setName("thing 2");
			items.add(item);

			order = new Orderr();
			orders.add(order);
			order.setOrderNum(321);
			items = new LinkedList<>();
			order.setItems(items);
			item = new Item();
			item.setName("orange");
			items.add(item);
			item = new Item();
			item.setName("apple");
			items.add(item);

			demoRepository.save(parent);

			demoRepository.findAll().forEach(System.out::println);
		};
	}
}
