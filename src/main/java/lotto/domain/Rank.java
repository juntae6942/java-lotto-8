package lotto.domain;

import java.util.Map;

public enum Rank {

    NONE(0, false, "0원"),
    FIFTH(3, false, "5,000원"),
    FOURTH(4, false, "50,000원"),
    THIRD(5, false, "1,500,000원"),
    SECOND(5, true, "30,000,000원"),
    FIRST(6, false, "2,000,000,000원");

    private final int matchCount;
    private final boolean hasBonus;
    private final String prize;

    Rank(int matchCount, boolean hasBonus, String prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    private static final Map<Integer, Rank> rankByCount = Map.of(
            6, FIRST,
            4, FOURTH,
            3, FIFTH
    );

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 5) {
            if (bonusMatch) {
                return SECOND;
            }
            return THIRD;
        }
        return rankByCount.getOrDefault(matchCount, NONE);
    }

    public String toString() {
        if (hasBonus) {
            return matchCount + "개 일치, 보너스 볼 일치 (" + prize + ")";
        }
        return matchCount + "개 일치 (" + prize + ")";
    }
}
