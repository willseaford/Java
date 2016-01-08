
public class comparestrings {
    
    
    public static void main(String args[]){
        boolean equal = true;
        char[] c1 = {'c','u','b','t'};
        char[] c2 = {'u','b','c','t'};
    
    for (int i = 0; i <= c1.length-1;i++){
        
        for(int j = 0;j<c2.length-1;j++){
            System.out.println("comparaing "+ c1[j] + " against " + c2[i]);
            if (c1[j]==c2[i]){
                System.out.println("found match");
                break;
            }
            System.out.println("testing against " + j);
            System.out.println("testing " + j + " against " + c1[length-1];
            if(j+1 == c2.length-1){
                equal = false;
                
            }
        }
            
        }
        
        
        if(equal == true){
            System.out.println("array match");
        }
        else System.out.println("match fail");
    }
        
    }


