import java.awt.*;

public class RedBlackTree {

    private PatientNode nil   = new PatientNode();
    private PatientNode root  = nil; // Root node
    private final Color RED   = Color.RED;
    private final Color BLACK = Color.BLACK;

    // Constructor
    public RedBlackTree() {
        root.left = nil;
        root.right = nil;
        root.p = nil;
    }

    /* RBInsert() O(lgn) is a function to insert a new node in the correct position of RBT */
    private void RBInsert(RedBlackTree T, PatientNode z){
        PatientNode y = T.nil;
        PatientNode x = T.root;

        while(x != T.nil){
            y = x;
            if(z.key < x.key){
                x = x.left;
            }
            else{
                x = x.right;
            }
        }
        z.p = y;

        if(y == T.nil){
            T.root = z;
        }

        else if(z.key < y.key){
            y.left = z;
        }

        else {
            y.right = z;
        }
        z.left = T.nil;
        z.right = T.nil;
        z.color = RED; // Color the insertion as RED
        RBInsertFixUp(T,z);
    }

    /* RBInsertFixUp() O(lgn) is an important helper function to adjust nodes within RBT based on color and key */
    private void RBInsertFixUp(RedBlackTree T, PatientNode z) {
        PatientNode y;
        while(z.p.color == RED){

            // If Z's parent is the left child of it's parent
            if(z.p == z.p.p.left){

                y = z.p.p.right; // Initialize y to be z's cousin

                // Case 1: Y is RED -> recolor
                if(y.color == RED){
                    z.p.color = BLACK;
                    y.color = BLACK;
                    z.p.p.color = RED;
                    z = z.p.p;
                }

                // Case 2: Y is BLACK and Z is a right child -> Left Rotate around Z's parent
                else if(z == z.p.right){
                    z = z.p;
                    leftRotate(T,z); // Left Rotate around z's parent
                }

                // Case 3: Y is black & Z is a left child -> Right Rotate around Z's grandparent
                else{
                    z.p.color = BLACK;
                    z.p.p.color = RED;
                    rightRotate(T,z.p.p);
                }
            }

            // If Z's parent is the right child of it's parent.
            else{
                y = z.p.p.left;

                // Case 1: Y is RED -> recolor
                if(y.color == RED){
                    z.p.color = BLACK;
                    y.color = BLACK;
                    z.p.p.color = RED;
                    z = z.p.p;
                }

                // Case 2: Y is BLACK and Z is a right child -> Right Rotate around Z's parent
                else if(z == z.p.left){
                    z = z.p;
                    rightRotate(T,z);
                }

                // Case 3: Y is black & Z is a left child -> Left Rotate around Z's grandparent
                else{
                    z.p.color = BLACK;
                    z.p.p.color = RED;
                    leftRotate(T,z.p.p);
                }
            }
        } // End of while loop

        T.root.color = BLACK;
    }

    /* rightRotate() O(lgn) is a local method that preserves the BST property */
    private void rightRotate(RedBlackTree T, PatientNode y) {

        PatientNode x = y.left; // Set x
        y.left = x.right; // Turn x's right subtree into y's left subtree

        // Check if X.right exists
        if(x.right != T.nil){
            x.right.p = y;
        }
        x.p = y.p; // Link x's parent to y

        // Y's parent is null -> set the root to be X
        if(y.p == T.nil){
            T.root = x;
        }

        // Y is equals to Y's cuisine
        else if(y == y.p.right){
            y.p.right = x;
        }

        else {
            y.p.left = x;
        }

        x.right = y; // put y on x's right
        y.p = x;
    }

    /* leftRotate() O(lgn) is a local method that preserves the BST property */
    private void leftRotate(RedBlackTree T, PatientNode x) {
        PatientNode y = x.right; // Set y
        x.right = y.left; // Turn y's left subtree into x's right subtree

        if(y.left != T.nil){
            y.left.p = x;
        }
        y.p = x.p; // Link x's parent to y

        if(x.p == T.nil){
            T.root = y;
        }

        else if(x == x.p.left){
            x.p.left = y;
        }

        else {
            x.p.right = y;
        }

        y.left = x; // put x on y's left
        x.p = y;

    }

    /* transplantRBT() O(lgn) is a method that replaces one sub-tree as a child of another sub-tree */
    private void transplantRBT(RedBlackTree T,PatientNode u, PatientNode v){

        if(u.p == T.nil){
            T.root = v;
        }

        else if(u == u.p.left){
            u.p.left = v;
        }

        else{
            u.p.right = v;
        }
        v.p = u.p; // Is that right?
    }


    /* deleteRBT() O(lgn) is method implements delete functionality for 4 cases of RBT node deletion. */
    private void deleteRBT(RedBlackTree T, PatientNode z){

        PatientNode y = z;
        PatientNode x;
        Color originalColorY = y.color; // Store the original color of Y

        if(z.left == T.nil){
            x = z.right;
            transplantRBT(T,z,z.right);
        }

        else{
            y = treeMinimum(z.right);
            originalColorY = y.color;
            x = y.right;

            if (y.p == z){
                x.p = y;
            }
            else {
                transplantRBT(T,y,y.right);
                y.right = z.right;
                y.right.p = y;
            }
            transplantRBT(T,z,y);
            y.left = z.left;
            y.left.p = y;
            y.color = z.color;
        }

        if(originalColorY == BLACK){
            deleteFixUpRBT(T,x);
        }
    }

    /* treeMinimum() is a helper method used by delete function that find the smallest node in the given tree. */
    private PatientNode treeMinimum(PatientNode x) {
        while (x.left != nil){
            x = x.left;
        }
        return x;

    }

    /* deleteFixUpRBT() O(lgn) is an important helper function to adjust nodes within RBT based on color and key after deletion */
    private void deleteFixUpRBT(RedBlackTree T, PatientNode x) {
        PatientNode w;
        while(x != T.root & x.color == BLACK){

            if(x == x.p.left){
                w = x.p.right;

                // Case 1: W's color is RED
                if(w.color == RED){
                    w.color = BLACK;
                    x.p.color = RED;
                    leftRotate(T, x.p);
                    w = x.p.right;
                }

                // Case 2: Both W's children are black
                if(w.left.color == BLACK & w.right.color == BLACK){
                    w.color = RED;
                    x = x.p;
                }

                // Case 3:
                else if(w.right.color == BLACK){
                    w.left.color = BLACK;
                    w.color = RED;
                    rightRotate(T, w);
                    w = x.p.right;
                }

                // Case 4
                else{
                    w.color = x.p.color;
                    x.p.color = BLACK;
                    w.right.color = BLACK;
                    leftRotate(T,x.p);
                    x = T.root;
                }
            }

            else {
                w = x.p.left;

                // Case 1: W's color is red
                if(w.color == RED){
                    w.color = BLACK;
                    x.p.color = RED;
                    rightRotate(T,x.p);
                    w = x.p.left;
                }

                // Case 2: Both W's children are black
                if(w.right.color == BLACK & w.left.color == BLACK){
                    w.color = RED;
                    x = x.p;
                }

                // Case 3: W's left child
                else if(w.left.color == BLACK){
                    w.right.color = BLACK;
                    w.color = RED;
                    leftRotate(T,w);
                    w = x.p.left;
                }

                // Case 4: W is BLACK and W.left is RED
                else{
                    w.color = x.p.color;
                    x.p.color = BLACK;
                    w.left.color = BLACK;
                    rightRotate(T,x.p);
                    x = T.root;
                }

            }
        } // end of while loop
        x.color = BLACK;
    }

    /* inOrderTreeWalk method O(n) traverses the tree and prints out in the command line. */
    private void inOrderTreeWalk(PatientNode root) {
        if (root != nil) {
            inOrderTreeWalk(root.left); // Traverse recursively down the left tree
            System.out.print(root.getKey()+" – "+root.getData().getName()+" ("+root.getColor()+"); ");
            inOrderTreeWalk(root.right); // Traverse recursively down the right tree
        }
    }

    /* preOrderTreeWalk method O(n) traverses the tree and prints out in the command line. */
    private void preOrderTreeWalk(PatientNode root) {
        if (root != nil){
            System.out.print(root.getKey()+" – "+root.getData().getName()+" ("+root.getColor()+"); ");
            preOrderTreeWalk(root.left);
            preOrderTreeWalk(root.right);
        }
    }

    /* treeSearch() is a private method that searches for node x, patient p in RBT */
    private PatientNode treeSearch(PatientNode x, int priority)
    {
        if(x == null || priority == x.getKey())
        {
            return x;
        }
        if(priority < x.getKey())
        {
            return treeSearch(x.getLeft(), priority);
        }
        else{
            return treeSearch(x.getRight(), priority);
        }
    }


    /* searchPatient() O(lgn) is a public method to search a Patient in RBT */
    public void searchPatient(int priority)
    {
        PatientNode temp = treeSearch(root, priority);
        System.out.printf("\nFound: %s - %d (%s)\n\n",temp.getData().getName(),temp.getData().getPriority(),temp.getColor());
    }

    /* Utility method O(lgn) to delete a node in the tree */
    public void deletePatient(int key) {
        PatientNode temp = treeSearch(root,key);
        System.out.printf("\nDeleted: %s, with priority %d, (%s)\n",temp.getData().getName(),temp.getData().getPriority(),temp.getColor());
        deleteRBT(this, temp);
        System.out.println("Tree after deletion: [Pre-order traversal]");
        preOrderTreeWalk(this.root);
        System.out.println("\n");
    }

    /* Utility method O(lgn) to insert a new node in the tree  */
    public void insert(Patient patient) {
        PatientNode temp = new PatientNode(patient.getPriority(),BLACK, patient);
        RBInsert(this, temp);;
        System.out.printf("\nInserted: %s, with priority %d, (%s)\n",patient.getName(),patient.getPriority(),temp.getColor());
        System.out.println("Tree after insertion: [Pre-order traversal]");
        preOrderTreeWalk(this.root);
        System.out.print("\n");
    }

    /* Utility method to sort a tree in the Increasing using In Order traversal O(n) */
    public void sort() {
        System.out.println("\nSorted list: ");
        inOrderTreeWalk(this.root);
    }


}
