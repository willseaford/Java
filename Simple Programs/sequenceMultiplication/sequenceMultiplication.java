public class sequenceMultiplication {
    
    public static void main(String args[]){
    int[] arr = {1,3,4,6};
	String seq = Integer.toString(arr[0]);
    int n = 4;
    for(int i = 1;i<=arr.length-1;i++){
      seq = seq + " , " + arr[i]; 
     
    }
    System.out.println(seq);
    
    arr = multiply(arr, n);
    seq = Integer.toString(arr[0] * n);
    for(int i = 1;i<=arr.length-1;i++){
      seq = seq + " , " + arr[i]; 
    }
    System.out.println(seq);
    }
    
    public static int[] multiply(int[] arr, int n){
        
    int[] arr2 = new int[arr.length];
    for(int i = 0;i<=arr2.length-1;i++){
        arr2[i] = arr[i]*n;
    }
    
        return arr2;
    }
}
