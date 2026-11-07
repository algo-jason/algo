// 중첩 깊이와 실제 반복 횟수는 구분한다.
// 같은 count++ 작업의 실행 횟수를 센다. 초 단위 실행 속도를 재는 벤치마크가 아니다.
class NestedLoopCounts {
    static long fixedTwoLevels() {
        long count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1000; j++) {
                count++;
            }
        }
        return count;
    }

    static long fixedFourLevels() {
        long count = 0;
        for (int d1 = 0; d1 < 4; d1++) {
            for (int d2 = 0; d2 < 4; d2++) {
                for (int d3 = 0; d3 < 4; d3++) {
                    for (int d4 = 0; d4 < 4; d4++) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static long gridFourDirections(int rows, int cols) {
        long count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int direction = 0; direction < 4; direction++) {
                    count++;
                }
            }
        }
        return count;
    }

    static long gridTwoSteps(int rows, int cols) {
        long count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int first = 0; first < 4; first++) {
                    for (int second = 0; second < 4; second++) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        check(100_000, fixedTwoLevels(), "100 × 1000");
        check(256, fixedFourLevels(), "4 × 4 × 4 × 4");
        check(24, gridFourDirections(2, 3), "2 × 3 × 4");
        check(96, gridTwoSteps(2, 3), "2 × 3 × 4 × 4");
        check(60, gridFourDirections(3, 5), "직사각형의 4방향");
        check(240, gridTwoSteps(3, 5), "직사각형의 두 방향 선택");
        check(0, gridFourDirections(0, 3), "행이 없을 때");
        check(0, gridTwoSteps(2, 0), "열이 없을 때");
    }

    private static void check(long expected, long actual, String label) {
        if (expected != actual) {
            throw new AssertionError(label + ": " + actual);
        }
        System.out.println("PASS: " + label + " = " + actual);
    }
}
