// <review-context>
/*
 * [복잡도 예시] 점수의 합
 * 상황: 학생들의 점수가 들어 있는 scores 배열의 전체 합을 구한다.
 * 입력: int[] scores. 이 예시에서는 빈 배열도 받을 수 있다.
 * 반환: 모든 원소의 합(long). 빈 배열이면 0이다.
 * int 범위를 넘는 합도 표현할 수 있도록 반환형과 누적값을 long으로 둔다.
 * 예: [10,20,30] -> 60, [] -> 0.
 * 직접 만든 개념 예시이며 별도의 온라인 문제는 아니다.
 */
// </review-context>

// 점수의_합 - slide:w1-s083 - PPT 61, 85쪽
class W01ScoreSum {
    static long sum(int[] scores) {
        long total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }
        return total;
    }

    // <review-runner>
    // 실행 확인용입니다. 스타일 골든 비교에서는 이 영역을 제외합니다.
    public static void main(String[] args) {
        reviewCheck(60L, sum(new int[]{10, 20, 30}), "점수의 합");
        reviewCheck(0L, sum(new int[]{}), "빈 배열");
        reviewCheck(4000000000L, sum(new int[]{2000000000, 2000000000}), "int 범위를 넘는 합");
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
