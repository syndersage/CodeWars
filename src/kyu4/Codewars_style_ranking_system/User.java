package kyu4.Codewars_style_ranking_system;

public class User {
    public int rank = -8;
    public int progress = 0;

    User() {}

    User(int rank, int progress) {
        this.rank = rank;
        this.progress = progress;
    }

    public void incProgress(int kataRank) {
        System.out.println(this + " " + kataRank);
        if (kataRank > 8 || kataRank < -8 || kataRank == 0) throw new RuntimeException();
        if (rank == 8) return;
        int diff = rank - kataRank;
        if (rank == -1 & kataRank == 1) progress += 10;
        else if (rank == 1 & kataRank == -1) progress++;
        else {
            if (rank <= -1 & kataRank >= 1) diff++;
            if (diff > 1) return;
            if (diff == 0) progress += 3;
            else if (diff == 1) progress += 1;
            else progress += 10 * diff * diff;
        }
        upRank();
    }

    private void upRank() {
        if (progress < 100) return;
        int rankDiff = progress / 100;
        if (rank <= -1 && rank + rankDiff >= 0) rankDiff++;
        progress = progress % 100;
        rank += rankDiff;
        if (rank >= 8) {
            rank = 8;
            progress = 0;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "rank=" + rank +
                ", progress=" + progress +
                '}';
    }

    public static void main(String[] args) {
        var user = new User(1, 61);
        System.out.println(user);
        user.incProgress(8);
        System.out.println(user);
    }
}
