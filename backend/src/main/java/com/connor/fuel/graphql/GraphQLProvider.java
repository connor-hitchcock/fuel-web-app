package com.connor.fuel.graphql;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Autowired
    GraphQLDataFetchers dataFetchers;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("graphql/schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("carDetails", dataFetchers.getCarDetailsDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("fuelPrices", dataFetchers.getFuelPricesDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("people", dataFetchers.getPersonDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("personCars", dataFetchers.getPersonCarDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("carByPlate", dataFetchers.getCarByPlateDataFetcher()))
                .type(newTypeWiring("CarDetail") //TODO don't think this name is correct
                        .dataFetcher("fuelPrice", dataFetchers.getFuelPriceDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("personByEmail", dataFetchers.getPersonByEmailDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("peopleByFirstName", dataFetchers.getPeopleByFirstNameDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("peopleByFirstLastName", dataFetchers.getPeopleByFirstLastNameDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("ownedCars", dataFetchers.getPersonCarsByEmailDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("personCarsByEmail", dataFetchers.getPersonCarsByEmailDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("personCarsByPlate", dataFetchers.getPersonCarsByLicensePlateDataFetcher()))
                .type(newTypeWiring("Query")
                        .dataFetcher("personCarsByIDPlate", dataFetchers.getPersonCarByEmailLicensePlateDataFetcher()))
                .build();
    }


}

































