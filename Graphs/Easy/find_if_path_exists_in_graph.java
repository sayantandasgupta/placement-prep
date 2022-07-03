package Graphs.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class find_if_path_exists_in_graph {

    /*
     * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

        You want to determine if there is a valid path that exists from vertex source to vertex destination.

        Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

        

        Example 1:


        Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
        Output: true
        Explanation: There are two paths from vertex 0 to vertex 2:
        - 0 → 1 → 2
        - 0 → 2
        Example 2:


        Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
        Output: false
        Explanation: There is no path from vertex 0 to vertex 5.
        

        Constraints:

        1 <= n <= 2 * 105
        0 <= edges.length <= 2 * 105
        edges[i].length == 2
        0 <= ui, vi <= n - 1
        ui != vi
        0 <= source, destination <= n - 1
        There are no duplicate edges.
        There are no self edges.
     */

    static boolean solution(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();        // Initialising the Adjacency List
        
        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<edges.length;i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<>();
        
        q.add(source);
        
        while(!q.isEmpty()) {
            int node = q.poll();
            visited.add(node);
            
            if(node == destination) return true;
            for(int adNode : graph.get(node)) {
                if(!visited.contains(adNode)) q.add(adNode);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2}, {3,5}, {5,4}, {4,3}};
        int source = 0, destination = 5;

        System.out.print(solution(n, edges, source, destination));
    }
}
