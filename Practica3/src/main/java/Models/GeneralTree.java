package Models;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T> {

    private T data;
    private List<GeneralTree<T>> children = new LinkedList<>();

    public GeneralTree() {

    }

    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this(data);
        this.children = children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }

    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null) {
            this.children = children;
        }
    }

    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren()) {
            children.remove(child);
        }
    }

    public void inOrder() {

        List<GeneralTree<T>> children = this.getChildren();

        if (!children.isEmpty()) {
            children.get(0).inOrder();  // Se pasa el primer hijo explícitamente
        }

        System.out.println("dato nodo = " + this.getData());

        for (int i = 1; i < children.size(); i++) {
            children.get(i).inOrder();  // Se pasan los hijos restantes
        }
    }

    public void preOrder() {
        System.out.println("dato nodo = " + this.getData());
        List<GeneralTree<T>> children = this.getChildren();
        for (GeneralTree<T> c : children) {
            c.preOrder();
        }
    }

    public void postOrder() {
        List<GeneralTree<T>> children = this.getChildren();
        for (GeneralTree<T> c : children) {
            c.postOrder();
        }
        System.out.println("dato nodo = " + this.getData());
    }

    public void recorridoPorNivel() {  //imperativo
        GeneralTree<T> nodo;
        Queue<GeneralTree<T>> cola = new Queue<>();
        cola.enqueue(this);
        int nivel;
        int cant;

        while (!cola.isEmpty()) {
            nivel = cola.size();
            cant = 0;
            for (int i = 0; i < nivel; i++) {
                cant++;
                nodo = cola.dequeue(); //tomo el nodo
                System.out.println("nodo = " + nodo.getData());
                List<GeneralTree<T>> children = nodo.getChildren();
                for (GeneralTree<T> c : children) {   //encola todos los hijos del nodo desencolado
                    cola.enqueue(c);
                }
            }
            System.out.println("cant nodos en nivel actual = " + cant);
        }

    }

    public int altura() {

        return 0;
    }

    public int nivel(T dato) {
        return 0;
    }

    public int ancho() {

        return 0;
    }

    @Override
    public String toString() {
        return "GeneralTree{" + "data=" + data + '}';
    }

    
    
    public static void main(String[] args) {
        GeneralTree<Integer> a1 = new GeneralTree<>(1);
        List<GeneralTree<Integer>> children2 = new LinkedList<>();
        children2.add(new GeneralTree<>(21));
        children2.add(new GeneralTree<>(22));
        children2.add(new GeneralTree<>(23));
        GeneralTree<Integer> a2 = new GeneralTree<>(2, children2);
        List<GeneralTree<Integer>> children3 = new LinkedList<>();
        children3.add(new GeneralTree<>(31));
        children3.add(new GeneralTree<>(32));
        GeneralTree<Integer> a3 = new GeneralTree<>(3, children3);
        List<GeneralTree<Integer>> childen = new LinkedList<>();
        childen.add(a1);
        childen.add(a2);
        childen.add(a3);
        GeneralTree<Integer> a = new GeneralTree<>(11, childen);

        System.out.println(" ------ RECORRIDO IN ORDER ------");
        a.inOrder();
        System.out.println(" ------ RECORRIDO PRE ORDER ------");
        a.preOrder();
        System.out.println(" ------ RECORRIDO POST ORDER ------");
        a.postOrder();
        System.out.println(" ------ RECORRIDO POR NIVELES ------");
        a.recorridoPorNivel();
    }

}
