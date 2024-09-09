// Classe para representar um nó em uma árvore binária de busca
class Node {
    int info; // Valor armazenado no nó
    Node esquerda; // Subárvore à esquerda
    Node direita; // Subárvore à direita

    // Construtor para criar um novo nó
    Node(int info) {
        this.info = info;
        this.esquerda = null;
        this.direita = null;
    }
}

// Classe para representar a árvore binária de busca
public class Main {
    private Node raiz; // Raiz da árvore

    // Construtor para inicializar a árvore vazia
    public Main() {
        raiz = null;
    }

    // Método para inserir um elemento na árvore binária de busca
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    // Método recursivo para inserir um elemento na árvore
    private Node inserirRecursivo(Node raiz, int valor) {
        if (raiz == null) {
            return new Node(valor);
        }
        if (valor < raiz.info) {
            raiz.esquerda = inserirRecursivo(raiz.esquerda, valor);
        } else if (valor > raiz.info) {
            raiz.direita = inserirRecursivo(raiz.direita, valor);
        }
        return raiz;
    }

    // Método para percorrer a árvore em in-ordem (esquerda-raiz-direita)
    public void percorrerInOrdem() {
        percorrerInOrdemRecursivo(raiz);
        System.out.println();
    }

    // Método recursivo para percorrer a árvore em in-ordem
    private void percorrerInOrdemRecursivo(Node raiz) {
        if (raiz != null) {
            percorrerInOrdemRecursivo(raiz.esquerda);
            System.out.print(raiz.info + " ");
            percorrerInOrdemRecursivo(raiz.direita);
        }
    }

    // Método para percorrer a árvore em pré-ordem (raiz-esquerda-direita)
    public void percorrerPreOrdem() {
        percorrerPreOrdemRecursivo(raiz);
        System.out.println();
    }

    // Método recursivo para percorrer a árvore em pré-ordem
    private void percorrerPreOrdemRecursivo(Node raiz) {
        if (raiz != null) {
            System.out.print(raiz.info + " ");
            percorrerPreOrdemRecursivo(raiz.esquerda);
            percorrerPreOrdemRecursivo(raiz.direita);
        }
    }

    // Método para percorrer a árvore em pós-ordem (esquerda-direita-raiz)
    public void percorrerPosOrdem() {
        percorrerPosOrdemRecursivo(raiz);
        System.out.println();
    }

    // Método recursivo para percorrer a árvore em pós-ordem
    private void percorrerPosOrdemRecursivo(Node raiz) {
        if (raiz != null) {
            percorrerPosOrdemRecursivo(raiz.esquerda);
            percorrerPosOrdemRecursivo(raiz.direita);
            System.out.print(raiz.info + " ");
        }
    }

    // Método para remover o maior elemento da árvore
    public void removerMaior() {
        raiz = removerMaiorRecursivo(raiz);
    }

    // Método recursivo para remover o maior elemento
    private Node removerMaiorRecursivo(Node raiz) {
        if (raiz.direita == null) {
            return raiz.esquerda; // Substitui a raiz pelo filho à esquerda
        }
        raiz.direita = removerMaiorRecursivo(raiz.direita);
        return raiz;
    }

    // Método para remover o menor elemento da árvore
    public void removerMenor() {
        raiz = removerMenorRecursivo(raiz);
    }

    // Método recursivo para remover o menor elemento
    private Node removerMenorRecursivo(Node raiz) {
        if (raiz.esquerda == null) {
            return raiz.direita; // Substitui a raiz pelo filho à direita
        }
        raiz.esquerda = removerMenorRecursivo(raiz.esquerda);
        return raiz;
    }

    ublic void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    // Método recursivo para remover um elemento específico
    private Node removerRecursivo(Node raiz, int valor) {
        if (raiz == null) {
            return null;
        }
        if (valor < raiz.info) {
            raiz.esquerda = removerRecursivo(raiz.esquerda, valor);
        } else if (valor > raiz.info) {
            raiz.direita = removerRecursivo(raiz.direita, valor);
        } else {
            // Nodo com o valor a ser removido encontrado
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }
            raiz.info = encontrarMinimo(raiz.direita).info;
            raiz.direita = removerRecursivo(raiz.direita, raiz.info);
        }
        return raiz;
    }

    // Método para encontrar o menor valor a partir de um nó
    private Node encontrarMinimo(Node raiz) {
        while (raiz.esquerda != null) {
            raiz = raiz.esquerda;
        }
        return raiz;
    }

    // Método principal para testar a árvore binária de busca
    public static void main(String[] args) {
        Main arvore = new Main();

        // Inserindo elementos na árvore
        int[] elementos = {14, 15, 4, 9, 7, 18, 3, 5, 16, 20, 17, 9, 5};
        for (int valor : elementos) {
            arvore.inserir(valor);
        }

        // Percorrendo a árvore em diferentes ordens
        System.out.print("In-ordem: ");
        arvore.percorrerInOrdem();
        System.out.print("Pré-ordem: ");
        arvore.percorrerPreOrdem();
        System.out.print("Pós-ordem: ");
        arvore.percorrerPosOrdem();

        // Removendo o maior elemento
        arvore.removerMaior();
        System.out.print("In-ordem após remover o maior elemento: ");
        arvore.percorrerInOrdem();

        // Removendo o menor elemento
        arvore.removerMenor();
        System.out.print("In-ordem após remover o menor elemento: ");
        arvore.percorrerInOrdem();

        // Removendo um elemento específico
        arvore.remover(15);
        System.out.print("In-ordem após remover o elemento 15: ");
        arvore.percorrerInOrdem();
    }
}
