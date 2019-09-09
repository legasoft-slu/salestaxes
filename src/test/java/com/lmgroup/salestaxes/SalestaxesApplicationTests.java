package com.lmgroup.salestaxes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringRunner;

import com.lmgroup.salestaxes.services.CheckoutService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalestaxesApplicationTests {

    @Autowired
    private YAMLConfig testConfig;
	
    @Autowired
	private CheckoutService checkoutService;
	
	private String inputText1, inputText2, inputText3;
	private String outputText1, outputText2, outputText3;
	
	@Before
    public void setUp() throws Exception {
		
		initH2DB();
		
		inputText1 = testConfig.getTest().getInput().getText1();
		inputText2 = testConfig.getTest().getInput().getText2();
		inputText3 = testConfig.getTest().getInput().getText3();
		
		outputText1 = testConfig.getTest().getOutput().getText1();
		outputText2 = testConfig.getTest().getOutput().getText2();
		outputText3 = testConfig.getTest().getOutput().getText3();
		
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
	
	@Test
	public void testInput1() {
		loadH2DB();
		assertEquals(outputText1, checkoutService.sellShoppingBasket(inputText1));
	}
	
	@Test
	public void testInput2() {
		loadH2DB();
		assertEquals(outputText2, checkoutService.sellShoppingBasket(inputText2));
	}
	
	@Test
	public void testInput3() {
		loadH2DB();
		assertEquals(outputText3, checkoutService.sellShoppingBasket(inputText3));
	}

}
