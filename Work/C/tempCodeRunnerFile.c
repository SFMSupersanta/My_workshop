#include <stdio.h> //
#include <stdlib.h> //
#include <math.h> //

int factorial(int x)
{
    int result = x;
    if(result < 2) return result;
    for(int i = 2; i < x; i++)
     result *= i;
    return result;
}

int main()
{ 
    printf("%d", factorial(5));
}