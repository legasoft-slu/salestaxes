package com.lmgroup.salestaxes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
public class SalestaxesApplication {

	public static void main(String[] args) {
		initH2DB();
		SpringApplication.run(SalestaxesApplication.class, args);
		loadH2DB();
	}
	
	private static void initH2DB() {
		EmbeddedDatabase db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("testdb;MODE=Oracle;INIT=create Schema if not exists SALESTAXES;")
                .addScript("/sql/dropProductsTable.sql")
                .addScript("/sql/dropProductTypesTable.sql")
                .addScript("/sql/dropTaxesTable.sql")
                .addScript("/sql/createTaxesTable.sql")
                .addScript("/sql/createProductTypesTable.sql")
                .addScript("/sql/createProductsTable.sql")
                .build();
	}
	
	private static void loadH2DB() {
		EmbeddedDatabase db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("testdb;MODE=Oracle;")
                .addScript("/sql/insertTaxesIntoTable.sql")
                .addScript("/sql/insertProductTypesIntoTable.sql")
                .addScript("/sql/insertProductsIntoTable.sql")
                .build();
	}

}
