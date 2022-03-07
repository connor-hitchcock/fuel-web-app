package data;

import model.CarDetail;

import java.util.List;
import java.util.Map;

public class CarDetailData {
    public static CarDetail connorCorolla = new CarDetail(
            "AAA111",
            1.8f,
            147,
            180,
            CarDetail.FuelType.PETROL91,
            9.9f,
            7.0f,
            "Toyota",
            "Auris",
            2010,
            "New Zealand"
    );

    public static CarDetail connorAudiA4 = new CarDetail(
            "BBB222",
            2.7f,
            190,
            400,
            CarDetail.FuelType.DIESEL,
            9.0f,
            6.3f,
            "Audi",
            "A4",
            2008,
            "New Zealand"
    );

    public static CarDetail connorDemio = new CarDetail(
            "CCC333",
            1.3f,
            86,
            122,
            CarDetail.FuelType.PETROL91,
            7.2f,
            5.5f,
            "Mazda",
            "Demio",
            2007,
            "New Zealand"
    );

    public static CarDetail connorJetta = new CarDetail(
            "DDD444",
            2.0f,
            140,
            320,
            CarDetail.FuelType.DIESEL,
            7.7f,
            5.7f,
            "Volkswagen",
            "Jetta",
            2006,
            "New Zealand"
    );

    public static CarDetail fatherBigHorn = new CarDetail(
            "EEE555",
            3.1f,
            133,
            294,
            CarDetail.FuelType.DIESEL,
            13.5f,
            10.5f,
            "Isuzu",
            "Big Horn",
            1996,
            "New Zealand"
    );

    public static CarDetail fatherCorolla = new CarDetail(
            "FFF666",
            2.0f,
            126,
            300,
            CarDetail.FuelType.DIESEL,
            7.2f,
            5.3f,
            "Toyota",
            "Corolla",
            2009,
            "New Zealand"
    );

    public static CarDetail alexSwift = new CarDetail(
            "GGG777",
            1.5f,
            102,
            133,
            CarDetail.FuelType.PETROL91,
            8.4f,
            6.3f,
            "Suzuki",
            "Swift",
            2008,
            "New Zealand"
    );

    public static List<CarDetail> allCarsDetails = List.of(
            connorCorolla, connorAudiA4, connorDemio, connorJetta, fatherBigHorn, fatherCorolla, alexSwift
    );

    public static List<Map<String, Object>> allCarDetailsMapped = List.of(
            connorCorolla.getCarDetailMap(), connorAudiA4.getCarDetailMap(), connorDemio.getCarDetailMap(),
            connorJetta.getCarDetailMap(), fatherBigHorn.getCarDetailMap(), fatherCorolla.getCarDetailMap(),
            alexSwift.getCarDetailMap()
    );
}
