
package usp.questao1;

public class Comparador<T extends Comparable> {
   private final T obj1;
   private final T obj2;
   
   public Comparador(T obj1, T obj2){
       this.obj1 = obj1;
       this.obj2 = obj2;
   }
   
   public T getMax(){
       if(obj1.compareTo(obj2) == 0) return null;
       else if(obj1.compareTo(obj2) > 0) return obj1;
       else return obj2;
   }
   
   @Override
   public String toString(){
       if(getMax()!= null){
            String str = getMax().toString() + " > ";
            if(getMax().equals(obj1)) str += obj2.toString();
            else str += obj1.toString();   
            return str;
       }
       else return obj1.toString() + " == " + obj2.toString();
   }
}
