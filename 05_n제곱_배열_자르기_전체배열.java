// <review-context>
/*
 * [실전 문제 1] n² 배열 자르기 - 프로그래머스 Lv.2
 * 수업용 첫 풀이. 전체 격자를 만드는 과정을 작은 입력으로 확인한다.
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * 문제: n×n 격자에서 i=1부터 n까지, 왼쪽 위 i×i 영역의 비어 있는 칸에 i를 채운다.
 * 각 행을 위에서 아래로 이어 붙인 뒤, left부터 right까지의 값을 반환한다(양 끝 포함).
 * 배열 인덱스는 0부터 센다. n은 최대 10,000,000이고, 반환할 원소는 최대 100,000개다.
 * 예: n=3, left=2, right=5 → [3,2,2,3].
 * 예: n=4, left=7, right=14 → [4,3,3,3,4,4,4,4].
 */
// </review-context>

class W01ArraySliceWhole {
    public int[] solution(int n, long left, long right) {
        int[][] array = createEmptyArray(n);
        fillNumbers(array);
        int[] flattenedArray = concatArray(array);
        return sliceArrayByRange(flattenedArray, left, right);
    }

    private int[][] createEmptyArray(int n) {
        return new int[n][n];
    }

    private void fillNumbers(int[][] array) {
        int n = array.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (col <= row) {
                    array[row][col] = row + 1;
                    continue;
                }

                array[row][col] = col + 1;
            }
        }
    }

    private int[] concatArray(int[][] array) {
        int n = array.length;
        int[] result = new int[n * n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int index = row * n + col;
                result[index] = array[row][col];
            }
        }

        return result;
    }

    private int[] sliceArrayByRange(int[] array, long left, long right) {
        int size = (int) (right - left + 1);
        int[] result = new int[size];

        for (long i = left; i <= right; i++) {
            int arrayIndex = (int) i;
            int resultIndex = (int) (i - left);
            result[resultIndex] = array[arrayIndex];
        }

        return result;
    }

    // <review-runner>
    // 실행 확인용입니다. 스타일 골든 비교에서는 이 영역을 제외합니다.
    public static void main(String[] args) {
        W01ArraySliceWhole example = new W01ArraySliceWhole();
        reviewCheck(new int[]{3, 2, 2, 3}, example.solution(3, 2L, 5L), "공식 예제 1");
        reviewCheck(new int[]{4, 3, 3, 3, 4, 4, 4, 4}, example.solution(4, 7L, 14L), "공식 예제 2");
        reviewCheck(new int[]{1}, example.solution(1, 0L, 0L), "최소 크기");
        reviewCheck(new int[]{3, 4, 4, 4, 4, 4}, example.solution(4, 10L, 15L), "해설 예제");
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
