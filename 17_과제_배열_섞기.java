// <review-context>
/*
 * [과제] 배열 섞기 (LeetCode 1470)
 * 문제 링크: https://leetcode.com/problems/shuffle-the-array/
 * 문제: 길이 2n인 배열이 [x1,x2,...,xn,y1,y2,...,yn] 순서로 들어온다.
 * 앞 묶음과 뒤 묶음을 번갈아 놓은 [x1,y1,x2,y2,...,xn,yn]을 반환한다.
 * 입력: int[] nums, int n. 1 <= n <= 500, nums의 길이는 2n이다.
 * 반환: 섞인 순서의 int[].
 * 예: nums=[2,5,1,3,4,7], n=3 -> [2,3,5,4,1,7].
 */
// </review-context>

// 과제_배열_섞기 - LC:1470
/** Java 17. Independent homework reference; keep separate from learner tasks. */
class W01ShuffleArray {
public int[] shuffle(int[] nums, int n) {
    int[] result = new int[2 * n];
    for (int i = 0; i < n; i++) {
        result[2 * i] = nums[i];
        result[2 * i + 1] = nums[i + n];
    }
    return result;
}

    // <review-runner>
    // 실행 확인용입니다. 스타일 골든 비교에서는 이 영역을 제외합니다.
    public static void main(String[] args) {
        W01ShuffleArray example = new W01ShuffleArray();
        reviewCheck(new int[]{2, 3, 5, 4, 1, 7}, example.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3), "공식 예제");
        reviewCheck(new int[]{1, 2}, example.shuffle(new int[]{1, 2}, 1), "한 쌍");
    }

    private static void reviewCheck(Object expected, Object actual, String label) {
        String expectedText = java.util.Arrays.deepToString(new Object[]{expected});
        String actualText = java.util.Arrays.deepToString(new Object[]{actual});
        if (!java.util.Objects.deepEquals(expected, actual)) {
            throw new AssertionError(label + " | expected=" + expectedText + " | actual=" + actualText);
        }
        System.out.println("PASS: " + label + " | result=" + actualText);
    }
    // </review-runner>
}
