import java.util.Scanner;
//Di codelab ini saya modifikasi sedikit dari modul yaitu saya menambahkan input dari pengguna untuk memasukkan nama hero yang diinginkan
//dan saya juga menambahkan pemilihan senjata beserta total damage yang diberikan ke target tiap tiap senjata

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hero character name : ");
        Hero hero = new Hero(scanner.nextLine(), 180);//objek hero dan kita langsung inisialisasi nama hero dari input user dengan scanner dan healthnya kita set ke 180
        Enemy enemy = new Enemy("Viper", 200);//enemy kita inisialisasi nama dan healthnya secara otomatis

        //menampilkan status hero kita dan enemy yang akan dilawan
        System.out.println("Initial Status :");
        System.out.println(hero.getName() + " has health : " + hero.getHealth());
        System.out.println("You will against " + enemy.getName() + ", health : " + enemy.getHealth());
        System.out.println("");

        hero.weapon(scanner);
        hero.Attack(enemy);
    }
}
