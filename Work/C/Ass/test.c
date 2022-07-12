#include<string.h>
#include<stdio.h>
#include<stdlib.h>

int inc_to_num(char* string);

int main()
{
    char* string = "14asdfas13123lk12";
    printf("%d\n", atoi(string));
    string += inc_to_num(string);
    printf("%d\n", atoi(string));
    string += inc_to_num(string);
    printf("%d\n", atoi(string));

}

int inc_to_num(char* string)
{
    int inc = 0;
    if(*string >= 48 && *string <= 57) 
        while (*(string+ inc) >= 48 && *(string + inc)<= 57) inc++;
    while(*(string + inc) < 48 || *(string + inc) > 57) inc++;
    return inc;
}