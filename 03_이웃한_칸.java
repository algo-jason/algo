// <review-context>
/*
 * [기본 문제] 이웃한 칸
 * 문제: 색 이름이 적힌 정사각형 격자 board에서 (h,w)칸과 색이 같은 이웃 칸의 수를 구한다.
 * 입력: board[row][col]은 해당 칸의 색 문자열. h는 행, w는 열이며 인덱스는 0부터 시작한다.
 * 이웃은 위·아래·왼쪽·오른쪽이다. 대각선, 자기 자신, 격자 밖은 세지 않는다.
 * 반환: 색이 같은 이웃 칸의 수(0~4).
 * 예: board=[["A","A"],["B","A"]], h=0, w=0 -> 1.
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/250125
 */
// </review-context>

// 이웃한 칸 - PG:250125
import java.util.*;
class W01SameColor {
    public int solution(String[][] board, int h, int w) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String targetColor = board[h][w];
        int count = 0;
        for (int[] direction : directions) {
            int row = h + direction[0];
            int col = w + direction[1];
            if (row < 0 || row >= board.length) continue;
            if (col < 0 || col >= board[0].length) continue;

            String currentColor = board[row][col];
            if (targetColor.equals(currentColor)) count++;
        }
        return count;
    }

    // <review-runner>
    // 실행 확인용입니다. 스타일 골든 비교에서는 이 영역을 제외합니다.
    public static void main(String[] args) {
        W01SameColor example = new W01SameColor();
        reviewCheck(1, example.solution(new String[][]{{"A", "A"}, {"B", "A"}}, 0, 0), "모서리 칸");
        reviewCheck(0, example.solution(new String[][]{{"A"}}, 0, 0), "한 칸");
        reviewCheck(4, example.solution(new String[][]{{"A", "A", "A"}, {"A", "A", "A"}, {"A", "A", "A"}}, 1, 1), "가운데 칸");
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
