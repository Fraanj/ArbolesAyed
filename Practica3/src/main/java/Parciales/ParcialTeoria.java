package Parciales;

import Models.GeneralTree;
import java.util.List;
import java.util.LinkedList;

public class ParcialTeoria {

    public List<GeneralTree<tuplaPt1>> dfs(GeneralTree<tuplaPt1> gt) {
        List<GeneralTree<tuplaPt1>> res = new LinkedList<>();
        List<GeneralTree<tuplaPt1>> actual = new LinkedList<>();
        if (!gt.isEmpty()) {
            if (!gt.getData().esDragon()) {   //procesa en raiz
                actual.add(gt);
            }
            dfs2(gt, actual, res);
        }
        return res;
    }

    private static void dfs2(GeneralTree<tuplaPt1> gt, List<GeneralTree<tuplaPt1>> actual, List<GeneralTree<tuplaPt1>> res) {
        if (gt.getData().esPrincesa()) {
            res.addAll(actual);
        }
        if (res.isEmpty() && !gt.getData().esDragon()) {
            List<GeneralTree<tuplaPt1>> children = gt.getChildren();   //pregunto si tiene hijos? --> no es necesario
            for (GeneralTree<tuplaPt1> child : children) {
                if (!child.getData().esDragon()) {
                    actual.add(child);
                    dfs2(child, actual, res);
                    actual.remove(actual.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Caso 1: Árbol con solo una princesa en la raíz
        ParcialTeoria algoritmo = new ParcialTeoria();
        GeneralTree<tuplaPt1> arbol1 = new GeneralTree<>(new tuplaPt1("Princesa", "Ariel"));
        System.out.println("Caso 1: " + algoritmo.dfs(arbol1)); // Esperado: [Ariel]

        // Caso 2: Princesa en un subárbol accesible
        GeneralTree<tuplaPt1> arbol2 = new GeneralTree<>(new tuplaPt1("Rey", "Arturo"));
        GeneralTree<tuplaPt1> nodo2_1 = new GeneralTree<>(new tuplaPt1("Princesa", "Bella"));
        GeneralTree<tuplaPt1> nodo2_2 = new GeneralTree<>(new tuplaPt1("Caballero", "Lancelot"));

        arbol2.addChild(nodo2_1);
        arbol2.addChild(nodo2_2);
        System.out.println("Caso 2: " + algoritmo.dfs(arbol2)); // Esperado: [Arturo, Bella] o similar
        // Caso 3: Princesa bloqueada por un dragón
        GeneralTree<tuplaPt1> arbol3 = new GeneralTree<>(new tuplaPt1("Rey", "Arturo"));
        GeneralTree<tuplaPt1> nodo3_1 = new GeneralTree<>(new tuplaPt1("Dragon", "Smaug"));
        GeneralTree<tuplaPt1> nodo3_2 = new GeneralTree<>(new tuplaPt1("Princesa", "Cenicienta"));

        arbol3.addChild(nodo3_1);
        nodo3_1.addChild(nodo3_2); // Cenicienta está bloqueada por Smaug

        System.out.println("Caso 3: " + algoritmo.dfs(arbol3)); // Esperado: []

        // Caso 4: Árbol con múltiples caminos, algunas princesas accesibles y otras bloqueadas
        GeneralTree<tuplaPt1> arbol4 = new GeneralTree<>(new tuplaPt1("Rey", "Arturo"));
        GeneralTree<tuplaPt1> nodo4_1 = new GeneralTree<>(new tuplaPt1("Dragon", "Smaug"));
        GeneralTree<tuplaPt1> nodo4_2 = new GeneralTree<>(new tuplaPt1("Princesa", "Elsa"));
        GeneralTree<tuplaPt1> nodo4_3 = new GeneralTree<>(new tuplaPt1("Caballero", "Galahad"));
        GeneralTree<tuplaPt1> nodo4_4 = new GeneralTree<>(new tuplaPt1("Princesa", "Jasmine"));

        arbol4.addChild(nodo4_1);
        arbol4.addChild(nodo4_2);
        nodo4_1.addChild(nodo4_3);
        nodo4_3.addChild(nodo4_4);

        System.out.println("Caso 4: " + algoritmo.dfs(arbol4)); // Esperado: [Arturo, Elsa]
    }
}
