package data;

import model.CarDetails;

import java.util.List;

public class CarDetailsData {
    public static CarDetails connorCorolla = new CarDetails(
            "AAA111",
            1.8f,
            147,
            180,
            CarDetails.FuelType.PETROL91,
            9.9f,
            7.0f,
            "Toyota",
            "Auris",
            2010,
            "New Zealand"
    );

    public static CarDetails connorAudiA4 = new CarDetails(
            "BBB222",
            2.7f,
            190,
            400,
            CarDetails.FuelType.DIESEL,
            9.0f,
            6.3f,
            "Audi",
            "A4",
            2008,
            "New Zealand"
    );

    public static CarDetails connorDemio = new CarDetails(
            "CCC333",
            1.3f,
            86,
            122,
            CarDetails.FuelType.PETROL91,
            7.2f,
            5.5f,
            "Mazda",
            "Demio",
            2007,
            "New Zealand"
    );

    public static CarDetails connorJetta = new CarDetails(
            "DDD444",
            2.0f,
            140,
            320,
            CarDetails.FuelType.DIESEL,
            7.7f,
            5.7f,
            "Volkswagen",
            "Jetta",
            2006,
            "New Zealand"
    );

    public static CarDetails fatherBigHorn = new CarDetails(
            "EEE555",
            3.1f,
            133,
            294,
            CarDetails.FuelType.DIESEL,
            13.5f,
            10.5f,
            "Isuzu",
            "Big Horn",
            1996,
            "New Zealand"
    );

    public static CarDetails fatherCorolla = new CarDetails(
            "FFF666",
            2.0f,
            126,
            300,
            CarDetails.FuelType.DIESEL,
            7.2f,
            5.3f,
            "Toyota",
            "Corolla",
            2009,
            "New Zealand"
    );

    public static CarDetails alexSwift = new CarDetails(
            "GGG777",
            1.5f,
            102,
            133,
            CarDetails.FuelType.PETROL91,
            8.4f,
            6.3f,
            "Suzuki",
            "Swift",
            2008,
            "New Zealand"
    );

    public static List<CarDetails> allCars = List.of(connorCorolla, connorAudiA4, connorDemio, connorJetta,
            fatherBigHorn, fatherCorolla, alexSwift);
}
