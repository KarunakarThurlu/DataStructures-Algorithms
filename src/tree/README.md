### Binary Tree

A **binaryTree** is a **hierarchical** data structure in which each node has at most two children. (i.e either 0 OR 1 OR 2)

```
    1                    
   / \                 
  2   3               
 / \   \              
4   5   6            
Binary Tree
```

## Types of Binary Trees


- **Full Binary Tree**: A binary tree is full if every node has 0 or 2 children.
- **Complete Binary Tree** : All levels are filled completely except the lowest level nodes, which are filled from left as possible.
- **Perfect Binary Tree** : All internal nodes have exactly two children and all leaf nodes are at the same level.
- **Balanced Binary Tree** : The height of the left and right subtrees of any node differs by at most 1.
- **Left-skewed Tree** : If all the nodes in the degenerate tree have only a left child.
- **Right-skewed Tree** : If all the nodes in the degenerate tree have only a right child.
- **Binary Search Tree** : A binary tree where left child node is less than root node and right child node is greater than root node.

```
    1              1             1            1            1                      6
   / \            / \           / \          /              \                    / \
  2   3          2   3         2   3        2                2                  4   8
 / \ / \        / \  /                     /                  \                / \   \
4  5 6  7      4   5 6                    3                    3              2   3   9

FBT              CBT            PBT       Left-skewed BT  Right-skewed BT        BST

```

* Height of Binary Tree : `` Height = max(Height of left subtree,Height of right subtree)+1 ``
* The diameter of a binary tree is the length of the longest path between any two nodes in the tree. This path may or may not pass through the root.



---

## Binary Tree vs. Binary Search Tree (BST)
- **Binary Tree**: A general structure with up to two children per node.
- **Binary Search Tree**: A binary tree with an ordering property where the left child is less than the parent, and the right child is greater.

```
  1                   10					 
 / \                  / \
2   3                9  11				   
BT                    BST						
```
## BinaryTree Node Class

```
public class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
```



