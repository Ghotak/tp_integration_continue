package com.integrationcontinue.controllers;

import com.integrationcontinue.Controller.ClientController;
import com.integrationcontinue.Entity.Client;
import com.integrationcontinue.Entity.Contrat;
import com.integrationcontinue.Entity.Product;
import com.integrationcontinue.Service.ClientService;
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
@WebMvcTest(value = ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    Contrat contrat = new Contrat(1, "ContratUn", 5.0);
    Client c1 = new Client(1, "Colin", "HENIQUE", "", contrat);
    List<Client> clientList= new ArrayList<>();

    @Test
    public void testFindAll() throws Exception {
        clientList.add(c1);

        Mockito.when(clientService.listAll()).thenReturn(clientList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/clients")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().getContentAsString());

        String expected = "[{\"id\":1,\"nom\":\"Colin\",\"prenom\":\"HENIQUE\",\"identifiant\":\"\",\"id_contrat\":{\"id\":1,\"libelle\":\"ContratUn\",\"reduction\":5.0}}]\n";

        Assertions.assertEquals(expected, result.getResponse().getContentAsString());

    }

    @ParameterizedTest
    @MethodSource("chargerJeuDeTest")
    public void testFindById(Client client, String expected) throws Exception{
        Mockito.when(clientService.get(client.getId())).thenReturn(client);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/clients/"+client.getId())
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().getContentAsString());

        Assertions.assertEquals(expected, result.getResponse().getContentAsString());
    }

    // méthode fournissant les données de test
    static Stream<Arguments> chargerJeuDeTest() throws Throwable {

        Contrat contrat = new Contrat(1, "ContratUn", 5.0);
        Client c1 = new Client(1, "Colin", "HENIQUE", "", contrat);

        return Stream.of(
                Arguments.of(c1, "{\"id\":1,\"nom\":\"Colin\",\"prenom\":\"HENIQUE\",\"identifiant\":\"\",\"id_contrat\":{\"id\":1,\"libelle\":\"ContratUn\",\"reduction\":5.0}}")
        );
    }
}
