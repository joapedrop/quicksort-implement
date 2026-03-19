import java.util.Scanner;

public class Quicksort {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
      ola();

    
    }
    public static int[] gerarVetor(int n) {
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }
        return vetor;
    }
    static int lerValor(){
        return sc.nextInt();
    }
    static int[] lerVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = sc.nextInt();
        }
        return vetor;
    }
    public static void ola(){
        System.out.println("--------------------------------");
        System.out.println("[0] numero random");
        System.out.println("[1] vc escolhe");
        int escolhe = lerValor();
        if(escolhe == 1){
            System.out.println("tamanho vetor");
            int tamanho  = lerValor();
            if(tamanho <=0){
                System.out.println("tem que ser maior que zero");
                ola();
                
            }
            int[] vetor = lerVetor(tamanho);
            System.out.println("----------");
            System.out.println("[0] ordem reversa");
            int escolha = sc.nextInt();
            if(escolha == 0){
                quicksortRevert(vetor, 0, vetor.length-1);
            }else{
                quicksort(vetor, 0, vetor.length-1);
            }
            printar(vetor);
        }else if(escolhe == 0){
            System.out.println("tamanho vetor");
            int tamanho = lerValor();
            if(tamanho <= 0){
                System.out.println("tem que ser maior que zero");
                ola();
            }
            int[] vetor = gerarVetor(tamanho);
            System.out.println("[0] reversa");
            System.out.println("[1] normal");
            int escolha = lerValor();
            if(escolha == 0){
                quicksortRevert(vetor, 0, vetor.length-1);
            }
            if(escolha == 1){
                quicksort(vetor, 0, vetor.length-1);
            }else{
                System.out.println("escolha invalida");
            }
            printar(vetor);
        }
    }
    static void printar(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
        
    }

    static void quicksort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(vetor, inicio, fim);
            quicksort(vetor, inicio, pivo - 1);
            quicksort(vetor, pivo + 1, fim);
        }
    }

    static void quicksortRevert(int[] vetor, int inicio, int fim){
        if(inicio < fim){
            int pivo = particionarR(vetor, inicio, fim);
            quicksortRevert(vetor, inicio, pivo-1);
            quicksortRevert(vetor, pivo+1, fim);
        }
    }

    public static int particionarR(int[] vetor, int left, int right){
        int i = (left -1);
        int pivo = right;

        for (int j = left; j < right; j++) {
            if(vetor[j] > vetor[pivo]){
                i++;
                int aux = vetor[j];
                vetor[j] = vetor[i];
                vetor[i] = aux;
            }
        }
        i++;
        int aux = vetor[right];
        vetor[right] = vetor[i];
        vetor[i] = aux;
        return i;
    }
    public static int particionar(int[] vetor, int left, int right){
        int i = left;
        int pivo = right;

        for (int j = left; j < right; j++) {
            if(vetor[j] <= vetor[pivo]){
                int aux = vetor[j];
                vetor[j] = vetor[i];
                vetor[i] = aux;
                i++;
            }
        }
        int aux = vetor[right];
        vetor[right] = vetor[i];
        vetor[i] = aux;
        return  i;
    }
}
