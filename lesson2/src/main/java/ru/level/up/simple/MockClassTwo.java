package ru.level.up.simple;

import org.levelup.annotations.RandomInt;

public class MockClassTwo {

    @RandomInt(min = 1)
    private Integer id;

    @RandomInt(min = 10)
    private double doubleField;

    @RandomInt(min = 20)
    private String stringField;
}
