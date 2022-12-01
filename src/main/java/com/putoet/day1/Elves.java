package com.putoet.day1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Elves {
    public static List<Elf> from(List<String> input) {
        assert input != null;
        final List<Elf> elves = new ArrayList<>();
        int id = 1;
        List<Integer> foodCalories = new ArrayList<>();
        for (String line : input) {
            if (line.trim().isEmpty()) {
                elves.add(new Elf(id++, foodCalories));
                foodCalories = new ArrayList<>();
            } else {
                foodCalories.add(Integer.parseInt(line.trim()));
            }
        }
        elves.add(new Elf(id++, foodCalories));
        return elves;
    }

    public static Optional<Elf> mostCalories(List<Elf> elves) {
        assert elves != null;
        return elves.stream().max(Comparator.comparing(Elf::calories));
    }

    public static int topThreeMostCalories(List<Elf> elves) {
        assert elves != null;
        assert elves.size() >= 3;

        return elves.stream()
                .sorted(Comparator.comparing(Elf::calories).reversed())
                .limit(3)
                .mapToInt(Elf::calories)
                .sum();
    }
}
