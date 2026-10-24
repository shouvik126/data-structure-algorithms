class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] cumDays = new int[13];
        cumDays[1] = 31;
        for (int i = 2; i <= 12; i++) {
            cumDays[i] = cumDays[i - 1] + days[i - 1];
        }
        int arriveAliceDays = findDays(arriveAlice, cumDays);
        int leaveAliceDays = findDays(leaveAlice, cumDays);
        int arriveBobDays = findDays(arriveBob, cumDays);
        int leaveBobDays = findDays(leaveBob, cumDays);
        int count = Math.min(leaveAliceDays, leaveBobDays) - Math.max(arriveAliceDays, arriveBobDays) + 1;
        return count < 0 ? 0 : count;
    }
    int findDays(String date, int[] cumDays) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));
        return cumDays[month - 1] + day;
    }
}