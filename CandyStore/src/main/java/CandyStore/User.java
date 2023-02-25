package CandyStore;

import lombok.Getter;
import java.lang.Thread;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@Getter
@Setter
public class User extends candyContainer implements IUser{
    Scanner scan = new Scanner(System.in);
    ArrayList<String> userDataLogins = new ArrayList<>();
    ArrayList<String> userDataPasswords = new ArrayList<>();

    private int userRequirement , amount , choice , candyChoice,settingsChoice;
    private String login , password, currentLogin,currentPassword,newLogin,newPassword;

    public void setLogin(String login){
        this.login = login;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void signIn(){
        System.out.println("Enter your login:");
        String login = scan.nextLine();
        setLogin(login);
        System.out.println("Enter your password:");
        String password = scan.nextLine();
        setPassword(password);

        userDataLogins.add(login);
        userDataPasswords.add(password);
    }

    public void functions(int choice,String currentPassword,String currentLogin,String newLogin,String newPassword) throws InterruptedException {
        boolean run = true;
        while(run) {
            System.out.println("Enter a request:\n1 - Purchase candies\n2 - Settings\n3 - Show cart\n4 - Clear cart\n5 - Show Profile\n 6 - Exit");
            choice = scan.nextInt();
            setChoice(choice);
            if (choice == 1) {
                buyCandies();
            } else if (choice == 2) {
                settings(currentLogin,currentPassword,newLogin,newPassword);
            }
            else if(choice == 3){
                showCart();
            }
            else if(choice == 4){
                cleanCart();
            }
            else if(choice == 5){
                showProfile();
            }
            else if(choice == 6){
                run = false;
                return;
            }
        }
    }
    public void buyCandies() throws InterruptedException {
        System.out.println("Enter amount of candies from 1 to 6:");
        amount = scan.nextInt();
        setAmount(amount);
        System.out.println("Here are our candies:");
        for (String candy : candies) {
            System.out.println(candy);
        }
        System.out.println();
        for(int i = 0;i<amount;i++){
            candyChoice = scan.nextInt();
            switch (candyChoice) {
                case 1 -> {
                    userCandies.add(candies.get(0));
                    System.out.println("You chose a " + candies.get(0));
                }
                case 2 -> {
                    userCandies.add(candies.get(1));
                    System.out.println("You chose a " + candies.get(1));
                }
                case 3 -> {
                    userCandies.add(candies.get(2));
                    System.out.println("You chose a " + candies.get(2));
                }
                case 4 -> {
                    userCandies.add(candies.get(3));
                    System.out.println("You chose a " + candies.get(3));
                }
                case 5 -> {
                    userCandies.add(candies.get(4));
                    System.out.println("You chose a " + candies.get(4));
                }
                case 6 -> {
                    userCandies.add(candies.get(5));
                    System.out.println("You chose a " + candies.get(5));
                }
            }

            Thread.sleep(1000);
        }
    }
    public void settings(String currentLogin,String currentPassword,String newLogin,String newPassword) throws InterruptedException {
        System.out.println("Settings:\n 1 - Change login\n 2 - Change password\n 3 - Delete account");
        settingsChoice = scan.nextInt();
        setSettingsChoice(settingsChoice);
        if(settingsChoice == 1){
            System.out.println("Enter your current login:");
            currentLogin = scan.next();
            if(currentLogin.equals(userDataLogins.get(0))){
                System.out.println("Enter new login:");
                newLogin = scan.next();
                userDataLogins.clear();
                userDataLogins.add(newLogin);
                login = newLogin;
            }
        }else if(settingsChoice == 2){
            System.out.println("Enter your current password:");
            currentPassword = scan.next();
            if(currentPassword.equals(userDataPasswords.get(1))){
                System.out.println("Enter new password:");
                newPassword = scan.next();
                userDataPasswords.clear();
                userDataLogins.add(newPassword);
                login = newPassword;
            }
        }
        else if(settingsChoice == 3){
            userDataPasswords.clear();
            userDataLogins.clear();
            userCandies.clear();
            setPassword(null);
            setLogin(null);
            System.out.println("Deleted successfully");
            Thread.sleep(1000);
        }
    }
    public void showCart() throws InterruptedException {
        if(!(userCandies.isEmpty())) {
            for (int i = 0; i < amount; i++) {
                System.out.println(userCandies.get(i));
            }
            Thread.sleep(1000);
        }
        else{
            System.out.println("Cart is clear");
        }
    }
    public void cleanCart() throws InterruptedException {
        userCandies.clear();
        System.out.println("Cleaned successfully");
        Thread.sleep(1000);
    }
    public void showProfile() throws InterruptedException {
        System.out.println("Your login is: " + getLogin());
        System.out.println("Your password is: " + getPassword());
        Thread.sleep(1000);
    }

}
