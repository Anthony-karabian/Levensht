public class main {

    public static void main(String[] args) {


        CharSequence s1 = "ACGCCG";

        CharSequence s2 = "ACCGTCG";

        int[][] distance = computeLevenshteinDistance(s1, s2);

        for (int i = 0; i < s2.length() + 1; i++) {
            for (int j = 0; j < s1.length() + 1; j++) {
                System.out.print(distance[i][j]+ ",");
            }
            System.out.println();
        }
    }

    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private static int maximum(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static int[][] computeLevenshteinDistance(CharSequence s1, CharSequence s2) {
        int[][] distance = new int[s2.length() + 1][s1.length() + 1];

        for (int i = 0; i <= s2.length(); i++)
            distance[i][0] = i * -4;
        for (int j = 1; j <= s1.length(); j++)
            distance[0][j] = j * -4;

        for (int i = 1; i <= s2.length(); i++) {
            for (int j = 1; j <= s1.length(); j++) {
                int insertion = distance[i][j - 1] - 4;
                int deletion = distance[i - 1][j] - 4;
                int replacement = distance[i - 1][j - 1] + computeSubstitution(s2.charAt(i-1), s1.charAt(j-1));
                distance[i][j] = maximum(deletion, insertion, replacement);
            }
        }

        return distance;
    }

    public static int computeSubstitution(char i, char j){

        int subPoint = 0;

        if(i == j)
            subPoint = 1;

        if(i == 'A' && j == 'C')
            subPoint = -1;

        if(i == 'A' && j == 'G')
            subPoint = -2;

        if(i == 'A' && j == 'T')
            subPoint = -1;

        if(i == 'C' && j == 'A')
            subPoint = -1;

        if(i == 'C' && j == 'G')
            subPoint = -3;

        if(i == 'C' && j == 'T')
            subPoint = -1;

        if(i == 'G' && j == 'A')
            subPoint = -2;

        if(i == 'G' && j == 'C')
            subPoint = -3;

        if(i == 'G' && j == 'T')
            subPoint = -2;

        if(i == 'T' && j == 'A')
            subPoint = -1;

        if(i == 'T' && j == 'C')
            subPoint = -1;

        if(i == 'T' && j == 'G')
            subPoint = -2;

        return subPoint;
    }
}
