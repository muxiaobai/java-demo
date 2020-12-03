package io.github.muxiaobai.labuladong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Package io.github.muxiaobai.labuladong
 * @date 2020/12/2/002 17:06
 * @BST 构造二叉树（Binary Search Tree）
 * <p>
 * 二叉树的序列化和反序列化
 * 直接使用hhh和hhh3 的 前序遍历，成一个完全而查实，再从前序遍历 生成完全二叉树
 *
 * 297. 二叉树的序列化与反序列化
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class hhh5 {
    public static void main(String[] args) {
        hhh5 hhh5 = new hhh5();
        System.out.println(hhh5.serialize(ddd.returnSearchTree()));
        System.out.println(hhh.traverseb(hhh5.deserialize(hhh5.serialize(ddd.returnSearchTree()))));

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return hhh.traverseb(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        return buildTree(new LinkedList<String>(Arrays.asList(str)) );
    }

    /**
     *
     *类似于一个完全二叉树
     * 不完全的地方用#代替
     * @param li
     * @return
     */
    TreeNode buildTree(List<String> li){
        //里的li.get(0) 不会越界，因为每一个List都有数据，如果是#的h话直接返回了
        if(li.get(0).equals("#")){
            li.remove(0);
            return null;
        }
        TreeNode res = new TreeNode(Integer.valueOf(li.get(0)));
        li.remove(0);
        res.left = buildTree(li);
        res.right = buildTree(li);
        return res;
    }
}
