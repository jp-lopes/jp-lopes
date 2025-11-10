package usp.questao2;

public class Questao2 {
    public static void main(String[] args) {
        Integer[] array = {50, 45, 32, 42, 20, 19, 13, 0, -1, 29, 0, 0};
        
        Sort<Integer> sortInt = new Sort<>();
        sortInt.InsertionSort(array);
        
        System.out.println();
        
        TimeFutebol[] times = {new TimeFutebol("AmazonasFC",100), 
                                new TimeFutebol("Flamengo",0), 
                                new TimeFutebol("Vasco",2),
                                new TimeFutebol("Corinthinhianhanhs", 1)};

        Sort<TimeFutebol> sortTimes = new Sort<>();
        sortTimes.InsertionSort(times);
        
    }
}
