import java.util.ArrayList;
public class insertionSort {
    
    public static void main(String args[]){
    
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(3);
        arr.add(7);
        arr.add(5);
        arr.add(9);
        arr.add(4);
        arr.add(0);
        arr.add(2);
        arr.add(8);
        arr.add(6);
        String seq = "";
        
        for(int i = 0;i<=arr.size()-1;i++){
            
        seq = seq + " , " + arr.get(i); 
     
        }
       
        System.out.println(seq);
        arr = sort(arr);
        seq = "";
        for(int i = 0;i<=arr.size()-1;i++){
        	seq = seq + " , " + arr.get(i); 
     
        }
        System.out.println(seq);
    }
    
    public static ArrayList<Integer> sort(ArrayList<Integer> arr){
    
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        
        for(int i = 0;i<=arr.size()-1;i++){
            insert(arr.get(i), arr2);
        }
        
        return arr2;
    } 
    
    public static void insert(int a, ArrayList<Integer> arr){
        int i;
        for(i = 0; i<=arr.size()-1&&arr.get(i).compareTo(a)<0;i++){ }
        arr.add(i, a);
        
    }
}
