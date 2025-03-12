class bankAccount{
    String accountNumber;
    String ownerName;
    double balance;

    bankAccount (String accountNumber,String ownerName,double balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    void displayInfo(){
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Owner Name : " + ownerName);
        System.out.println("Balance : " + balance);
        System.out.println("");
    }

    void depositMoney(double amount){
        if(amount > 0) {
            balance += amount;
            System.out.println(ownerName + " deposit Rp" + amount + ", current balance Rp" + balance);
        }
        else{
            System.out.println("Deposit must be positive");
        }
    }

    void withdrawMoney(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println(ownerName + " withdraw Rp" + amount + ", (Works) current balance Rp" + balance);
        }
        else {
            System.out.println(ownerName + " withdraw Rp" + amount + ", (Failed, insufficient balance) current balance Rp" + balance);
        }
    }
}

public class Codelab2 {
    public static void main(String[] args) {
        bankAccount account1 = new bankAccount("202410370110165","Farrel",500000);
        bankAccount account2 = new bankAccount("202410370110382","Razky",1000000);

        account1.displayInfo();
        account2.displayInfo();

        account1.depositMoney(200000);
        account2.depositMoney(500000);
        System.out.println("");
        account1.withdrawMoney(800000);
        account2.withdrawMoney(300000);
        System.out.println("");
        account1.displayInfo();
        account2.displayInfo();
    }
}