package src;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private List<User> db;

    public UserDB(){
        this.db = new ArrayList<User>();
    }

    public void addUser(User user) {
        this.db.add(user);
    }

    public void removeUser(String userId){
        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getUserId().equals(userId)) {
                db.remove(i);
                break;
            }
        }
    }

    public void updateUser(String userId, User updatedUser) {
        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getUserId().equals(userId)) {
                db.set(i, updatedUser);
                break;
            }
        }
    }

    public User getUserByEmail(String email){
        for (User user : db) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByEmailAndPasswordHash(String email, String passwordHash) {
        for (User user : db) {
            if (user.getEmail().equals(email) && user.getPasswordHash().equals(passwordHash)) {
                return user;
            }
        }
        return null;
    }

    public User getUserById(String userId) {
        for (User user : db) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

}
