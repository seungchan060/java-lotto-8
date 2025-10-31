package lotto;

public enum Rank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    MISS(0, false, 0L);

    private final int matchCount;
    private final boolean requiresBonus;
    private final long prize;

    Rank(int matchCount, boolean requiresBonus, long prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    public long prize() {
        return prize;
    }

    public static Rank from(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatched) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return MISS;
    }
}
