package org.team2.FinalLab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Graph undirected untuk relasi pertemanan antar kontak.

public class graph {
    private final Map<Integer, List<Integer>> adj = new HashMap<>();

    // Tambah node kontak
    public void addNode(int id) {
        adj.putIfAbsent(id, new ArrayList<>());
    }

    // Tambah edge pertemanan
    public void addEdge(int u, int v) {
        adj.putIfAbsent(u, new ArrayList<>());
        adj.putIfAbsent(v, new ArrayList<>());
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Daftar teman dari id
    public List<Integer> getFriends(int id) {
        return adj.getOrDefault(id, Collections.emptyList());
    }

    // Cari jalur terpendek via BFS
    public List<Integer> shortestPath(int s, int t) {
        if (!adj.containsKey(s) || !adj.containsKey(t)) return null;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> prev = new HashMap<>();
        queue.add(s);
        prev.put(s, null);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == t) break;
            for (int v : adj.get(u)) {
                if (!prev.containsKey(v)) {
                    queue.add(v);
                    prev.put(v, u);
                }
            }
        }
        if (!prev.containsKey(t)) return null;
        List<Integer> path = new ArrayList<>();
        for (Integer at = t; at != null; at = prev.get(at)) path.add(at);
        Collections.reverse(path);
        return path;
    }
}
