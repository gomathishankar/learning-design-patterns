package learning.designpattern.BuilderPattern.Excercise1;

/*
Scenario : All the fields in this are mandatory
 */

public class Dog {

    private String name;
    private String breed;
    private String favouriteFood;
    private int age;

    private Dog(String name, String breed, String favouriteFood, int age) {
        this.name = name;
        this.breed = breed;
        this.favouriteFood = favouriteFood;
        this.age = age;
    }

    public static DogBuilder called(String name) {
        return new DogBuilder(name);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", favouriteFood='" + favouriteFood + '\'' +
                ", age=" + age +
                '}';
    }

    public static class DogBuilder {
        private String name;
        private String breed;
        private String favouriteFood;
        private int age;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String name) {
            this.breed = breed;
            return this;
        }

        public DogBuilder eatsFavouriteFood(String favouriteFood) {
            this.favouriteFood = favouriteFood;
            return this;
        }

        public DogBuilder andItsAge(int age) {
            this.age = age;
            return this;
        }

        public Dog build() {
            return new Dog(name, breed, favouriteFood, age);
        }
    }

}
