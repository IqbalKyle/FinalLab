

package org.team2.FinalLab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

//Main interaktif 
public class FinalLab {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        bst bst = new bst();
        HashTable ht = new HashTable();
        graph graph = new graph();

        //Memuat data dummy 
        System.out.println("Memuat data dummy");
        DummyData.load(bst, ht, graph);
        
        while (true) {
            System.out.println("=== Contact Manager with Friends ===");
            System.out.println("1) Tambah kontak");
            System.out.println("2) Cari kontak by ID");
            System.out.println("3) Hapus kontak by ID");
            System.out.println("4) Daftar semua kontak");
            System.out.println("5) Tambah teman (relasi)");
            System.out.println("6) Lihat teman kontak");
            System.out.println("7) Cari jalur terpendek antar kontak");
            System.out.println("0) Keluar");
            System.out.print("Pilih: ");
            String choice = in.readLine().trim();
            if (choice.equals("0")) break;

            switch (choice) {
                case "1" -> {
                    System.out.print("Masukkan ID (integer): ");
                    int newId = Integer.parseInt(in.readLine());
                    System.out.print("Masukkan nama: ");
                    String newName = in.readLine();
                    if (bst.search(newId)) {
                        System.out.println("ID sudah ada. Gunakan ID lain.");
                    } else {
                        bst.insert(newId);
                        ht.insert(newId, newName);
                        graph.addNode(newId);
                        System.out.println("Kontak tersimpan.");
                    }
                }

                case "2" -> {
                    System.out.print("Masukkan ID yang dicari: ");
                    int searchId = Integer.parseInt(in.readLine());
                    if (bst.search(searchId)) {
                        System.out.println("Ditemukan: " + ht.search(searchId));
                    } else {
                        System.out.println("Kontak dengan ID tersebut tidak ditemukan.");
                    }
                }

                case "3" -> {
                    System.out.print("Masukkan ID yang akan dihapus: ");
                    int delId = Integer.parseInt(in.readLine());
                    if (bst.search(delId)) {
                        bst.delete(delId);
                        ht.delete(delId);
                        graph.adj.remove(delId);
                        graph.adj.values().forEach(list -> list.remove((Integer) delId));
                        System.out.println("Kontak dihapus.");
                    } else {
                        System.out.println("ID tidak ditemukan.");
                    }
                }

                case "4" -> {
                    System.out.println("--- Daftar Kontak (terurut by ID) ---");
                    bst.inorderPrint(ht.entries());
                }

                case "5" -> {
                    System.out.print("Masukkan ID kontak pertama: ");
                    int id1 = Integer.parseInt(in.readLine());
                    System.out.print("Masukkan ID kontak kedua: ");
                    int id2 = Integer.parseInt(in.readLine());
                    if (bst.search(id1) && bst.search(id2)) {
                        graph.addEdge(id1, id2);
                        System.out.println("Relasi pertemanan ditambahkan.");
                    } else {
                        System.out.println("Salah satu ID tidak ditemukan.");
                    }
                }

                case "6" -> {
                    System.out.print("Masukkan ID kontak: ");
                    int idf = Integer.parseInt(in.readLine());
                    if (bst.search(idf)) {
                        List<Integer> friends = graph.getFriends(idf);
                        System.out.println("Daftar teman ID " + idf + ": " + friends);
                    } else {
                        System.out.println("ID tidak ditemukan.");
                    }
                }

                case "7" -> {
                    System.out.print("Masukkan ID sumber: ");
                    int s = Integer.parseInt(in.readLine());
                    System.out.print("Masukkan ID target: ");
                    int t = Integer.parseInt(in.readLine());
                    List<Integer> path = graph.shortestPath(s, t);
                    if (path == null) System.out.println("Tidak ada jalur menghubungkan.");
                    else System.out.println("Jalur terpendek: " + path);
                }

                default -> System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        }
        System.out.println("Terima kasih! Program selesai.");
    }
}
