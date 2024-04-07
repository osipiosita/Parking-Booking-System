package src;
public class User{
    private String userName;
    private String email;
    private String userId;
    private String passwordHash;

    public User() {
    }

    public User(String userName, String userId, String email, String passwordHash) {
        this.userName = userName;
        this.email = email;
        this.userId = userId;
        this.passwordHash = passwordHash;
    }
    
    public String getName(){
        return this.userName;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public String getEmail(){
        return this.email;
    }
}




