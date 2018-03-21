import java.util.Stack;

/**
 * Created by WenXun on 2018/3/13.
 * an instance of binary tree
 */
class Node{
    int val;
    Node leftChild;
    Node rightChild;

    Node(int val){
        this.val = val;
    }

    public void display() {
        System.out.print(this.val + "\t");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.valueOf(val);
    }

}
public class BinaryTree {
    private Node root = null;

    BinaryTree(int value){
        root = new Node(value);
        root.leftChild = null;
        root.rightChild = null;
    }

    public Node findKey(int value) {
        Node current = root;
        while(true){
            if (value == current.val)
                return current;
            else if (value < current.val)
                current = current.leftChild;
            else if (value > current.val)
                current = current.rightChild;

            if (current == null)
                return null;
        }
    }   //查找


    public String insert(int value) {
        String error = null;
        Node node = new Node(value);

        if (root == null){
            root = node;
            root.leftChild = null;
            root.rightChild = null;
        }else{
            Node current = root;
            Node parent = null;
            while (true){
                if (value < current.val){
                    parent = current;
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = node;
                        break;
                    }
                }else if(value > current.val){
                    parent = current;
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = node;
                        break;
                    }
                }else{
                    error = "already have same value!";
                }
            } //end if while
        }
    return error;
    }  //插入


    public void inOrderTraverse() {
        System.out.println("递归中序遍历");
        inOrderTraverse(root);
        System.out.println();
    }    //中序遍历递归操作
    private void inOrderTraverse(Node node){
        if (node == null){
            return ;
        }

        inOrderTraverse(node.leftChild);
        node.display();
        inOrderTraverse(node.rightChild);
    }


    /**
     * 中序遍历非递归：
     * 1.对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点设置为current，重复此操作直至current为空
     * 2.若左子树为空则栈顶节点出栈，访问该节点后将其右子树设置为current
     * 3.重复1、2步操作，直到current为空且栈内节点为空
     */
    public void inOrderByStack() {
        System.out.println("非递归中序遍历");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.leftChild;
            }

            if (!stack.isEmpty()){
                current = stack.pop();
                current.display();
                current = current.rightChild;
            }
        }
        System.out.println();
    }     //中序遍历非递归操作


    public void preOrderTraverse() {}  //前序遍历
    public void preOrderByStack() {}   //前序遍历非递归操作
    public void postOrderTraverse() {} //后序遍历
    public void postOrderByStack() {}  //后序遍历非递归操作
    public int getMinValue() {
        return 0;
    } //得到最小(大)值
    public boolean delete(int value) {
        return false;
    } //删除
}