package repasaco;

import repasaco.model.Character;
import repasaco.model.DevelopmentTeam;
import repasaco.model.InventoryItem;

import java.util.*;
import java.util.function.Supplier;

public class DataGenerator {

    // Generate random characters with various attributes
    public static Supplier<List<Character>> randomCharacters = () -> {
        return new ArrayList<>(List.of(
                new Character("Aragorn", getRandomLevel(), getRandomHealth()),
                new Character("Legolas", getRandomLevel(), getRandomHealth()),
                new Character("Gandalf", getRandomLevel(), getRandomHealth()),
                new Character("Frodo", getRandomLevel(), getRandomHealth()),
                new Character("Bilbo", getRandomLevel(), getRandomHealth()),
                new Character("Sam", getRandomLevel(), getRandomHealth()),
                new Character("Boromir", getRandomLevel(), getRandomHealth()),
                new Character("Elrond", getRandomLevel(), getRandomHealth()),
                new Character("Galadriel", getRandomLevel(), getRandomHealth()),
                new Character("Gimli", getRandomLevel(), getRandomHealth()),
                new Character("Sauron", getRandomLevel(), getRandomHealth()),
                new Character("Thorin", getRandomLevel(), getRandomHealth()),
                new Character("Bilbo Baggins", getRandomLevel(), getRandomHealth()),
                new Character("Eowyn", getRandomLevel(), getRandomHealth()),
                new Character("Galandriel", getRandomLevel(), getRandomHealth()),
                new Character("Denethor", getRandomLevel(), getRandomHealth())
        ));
    };

    // Generate random inventory items
    public static Supplier<Map<String, InventoryItem>> randomInventory = () -> {
        Map<String, InventoryItem> inventory = new HashMap<>();
        for (int i = 1; i <= 30; i++) { // Generate 30 inventory items
            String itemName = "Item" + i;
            String category = generateRandomCategory();
            int quantity = getRandomQuantity();
            float value = getRandomValue();
            inventory.put(itemName, new InventoryItem(itemName, category, quantity, value));
        }
        return inventory;
    };

    // Generate random development teams
    public static Supplier<List<DevelopmentTeam>> randomDevelopmentTeams = () -> {
        List<DevelopmentTeam> teams = new ArrayList<>();
        for (int i = 1; i <= 5; i++) { // Generate 5 development teams
            String teamName = "Team " + i;
            String project = "Project " + i;
            DevelopmentTeam team = generateDevelopmentTeam(teamName, project, getRandomNumber(3, 10)); // Random members
            teams.add(team);
        }
        return teams;
    };

    // Generate a random development team with a specific number of members
    private static DevelopmentTeam generateDevelopmentTeam(String teamName, String project, int numberOfMembers) {
        DevelopmentTeam team = new DevelopmentTeam(teamName, project);
        for (int i = 1; i <= numberOfMembers; i++) {
            team.addMember("Member " + i);
        }
        return team;
    }

    // Generate a random category for items
    private static String generateRandomCategory() {
        List<String> categories = Arrays.asList("Weapon", "Potion", "Armor", "Material", "Tool");
        return categories.get(new Random().nextInt(categories.size()));
    }

    // Random level generator
    private static int getRandomLevel() {
        return new Random().nextInt(50) + 1; // Levels from 1 to 50
    }

    // Random health generator
    private static int getRandomHealth() {
        return new Random().nextInt(500) + 100; // Health between 100 and 600
    }

    // Random quantity generator
    private static int getRandomQuantity() {
        return new Random().nextInt(100) + 1; // Quantity between 1 and 100
    }

    // Random value generator
    private static float getRandomValue() {
        return new Random().nextFloat() * 500; // Value up to 500 currency units
    }

    // Random number generator between min and max
    private static int getRandomNumber(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min; // Generate a random number between min and max
    }

    // Utility methods to print generated characters, inventory, and teams
    public static void printGeneratedCharacters(List<Character> characters) {
        for (Character character : characters) {
            System.out.println(character);
        }
    }

    public static void printGeneratedInventory(Map<String, InventoryItem> inventory) {
        for (Map.Entry<String, InventoryItem> entry : inventory.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void printGeneratedTeams(List<DevelopmentTeam> teams) {
        for (DevelopmentTeam team : teams) {
            System.out.println(team);
        }
    }
}
