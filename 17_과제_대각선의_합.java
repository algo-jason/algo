// <review-context>
/*
 * [과제] 대각선의 합 (LeetCode 1572)
 * 문제 링크: https://leetcode.com/problems/matrix-diagonal-sum/
 * 문제: 정사각형 행렬 mat의 왼쪽 위~오른쪽 아래 대각선과
 * 오른쪽 위~왼쪽 아래 대각선에 있는 원소를 모두 더한다.
 * 홀수 크기에서는 가운데 칸이 두 대각선에 동시에 속하므로 한 번만 더한다.
 * 입력: 한 변의 길이가 1~100인 int[][] mat. 반환: 대각선 원소의 합(int).
 * 예: [[1,2,3],[4,5,6],[7,8,9]] -> 25(가운데 5는 한 번만 포함).
 */
// </review-context>

// 과제_대각선의_합 - LC:1572
/** Java 17. Independent homework reference; keep separate from learner tasks. */
class W01DiagonalSum {
public int diagonalSum(int[][] mat) {
    int n = mat.length, sum = 0;
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            if (r == c || r + c == n - 1) sum += mat[r][c];
        }
    }
    return sum;
}

    // <review-runner>
    // 실행 확인용입니다. 스타일 골든 비교에서는 이 영역을 제외합니다.
    public static void main(String[] args) {
        W01DiagonalSum example = new W01DiagonalSum();
        reviewCheck(25, example.diagonalSum(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}), "홀수 크기: 가운데 한 번");
        reviewCheck(10, example.diagonalSum(new int[][]{{1,2}, {3,4}}), "짝수 크기");
        reviewCheck(5, example.diagonalSum(new int[][]{{5}}), "한 칸");
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
