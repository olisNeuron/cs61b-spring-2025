package lec2;

public class DogLauncher {
    public static void main(String[] args) {
        Dog maya = new Dog(4);
        Dog hugeDog = new Dog(1500);
        Dog largerDog = Dog.maxDog(maya,hugeDog);
        largerDog.makeNoise();
        Dog largerDogs = maya.maxDog(hugeDog);
        largerDogs.makeNoise();
    }
}
