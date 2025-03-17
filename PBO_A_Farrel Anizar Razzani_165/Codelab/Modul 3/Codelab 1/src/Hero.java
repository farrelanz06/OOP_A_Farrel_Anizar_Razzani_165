import java.util.Scanner;

// kelas anak hero yang mewarisi dari kelas induknya yaitu gamecharacter
public class Hero extends GameCharacter{

    //constructor subclass dengan kata kunci super untuk memanggil constructor dari kelas induk
    public Hero(String name, int health){
        super(name, health);
    }

    //method weapon dengan parameter Scanner dari main class
    public void weapon(Scanner scanner) {
        int choose;
        //untuk menentukan senjata, jika memilih di luar antara pilihan maka akan looping meminta memilih senjata sampai pilihan valid
        do {
            System.out.println("Choose your weapon :");
            System.out.println("1. Sword (30 attack damage)\n2. Magic (25 attack damage)\n3. Arrow (15 attack damage)");
            System.out.print("Enter your pick : ");
            choose = scanner.nextInt();

            //masing masing pilihan akan mengset weapon dan damage dari senjata yang dipilih
            if (choose == 1) {
                setWeapon("Sword");
                setDamage(30);
            } else if (choose == 2) {
                setWeapon("Magic");
                setDamage(25);
            } else if (choose == 3) {
                setWeapon("Arrow");
                setDamage(15);
            } else {
                System.out.println("Invalid choice, please pick again.");
            }
        } while (choose < 1 || choose > 3);//kondisi yang dimana akan looping terus jika pilihan 0/negatif atau lebih dari 3
    }

    //override method attack dari parent class yang berisi menampilkan notifikasi menyerang dan menghitung darah musuh sesuai damage yang diberikan dari senjata
    //dan juga menampilkan sisa darah dari musuh
    @Override
    public void Attack(GameCharacter target) {
        System.out.println(getName() + " Attacks " + target.getName() + " with " + getWeapon());
        target.setHealth(target.getHealth() - getDamage());
        System.out.println(target.getName() + " now has " + target.getHealth() + " health");
    }
}
