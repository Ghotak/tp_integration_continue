package com.integrationcontinue.controllers;


import com.integrationcontinue.Controller.ProductController;
import com.integrationcontinue.Entity.Product;
import com.integrationcontinue.Service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    Product p1 = new Product(1,"Casque",20);
    Product p2 = new Product(2,"Actimel",20);

    List<Product> productList= new ArrayList<>();

    @Test
    public void testFindAll() throws Exception {
        productList.add(p1);
        productList.add(p2);

        Mockito.when(productService.listAll()).thenReturn(productList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().getContentAsString());

        String expected = "[{\"id\":1,\"name\":\"Casque\",\"price\":20.0},{\"id\":2,\"name\":\"Actimel\",\"price\":20.0}]";

        Assertions.assertEquals(expected, result.getResponse().getContentAsString());

    }

    @ParameterizedTest
    @MethodSource("chargerJeuDeTest")
    public void testFindById(Product product, String expected) throws Exception{
        Mockito.when(productService.get(product.getId())).thenReturn(product);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products/"+product.getId())
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().getContentAsString());

        Assertions.assertEquals(expected, result.getResponse().getContentAsString());
    }

    // méthode fournissant les données de test
    static Stream<Arguments> chargerJeuDeTest() throws Throwable {

        Product p1 = new Product(1,"Casque",20);
        Product p2 = new Product(2,"Actimel",20);

        return Stream.of(
                Arguments.of(p1, "{\"id\":1,\"name\":\"Casque\",\"price\":20.0}"),
                Arguments.of(p2, "{\"id\":2,\"name\":\"Actimel\",\"price\":20.0}")
        );
    }
}
