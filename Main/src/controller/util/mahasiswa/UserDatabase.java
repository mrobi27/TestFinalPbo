package controller.util.mahasiswa;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {

    // Simulasi database username -> password
    private static Map<String, String> users = new HashMap<>();

    // Cek apakah username dan password valid untuk login
    public static boolean isValidUser(String username, String password) {
        if (username == null || password == null) return false;

        String storedPassword = users.get(username);
        return password.equals(storedPassword);
    }

    // Cek apakah username sudah terdaftar
    public static boolean userExists(String username) {
        return users.containsKey(username);
    }

    // Tambah user baru ke database
    public static void addUser(String username, String password) {
        users.put(username, password);
    }
}
