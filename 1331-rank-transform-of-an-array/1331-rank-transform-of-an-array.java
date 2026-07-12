class Solution {
    public int[] arrayRankTransform(int[] arr) {
        List<int[]> list = new ArrayList<>();
        if (arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            list.add(new int[]{arr[i], i});
        }
        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        arr[list.get(0)[1]] = 1;
        for (int i = 1; i < list.size(); i++) {
            int[] ele = list.get(i);
            int[] prevEle = list.get(i - 1);
            if (ele[0] == prevEle[0]) {
                arr[ele[1]] = arr[prevEle[1]];
            } else {
                arr[ele[1]] = arr[prevEle[1]] + 1;
            }
        }
        return arr;
    }
}