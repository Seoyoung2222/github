import java.util.*;

public class Main {
    public static List<List<Edge>> graph;

    public static class Edge {
        int to; // 도착 정점
        int weight; // 간선의 가중치

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int[] shortestPath(int start, int V) {
        int[] dist = new int[V+1]; // 최단 거리 배열
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currentNode = curr[0]; // 현재 정점
            int currentDistance = curr[1]; // 시작 정점부터 현재 정점까지의 거리

            if (dist[currentNode] > currentDistance) { // 이미 더 짧은 경로인 경우 스킵
                continue;
            }

            for (Edge edge : graph.get(currentNode)) {
                int newDistance = edge.weight + currentDistance;
                if (newDistance < dist[edge.to]) {
                    dist[edge.to] = newDistance;
                    pq.offer(new int[]{edge.to, newDistance});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 정점의 개수
        int E = sc.nextInt(); // 간선의 개수
        int start = sc.nextInt(); // 시작 정점

        graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 초기화
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(); // 출발 정점
            int v = sc.nextInt(); // 도착 정점
            int w = sc.nextInt(); // 가중치
            graph.get(u).add(new Edge(v, w));
        }

        int[] result = shortestPath(start, V);

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }
}
