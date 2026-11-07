// <review-context>
/*
 * [기본 문제] 원소 제거 (LeetCode 27)
 * 문제: 정수 배열 nums에서 val과 같은 값을 모두 제거한다.
 * 학습용 기본 풀이: 새 배열에 남길 값을 모은 뒤 nums의 앞 k칸에 복사한다.
 * 새 배열은 보관용이며 반환값은 k다. 추가 공간은 O(N)을 사용한다.
 * 원문의 in-place 최적화 요구는 후속 학습 대상으로 둔다.
 * 반환: 남은 원소 수 k. 앞 k칸의 순서는 자유이며, 뒤쪽 칸의 값은 채점하지 않는다.
 * 입력: nums 길이 0~100, 원소 0~50, val 0~100.
 * 예: nums=[3,2,2,3], val=3 -> k=2, nums의 앞부분=[2,2].
 * 문제 링크: https://leetcode.com/problems/remove-element/
 */
// </review-context>

// 원소 제거 - LC:27
import java.util.*;

class W01RemoveElement {
    public int removeElement(int[] nums, int val) {
        int[] remaining = new int[nums.length];
        int count = 0;

        for (int currentNumber : nums) {
            if (currentNumber != val) {
                remaining[count] = currentNumber;
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            nums[i] = remaining[i];
        }
        return count;
    }

    // <review-runner>
    // 실행 확인용입니다. 스타일 골든 비교에서는 이 영역을 제외합니다.
    public static void main(String[] args) {
        W01RemoveElement example = new W01RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int count = example.removeElement(nums, 3);
        reviewCheck(2, count, "남은 원소 수");
        reviewCheck(new int[]{2, 2}, java.util.Arrays.copyOf(nums, count), "앞 count칸");
        reviewCheck(0, example.removeElement(new int[]{}, 3), "빈 배열");
        reviewCheck(0, example.removeElement(new int[]{1, 1}, 1), "모두 제거");
        reviewCheck(2, example.removeElement(new int[]{1, 2}, 3), "제거할 값 없음");
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
