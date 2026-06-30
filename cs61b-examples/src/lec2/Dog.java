package lec2;

public class Dog {
    public int size;

    public Dog(int s){
        size = s;
    }

    public void makeNoise() {
        if (size > 20) {
            System.out.println("arooooooo!");
        }else if (size > 10) {
            System.out.println("yipyipyip!");
        }else {
            System.out.println("bark");
        }
    }

    public static Dog maxDog(Dog dog1, Dog dog2) {
        if (dog1.size > dog2.size) {
            return dog1;
        }
        return dog2;
    }

    public Dog maxDog(Dog anotherDog){
        if (this.size > anotherDog.size) {
            return this;
        }
        return anotherDog;
    }
}
