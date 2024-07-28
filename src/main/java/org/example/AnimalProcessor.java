package org.example;

public class AnimalProcessor {

    public <T extends Animal> T processAnimal(Class<T> type,String name) throws Exception {
        Animal animal=type.getDeclaredConstructor().newInstance();  //using Reflections to create object dynamically
        System.out.println("Processing " + name + " the " + type.getSimpleName());
        return (T) animal;

    }

    public static void main(String[] args) {
        try{
            AnimalProcessor processor=new AnimalProcessor();
            Dog dog=processor.processAnimal(Dog.class,"Tuffy");
            Cat cat=processor.processAnimal(Cat.class,"Mary");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}