// <review-context>
/*
 * [실전 문제 1] n² 배열 자르기 - 프로그래머스 Lv.2
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * 문제: n×n 격자에서 i=1부터 n까지, 왼쪽 위 i×i 영역의 비어 있는 칸에 i를 채운다.
 * 각 행을 위에서 아래로 이어 붙인 뒤, left부터 right까지의 값을 반환한다(양 끝 포함).
 * 배열 인덱스는 0부터 센다. n은 최대 10,000,000이고, 반환할 원소는 최대 100,000개다.
 * 예: n=3, left=2, right=5 → [3,2,2,3].
 * 예: n=4, left=7, right=14 → [4,3,3,3,4,4,4,4].
 */
// </review-context>

class W01ArraySlice {
    public int[] solution(int n, long left, long right) {
        return makeSlicedNNArray(n, left, right);
    }

    private int[] makeSlicedNNArray(int n, long left, long right) {
        int size = (int) (right - left + 1);
        int[] result = new int[size];

        for (long currentNumber = left; currentNumber <= right; currentNumber++) {
            int row = (int) (currentNumber / n);
            int col = (int) (currentNumber % n);
            int resultIndex = (int) (currentNumber - left);

            // 이 칸을 처음 덮는 정사각형의 한 변 길이를 넣는다.
            if (col <= row) {
                result[resultIndex] = row + 1;
                continue;
            }

            result[resultIndex] = col + 1;
        }

        return result;
    }

    // <review-runner>
    // 실행 확인용입니다. 스타일 골든 비교에서는 이 영역을 제외합니다.
    public static void main(String[] args) {
        W01ArraySlice example = new W01ArraySlice();
        reviewCheck(new int[]{3, 2, 2, 3}, example.solution(3, 2L, 5L), "공식 예제 1");
        reviewCheck(new int[]{4, 3, 3, 3, 4, 4, 4, 4}, example.solution(4, 7L, 14L), "공식 예제 2");
        reviewCheck(new int[]{1}, example.solution(1, 0L, 0L), "최소 크기");
        reviewCheck(new int[]{3, 4, 4, 4, 4, 4}, example.solution(4, 10L, 15L), "해설 예제");
        reviewCheck(new int[]{10_000_000}, example.solution(10_000_000, 99_999_999_999_999L, 99_999_999_999_999L), "int 범위를 넘는 위치");
    }

    private static void reviewCheck(int[] expected, int[] actual, String label) {
        if (!java.util.Arrays.equals(expected, actual)) {
            throw new AssertionError(label + " | expected=" + java.util.Arrays.toString(expected)
                    + " | actual=" + java.util.Arrays.toString(actual));
        }
        System.out.println("PASS: " + label + " | result=" + java.util.Arrays.toString(actual));
    }
    // </review-runner>
}
