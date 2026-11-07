// 고정 배열의 여러 구간 합을 두 방법으로 비교하는 트레이드오프 예시다.
// 별도 누적합 과제나 실전 문제로 제시하지 않는다.
class PrefixSumComparison {
static long[] createPrefixSums(int[] numbers) {
    long[] prefix = new long[numbers.length + 1];
    for (int i = 0; i < numbers.length; i++) {
        prefix[i + 1] = prefix[i] + numbers[i];
    }
    return prefix;
}
static long sumRange(long[] prefix, int left, int right) {
    return prefix[right + 1] - prefix[left];
}
    public static void main(String[] args) {
        int[] numbers = {4, 2, 7, 1, 3};
        long[] prefix = createPrefixSums(numbers);
        if (sumRange(prefix, 1, 3) != 10) throw new AssertionError();
        if (sumRange(prefix, 0, 0) != 4) throw new AssertionError();
        if (sumRange(prefix, 0, 4) != 17) throw new AssertionError();
        if (createPrefixSums(new int[0]).length != 1) throw new AssertionError();
        System.out.println("PrefixSumComparison: 4 checks passed");
    }
}
