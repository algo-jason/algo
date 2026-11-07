import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 기둥과 보 설치: https://school.programmers.co.kr/learn/courses/30/lessons/60061
// [x, y, 종류] 목록을 x, y, 종류의 오름차순으로 정렬하는 부분 연습이다.
// 종류 0은 기둥, 1은 보다. 설치 가능 여부를 판정하는 전체 풀이와 분리했다.
class StructureSorting {
    static void sortArray(int[][] structures) {
        Arrays.sort(structures,
            Comparator.comparingInt((int[] structure) -> structure[0])
                .thenComparingInt(structure -> structure[1])
                .thenComparingInt(structure -> structure[2]));
    }

    static void sortList(List<int[]> structures) {
        structures.sort(
            Comparator.comparingInt((int[] structure) -> structure[0])
                .thenComparingInt(structure -> structure[1])
                .thenComparingInt(structure -> structure[2]));
    }

    public static void main(String[] args) {
        int[][] input = {{2, 1, 0}, {1, 1, 1}, {1, 0, 0}, {1, 1, 0}};
        int[][] expected = {{1, 0, 0}, {1, 1, 0}, {1, 1, 1}, {2, 1, 0}};
        sortArray(input);
        if (!Arrays.deepEquals(input, expected)) {
            throw new AssertionError("배열의 x/y/종류 순서가 다릅니다.");
        }
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{2, 1, 0});
        list.add(new int[]{1, 1, 1});
        list.add(new int[]{1, 0, 0});
        list.add(new int[]{1, 1, 0});
        sortList(list);
        if (!Arrays.deepEquals(list.toArray(new int[0][]), expected)) {
            throw new AssertionError("리스트의 x/y/종류 순서가 다릅니다.");
        }
        int[][] empty = {};
        sortArray(empty);
        if (empty.length != 0) throw new AssertionError("빈 배열이 달라졌습니다.");
        System.out.println("PASS: array / list / x ties / y ties / type ties / empty");
        System.out.println(Arrays.deepToString(input));
    }
}
