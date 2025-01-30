package Parciales;

import Models.GeneralTree;
import Models.Queue;
import java.util.List;
import java.util.LinkedList;

public class ParcialTeoria2 {

    public List<GeneralTree<Integer>> ejercicio (GeneralTree<Integer> gt) {
        List<GeneralTree<Integer>> res = new LinkedList<>();
        if (!gt.isEmpty()){
            if (gt.hasChildren()){
                padresMax(gt, res);
            }else{ //es hoja
                res.add(gt);
            }
        }
        return res;
    }
    
    public void padresMax(GeneralTree<Integer> gt, List<GeneralTree<Integer>> res) {
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        GeneralTree<Integer> subArbol;
        int nivel;
        int contador = 0;

        cola.enqueue(gt);

        while (!cola.isEmpty()) {
            nivel = cola.size();
            for (int i = 0; i < nivel; i++) {
                subArbol = cola.dequeue();
                List<GeneralTree<Integer>> children = subArbol.getChildren();
                //POR CADA ELEMENTO DE LA COLA SACO EL NODO Y ENCOLO SUS HIJOS
                for (GeneralTree<Integer> child : children) {
                    cola.enqueue(child);
                    contador += (int) child.getData();
                }
                //TERMINÉ DE RECORRER Y SUMAR EL DATO DE LOS HIJOS
                if (subArbol.getData() > contador) {
                    res.add(subArbol);
                }
            }

        }
    }

}
