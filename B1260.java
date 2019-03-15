import java.util.*;

public class B1260 {
    static boolean[] visit;
    static ArrayList<Integer>[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        visit = new boolean[n + 1];
        a = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x].add(y);
            a[y].add(x);
        }
        for (int i=1; i<=n; i++) {
            Collections.sort(a[i]);
        }
        dfs(v);
        System.out.println();
        visit = new boolean[n + 1];
        bfs(v);
    }

    public static void dfs(int x) {
        visit[x] = true;
        System.out.print(x + " ");
        for (int y : a[x]) {
            if (!visit[y]) {
                dfs(y);
            }
        }
    }

    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visit[x] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for (int y : a[cur]) {
                if (!visit[y]) {
                    q.offer(y);
                    visit[y] = true;
                }
            }
        }
    }
}



