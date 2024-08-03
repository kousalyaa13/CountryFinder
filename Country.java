import java.util.*;
import java.io.*;

public class Country {
    private String name;
    private String capital;
    private int population;

    public Country(String name, String capital, int population) {
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return name + " (capital: " + capital + ", population: " + population + ")";
    }
}
