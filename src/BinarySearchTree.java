public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BinarySearchTree() {

    }

    public BinarySearchTree(E[] elements) {
        for (int i = 0; i < elements.length; i++) {
            insert(elements[i]);
        }
    }

    @Override
    public boolean insert(E element) {
        if (root == null)
            root = createNewNode(element);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (element.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (element.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }
            if (element.compareTo(parent.element) < 0)
                parent.left = createNewNode(element);
            else
                parent.right = createNewNode(element);
        }
        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public boolean find(TreeNode<E> treeNode, E e) {
        if (treeNode == null) {
            return false;
        }
        if (treeNode.element.equals(e)) {
            return true;
        }
        return e.compareTo(treeNode.element) < 0 ? find(treeNode.left, e) : find(treeNode.right, e);
    }

    @Override
    public void inOrder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void posOrder() {
        posOrder(root);
    }

    protected void posOrder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        posOrder(root.left);
        posOrder(root.right);
        System.out.print(root.element + " ");
    }

    @Override
    public void preOrder() {
        preOrder(this.root);
    }

    protected void preOrder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.element + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    @Override
    public int getSize() {
        return this.size;
    }
    
    @Override
    public boolean remove(TreeNode<E> treeNode, E e) {
        if (treeNode == null) {
            return false;
        }
        if (e.compareTo(treeNode.element) < 0) {
            return remove(treeNode.left, e);
        } else if (e.compareTo(treeNode.element) > 0) {
            return remove(treeNode.right, e);
        } else {
            if (treeNode.left == null) {
                treeNode = treeNode.right;
            } else if (treeNode.right == null) {
                treeNode = treeNode.left;
            } else {
                TreeNode<E> temp = treeNode.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                treeNode.element = temp.element;
                return remove(treeNode.left, temp.element);
            }
        }
        return true;
    }
}
