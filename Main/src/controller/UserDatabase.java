package controller;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static Map<String, String> users = new HashMap<>();

    static {
        // User default
        users.put("user", "1234");
    }

    public static void addUser(String username, String password) {
        users.put(username, password);
    }

    public static boolean isValidUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    // Tambahan method untuk cek user exist tanpa akses langsung Map
    public static boolean userExists(String username) {
        return users.containsKey(username);
    }
}