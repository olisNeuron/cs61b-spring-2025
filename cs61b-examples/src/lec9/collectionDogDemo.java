package lec9;

import org.checkerframework.checker.units.qual.A;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class collectionDogDemo {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();

        dogs.add(new Dog("grigometh", 200));
        dogs.add(new Dog("pelusa", 5));
        dogs.add(new Dog("clifford", 9000));

        Dog maxDog = Collections.max(dogs, Dog.NAME_COMPARATOR);
    }
}
