package tree;

import java.util.ArrayList;

/**
 * Created by Temurbek Ismoilov on 21/01/23.
 */

public class TreeNode<T> {
    public T data;
    public ArrayList<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(T childData) {
        children.add(new TreeNode<>(childData));
    }
}
