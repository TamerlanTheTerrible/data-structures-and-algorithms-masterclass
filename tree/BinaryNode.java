package tree;

/**
 * Created by Temurbek Ismoilov on 22/01/23.
 */
public class BinaryNode<T> {
    public T value;
    public BinaryNode<T> left;
    public BinaryNode<T> right;
    public int height;

    public BinaryNode(T value) {
        this.value = value;
        this.height = 0;
    }

    public BinaryNode(){
        this.height = 0;
    };
}
