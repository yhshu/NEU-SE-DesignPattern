package exp3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TreeMenuNode {
    private String name;
    private List<TreeMenuNode> subordinates;

    /**
     * 构造方法
     */
    public TreeMenuNode(String name) {
        this.name = name;
        this.subordinates = new CopyOnWriteArrayList<>();
    }

    public void add(TreeMenuNode treeMenuNode) {
        subordinates.add(treeMenuNode);
    }

    public void remove(TreeMenuNode treeMenuNode) {
        subordinates.remove(treeMenuNode);
    }

    public String getName() {
        return this.name;
    }

    public List<TreeMenuNode> getSubordinates() {
        return this.subordinates;
    }

    /**
     * 打印以当前结点为根结点的树形菜单
     */
    public String toString(int startLevel) {
        StringBuilder sb = new StringBuilder();
        builderAppendTab(startLevel, sb);
        sb.append(name).append("\n");
        if (!subordinates.isEmpty()) { // 如果含有子结点
            for (TreeMenuNode treeMenuNode : subordinates) {
                sb.append(treeMenuNode.toString(startLevel + 1));
            }
        }
        return sb.toString();
    }

    public void builderAppendTab(int count, StringBuilder stringBuilder) {
        for (int i = 0; i < count; i++) {
            stringBuilder.append("\t");
        }
    }
}
