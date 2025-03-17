//kelas anak enemy mewarisi dari kelas induk
public class Enemy extends GameCharacter{
    //constructor subclass dengan kata kunci super untuk memanggil constructor dari kelas induk
    public Enemy(String name, int health){
        super(name, health);
    }
}
