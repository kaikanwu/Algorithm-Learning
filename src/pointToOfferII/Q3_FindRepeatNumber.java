package pointToOfferII;

public class Q3_FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return -1;
        }
        int[] hashTable = new int[nums.length];

        for (int num : nums) {
            if (hashTable[num] >= 1) {
                return num;
            } else {
                hashTable[num] = 1;
            }
        }
        return -1;
    }
}
