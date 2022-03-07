package com.connor.fuel.graphql;

import com.connor.fuel.data.CarDetailData;
import com.connor.fuel.data.FuelPriceData;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GraphQLDataFetchers {
    //Using hardcoded data at the moment

    public DataFetcher getCarDetailsDataFetcher() {
        return dataFetchingEnvironment -> CarDetailData.allCarDetailsMapped;
    }

    public DataFetcher getFuelPricesDataFetcher() {
        return dataFetchingEnvironment -> FuelPriceData.allFuelPricesMapped;
    }

    public DataFetcher getCarByPlateDataFetcher() {
        return dataFetchingEnvironment -> {
            String licensePlate = dataFetchingEnvironment.getArgument("licensePlate");
            return CarDetailData.allCarDetailsMapped
                    .stream()
                    .filter(carDetail -> carDetail.get("licensePlate").equals(licensePlate))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getFuelPriceDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, Object> carDetail = dataFetchingEnvironment.getSource();
            String country = (String) carDetail.get("country");
            return FuelPriceData.allFuelPricesMapped
                    .stream()
                    .filter(fuelPrice -> fuelPrice.get("country").equals(country))
                    .findFirst()
                    .orElse(null);
        };
    }
}
