package entities;

import java.util.ArrayList;

public class AllUsers {
    private ArrayList<User> users = new ArrayList<User>();

    public void addUser(User user){
        users.add(user);
    }

    public User getUser(String name, String password) {
        for(User user: this.users){
            if (user.getName().equals(name) && user.getPassword().equals(password)){
                return user;
            }
        }
        System.out.println("Usuario não encontrado");
        return null;
    }
}
