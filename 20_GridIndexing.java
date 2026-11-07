import java.util.Arrays;

// 격자를 행 순서대로 펼치고, 일차원 배열을 다시 격자로 복원한다.
// 모든 위치는 0부터 센다. 각 행의 칸 수가 같은 직사각형 격자를 다룬다.
class GridIndexing {
    static int[] flatten(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] flat = new int[rows * cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int index = row * cols + col;
                flat[index] = grid[row][col];
            }
        }
        return flat;
    }

    static int[][] restore(int[] flat, int rows, int cols) {
        int[][] grid = new int[rows][cols];

        for (int index = 0; index < flat.length; index++) {
            int row = index / cols;
            int col = index % cols;
            grid[row][col] = flat[index];
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2}, {3, 4, 5}};
        int[] flat = flatten(grid);
        if (!Arrays.equals(flat, new int[]{0, 1, 2, 3, 4, 5})) {
            throw new AssertionError("행 순서로 펼친 결과가 다릅니다.");
        }
        if (!Arrays.deepEquals(restore(flat, 2, 3), grid)) {
            throw new AssertionError("직사각형 격자 복원 결과가 다릅니다.");
        }
        int[][] column = {{7}, {8}, {9}};
        if (!Arrays.deepEquals(restore(flatten(column), 3, 1), column)) {
            throw new AssertionError("한 열 격자 복원 결과가 다릅니다.");
        }
        System.out.println("PASS: flatten / restore / rectangular grid / one column");
        System.out.println(Arrays.toString(flat));
    }
}
