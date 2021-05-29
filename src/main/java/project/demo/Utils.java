package project.demo;

import project.demo.domain.Flight;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public final static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");

    public static Flight parseFlightData(String line) {
        List<String> data = Arrays.stream(line.split(",")).map(String::strip).collect(Collectors.toList());
        if (data.size() != 8) {
            System.err.printf("Illegal number of arguments expected 8, actual %s%n", data.size());
            return null;
        }
        Long id = Long.parseLong(data.get(0));
        String origin = data.get(1);
        String destination = data.get(2);
        Date departureTime;
        Date arrivalTime;
        try {
            departureTime = dateFormat(data.get(3) + data.get(4));
            arrivalTime = dateFormat(data.get(5) + data.get(6));
        } catch (ParseException parseException) {
            System.err.println("Can't parse " + parseException.getMessage());
            return null;
        }
        String number = data.get(7);
        return new Flight(id, origin, destination, departureTime, arrivalTime, number);
    }

    public static Date dateFormat(String data) throws ParseException {
        return dateFormat.parse(data);
    }

}
