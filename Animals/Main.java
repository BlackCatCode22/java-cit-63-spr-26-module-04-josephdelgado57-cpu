package Animals;

import java.io.*;
import java.util.*;

public class Main {public static void main(String[] args) {
    String basePath = " ";
    ArrayList<String> namePool = new ArrayList<>();
    ArrayList<Animal> zooList = new ArrayList<>();
    HashMap<String, Integer> speciesCounts = new HashMap<>();

    try (BufferedReader nameReader = new BufferedReader(new FileReader("animalNames.txt"))) {
        String line;
        while ((line = nameReader.readLine()) != null) {
            if (!line.trim().isEmpty() && !line.contains("Names")) {
                String[] names = line.split(",");
                for (String name : names) {
                    namePool.add(name.trim());
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading animalNames.txt: " + e.getMessage());
    }

    try (BufferedReader popReader = new BufferedReader(new FileReader("zooPopulation.txt"))) {
        String line;
        while ((line = popReader.readLine()) != null) {
        }
    } catch (IOException e) {
        System.out.println("Error reading zooPopulation.txt: " + e.getMessage());
    }

    try (BufferedReader animalReader = new BufferedReader(new FileReader("arrivingAnimals.txt"))) {
        String line;
        int nameIndex = 0;
        while ((line = animalReader.readLine()) != null) {
            String[] parts = line.split(" ");
            int age = Integer.parseInt(parts[0]);
            String species = parts[4].replace(",", "").toLowerCase();

            String assignedName = namePool.isEmpty() ? "Unknown" : namePool.get(nameIndex % namePool.size());
            nameIndex++;

            if (species.equals("hyena")) {
                zooList.add(new Hyena(assignedName, age, "Laughing"));
            } else if (species.equals("lion")) {
                zooList.add(new Lion(assignedName, age, true));
            } else if (species.equals("tiger")) {
                zooList.add(new Tiger(assignedName, age, 100));
            } else if (species.equals("bear")) {
                zooList.add(new Bear(assignedName, age, "Brown"));
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading arrivingAnimals.txt: " + e.getMessage());
    }

    for (Animal animal : zooList) {
        String speciesKey = animal.getSpecies();
        speciesCounts.put(speciesKey, speciesCounts.getOrDefault(speciesKey, 0) + 1);
    }

    try (PrintWriter writer = new PrintWriter(new FileWriter("newAni.txtmals"))) {
        writer.println("******************************************");
        writer.println("         ZOO INVENTORY REPORT             ");
        writer.println("******************************************\n");

        writer.println("--- Individual Animal List ---");
        for (Animal animal : zooList) {
            writer.printf("Name: %-10s | Age: %-2d | Species: %-10s%n",
                    animal.getName(), animal.getAge(), animal.getSpecies());
        }

        writer.println("\n------------------------------------------");
        writer.println("--- Species Totals ---");
        for (String species : speciesCounts.keySet()) {
            writer.println(species + ": " + speciesCounts.get(species));
        }

        System.out.println("Process Complete. Check 'newAnimals.txt' for the report.");

    } catch (IOException e) {
        System.out.println("Error writing report: " + e.getMessage());
    }
}
}