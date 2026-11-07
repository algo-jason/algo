 // <review-context>
/*
 * [기본 문제] 각도기
 * 문제: 정수 각도 angle을 받아 각의 종류를 숫자로 반환한다.
 * 입력: 1 <= angle <= 180.
 * 반환: 0 < angle < 90이면 예각(1), 90이면 직각(2),
 *       90 < angle < 180이면 둔각(3), 180이면 평각(4).
 * 예: angle=89 -> 1, angle=90 -> 2, angle=91 -> 3, angle=180 -> 4.
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120829
 */
// </review-context>

// 각도기 - PG:120829
import java.util.*;

class W01Angle {
    private static int 예각 = 1;
    private static int 직각 = 2;
    private static int 둔각 = 3;
    private static int 평각 = 4;

    public int solution(int angle) {
        if (angle < 90) return 예각;
        if (angle == 90) return 직각;
        if (angle < 180) return 둔각;
        return 평각;
    }

    // <review-runner>
    // 실행 확인용입니다. 스타일 골든 비교에서는 이 영역을 제외합니다.
    public static void main(String[] args) {
        reviewCheck(1, new W01Angle().solution(1), "angle=1");
        reviewCheck(1, new W01Angle().solution(89), "angle=89");
        reviewCheck(2, new W01Angle().solution(90), "angle=90");
        reviewCheck(3, new W01Angle().solution(91), "angle=91");
        reviewCheck(3, new W01Angle().solution(179), "angle=179");
        reviewCheck(4, new W01Angle().solution(180), "angle=180");
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
