package org.team2.FinalLab;

import java.util.HashMap;
import java.util.Map;

//Hash table digunakan untuk menyimpan detail kontak 
public class HashTable {
    private final Map<Integer, String> map = new HashMap<>();

    // Tambah atau update kontak
    public void insert(int key, String value) {
        map.put(key, value);
    }

    // Cari kontak berdasarkan key
    public String search(int key) {
        return map.get(key);
    }

    // Hapus kontak, return true jika berhasil
    public boolean delete(int key) {
        return map.remove(key) != null;
    }

    // Mendapatkan semua entry untuk iterasi jika perlu
    public Map<Integer, String> entries() {
        return map;
    }

    // Ukuran tabel
    public int size() {
        return map.size();
    }
}
