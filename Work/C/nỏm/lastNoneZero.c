#include <stdio.h> //
#include <stdlib.h> //
#include <math.h> //

int factorial(int x)
{
    int result = x;
    if(x == 0) return 1;
    if(x < 2) return result;
    for(int i = 2; i < x; i++)
     result *= i;
    return result;
}

long long NonZero(int A, int B);

 
int main()
{
    printf("Type in the number to factorial (!): ");
    int num = 100;
    scanf("%d", &num);
    long long nonZero = NonZero(num/5, num % 5);
    printf("\nThe last none zero value is : %d", nonZero % 10);
}

long long NonZero(int A, int B)
{
    if(A <= 10) 
        return (long long)(pow(2, A) * factorial(A) * factorial(B));
    else 
        return (long long)(pow(2, A) * NonZero((A / 5), (A % 5)) * factorial(B));
}