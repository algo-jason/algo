// <review-context>
/*
 * [실전 문제 2] 기둥과 보 설치 - 프로그래머스 Lv.3
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/60061
 * 문제: n x n 크기의 벽에 기둥과 보를 설치·삭제하고, 최종적으로 남은 구조물을 반환한다.
 * 명령 [x,y,a,b]에서 a=0은 기둥, a=1은 보, b=1은 설치, b=0은 삭제다.
 * 기둥은 (x,y)에서 위로 길이 1, 보는 (x,y)에서 오른쪽으로 길이 1이다.
 * 기둥은 바닥 위, 다른 기둥 위, 보의 한쪽 끝 위에 있을 수 있다.
 * 보는 한쪽 끝이 기둥 위에 있거나, 양쪽 끝이 다른 보와 동시에 연결되어야 한다.
 * 설치·삭제 후 남은 구조물 하나라도 규칙을 어기면 해당 명령을 무시한다.
 * 반환: [x,y,a] 목록을 x, y, a의 오름차순으로 정렬한 int[][].
 * 범위: n=5~100, 명령 1~1,000개. 좌표의 원점은 벽의 왼쪽 아래다.
 * 예: n=5, commands=[[1,0,0,1],[1,1,1,1]] -> [[1,0,0],[1,1,1]].
 */
// </review-context>

import java.util.*;

class W01Structures {
    public int[][] solution(int n, int[][] buildFrame) {
        boolean[][] 기둥_배열 = new boolean[n + 2][n + 2];
        boolean[][] 보_배열 = new boolean[n + 2][n + 2];

        for (int[] command : buildFrame) {
            applyCommand(command, 기둥_배열, 보_배열, n);
        }

        return makeAnswer(기둥_배열, 보_배열, n);
    }

    // 명령 판단 + 적용
    private void applyCommand(int[] command, boolean[][] 기둥_배열, boolean[][] 보_배열, int n) {
        int x = command[0];
        int y = command[1];
        boolean is_보 = command[2] == 1;
        boolean isInstall = command[3] == 1;

        // 바꾸기 전 값 보관
        boolean[][] structure = is_보 ? 보_배열 : 기둥_배열;
        boolean previous = structure[x][y];

        // 먼저 설치하거나 삭제
        structure[x][y] = isInstall;

        // 검증
        if (isInvalidStructure(기둥_배열, 보_배열, n)) {
            // 되돌리기
            structure[x][y] = previous;
        }
    }

    private boolean isInvalidStructure(boolean[][] 기둥_배열, boolean[][] 보_배열, int n) {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (기둥_배열[x][y] && !canBuild_기둥(기둥_배열, 보_배열, x, y)) {
                    return true;
                }

                if (보_배열[x][y] && !canBuild_보(기둥_배열, 보_배열, x, y)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canBuild_기둥(boolean[][] 기둥_배열, boolean[][] 보_배열, int x, int y) {
        // 맨땅이면 바로 설치 가능
        if (y == 0) {
            return true;
        }

        // 기둥 아래 기둥 있으면 설치 가능
        boolean below = 기둥_배열[x][y - 1];
        if (below) {
            return true;
        }

        // 왼쪽에 보 있으면 설치 가능
        boolean left = x > 0 && 보_배열[x - 1][y];
        if (left) {
            return true;
        }

        // 오른쪽에 보 있으면 설치 가능
        boolean right = 보_배열[x][y];
        if (right) {
            return true;
        }

        // 어느 조건도 만족하지 않으면 설치 불가능
        return false;
    }

    private boolean canBuild_보(boolean[][] 기둥_배열, boolean[][] 보_배열, int x, int y) {
        // 맨땅에는 보를 설치할 수 없음
        if (y == 0) {
            return false;
        }

        // 왼쪽 끝 아래에 기둥 있으면 설치 가능
        boolean belowLeft = 기둥_배열[x][y - 1];
        if (belowLeft) {
            return true;
        }

        // 오른쪽 끝 아래에 기둥 있으면 설치 가능
        boolean belowRight = 기둥_배열[x + 1][y - 1];
        if (belowRight) {
            return true;
        }

        // 양쪽 끝이 다른 보와 연결되어 있으면 설치 가능
        boolean left = x > 0 && 보_배열[x - 1][y];
        boolean right = 보_배열[x + 1][y];
        if (left && right) {
            return true;
        }

        // 어느 조건도 만족하지 않으면 설치 불가능
        return false;
    }

    private int[][] makeAnswer(boolean[][] 기둥_배열, boolean[][] 보_배열, int n) {
        List<int[]> structures = new ArrayList<>();

        // x, y, 구조물 종류 순서로 담으면 요구한 정렬 순서가 된다.
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (기둥_배열[x][y]) {
                    structures.add(new int[]{x, y, 0});
                }

                if (보_배열[x][y]) {
                    structures.add(new int[]{x, y, 1});
                }
            }
        }

        return structures.toArray(new int[structures.size()][]);
    }

    // <review-runner>
    // 실행 확인용입니다. 스타일 골든 비교에서는 이 영역을 제외합니다.
    public static void main(String[] args) {
        W01Structures example = new W01Structures();
        int[][] commands = {{1,0,0,1}, {1,1,1,1}, {2,1,0,1}, {2,2,1,1}, {5,0,0,1}, {5,1,0,1}, {4,2,1,1}, {3,2,1,1}};
        int[][] expected = {{1,0,0}, {1,1,1}, {2,1,0}, {2,2,1}, {3,2,1}, {4,2,1}, {5,0,0}, {5,1,0}};
        reviewCheck(expected, example.solution(5, commands), "공식 예제 1");
        int[][] deletion = {{0,0,0,1}, {2,0,0,1}, {4,0,0,1}, {0,1,1,1}, {1,1,1,1}, {2,1,1,1}, {3,1,1,1}, {2,0,0,0}, {1,1,1,0}, {2,2,0,1}};
        reviewCheck(new int[][]{{0,0,0}, {0,1,1}, {1,1,1}, {2,1,1}, {3,1,1}, {4,0,0}}, example.solution(5, deletion), "공식 예제 2: 삭제와 복원");
        reviewCheck(new int[0][3], example.solution(5, new int[][]{{0,0,0,1}, {0,0,0,0}}), "설치 후 삭제");
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
