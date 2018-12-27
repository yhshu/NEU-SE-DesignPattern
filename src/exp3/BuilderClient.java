package exp3;

public class BuilderClient {
    public static void main(String args[]) {
        TreeMenuNodeBuilder treeMenuNodeBuilder = new TreeMenuNodeBuilder();
        TreeMenuNode treeMenuNode = treeMenuNodeBuilder.buildTreeMenu(6);
        System.out.println(treeMenuNode.toString(0));
    }
}
