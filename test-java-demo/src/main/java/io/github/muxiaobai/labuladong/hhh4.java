package io.github.muxiaobai.labuladong;


/**
 * @Package io.github.muxiaobai.labuladong
 * @date 2020/12/2/002 17:06
 * @BST 二叉搜索树（Binary Search Tree）
 * BST 的中序遍历结果是有序的（升序）。
 * <p>
 * 二叉搜索树的 增删改查 和 验证是否是二叉搜索树
 */
public class hhh4 {
    public static void main(String[] args) {
        System.out.println(hhh.traversem(ddd.returnSearchTree()));
        System.out.println(hhh.traversem(hhh4.searchBST(ddd.returnSearchTree(), 2)));

        System.out.println(hhh.traversem(hhh4.insertIntoBST(ddd.returnSearchTree(), 8)));

        System.out.println(hhh4.isValidBST(ddd.returnTree()));
        System.out.println(hhh4.isValidBST(ddd.returnSearchTree()));
        System.out.println(hhh.traverseb(hhh4.deleteNode(ddd.returnSearchTree(), 2)));
    }

    /**
     * 查找
     * 广度优先 因为二叉搜索树中序有顺序
     * 700. 二叉搜索树中的搜索
     * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null) {
                return null;
            }
            return searchBST(root.left, val);
        } else if (root.val < val) {
            if (root.right == null) {
                return null;
            }
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    /**
     * 插入701. 二叉搜索树中的插入操作
     * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
     * 随意返回一个二叉树
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        helpInsertIntoBST(root, val);
        return root;
    }

    public static void helpInsertIntoBST(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                helpInsertIntoBST(root.right, val);
            }
        }
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                helpInsertIntoBST(root.left, val);
            }
        }
    }

    public static TreeNode insertIntoBST0(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST0(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST0(root.left, val);
        }
        return root;
    }

    /**
     * 插入
     * 返回必须是二叉搜索树
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode insertIntoBST1(TreeNode root, int val) {
        return root;

    }

    /**
     * 判断是否是二擦搜索树
     * BST
     * 98. 验证二叉搜索树
     * https://leetcode-cn.com/problems/validate-binary-search-tree/
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 我的叶子结点 左侧，必须小于我，右侧必须大于我
     *
     * @param root
     * @param min  右侧必须大于min
     * @param max  左侧必须小于max
     * @return
     */
    public static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        // 左侧，当前的节点要小于max
        if (max != null && (root.val >= max.val)) {
            return false;
        }
        //右侧，当前节点要大于min
        if (min != null && (root.val <= min.val)) {
            return false;
        }
        //我的左侧必须小于min,我的右侧必须大于max
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    /**
     * 450. 删除二叉搜索树中的节点
     * https://leetcode-cn.com/problems/delete-node-in-a-bst/
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            // 没有子节点
            if (root.left == null && root.right == null) {
                return null;
            }
            // 只有一个子节点。直接把节点往上提
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 两个节点都在
            //相当于递归 继续找当前
            // 处理情况 必须找到左子树中最大的那个节点，

//            TreeNode maxNode = getMax(root.left);
//            root.val = maxNode.val;
//            root.left = deleteNode(root.left, maxNode.val);

            //或者右子树中最小的那个节点来接替自己。
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);

        } else if (root.val > key) {
            // 如果当前的节点大于要找的key，查左边的节点
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // 当前节点小于要找的节点，那里查询右边，进行删除
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    /**
     * root.left 左侧
     * #,1,#,3,#,4,#,6,#,7,#
     * @param node
     * @return
     */
    static TreeNode getMax(TreeNode node) {
        // BST 最右边的就是最大的
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    /**
     *
     *
     * *        4
     * *    2        6
     * *  1  3      n  7
     * *  nn  nn        nn
     *
     * 左侧最大上调
     * *        4
     * *    1        6
     * *  n  3      n  7
     * *      nn        nn
     *4,1,#,3,#,#,6,#,7,#,#
     *#,1,#,3,#,4,#,6,#,7,#
     *
     *右侧最小上调
     * *        4
     * *    3        6
     * *  1   n     n  7
     * *  nn             nn
     *4,3,1,#,#,#,6,#,7,#,#
     *#,1,#,3,#,4,#,6,#,7,#
     *
     *
     *          5
     *      2      6
     *   1    4      7
     *       3
     *
     *
     * 2 获取左侧最大的跳上来就是 1 跳上来 getMax()
     *          5
     *      1      6
     *        4       7
     *       3
     *5,1,#,4,3,#,#,#,6,#,7,#,#
     *中序遍历 从小到大
     *
     *
     *
     * 2 获取右侧最小的就是3 跳上来 getMin()
     *          5
     *      3      6
     *   1    4       7
     *5,3,1,#,#,4,#,#,6,#,7,#,#
     * 中序遍历 从小到大
     *
     *
     * root.right
     * @param node
     * @return
     */
    static TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
