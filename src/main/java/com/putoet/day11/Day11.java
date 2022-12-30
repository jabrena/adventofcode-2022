package com.putoet.day11;

import com.putoet.day.Day;
import com.putoet.resources.ResourceLines;

public class Day11 extends Day {
    public static void main(String[] args) {
        final var day = new Day11();
        day.challenge();
    }

    @Override
    public void part1() {
        final var monkeys = Game.monkeys(ResourceLines.list("/day11.txt"));
        Game.rounds(monkeys, 20,  value -> value / 3L);

        System.out.println("The level of monkey business after 20 rounds of stuff-slinging simian shenanigans is "
            + Game.monkeyBusiness(monkeys));
    }

    @Override
    public void part2() {
        final var monkeys = Game.monkeys(ResourceLines.list("/day11.txt"));
        final var lcm = Game.lcm(monkeys);
        Game.rounds(monkeys, 10_000, value -> value % lcm);

        System.out.println("The level of monkey business after 10.000 rounds of stuff-slinging simian shenanigans is "
                           + Game.monkeyBusiness(monkeys));
    }
}
