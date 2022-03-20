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
        return env -> CarDetailData.allCarDetailsMapped;
    }

    public DataFetcher getFuelPricesDataFetcher() {
        return env -> FuelPriceData.allFuelPricesMapped;
    }

    public DataFetcher getCarByPlateDataFetcher() {
        return env -> {
            String licensePlate = env.getArgument("licensePlate");
            return CarDetailData.allCarDetailsMapped
                    .stream()
                    .filter(carDetail -> carDetail.get("licensePlate").equals(licensePlate))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getFuelPriceDataFetcher() {
        return env -> {
            Map<String, Object> carDetail = env.getSource();
            String country = (String) carDetail.get("country");
            return FuelPriceData.allFuelPricesMapped
                    .stream()
                    .filter(fuelPrice -> fuelPrice.get("country").equals(country))
                    .findFirst()
                    .orElse(null);
        };
    }
}
