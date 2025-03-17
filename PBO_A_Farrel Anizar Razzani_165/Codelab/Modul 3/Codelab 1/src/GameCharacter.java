public class GameCharacter { //Kelas induk

    //atribut dengan access modifier private agar tidak sembarangan orang bisa mengubah datanya
    private String name;
    private int health;
    private String weapon;
    private int damage;

    //constructor kelas induk
    public GameCharacter(String name, int health){
        this.name = name;
        this.health = health;
    }

    //getter setter untuk mengambil dan mengset nilai atribut yang diprivate
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //method attack yang akan di override di subclass
    public void Attack(GameCharacter target){
    }
}
