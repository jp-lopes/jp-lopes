package usp.questao2;

public class Sort<T extends Comparable> {
    
    public void InsertionSort(T[] array){
        
        System.out.print("Antes da ordenacao: ");
        for(T obj : array) System.out.print(obj + " ");
        System.out.println();
        
        for(int j=1;j<array.length;j++){
            T temp = array[j];
            int i = j-1;
            while(i>=0 && array[i].compareTo(temp)>0){
                array[i+1] = array[i];
                i = i-1;                
            }
            array[i+1] = temp;
        }
        
        System.out.print("Apos a ordenacao: ");
        for(T obj : array) System.out.print(obj + " ");
        System.out.println();

    }
    
}
