// Implementação de uma fila circular ⚙️
public class FilaCircular {
    private int top = -1; // Índice inicial do topo da fila, -1 indica que a fila está vazia
    private int bottom = 0; // Índice inicial da base da fila

    private int[] array_data; // Array que representa a fila

    private int size; // Tamanho máximo da fila

    FilaCircular(int size) { // Construtor para criar a fila
        this.size = size;
        this.array_data = new int[size];
    }

    public void adicionar(int value) {
        if (isFull()) { // Verifica se a fila está cheia antes de adicionar um novo elemento
            return; // Se estiver cheia, para o programa
        }
        top = mover(top); // Move o índice do topo para a próxima posição circular
        array_data[top] = value; // coloca o valor informado na posição atual do indice topo
    }

    public int remover() {
        if (isEmpty()) { // Verifica se a fila está vazia antes de remover um elemento
            return -1; // Se estiver vazia, retorna -1 e para o programa
        }
        int value = array_data[bottom]; // guarda o valor removido (para dar o return com o valor)
        if (bottom == top) { // Se o índice bottom atingir o indice top, a fila foi esvaziada apos remover esse elemento
            top = -1; // Reseta o índice `top` para -1, indicando que a fila está vazia
            bottom = 0; // Reseta o índice `bottom` para a posição inicial
        } else {
            bottom = mover(bottom); //Se nao estiver esvaziada, move o bottom para a proxima posição (quando REMOVEMOS elementos mudamos o bottom e quando ADICIONAMOS mudamos o top)
        }
        return value; // Retorna o valor removido da fila
    }

    public void clear() {
        top = -1; // Vamos resetar os indices, pois a fila esvazia. reseta o top
        bottom = 0; // Reseta o bottom
        for (int i = 0; i < size; i++) { // Percorre todos os indices do array
            array_data[i] = 0; // Limpa todos os valores no array, setando-os para 0
        } //para cada indice do array, mude o valor para 0
    }

    public boolean isEmpty() {
        return top == -1 || bottom == top; // A fila está vazia se o índice do topo for -1
    }

    public boolean isFull() {
        return mover(top) == bottom;
        // Move o índice do topo para a próxima posição circular.
        // Se a próxima posição circular do topo coincidir com o índice de `bottom`,
        // a fila está cheia, pois não há espaço para adicionar novos elementos.
    }

    public int mover(int posicao) {
        // Função que calcula a próxima posição circular disponível no array.
        if (posicao + 1 == array_data.length) {
            // Se a posição atual for a última do array, a próxima posição circular é a posição 0,
            // voltando ao início do array, então ele retorna 0 (o índice inicial do array).
            return 0;
        }
        return posicao + 1; // Caso contrário, incrementa a posição em 1, movendo para o próximo índice do array.
    }
}
