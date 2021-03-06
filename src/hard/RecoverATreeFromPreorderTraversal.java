package hard;

import common.TreeNode;

/**
 * We run a preorder depth first search on the root of a binary tree.
 *
 * At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)
 *
 * If a node has only one child, that child is guaranteed to be the left child.
 *
 * Given the output S of this traversal, recover the tree and return its root.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: "1-2--3--4-5--6--7"
 * Output: [1,2,5,3,4,6,7]
 * Example 2:
 *
 *
 *
 * Input: "1-2--3---4-5--6---7"
 * Output: [1,2,5,3,null,6,null,4,null,7]
 *
 *
 * Example 3:
 *
 *
 *
 * Input: "1-401--349---90--88"
 * Output: [1,401,null,349,88,90]
 *
 *
 * Note:
 *
 * The number of nodes in the original tree is between 1 and 1000.
 * Each node will have a value between 1 and 10^9.
 *
 * 比较有技巧，不用回溯。
 * count与level不对应，则直接返回null
 */
public class RecoverATreeFromPreorderTraversal {
    public TreeNode recoverFromPreorder(String S) {
        return construct(S, new int[]{0}, 0);
    }

    TreeNode construct(String s, int[] i, int level) {
        int count = 0, val = 0;
        while (i[0] + count < s.length() && s.charAt(i[0] + count) == '-') ++count;
        if (count != level) return null;
        i[0] += count;
        for (; i[0] < s.length() && s.charAt(i[0]) != '-'; ++i[0]) {
            val = 10 * val + (s.charAt(i[0]) - '0');
        }
        TreeNode node = new TreeNode(val);
        node.left = construct(s, i, level + 1);
        node.right = construct(s, i, level + 1);
        return node;
    }
}
