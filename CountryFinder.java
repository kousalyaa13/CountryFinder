import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryFinder {
    private List<Country> countries;

    public CountryFinder(String fileName) {
        countries = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNextLine()) {
                String[] fields = input.nextLine().split(",");
                String name = fields[0];
                String capital = fields[1];
                int population = Integer.parseInt(fields[2]);
                countries.add(new Country(name, capital, population));
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public List<Country> searchByName(String name) {
        List<Country> result = new ArrayList<>();
        for (Country country : countries) {
            if (country.getName().toLowerCase().startsWith(name.toLowerCase())) {
                result.add(country);
            }
        }
        return result;
    }
}
