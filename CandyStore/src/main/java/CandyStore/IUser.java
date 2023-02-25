package CandyStore;

public interface IUser {
    void functions(int choice,String currentPassword,String currentLogin,String newLogin,String newPassword) throws InterruptedException;
    void buyCandies() throws InterruptedException;
}
