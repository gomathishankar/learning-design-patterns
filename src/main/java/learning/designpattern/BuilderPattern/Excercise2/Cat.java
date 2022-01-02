package learning.designpattern.BuilderPattern.Excercise2;

/*
Scenario : All the fields in this are mandatory
 */

public class Cat {

    private String name;
    private String breed;
    private String favouriteFood;
    private int age;

    private Cat(String name, String breed, String favouriteFood, int age) {
        this.name = name;
        this.breed = breed;
        this.favouriteFood = favouriteFood;
        this.age = age;
    }
    
    public static TypeOfBreed called(String name){
        return new CatBuilder(name);
    }
    

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", favouriteFood='" + favouriteFood + '\'' +
                ", age=" + age +
                '}';
    }

    public static class CatBuilder implements TypeOfBreed{

        private String name;
        private String breed;
        private String favouriteFood;
        private int age;

        public CatBuilder(String name) {
            this.name = name;
        }

        public CatBuilder eatsFavouriteFood(String favouriteFood) {
            this.favouriteFood = favouriteFood;
            return this;
        }

        public CatBuilder andItsAge(int age) {
            this.age = age;
            return this;

        }

        public Cat build() {
            return new Cat(name,breed,favouriteFood,age);
        }

        @Override
        public CatBuilder offBreed(String breed) {
            this.breed = breed;
           return this;
        }
    }

}
