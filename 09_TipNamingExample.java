// TIP-001: 같은 조건을 검사하되, 이름으로 그 의미를 드러낸다.
// onBeam에는 보의 어느 끝에서든 받쳐지는지를 미리 계산해 전달한다.
class TipNamingExample {
    static boolean f(
            boolean a,
            boolean b,
            boolean c) {
        return a || b || c;
    }

    static boolean canPlacePillar(
            boolean onGround,
            boolean onPillar,
            boolean onBeam) {
        return onGround || onPillar || onBeam;
    }

    public static void main(String[] args) {
        int checks = 0;
        for (int flags = 0; flags < 8; flags++) {
            boolean onGround = (flags & 1) != 0;
            boolean onPillar = (flags & 2) != 0;
            boolean onBeam = (flags & 4) != 0;
            boolean expected = flags != 0;
            if (f(onGround, onPillar, onBeam) != expected
                    || canPlacePillar(onGround, onPillar, onBeam) != expected) {
                throw new AssertionError("지지 조건의 결과가 다릅니다.");
            }
            checks++;
        }
        System.out.println("PASS: " + checks + " support combinations");
    }
}
