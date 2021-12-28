
import java.util.*;
class chineseRemainderTheorem
{
  public static int gcd(int n,int m)
  {
    while(m!=n)
    {
      if(m>n)
    {
        m=m-n;
}else
    {
        n=n-m;
    }
}
  return m;
}
  
public static void main(String []args)
{
  System.out.println("Enter total number of equation : ");
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int a[]=new int[n];
  int m[]=new int[n];
  int Mi[]=new int[n];

  int Yi[]=new int[n];
  int M=1;
  for(int i=0;i<n;i++)
  {
    System.out.println("\nEnter value of a"+(i+1)+" : ");
    a[i]=sc.nextInt();
    System.out.println("Enter value of m"+(i+1)+" : ");
    m[i]=sc.nextInt();
    M*=m[i];//calculation for M
  }
//Check Whether All a1,a2,...,an are coprime or not
  for(int i=0;i<n-1;i++)
  {
    int gcd=gcd(a[i],a[i+1]);
    if(gcd!=1){
    //If not coprime then stop and return
    System.out.println("GCD of "+a[i]+" and "+a[i+1]+" are not 1 hence are not coprime so CRT fails");
    return ;
   }
 }
  System.out.println("\nThe value of M is "+M);
  System.out.println();
//Calculate Mi
  for(int i=0;i<n;i++)
  {
    Mi[i]=M/m[i];
    System.out.println("The value of Mi["+(i+1)+"] is "+Mi[i]);
  }
  System.out.println();
//Calculate Xi
  for(int i=0;i<n;i++)
  {
    for(int j=1;j<m[i];j++)
    {
      if(((Mi[i]*j)%m[i])==1)
      {
        Yi[i]=j;
        System.out.println("The value of Yi["+(i+1)+"] is "+Yi[i]);
        break;
      }
   }
}
//Calculate x
int x=0;
for(int i=0;i<n;i++)
{
  x+=Mi[i]*a[i]*Yi[i];
}
x=x%M;
System.out.println("\nThe value of x is "+x);
System.out.println("\nThe equations are ");
for(int i=0;i<n;i++)
{
  System.out.println(x+" = "+a[i]+" mod "+m[i]);
}
}
}
