// <review-context>
/*
 * [공간 복잡도 예시] 같은 배열과 새 배열
 * 상황: 입력 배열 nums와 값은 같지만 별개의 객체인 새 배열을 만든다.
 * 입력: int[] nums. 반환: 각 원소를 복사한 새 int[].
 * 복사한 배열의 값을 바꾸어도 원본 nums의 값은 바뀌지 않아야 한다.
 * 코드의 same=nums는 원본 배열을 함께 가리키는 참조이며 새 배열을 만드는 동작이 아니다.
 * 예: nums=[1,2,3] -> [1,2,3]. 반환 배열의 0번을 99로 바꾸어도 nums[0]은 1이다.
 * 직접 만든 개념 예시이며 별도의 온라인 문제는 아니다.
 */
// </review-context>

// 같은_배열과_새_배열 - slide:w1-s109
class W01ArrayCopy {
    static int[] copy(int[] nums) {
        int[] same = nums;
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        return copy;
    }

    // <review-runner>
    // 실행 확인용입니다. 스타일 골든 비교에서는 이 영역을 제외합니다.
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] result = copy(nums);
        reviewCheck(new int[]{1, 2, 3}, result, "복사한 값");
        reviewCheck(false, nums == result, "서로 다른 배열");
        result[0] = 99;
        reviewCheck(1, nums[0], "복사본 변경 후 원본");
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
