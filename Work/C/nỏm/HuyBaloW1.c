#include <stdio.h> //
#include <stdlib.h> //
#include <string.h> //
#include <math.h> //

#define MAX_SIZE 1024

long long* getInt(char msg[], long long min, long long max);

void printArr(long long arr[], int size);

void xap_xep_mang(long long arr[], int size);

int findInd(long long arr[], int size, int num);

void swap(long long *a, long long *b)
{
    long long c=*a;
    *a=*b;
    *b=c;
} 


int main()
{ 
    char border[] = "----------------------------------------------------------------\n";
    long long arr[MAX_SIZE];
    int size = 0;
    long long* choice;
    int menuL = 5;
    char* menu[5];
    menu[0] = "1. add an element.";
    menu[1] = "2. Show the array.";
    menu[2] = "3. Show sorted array without affecting the main array.";
    menu[3] = "4. Find index of user inputed element.";
    menu[4] = "5. End program.";
    
    do
    {
        system("cls");
        printf("%s", border);
        for (int i = 0; i < 5; i++)
        { 
            printf("%s\n", menu[i]);
        }
        choice = getInt("Your choice\n", 1,5);

        long long* value;

        switch (*choice)
        {
            case 1: 
                system("cls");
                printf("%s", border);
                value = getInt("Input the value (int)\n", -10000000000, 10000000000);
                arr[size++] = *value;
                free(value);
                break;
            case 2:
                system("cls");
                printf("%s", border);
                printf("The array: ");
                printArr(arr, size);
                printf("\nPress ENTER key to Continue\n");  
                getchar();  
                break;
            case 3:
                system("cls");
                printf("%s", border);
                long long* newArr = (long long*) malloc(sizeof(long long) * size);
                for (int i = 0; i < size; i++) *(newArr+i) = *(arr+i);
                xap_xep_mang(newArr, size);
                printf("After sorting: |");
                printArr(newArr, size);
                free(newArr);
                printf("\nPress ENTER key to Continue\n");  
                getchar();  
                break;
            case 4:
                system("cls");
                printf("%s", border);
                value = getInt("Input the value\n", -10000000000, 10000000000);
                int ind = findInd(arr, size, *value);
                if(ind == -1) printf("Can't find the value, Try again later\n");
                else printf("Found value %lld at index #%d", *value, ind);
                printf("\nPress ENTER key to Continue\n");  
                getchar();  
                break;
            case 5:
                system("cls");
                printf("%s", border);
                printf("Closing the program");
                

        }

    } while (*choice != 5);
    free(choice);
}

int findInd (long long arr[], int size, int num)
{
    for (int i = 0; i < size; i++)
    {   
        if(*(arr+i) == num) return i;
    }
    return -1;
}

void xap_xep_mang (long long arr[], int size)
{
    for(int i = 0; i < size; i++)
    {
        long long *jmin = &arr[i];
        for(int j = i+1; j < size; j++)
        {
            if(arr[j] < *jmin) jmin = &arr[j];
        }
        swap(&arr[i], &*jmin);
    }
}

void printArr (long long* arr, int size)
{
    for(int i = 0; i < size; i++)
    {
        printf("%d|", *(arr + i));
    }
}

long long* getInt(char msg[], long long min, long long max) 
{
     long long* value = (long long*) malloc(sizeof(long long));
     int rc = 0;

     while (1) 
     {
         printf("%s", msg);
         printf("in the range [%lld,%lld] : ",min, max);
         rc = scanf("%lld", value);
         if(rc == 0)
         {
             printf("No input accepted!\n");
             while(getchar() != '\n');
         }
         else if(getchar() != '\n')
         {
             printf("Trailing characters!\n");
             while(getchar() != '\n');
         }
         else if(*value < min || *value > max)
         {
             printf("Out of range!\n");
         }
         else break;
     }

     return value;
 }