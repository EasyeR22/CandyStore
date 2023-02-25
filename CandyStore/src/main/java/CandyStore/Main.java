package CandyStore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String password = new String();
        String login = new String();
        int choice = 0;
        User user = new User();
        Scanner scan = new Scanner(System.in);
        String currentLogin = new String(),currentPassword =new String(), newLogin = new String(),newPassword =new String();

        user.signIn();
        user.functions(choice,currentPassword,currentLogin,newLogin,newPassword);
    }
}
