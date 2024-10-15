package test;

import org.junit.Test;
import static org.junit.Assert.*;
import src.CollegeRanker;
import src.utils.HelperClass;

import java.util.ArrayList;
import java.util.List;

public class CollegeRankingSystemTest {

    @Test
    public void testCollegeRanking() {
        // Create a list of colleges
        List<CollegeRanker.College> colleges = new ArrayList<>();
        colleges.add(new CollegeRanker.College("College A", "New York", 20000, 1));
        colleges.add(new CollegeRanker.College("College B", "California", 15000, 2));
        colleges.add(new CollegeRanker.College("College C", "New York", 25000, 3));
        colleges.add(new CollegeRanker.College("College D", "New York", 10000, 4));

        // User preferences
        String preferredLocation = "New York";
        int maxFees = 20000;
        int rankingWeight = 2;
        int feesWeight = 1;

        // Rank colleges based on user preferences
        List<CollegeRanker.College> rankedColleges = CollegeRanker.rankColleges(colleges, preferredLocation, maxFees, rankingWeight, feesWeight);

        // Verify the ranking results
        assertEquals(2, rankedColleges.size());  // Only two colleges should match the criteria

        // Check if College A is ranked first with the lowest score
        assertEquals("College A", rankedColleges.get(0).getName());
        assertEquals("College D", rankedColleges.get(1).getName());

        // Verify scores
        assertEquals(4.00, rankedColleges.get(0).getScore(), 0.01);
        assertEquals(9.00, rankedColleges.get(1).getScore(), 0.01);
    }

    @Test
    public void testNoMatchingColleges() {
        // Create a list of colleges
        List<CollegeRanker.College> colleges = new ArrayList<>();
        colleges.add(new CollegeRanker.College("College A", "California", 20000, 1));

        // User preferences
        String preferredLocation = "New York";
        int maxFees = 15000;
        int rankingWeight = 2;
        int feesWeight = 1;

        // Rank colleges based on user preferences
        List<CollegeRanker.College> rankedColleges = CollegeRanker.rankColleges(colleges, preferredLocation, maxFees, rankingWeight, feesWeight);

        // Verify that no colleges match the user's preferences
        assertEquals(0, rankedColleges.size());
    }
}
