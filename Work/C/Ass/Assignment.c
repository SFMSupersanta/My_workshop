#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <math.h>
#include "helper.h"

int main()
{

    customer cus_arr[MAXCUS_SIZE];

    int cus_num = 0;
    from_binary(cus_arr, &cus_num);
    printf("%s", cus_arr[0].cardnum);
    char choices[CHOICE_SIZE][ADDRESS_SIZE];
    strcpy(choices[0], "1. Input a number of customer and write into a binary file");
    strcpy(choices[1], "2. Input a customer and write into a binary file");
    strcpy(choices[2], "3. Show all customers detailed infomation");

    int choice, inpsize;
    do
    {
        for (int i = 0; i < CHOICE_SIZE; i++)
            printf("%s\n", choices[i]);
        printf("You have the total ammount of %d customers\n", cus_num);
        choice = getInt("Your choice(0 - 18)? ", 0, CHOICE_SIZE);
        switch (choice)
        {
        case 1:
            inpsize = getInt("How many custemer to add (0-300): ", 0, 300);
            input_mul(cus_arr, &cus_num, inpsize);
            to_binary(cus_arr, cus_num);
            printf("%d\n", cus_num);
            break;
        case 2:
            cus_arr[cus_num++] = inpCus(0);
            to_binary(cus_arr, cus_num);
            break;
        case 3:
            print_cus(cus_arr, cus_num);
            break;
            break;
        }

    } while (choice != 0);

    return 0;
}

customer get_by_name(char *name, customer *cus_arr, int cus_num)
{
}

void print_cus(customer *cus_arr, int cus_num)
{
    printf("||%-30s||%-10s||%-30s||%-10s||%-10s||%-15s||%-16s||\n", "Customer's name", "Birth day", "Customer's adress", "Phone number", "Open date", "Balance", "Card number");

    for (int i = 0; i < cus_num; i++)
    {
        char *buffer = to_string(cus_arr[i]);
        puts(buffer);
        free(buffer);
    }
}

char *to_string(customer cus)
{
    char *buffer = (char *)malloc(BUFFER_SIZE);
    snprintf(buffer, BUFFER_SIZE, "||%-30s||%2d/%2d/%4d||%-30s||%-12s||%2d/%2d/%-4d||%-15.4lf||%-16s||", cus.name, cus.birth.date, cus.birth.month, cus.birth.year, cus.address, cus.phone,
             cus.opening.date, cus.opening.month, cus.opening.year, cus.balance, cus.cardnum);
    return buffer;
}

void input_mul(customer *cus_arr, int *cus_num, int times)
{
    times += *cus_num;

    for (*cus_num; *cus_num < times; *cus_num += 1)
    {
        cus_arr[*cus_num] = inpCus((*cus_num) + 1);
    }
}

void from_binary(customer *cus_arr, int *cus_num)
{
    *cus_num = 0;
    FILE *fp = fopen("customer.dat", "r+");
    if (fp == NULL)
    {
        printf("Could not open file!\n");
        return;
    }
    while (fread(&cus_arr[*cus_num], sizeof(customer), 1, fp))
    {
        *cus_num += 1;
    }
    printf("Read from customer.dat\n");
    fclose(fp);
}

void to_binary(customer *cus_arr, int cus_num)
{
    FILE *fp = fopen("customer.dat", "w");
    if (fp == NULL)
    {
        printf("Could not open file!\n");
        return;
    }
    for (int i = 0; i < cus_num; i++)
    {
        fwrite(&cus_arr[i], sizeof(customer), 1, fp);
    }
    printf("written to file customer.dat\n");
    fclose(fp);
}

customer inpCus(int ind)
{
    if (ind != 0)
    {
        printf("Customer #%d\n", ind);
    }
    customer inp;

    printf("Enter your full name: ");
    fgets(inp.name, NAME_SIZE, stdin);
    inp.name[strcspn(inp.name, "\n")] = '\0';
    while (getdate(&inp.birth, "Enter birth day (day->date/day->month/day->yearday->year format): "))
        ;
    printf("Enter your address: ");
    fgets(inp.address, ADDRESS_SIZE, stdin);
    inp.address[strcspn(inp.address, "\n")] = '\0';

    while (getphonenumber(inp.phone))
        ;
    inp.balance = getDouble("Input balance: ", 0, 1000000000);
    while (getdate(&inp.opening, "Enter opening day  (day->date/day->month/day->yearday->year format): "))
        ;
    while (getcardid(inp.cardnum))
        ;

    return inp;
}

int getcardid(char *fone)
{
    printf("Enter your card number (16 number digits): ");
    fscanf(stdin, "%17s", fone);
    if (strlen(fone) > 16)
    {
        printf("Overflow\n");
        clear_buffer();
        return 1;
    }
    if (strlen(fone) < 16)
    {
        printf("Invalid\n");
        return 1;
    }
    clear_buffer();
    for (int i = 0; i < CARD_SIZE - 1; i++)
    {
        if (fone[i] < 48 || fone[i] > 57)
        {
            printf("Invalid input\n");
            return 1;
        }
    }

    fone[CARD_SIZE] = '\0';

    return 0;
}

int getdate(date *day, char *msg)
{

    printf("%s", msg);
    char string[12];
    char *inp = string;
    scanf("%11s", inp);
    if (strlen(inp) > 11 || strlen(inp) < 8)
    {
        printf("Invalid input\n");
        clear_buffer();
        return 1;
    }

    day->date = atoi(inp);
    inp += inc_to_num(inp);
    if (*inp != '/')
    {
        printf("Invalid input\n");
        return 1;
    }
    *inp++;

    day->month = atoi(inp);
    inp += inc_to_num(inp);
    if (*inp != '/')
    {
        printf("Invalid input\n");
        return 1;
    }
    *inp++;

    day->year = atof(inp);

    clear_buffer();

    // check year
    if (day->year >= 1900 && day->year <= 9999)
    {
        // check month
        if (day->month >= 1 && day->month <= 12)
        {
            // check days
            if ((day->date >= 1 && day->date <= 31) && (day->month == 1 || day->month == 3 || day->month == 5 || day->month == 7 || day->month == 8 || day->month == 10 || day->month == 12))
                printf("Date is valid.\n");
            else if ((day->date >= 1 && day->date <= 30) && (day->month == 4 || day->month == 6 || day->month == 9 || day->month == 11))
                printf("Date is valid.\n");
            else if ((day->date >= 1 && day->date <= 28) && (day->month == 2))
                printf("Date is valid.\n");
            else if (day->date == 29 && day->month == 2 && (day->year % 400 == 0 || (day->year % 4 == 0 && day->year % 100 != 0)))
                printf("Date is valid.\n");
            else
            {
                printf("Day is invalid.\n");
                return 1;
                clear_buffer();
            }
        }
        else
        {
            printf("Month is not valid.\n");
            return 1;
            clear_buffer();
        }
    }
    else
    {
        printf("Year is not valid.\n");
        return 1;
        clear_buffer();
    }

    return 0;
}

int inc_to_num(char *string)
{
    int inc = 0;
    if (*string >= 48 && *string <= 57)
        while (*(string + inc) >= 48 && *(string + inc) <= 57)
            inc++;
    while (*(string + inc + 1) < 48 || *(string + inc + 1) > 57)
        inc++;
    return inc;
}

int getphonenumber(char *fone)
{
    printf("Enter your phone number (10 number digits): ");
    fscanf(stdin, "%10s", fone);
    if (getchar() != '\n')
    {
        printf("Overflow characters\n");
        clear_buffer();
        return 1;
    }
    for (int i = 0; i < FONE_SIZE; i++)
    {
        if (fone[i] < 48 || fone[i] > 57)
        {
            printf("Invalid input\n");
            return 1;
        }
    }
    return 0;
}

void clear_buffer(void)
{
    char c;
    while ((c = getchar()) != '\n' && c != EOF)
        ;
}
void getString(char msg[], char arr[], int size)
{
    while (1)
    {
        printf("%s", msg);
        fgets(arr, size, stdin);
        int rc = 1;
        for (int i = 0; i < size; i++)
        {
            if (arr[i] == '\n')
            {
                rc = 0;
                arr[i] = '\0';
                i = size;
            }
        }
        if (rc != 0)
        {
            clear_buffer();
        }
        else
        {
            if (arr[0] != '\n')
                break;
        }
    }
}

long long getInt(char msg[], long long min, long long max)
{

    char val[20]; // input value
    long long intval;
    int count, rc; // int value and count value
    while (1)
    {
        printf("%s", msg);
        count = 0;
        rc = 0;
        fgets(val, 20, stdin);
        if (val[0] != '\n')
        {
            if (0 <= max && 0 >= min)
                if (val[0] == '0' && val[1] == '\n')
                    return 0;
            for (int i = 0; i < 20; i++)
            {
                if (val[i] == '\n')
                {
                    rc = 1;
                    i = 20;
                }
            }
            if (rc == 0)
            {
                clear_buffer();
            }
            val[strcspn(val, "\n")] = '\0';

            if (val[count] == '0')
            {
                while (val[count] == '0')
                {
                    count++;
                }
            }
            char *ovf;
            intval = strtoll(val, &ovf, 10);

            if (intval <= 0)
                count++;
            long long intvaldup = intval;

            while (intvaldup != 0)
            {
                intvaldup /= 10;
                count++;
            }
            if (val[count] != '\0')
                printf("*Trailing Character(s)*\n");
            else if (min <= intval && intval <= max)
            {
                return intval;
            }
            else
                printf("*OUT OF RANGE*\n");
        }
        else
            printf("*No input*\n");
    }
}
double getDouble(char msg[], double min, double max)
{
    double value, rc;
    int keeptrying = 1;
    char excess;
    do
    {
        printf("%s", msg);
        rc = scanf("%lf%c", &value, &excess);
        if (rc == 0)
        {
            printf("*No input accepted!*\n\n");
            clear_buffer();
        }
        else if (excess != '\n')
        {
            printf("*Trailing characters!*\n\n");
            clear_buffer();
        }
        else if (value < min || value > max)
        {
            printf("*Out of range!*\n\n");
        }
        else
            keeptrying = 0;
    } while (keeptrying == 1);

    return value;
}
char getChar(char msg[], char limit[])
{
    int keeptrying = 0;
    char value;
    do
    {
        printf("%s", msg);
        value = getchar();
        {
            for (int i = 0; limit[i] != '\0'; i++)
            {
                if (value == limit[i])
                {
                    if (getchar() == '\n')
                        keeptrying = 1;
                }
            }
            if (keeptrying == 0)
            {
                clear_buffer();
                printf("*Invalid character(s)!*\n");
            }
        }
    } while (keeptrying == 0);
    return value;
}