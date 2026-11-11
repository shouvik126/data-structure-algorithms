class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if ((long) cost1 + cost2 <= costBoth) {
            return (long) need1 * cost1 + (long) need2 * cost2;
        }

        long both = Math.min(need1, need2);

        long total = both * costBoth;

        need1 -= both;
        need2 -= both;

        total += (long) need1 * Math.min(cost1, costBoth);
        total += (long) need2 * Math.min(cost2, costBoth);

        return total;
    }
}