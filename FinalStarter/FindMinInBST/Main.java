// Java program to find minimum value node in Binary Search Tree 
// A binary tree node 
class Node { 
        int data; 
        Node left, right; 
        Node(int d) { 
                data = d; 
                left = right = null; 
        } 

        int getData() {
                return data;
        }

        Node getLeft() {
                return left;
        }

        Node getRight() {
                return right;
        }

        void setData(int data) {
                this.data = data;
        }

        void setLeft(Node left) {
                this.left = left;
        }

        void setRight(Node right) {
                this.right = right;
        }
} 
public class Main { 
        static Node head; 
        /* Given a binary search tree and a number, inserts a new node with the given number in the correct place in the tree. Returns the new root pointer which the caller should then use (the standard trick to avoid using reference parameters). */
        Node insert(Node node, int data) { 
                /* 1. If the tree is empty, return a new, single node */
                if (node == null) { 
                        return (new Node(data)); 
                } else { 
                        /* 2. Otherwise, recur down the tree */
                        if (data <= node.getData()) { 
                                node.setLeft(insert(node.getLeft(), data)); 
                        } else { 
                                node.setRight(insert(node.getRight(), data)); 
                        } 
                        /* return the (unchanged) node pointer */
                        return node; 
                } 
        }
        /* Given a non-empty binary search tree, return the minimum data value found in that tree. Note that the entire tree does not need to be searched. */
        int minvalue(Node node) {

                /* TODO loop down to find the leftmost leaf */
                if (node.getLeft() == null){
                        return node.getData();
                } else {
                        return minvalue(node.getLeft());
                }


                //return (current.getData()); 
        }
        /* Given a non-empty binary search tree, return the maximum data value found in that tree. Note that the entire tree does not need to be searched. */
        int maxvalue(Node node) {
 
                /* TODO loop down to find the rightmost leaf */
                if (node.getRight() == null){
                        return node.getData();
                } else {
                        return maxvalue(node.getRight());
                }

        }
        // Driver program to test above functions 
        public static void main(String[] args) { 
                Main tree = new Main(); 
                Node root = null; 
                root = tree.insert(root, 4); 
                tree.insert(root, 2); 
                tree.insert(root, 1); 
                tree.insert(root, 3); 
                tree.insert(root, 6); 
                tree.insert(root, 5); 
                System.out.println("Minimum value of BST is " + tree.minvalue(root));
                System.out.println("Maximum value of BST is " + tree.maxvalue(root));
        } 
}
