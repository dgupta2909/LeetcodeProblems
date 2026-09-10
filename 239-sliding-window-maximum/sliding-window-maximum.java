class Pair implements Comparable<Pair> {
    int num;
    int index;

    public Pair(int num, int index) {
        this.num = num;
        this.index = index;
    }

    @Override
    public int compareTo(Pair pair) {
        return pair.num - this.num;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(nums[i], i));
        }

        ans[0] = pq.peek().num;

        int j = 1;

        for (int i = k; i < nums.length; i++) {

            pq.add(new Pair(nums[i], i));

            while (!pq.isEmpty() && pq.peek().index <= i - k) {
                pq.poll();
            }

            ans[j++] = pq.peek().num;
        }

        return ans;
    }
}