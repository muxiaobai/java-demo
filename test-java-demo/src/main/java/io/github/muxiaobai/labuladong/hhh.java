package io.github.muxiaobai.labuladong;


/**
 * 二叉树
 *  前中后遍历
 * <p>
 * 遍历
 **/
public class hhh {

    public static void main(String[] args) {
        TreeNode root = ddd.returnTree();
        System.out.println(count(root));
        System.out.println(traverseb(root));
        System.out.println(traversem(root));
        System.out.println(traversee(root));
    }

    /**
     * 一棵树 有多少个节点
     *
     * @param root
     * @return
     */
    public static int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = count(root.left);
        int right = count(root.right);
        //结果 后序遍历
        int result = left + right + 1;
        return result;
    }


    /**
     * 先序遍历
     *144
     *
     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public static String traverseb(TreeNode root) {
        // 对于空节点，可以用一个特殊字符表示
        if (root == null) {
            return "#";
        }
        // 将左右子树序列化成字符串
        String left = traverseb(root.left);
        String right = traverseb(root.right);
        /* 先序遍历代码位置 */
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        String subTree = root.val + "," + left + "," + right;
        return subTree;
    }


    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static String traversem(TreeNode root) {
        // 对于空节点，可以用一个特殊字符表示
        if (root == null) {
            return "#";
        }
        // 将左右子树序列化成字符串
        String left = traversem(root.left);
        String right = traversem(root.right);
        /* 中序遍历代码位置 */
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        String subTree = left + "," + root.val + "," + right;
        return subTree;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public static String traversee(TreeNode root) {
        // 对于空节点，可以用一个特殊字符表示
        if (root == null) {
            return "#";
        }
        // 将左右子树序列化成字符串
        String left = traversee(root.left);
        String right = traversee(root.right);
        /* 后序遍历代码位置 */
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        String subTree = left + "," + right + "," + root.val;
        return subTree;
    }
}

