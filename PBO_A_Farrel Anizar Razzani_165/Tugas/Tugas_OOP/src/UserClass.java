import java.util.Scanner;

class UserClass {
    private String name;
    private String id;

    UserClass(String name,String id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    void Login(){

    }

    void DisplayInfo(){
        System.out.println("\nUser Information : ");
        System.out.println("Nama : " + name);
        System.out.println("NIM : " + id);
    }
}

