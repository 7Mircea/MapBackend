package com.example.backendMongo;

import com.example.backendMongo.dao.RestaurantRepository;
import com.example.backendMongo.model.Location;
import com.example.backendMongo.model.Restaurant;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackendMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendMongoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(RestaurantRepository repository, MongoTemplate mongoTemplate) {
        return args -> {

            List<Restaurant> list = getRestaurantsFromCSVFile();
            repository.findRestaurantByRestaurantLink("g9867250-d14979687")
                    .ifPresentOrElse(restaurant -> {
                        System.out.println(restaurant + " already exists ");
                    }, () -> {
                        System.out.println("Inserting student ");
                        repository.insert(list);
                    });
            list.clear();
        };
    }

    public List<Restaurant> getRestaurantsFromCSVFile() {
        File csvFile = null;
        List<Restaurant> list = new ArrayList<>(1000000);
        try {
            csvFile = ResourceUtils.getFile("classpath:file.csv");//you have to manualy add to the folder there the .class files are(target/classes dir)
            CSVParser csvParser = CSVFormat.DEFAULT.parse(new InputStreamReader(new FileInputStream(csvFile)));
            for (CSVRecord record : csvParser) {
                list.add(new Restaurant(record.get(0),
                        record.get(1),
                        getLocation(record.get(2)),
                        record.get(3),
                        record.get(4),
                        record.get(5),
                        record.get(6),
                        record.get(7),
                        record.get(8),
                        record.get(9)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Location getLocation(String line) throws Exception {
        line = line.replace("[", " ").replace("]", "")
                .replace("\"", "");
        String[] array = line.split(",");
        Location location = new Location();
        for (String val : array) {
            location.add(val);
        }
        return location;
    }


}
