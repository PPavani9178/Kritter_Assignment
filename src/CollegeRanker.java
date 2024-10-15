import java.util.*;

class College {
    String name;
    String location;
    int fees;
    int ranking;
    
    College(String name, String location, int fees, int ranking) {
        this.name = name;
        this.location = location;
        this.fees = fees;
        this.ranking = ranking;
    }
}

public class CollegeRanker {

    public static List<College> rankColleges(List<College> colleges, String preferredLocation, int maxFees, int rankingWeight, int feesWeight) {
        List<College> filteredColleges = new ArrayList<>();

        // Step 1: Filter by location and fees
        for (College college : colleges) {
            if (college.location.equalsIgnoreCase(preferredLocation) && college.fees <= maxFees) {
                filteredColleges.add(college);
            }
        }

        // Step 2: Calculate scores and sort by scores
        filteredColleges.sort((c1, c2) -> {
            double score1 = (c1.ranking * rankingWeight) + ((double) c1.fees / maxFees * feesWeight);
            double score2 = (c2.ranking * rankingWeight) + ((double) c2.fees / maxFees * feesWeight);
            return Double.compare(score1, score2);
        });

        return filteredColleges;
    }

    public static void main(String[] args) {
        List<College> colleges = Arrays.asList(
                new College("College A", "New York", 20000, 1),
                new College("College B", "California", 15000, 2),
                new College("College C", "New York", 25000, 3),
                new College("College D", "New York", 10000, 4)
        );

        List<College> rankedColleges = rankColleges(colleges, "New York", 20000, 2, 1);
        for (College college : rankedColleges) {
            System.out.printf("Name: %s, Location: %s, Fees: %d, Ranking: %d\n", college.name, college.location, college.fees, college.ranking);
        }
    }
}
