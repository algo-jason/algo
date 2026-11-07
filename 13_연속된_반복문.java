// <review-context>
/*
 * [복잡도 예시] 연속된 반복문
 * 상황: 배열 a의 앞 n개 값과 배열 b의 앞 n개 값을 모두 더한다.
 * 입력: int[] a, int[] b, int n. 0 <= n <= 두 배열 각각의 길이라고 가정한다.
 * 반환: 두 배열에서 선택한 값의 합(long).
 * 예: a=[1,2,3], b=[4,5,6], n=3 -> 21.
 * 이 예시는 두 반복문이 차례로 실행될 때 처리 횟수를 세기 위한 코드다.
 * 직접 만든 개념 예시이며 별도의 온라인 문제는 아니다.
 */
// </review-context>

// 연속된_반복문 - slide:w1-s094
class W01ConsecutiveLoops {
    static long sumBoth(int[] a, int[] b, int n) {
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += a[i];
        }
        for (int j = 0; j < n; j++) {
            total += b[j];
        }
        return total;
    }

    // <review-runner>
    // 실행 확인용입니다. 스타일 골든 비교에서는 이 영역을 제외합니다.
    public static void main(String[] args) {
        reviewCheck(21L, sumBoth(new int[]{1, 2, 3}, new int[]{4, 5, 6}, 3), "두 배열의 합");
        reviewCheck(0L, sumBoth(new int[]{}, new int[]{}, 0), "반복 0회");
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
