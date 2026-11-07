// <review-context>
/*
 * [기본 문제] 원점으로 돌아오기 (LeetCode 657)
 * 문제: 로봇이 (0,0)에서 출발해 moves 문자열의 명령을 순서대로 수행한다.
 * U는 위, D는 아래, L은 왼쪽, R은 오른쪽으로 한 칸 이동한다.
 * 지도 경계나 장애물은 없다. 좌표축의 부호는 어떤 방식으로 정해도 된다.
 * 입력: 길이 1~20,000의 문자열. U,D,L,R만 들어온다.
 * 반환: 모든 명령을 수행한 뒤 출발점으로 돌아왔으면 true, 아니면 false.
 * 예: "URDL" -> true, "LL" -> false.
 * 문제 링크: https://leetcode.com/problems/robot-return-to-origin/
 */
// </review-context>

import java.util.*;
class W01RobotOrigin {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int col = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') row--;
            else if (move == 'D') row++;
            else if (move == 'L') col--;
            else if (move == 'R') col++;
        }
        return row == 0 && col == 0;
    }

    // <review-runner>
    // 실행 확인용입니다. 스타일 골든 비교에서는 이 영역을 제외합니다.
    public static void main(String[] args) {
        W01RobotOrigin example = new W01RobotOrigin();
        reviewCheck(true, example.judgeCircle("URDL"), "원점 복귀");
        reviewCheck(false, example.judgeCircle("LL"), "왼쪽으로 두 칸");
        reviewCheck(true, example.judgeCircle("UD"), "위아래 이동");
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
