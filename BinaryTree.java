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
    }   //����


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
    }  //����


    public void inOrderTraverse() {
        System.out.println("�ݹ��������");
        inOrderTraverse(root);
        System.out.println();
    }    //��������ݹ����
    private void inOrderTraverse(Node node){
        if (node == null){
            return ;
        }

        inOrderTraverse(node.leftChild);
        node.display();
        inOrderTraverse(node.rightChild);
    }


    /**
     * ��������ǵݹ飺
     * 1.��������ڵ�current�����ýڵ㲻Ϊ���򽫸ýڵ�ѹջ�������������ڵ�����Ϊcurrent���ظ��˲���ֱ��currentΪ��
     * 2.��������Ϊ����ջ���ڵ��ջ�����ʸýڵ��������������Ϊcurrent
     * 3.�ظ�1��2��������ֱ��currentΪ����ջ�ڽڵ�Ϊ��
     */
    public void inOrderByStack() {
        System.out.println("�ǵݹ��������");
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
    }     //��������ǵݹ����


    public void preOrderTraverse() {
        System.out.println("�ݹ�ǰ�����");
        preOrderTraverse(root);
        System.out.println();
    }  //ǰ������ݹ�

    public void preOrderTraverse(Node node) {
        if (node == null)
            return ;

        node.display();
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }


    /**
     * ǰ������ǵݹ������
     * 1.��������ڵ�current������Ϊ���򽫸ýڵ���ʺ��ٽ�����ջ��������������Ϊcurrent���ظ��˲�����ֱ��currentΪ��
     * 2.��������Ϊ�գ�ջ���ڵ��ջ�����ýڵ����������Ϊcurrent
     * 3.�ظ�1.2����ֱ��currentΪ����ջΪ��
     */
    public void preOrderByStack() {
        System.out.println("ǰ������ǵݹ�");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;

        while (current != null || !stack.isEmpty()){
            while (current != null){
                current.display();
                stack.push(current);
                current = current.leftChild;
            }

            if (!stack.isEmpty()){
                current = stack.pop();
                current = current.rightChild;
            }
        }

        System.out.println();
    }   //ǰ������ǵݹ����


    /**
     * �ݹ�ʵ�ֵĺ�������
     * 1.�����������������
     * 2.�����������������
     * 3.���ʸýڵ�
     */
    public void postOrderTraverse() {
        System.out.println("���������ݹ����");
        postOrderTraverse(root);
        System.out.println();
    } //�������
    public void postOrderTraverse(Node node) {
        if (node == null)
            return ;

        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        node.display();
    }

    /**
     * �ǵݹ�ʵ�ֺ���������
     * 1.��������ڵ�current�����ýڵ㲻Ϊ���򽫸ýڵ�ѹջ�������������ڵ�����Ϊcurrent���ظ��˲�����ֱ��currentΪ��
     * 2.��������Ϊ�գ���ȡջ���ڵ�������������������Ϊ�ջ��������ոշ��ʹ�������ʸýڵ㣬����preNode����Ϊ�ýڵ�
     * 3.�ظ�1��2����ֱ��ջΪ��
     */
    public void postOrderByStack() {
        System.out.println("�ǵݹ��������ʵ��");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        Node preNode = null;
        while ( current != null || !stack.isEmpty()){
            while ( current != null){
                stack.push(current);
                current = current.leftChild;
            }

            if (!stack.isEmpty()){
                current = stack.peek().rightChild;
                if (current == null || current == preNode){
                    current = stack.pop();
                    current.display();
                    preNode = current;
                    current = null;
                }
            }
        }

        System.out.println();
    }  //��������ǵݹ����

    
    public boolean delete(int value) {
        return false;
    } //ɾ��
}