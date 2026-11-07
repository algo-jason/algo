// 길이 2인 대문자 문자열의 모든 후보를 확인하는 개념 시연이다.
// 실제 서비스의 비밀번호를 검사하거나 공격하는 프로그램이 아니다.
class PasswordCandidates {
    private final String expected;
    PasswordCandidates(String expected) { this.expected = expected; }
public String solution() {
    for (char first = 'A'; first <= 'Z'; first++) {
        for (char second = 'A'; second <= 'Z'; second++) {
            String candidate = "" + first + second;
            if (isCorrect(candidate)) {
                return candidate;
            }
        }
    }
    return "";
}
    private boolean isCorrect(String candidate) {
        return candidate.equals(expected);
    }
    public static void main(String[] args) {
        for (String expected : new String[]{"AA", "AZ", "BA", "ZZ"}) {
            String actual = new PasswordCandidates(expected).solution();
            if (!actual.equals(expected)) throw new AssertionError(expected);
        }
        if (!new PasswordCandidates("AAA").solution().equals("")) throw new AssertionError();
        System.out.println("PasswordCandidates: 5 checks passed");
    }
}
