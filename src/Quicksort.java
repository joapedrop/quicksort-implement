public class Quicksort {
    public static void main(String[] args) throws Exception {
      int[] vetor = gerarVetor(10);
        printar(vetor);
        quicksort(vetor, 0, vetor.length-1);
        printar(vetor);
    
    }
    public static int[] gerarVetor(int n) {
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }
        return vetor;
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
