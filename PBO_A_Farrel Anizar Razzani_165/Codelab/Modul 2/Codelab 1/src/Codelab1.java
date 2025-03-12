class Animal{
    String name;
    String type;
    String sound;

    Animal(String name,String type,String sound){
        this.name = name;
        this.type = type;
        this.sound = sound;
    }
    void displayinfo(){
        System.out.println("Name : " + name);
        System.out.println("Type : " + type);
        System.out.println("Sound : " + sound);
        System.out.println("");
    }
}

public class Codelab1{
    public static void main(String[] args) {
        Animal animal1 = new Animal("Cat","Mammal","Miaaawww...");

        Animal animal2 = new Animal("Dog", "Mammal","Guk Guk...");

        animal1.displayinfo();
        animal2.displayinfo();

    }
}