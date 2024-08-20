//implementação de uma fila estática ✨
public class FilaEstatica {
    private int top = -1; //valor do topo
    private int bottom = -1; //valor da base

    private int[] array_data; //array (fila)

    private int size; //tamanho da fila | estática |
    FilaEstatica(int size){ //construtor para criar uma fila
        this.size = size;
        this.array_data = new int[size];
    }

    private void adicionar(int value){
        if (isFull()) { //verifica se a fila está cheia, caso estiver, para o programa
            return;
        }
        if (top == -1 && bottom == -1) { //aqui vai 'inicializar' o bottom, já que agora temos um valor na fila
            bottom = 0; //colocamos ele como 0 (primeiro índice)
        }
        top++; //se n estiver cheia, vai incrementar o topo
        array_data[top] = value; //e o índice do topo (já incrementado) vai ser o índice do novo valor "pushado"
    }

    private int remover(){
        if (isEmpty()){ //se estiver vazia para o programa
            return -1;
        }
        int valor = array_data[bottom]; //uma variavel que armazena o valor do indice bottom (o que vai ser removido)
        array_data[bottom] = 0; // o valor do indice bottom agora é 0 (foi retirado)
        bottom++; //aumenta a base, pois o primeiro da fila foi removido e base passa para o indice seguinte
        return valor;
    }

    public void clear(){ //top começa com o valor final da fila aqui ex:top = tem 5 valores na fila e o top é 4
        while (top != -1 && bottom <= top) { //percorre os valores da fila e seta o valor com o indice do bottom para 0
            array_data[bottom] = 0; // e vai incrementando o bottom
            bottom++; //quando o bottom chega no valor do top ele para o while
        }
        top = bottom = -1; //termina resetando os valores do top e bottom
    }

    public boolean isFull(){
        return top >= size - 1; //se o topo for maior que o tamanho do array (tamanho 5 - 1 = 4) a fila ta cheia
    }

    public boolean isEmpty(){ //se o topo e o bottom forem -1, a fila ta vazia
        return (bottom==-1 && top==-1) ;
    }
}
