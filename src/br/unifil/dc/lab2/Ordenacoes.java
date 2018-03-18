package br.unifil.dc.lab2;

import java.util.Arrays;
import java.util.List;

/**
 * Classe contendo os metodos de ordenação requisitados na
 * lista04 da materia Laboratorio de Computação II
 *
 * @author Matheus Muriel
 * @author Guilherme Manhani
 * @version 03.18
 *
 * @Perguntas
 *  1)
 *      1.1- Porque o n é o ultimo numero da lista e sera colocado na ordem correta
 * com a comparaçao entre o penultimo elemento e o ultimo elemento
 * logo ele ja estará ordenado nao necessitando de mais um ciclo do for.
 *
 *      1.2- Será executada de acordo com o tamanho do vetor menos um, por exemplo,
 * se a lista tiver 10 elementos o laço sera executado 9 vezes repetiçoes = (vetor-1).
 *
 *      1.3- O tamanho do vetor menos 1; este metodo de seleçao é mais exato, pois
 * sempre vamos saber quantos laços o programa executara indepentende do
 * numero de elementos passado ou da ordem que eles tiverem.
 *
 *  2)
 *      1.1- Vai depender da quantidade de elementos na lista, pois o do while é executado de acordo
 * com o numero total de elementos por exemplo 5 elementos na lista o for se repetiria 5x.
 *
 *      1.2- Uma unica vez, apenas para verificar se vai haver troca.
 *
 *      1.3- Depende  de como os elementos estão ordenados na lista, pois se os elementos já estão
 * ordenados o metodo de bolha é melhor, pois ele percorrera apenas uma vez e não ira fazer nenhuma troca.
 * Já o metodo de seleção é exato no numero de trocas que executara no programa, que é: x-1 sendo x
 * o numero de elementos da lista. Ou seja, se os elementos estiverem totalmente desordenados o método de
 * seleção faz menos trocas que o método de bolha.
 *
 * @Livro
 *  19.6- a) Está implementado no método ordenarPorBolha.
 *        b) Está implementado no método ordenarPorBolha.
 *
 *  19.8-
 */
public class Ordenacoes {

    public static void main(String[] args) {
        //List<Integer> numeros = Arrays.asList (5,4,3,2,1);
        //SELECTIOOOON !!
        //System.out.println("Original: " + numeros);
        //ordenarPorSelecao(numeros);
        //System.out.println("Por seleção: " + numeros); //3,345 segundos

        //BOOOOOLHA !!!
        //System.out.println("Original: " + numeros);
        //ordenarPorBolha(numeros);
        //System.out.println("Por bolha: " + numeros); //X segundos

        //Procura
        //int[] data = {5, 6, 7, 1, 1, 15};
        //System.out.println(recursiveLinearSearch(data, 9));
    }

    /**
     *  Metodo de Ordenação por Seleção faz um ordenacao do maior elemento para o menor,
     * selecionando um por um dos elementos de dentro da lista.
     *
     * @param numeros   List de Inteiros, contendo os números a serem ordenados.
     */
    public static void ordenarPorSelecao (List<Integer> numeros) {
        assert numeros != null : "Só é aceito listas não nulas";

        int c = 1;
        for(int i = 0; i < numeros.size()-1; i++){
            c++;
            int menor = i;
            for(int j = i+1; j < numeros.size(); j++){
                if(numeros.get(menor) > numeros.get(j))
                    menor = j;
            }
            trocar(numeros, i, menor);
        }
    }

    /**
     * O método de Ordenação por Bolha compara o primeiro elemento de uma lista o segundo, se ele for maior
     * os elementos são trocados. Depois esse processo é feito com o segundo e o terceiro, depois o quarto e o quinto
     * e assim por diante. Esse processo é repetido N - 1 vezes, sendo N = lista.size().
     *
     * @param numeros   List de Inteiros, contendo os números a serem ordenados.
     */
    public static void ordenarPorBolha(List<Integer> numeros){
        assert numeros != null : "Só é aceito listas não nulas";

        boolean troca;
        int x = 0;
        do {
            troca = false;
            x--;
            for (int i = 0; i < (numeros.size() + x); i++) {
                System.out.println("Dentro do for, " + i);
                if (numeros.get(i) > numeros.get(i + 1)) {
                    trocar(numeros, i, i + 1);
                    troca = true;
                }
            }
        } while (troca);
    }

    /**
     *  Metodo para trocar 2 elementos de uma lista de inteiros.
     *
     * @param numeros   Lista de Inteiros aonde estão os numeros a serem trocados.
     * @param i Elemento 1.
     * @param j Elemento 2.
     */
    private static void trocar(List<Integer> numeros, int i, int j){
        Integer aux = numeros.get(i);
        numeros.set(i, numeros.get(j));
        numeros.set(j, aux);

    }

    /**
     *      Metodo recursivo que faz uma busca linear em um arranjo para encontrar uma chave
     * @param data  Arranjo para ser pesquisado.
     * @param searchKey Chave a ser encontrada.
     * @return Se encontrar a chave de pesquisa dentro do array
     * retorna o indice aonde se encontra o elemento, caso contrario, retorna -1
     */
    public static int recursiveLinearSearch(int data[], int searchKey) {
        assert data != null : "A lista não pode ser nula";

        if (data.length == 0)return -1;

        if (searchKey == data[data.length-1]) {
            //System.out.println("Achou, o índice da chave é: " + (data.length-1));
            return data.length-1;
        } else {
            return recursiveLinearSearch(Arrays.copyOfRange(data, 0, data.length - 1), searchKey);
        }

    }
}


