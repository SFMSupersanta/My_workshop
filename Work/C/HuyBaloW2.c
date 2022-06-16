#include<stdio.h>
#include<stdlib.h>

int mystrlen(char *str)
{ 
    int i = 0;
    while(*str++ != '\0') i++;
    return i;
}

void mystrcpy(char *dest, const char *src)
{
    while(*src)
    { 
        *dest++ = *src++;
    }
    *dest = '\0';
}

void mystrncpy(char *dest, const char *src, size_t size)
{
    for(int i = 0; i < size; i++)
    { 
        *dest++ = *src++;
    }
    *dest = '\0';
}

void mystrnset(char *dest, char ch, int n)
{ 
    if(n > mystrlen(dest)) n = mystrlen(dest);
    for(int i = 0; i < n; i++)
    { 
        *dest++ = ch;
    }
}

char* mystrstr(char *dest, char *src)
{ 
    char* ret = dest;

    for(int i = 0; i < mystrlen(dest); i++)
    {
        if (*ret == *src)
        {
            char* tempsrc = src + 1;
            char* tempret = ret + 1;
            for(int j = 0; j < mystrlen(tempsrc) - 1; j++)
            {
                if(*tempsrc++ != *tempret++) break;
                else if (j == mystrlen(tempsrc) - 2) return ret;
            }
        }
        *ret++;
    }
    return NULL;

}

char* mystrchr(char * dest, char ch)
{
    while(*dest)
    {
        if(*dest == ch) return dest;
        *dest++;
    }
        
    return NULL;
}

int mystrcmp(char *dest, char* src)
{
    while(*dest)
    {
        int i = *dest++ - *src++;
        if(i != 0) return i;
    }
    return 0;
}

void mystrcat(char *dest, char *src)
{
    char *ret = (char*)malloc(mystrlen(src) + mystrlen(dest) + 1);
    mystrncpy(ret, dest, mystrlen(dest));
    mystrncpy(ret + mystrlen(dest), src, mystrlen(src));
    mystrcpy(dest, ret);
    free(ret);
}

int main()
{
    char str[] = "Hello, this is a random string.";
    char str2[] = " Hello, this is the second random string.";

    // Test 1, equal strings
    if(mystrcmp(str, "Hello, this is a random string.") == 0)
    printf("Test1(mystrcmp): true\n");
    // Test 2, not equal strings
    if(mystrcmp(str, str2) != 0)
    printf("Test2(mystrcmp): true\n--------------------------");

    // Test 3, substring exist
    char* test = mystrstr(str, "this");
    if(*test != '\n') printf ("\nTest3(strstr) result: %s\n", test);
    // Test 4, substring not exit
    test = mystrstr(str, "burito");
    if(test == NULL) printf ("Test4(strstr): true\n--------------------------\n");

    // Test 5, char exist
    test = mystrchr(str, 't');
    printf("Test5 (mystrchr) result: %s\n", test);
    // Test 6, char not exit
    test = mystrchr(str, 'O');
    if(test == NULL) printf ("Test6 (mystrchr): true\n--------------------------\n");

    // Test 7 string: "Hello, this is a coppied string"
    mystrcpy(str, "Hello, this is a coppied string lmao bruh bruh lmao");
    printf("Test7 (mystrcpy) result: %s\n", str);
    // Test 8
    mystrncpy(str, "Hello, this is a coppied string", 15);
    printf("Test8 (mystrncpy) result: %s\n--------------------------\n", str);

    // Test 9 : char 'a'
    mystrnset(str, 'a', 10);
    printf("Test9 (mystrnset) result: %s\n--------------------------\n", str);

    // Test 10 String: "This is an additional string";
    mystrcat(str, "This is an additional string");
    printf("Test10 (mystrcat) result: %s\n", str);



}