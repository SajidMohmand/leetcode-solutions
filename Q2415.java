
public class Q2415 {
//    public TreeNode reverseOddLevels(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        List<List<Integer>> levels = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//            List<Integer> currentLevel = new ArrayList<>();
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode node = queue.poll();
//                currentLevel.add(node.val);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            levels.add(currentLevel);
//        }
//        for (int i = 1; i < levels.size(); i += 2) {
//            List<Integer> currentLevel = levels.get(i);
//            Collections.reverse(currentLevel);
//            levels.set(i, currentLevel);
//        }
//        queue.add(root);
//        int levelIndex = 0;
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//            List<Integer> currentLevel = levels.get(levelIndex++);
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode node = queue.poll();
//                node.val = currentLevel.get(i);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//        }
//        return root;
//    }
}
