package csv;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    Gson gson = new Gson();
    String url = "localhost:8080/addresses";


    public static void main(String[] args) throws IOException {
        new CSVReader().read("C:\\Users\\Gardner\\IdeaProjects\\esg-kata\\src\\csv\\testdata.csv");
    }
    public void read(String file) throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }

        System.out.println(records);
        for (int i=1; i<records.size(); i++) {
            Address address = getAddress(records, i);
            String json = gson.toJson(address);

            System.out.println("Sending json:" + json);
            String command = "curl -X PUT <url> -H 'Content-type:application/json' -d '<json>'";
            Process process = Runtime.getRuntime().exec(command.replace("<url>", url).replace("<json>", json));
            process.getInputStream();
        }

    }

    private static Address getAddress(List<List<String>> records, int i) {
        Address address = new Address();
        List<String> addressRaw = records.get(i);
        address.setCustomerRef(addressRaw.get(0));
        address.setCustomerName(addressRaw.get(1));
        address.setAddressLineOne(addressRaw.get(2));
        address.setAddressLineTwo(addressRaw.get(3));
        address.setTown(addressRaw.get(4));
        address.setCounty(addressRaw.get(5));
        address.setCountry(addressRaw.get(6));
        address.setPostcode(addressRaw.get(7));
        return address;
    }
}
