package src;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Authentication {
    private AppDB appDB;

    public Authentication(AppDB appDB) {
        this.appDB = appDB;
    }

    public boolean login(String email, String password) throws NoSuchAlgorithmException {
        User user = appDB.getUserDB().getUserByEmail(email);
        if (user != null) {
            String hashedPassword = this.hashPassword(password);
            return user.getPasswordHash().equals(hashedPassword);
        }
        return false;
    }

    public boolean register(String username, String email, String password) throws NoSuchAlgorithmException {
        // Check if an account with the email already exists
        if (appDB.getUserDB().getUserByEmail(email) != null) {
            return false; // Account with the email already exists
        }
    
        // Generate a new user ID and hash the password
        String userId = UUID.randomUUID().toString();
        String hashedPassword = this.hashPassword(password);
    
        // Create a new user object and add it to the database
        User user = new User(username, userId, email, hashedPassword);
        appDB.getUserDB().addUser(user);
    
        return true; // Registration successful
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256"); // hashing algorithm
        md.update(password.getBytes());
        byte[] hashedPasswordBytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPasswordBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}


