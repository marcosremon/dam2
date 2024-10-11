
package repasaco.model;

import java.util.HashMap;
import java.util.Map;

public class Character {
    private String name;
    private int level;
    private int health;
    private Map<String, Integer> skills;

    public Character(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.skills = new HashMap<>();
    }

    public void addSkill(String skillName, int skillLevel) {
        skills.put(skillName, skillLevel);
    }

    public void levelUp() {
        this.level++;
    }

    public void modifySkill(String skillName, int newLevel) {
        if (skills.containsKey(skillName)) {
            skills.put(skillName, newLevel);
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public Map<String, Integer> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Character [name=" + name + ", level=" + level + ", health=" + health + ", skills=" + skills + "]";
    }
}
