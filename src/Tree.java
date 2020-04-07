public interface Tree<E> {
    public boolean insert(E element);
    public void inOrder();
    public void posOrder();
    public void preOrder();
    public int getSize();
    public boolean find(TreeNode<E> treeNode, E element);
    public boolean remove(TreeNode<E> treeNode, E element);
}
