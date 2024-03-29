package month;



import java.util.*;

/**
 * @author 邹松林
 * @version 1.0
 * @Title: three
 * @Description: TODO
 * @date 2024/3/12 16:22
 */
public class three {
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> stack = new LinkedList<>();
        int len = sandwiches.length;
        for (int i = 0; i < len; i++) {
            stack.addLast(students[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.size();
        for (int i = 0; i < sandwiches.length; i++) {
            if (stack.getFirst()==sandwiches[i]) stack.removeFirst();
            else {
                int size = stack.size();
                boolean flag=true;
                while (size-->0){
                    stack.addLast(stack.removeFirst());
                    if (stack.getFirst()==sandwiches[i]){
                        stack.removeFirst();
                        flag=false;
                        break;
                    }
                }
                if (flag) return stack.size();
            }
        }
        return 0;
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[n+1];
        int[] f = new int[n * (n + 1) / 2];
        sums[0]=0;

        for (int i = 1; i <= n; i++) {
            sums[i]=sums[i-1]+nums[i-1];
            // System.out.println(sums[i]);
        }
        int z=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // System.out.printf("%d,%d",z,sums[i]-sums[j]);
                // System.out.println();
                f[z++]=sums[i]-sums[j];
            }
        }
        Arrays.sort(f);
        int ans=0;
        int MAX=1000000007;
        for (int i = left-1; i < right; i++) {
            System.out.println(f[i]);
            ans=(ans+f[i])%MAX;
        }
        return ans;

    }
    public int minimumSwap(String s1, String s2) {
        int d=0,xy=0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)!=s2.charAt(i)){
                d++;
                if (s1.charAt(i)=='x') xy++;
            }
        }
        if (d%2==1) return -1;
        else {
            if (xy%2==0) return d/2;
            else return d/2+1;
        }
    }
    public int longestStrChain(String[] words) {
        int ans=0;
        HashMap<String,Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],0);
        }
        for (int i = 0; i < words.length; i++) {
            ans=Math.max(ans,dfs(words[i],map));
        }
        return ans;
    }
    int dfs(String s,HashMap<String,Integer> map){

        int num = map.get(s);
        if (num!=0) return num;
        else num=1;
        for (int i = 0; i < s.length(); i++) {
            String pre=s.substring(0,i)+s.substring(i+1);
            if (map.containsKey(pre)) {
                num=Math.max(num,dfs(pre,map)+1);
                map.put(pre,num);
            }
        }
        return num;
    }
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> ans = new ArrayList<>();
        //flagx记录哪些行被占用了，每行的哪一列放了元素，flagy记录哪些列被占用了
        int[] flagx = new int[n];
        Arrays.fill(flagx,-1);
        int[] flagy = new int[n];
        Arrays.fill(flagy,-1);
        HashSet<Integer> flagl = new HashSet<>();
        HashSet<Integer> flagr = new HashSet<>();
        dfs(n,0,flagx,flagy,flagl,flagr,ans);
        return ans;
    }
    private void dfs(int n,int y,int[] flagx,int[] flagy,HashSet<Integer> flagl,HashSet<Integer> flagr,ArrayList<List<String>> ans) {
        if (y==n) {
            for (int i = 0; i < n; i++) {
                System.out.println(flagx[i]);
            }

            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (flagy[i]==j) sb.append("Q");
                    else sb.append(".");
                }
                list.add(new String(sb));
            }
            ans.add(list);
            return;
        }
        //flagx记录哪些行被占用了，每行的哪一列放了元素，flagy记录哪些列被占用了，
        //i表示横坐标，y表示纵坐标
        for (int i = 0; i < n; i++) {
            if (flagx[i]!=-1||flagy[y]!=-1||flagl.contains(i+y)||flagr.contains(i-y)) continue;
            flagx[i]=y;
            flagy[y]=i;
            flagl.add(i+y);
            flagr.add(i-y);
            dfs(n,y+1,flagx,flagy,flagl,flagr,ans);
            flagx[i]=-1;
            flagy[y]=-1;
            flagl.remove(i+y);
            flagr.remove(i-y);
        }
    }

    /*public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> ans = new ArrayList<>();

        int[][] vis = new int[n][n];
        HashSet<Integer> flagx = new HashSet<>();
        HashSet<Integer> flagy = new HashSet<>();
        HashSet<Integer> flagl = new HashSet<>();
        HashSet<Integer> flagr = new HashSet<>();
        dfs(n,0,vis,flagx,flagy,flagl,flagr,ans);
        return ans;
    }

    private void dfs(int n,int y,int[][] vis,HashSet<Integer> flagx,HashSet<Integer> flagy,HashSet<Integer> flagl,HashSet<Integer> flagr,ArrayList<List<String>> ans) {
        if (y==n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (vis[i][j]==1) sb.append("Q");
                    else sb.append(".");
                }
                list.add(new String(sb));
            }

            *//*for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (flagx[i]==j) sb.append("Q");
                    else sb.append(".");
                }
                list.add(new String(sb));
            }*//*
            ans.add(list);
            return;
        }
        for (int i = 0; i < n; i++) { //i表示横坐标，y表示列坐标
            if (flagx.contains(i)||flagl.contains(i+y)||flagr.contains(i-y)) continue;
            flagx.add(i);
            flagl.add(i+y);
            flagr.add(i-y);
            vis[y][i]=1;
            dfs(n,y+1,vis,flagx,flagy,flagl,flagr,ans);
            flagx.remove(i);
            flagl.remove(i+y);
            flagr.remove(i-y);
            vis[y][i]=0;
        }
    }*/


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a - x) < Math.abs(b - x)) return 0;
            else if (Math.abs(a - x) == Math.abs(b - x) && a < b) return 0;
            else return 1;
        });
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        Integer[] nums = new Integer[k];
        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            nums[i]=poll;
            System.out.println(poll);
        }
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        return list;
    }
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        String[] ans = new String[len];
        Integer[] sc = new Integer[len];
        for (int i = 0; i < len; i++) {
            sc[i]=score[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(score[i],i);
        }
        Arrays.sort(sc,(a,b)->b-a);
        for (int i = 0; i < len; i++) {
            if (i==0){
                ans[map.get(sc[i])]="Gold Medal";
            }else if (i==1){
                ans[map.get(sc[i])]="Silver Medal";
            }else if (i==2){
                ans[map.get(sc[i])]="Bronze Medal";
            }else {
                ans[map.get(sc[i])]=String.valueOf(i+1);
            }
        }
        return ans;
    }
    public String frequencySort(String s) {
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            Map.Entry<Character, Integer> poll = queue.poll();
            for (int i = 0; i < poll.getValue(); i++) {
                sb.append(poll.getKey());
            }
        }
        return new String(sb);
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int ans=0;
        for (int i = 0; i < matrix.length; i++) {
            queue.add(new int[]{matrix[i][0],i,0});
        }
        while (k-- > 0 && !queue.isEmpty()){
            int[] poll = queue.poll();
            if (poll[2]<matrix[0].length){
                queue.add(new int[]{matrix[poll[1]][poll[2]+1],poll[1],poll[2]+1});
            }
            ans=poll[0];
        }

        return ans;
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            priorityQueue.add(new int[]{i, 0});
        }
        for (int i = 0; i < k; i++) {
            int[] poll = priorityQueue.poll();
            ans.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));
            if (++poll[1] < nums2.length) {
                priorityQueue.add(poll);
            }
        }
        return ans;
    }


    public int nthUglyNumber(int n) {
//        int a = 0, b = 0, c = 0;
//        int[] ans = new int[n];
//        ans[0] = 1;
//        for (int i = 1; i < n; i++) {
//            ans[i]=Math.min(ans[a]*2,Math.min(ans[b]*3,ans[c]*5));
//            if (ans[i]==ans[a]*2) a++;
//            if (ans[i]==ans[b]*3) b++;
//            if (ans[i]==ans[c]*5) c++;
//        }
//        return ans[n - 1];
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        long poll = 1L;
        for (int i = 0; i < n; i++) {
            poll = queue.poll();
            if (set.add(poll * 2)) queue.add(poll * 2);
            if (set.add(poll * 3)) queue.add(poll * 3);
            if (set.add(poll * 5)) queue.add(poll * 5);
        }
        return (int) poll;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() == k) {
                if (entry.getValue() > queue.peek().getValue()) {
                    queue.poll();
                    queue.add(entry);
                }
            } else {
                queue.add(entry);
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }


}
