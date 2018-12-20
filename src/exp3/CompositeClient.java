package exp3;

public class CompositeClient {
    public static void main(String[] args) {
        TreeMenuNode level_1 = new TreeMenuNode("Level_1");

        TreeMenuNode level2_1 = new TreeMenuNode("Level2_1");
        level_1.add(level2_1);

        TreeMenuNode level3_1_1 = new TreeMenuNode("Level3_1_1");
        level2_1.add(level3_1_1);

        TreeMenuNode level3_1_2 = new TreeMenuNode("Level3_1_2");
        level2_1.add(level3_1_2);

        TreeMenuNode level2_2 = new TreeMenuNode("Level2_2");
        level_1.add(level2_2);

        TreeMenuNode level3_2_1 = new TreeMenuNode("Level3_2_1");
        level2_2.add(level3_2_1);

        TreeMenuNode level3_2_2 = new TreeMenuNode("Level3_2_2");
        level2_2.add(level3_2_2);

        System.out.println(level_1.toString(0));
    }
}
