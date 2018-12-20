package exp3;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TreeMenuNodeBuilder {
    /**
     * 广度优先构造满二叉树
     *
     * @param level 满二叉树层数
     * @return 根结点
     */
    public TreeMenuNode buildTreeMenu(int level) {
        if (level == 0)
            return null;
        Queue<TreeMenuNode> queue = new ConcurrentLinkedQueue<>();
        TreeMenuNode root = new TreeMenuNode("level_1");
        queue.add(root);
        if (level == 1)
            return root;
        queue.add(new TreeMenuNode("null"));
        int l = 1;
        while (!queue.isEmpty()) {
            TreeMenuNode cur = queue.poll();
            if (cur.getName().equals("null")) {
                // 一层已结束
                if (l + 1 >= level)
                    break;
                l++;
                queue.add(new TreeMenuNode("null"));
            } else {
                String subName1;
                String subName2;
                if (l == 1) {
                    subName1 = "level_2_1";
                    subName2 = "level_2_2";
                } else {
                    String[] curNameSplit = cur.getName().split("_", 3);
                    String namePrefix = curNameSplit[2];
                    subName1 = "level_" + (l + 1) + "_" + namePrefix + "_1";
                    subName2 = "level_" + (l + 1) + "_" + namePrefix + "_2";
                }
                TreeMenuNode sub1 = new TreeMenuNode(subName1);
                cur.add(sub1);
                queue.add(sub1);
                TreeMenuNode sub2 = new TreeMenuNode(subName2);
                cur.add(sub2);
                queue.add(sub2);
            }
        }
        return root;
    }
}
