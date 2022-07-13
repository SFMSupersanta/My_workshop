#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#include "helper.h"

char months[12][20] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

void each_month_detail(customer *cus_arr, int cus_num)
{
    double max = 0.0;
    int ind;

    double data[12][cus_num];
    for (int i = 0; i < 11; i++)
        for (int j = 0; j < cus_num; j++)
            data[i][j] = cus_arr[j].balance_arr[i];

    double dec_arr[cus_num];
    for (int i = 0; i < cus_num; i++)
        dec_arr[i] = cus_arr[i].balance;

    double total[12];
    for (int i = 0; i < 11; i++)
        total[i] = total_arr(data[i], cus_num);
    total[11] = total_arr(dec_arr, cus_num);

    for (int i = 0; i < 12; i++)
        if (total[i] > max)
        {
            max = total[i];
            ind = i;
        }

    for (int i = 0; i < 11; i++)
    {
        puts("-------------------------------------------------------------------");
        sort_double(data[i], cus_num);
        printf("%s highest balance: %.5lf, second highest: %.5lf\n", months[i], data[i][cus_num - 1], data[i][cus_num - 2]);
        printf("%s lowest balance:  %.5lf, second lowest:  %.5lf\n", months[i], data[i][0], data[i][1]);
        printf("Total ammount of %s: %.5lf\n", months[i], total[i]);
    }

    sort_double(dec_arr, cus_num);
    puts("-------------------------------------------------------------------");
    printf("%s highest balance: %.5lf, second highest: %.5lf\n", months[11], dec_arr[cus_num - 1], dec_arr[cus_num - 2]);
    printf("%s highest balance: %.5lf, second highest: %.5lf\n", months[11], dec_arr[0], dec_arr[1]);
    printf("Total ammount of %s: %.5lf\n", months[11], total[11]);
    puts("-------------------------------------------------------------------\n");
    printf("The month capture the highest total balance ammount is %s of %.7lf\n\n", months[ind], total[ind]);
}

void swap_double(double *a, double *b)
{
    int c = *a;
    *a = *b;
    *b = c;
}

void sort_double(double arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        double *jmin = &arr[i];
        for (int j = i + 1; j < size; j++)
        {
            if (arr[j] < *jmin)
                jmin = &arr[j];
        }
        swap_double(&arr[i], &*jmin);
    }
}

double total_arr(double *balance_arr, int size)
{
    double total = 0;
    for (int i = 0; i < 12; i++)
        total += balance_arr[i];
    return total;
}

void print_highest_balance(customer *cus_arr, int cus_num)
{
    double increasing[cus_num];
    double decreasing[cus_num];

    sort(cus_arr, cus_num);
    for (int i = 0; i < cus_num; i++)
        increasing[i] = cus_arr[i].balance;

    sort_rev(cus_arr, cus_num);
    for (int i = 0; i < cus_num; i++)
        decreasing[i] = cus_arr[i].balance;
    puts("-------------------------------------------------------------------");
    printf("The highest balance: %.7lf\n", increasing[cus_num - 1]);
    printf("The second highest balance: %.7lf\n", increasing[cus_num - 2]);
    printf("The lowest balance: %.7lf\n", increasing[0]);
    printf("The second lowest balance: %.7lf\n", increasing[1]);
    printf("Increasing balance array: ");
    arr_d_tostring(increasing, cus_num);
    printf("Decreasing balance array: ");
    arr_d_tostring(decreasing, cus_num);
}

void arr_d_tostring(double *arr, int size)
{
    printf("[");
    for (int i = 0; i < size; i++)
    {
        printf("%.7lf", arr[i]);
        if (i != size - 1)
            printf(", ");
    }
    printf("]\n");
}

double interest_cal(double interest, int yy)
{
    double rate;
    if (interest < 10000000)
        rate = 0.2;
    else if (interest < 50000000)
        rate = 0.3;
    else
        rate = 0.4;
    return (interest * (pow((1 + rate), yy)));
}

char *to_interest_string(customer cus, int yy)
{
    char *buffer = malloc(BUFFER_SIZE);
    double interest = interest_cal(cus.balance, yy) - cus.balance;
    snprintf(buffer, BUFFER_SIZE, "||%-50s||%-20.6lf||%-20.6lf||%-20.6lf||", cus.name, cus.balance, interest, cus.balance + interest);
    return buffer;
}

void print_interest(customer *cus_arr, int cus_num)
{
    int days = getInt("Number of days: ", 0, 99999999);
    printf("||%-50s||%-20s||%-20s||%-20s||\n", "Customer's name", "Account's balance", "Interest ammount", "Summation of balance");
    puts("--------------------------------------------------------------------------------------------------------------------");
    for (int i = 0; i < cus_num; i++)
    {
        char *buf = to_interest_string(cus_arr[i], days / 365);
        if (buf != NULL)
        {
            puts(buf);
            free(buf);
        }
        else
            printf("Problem uccured");
    }
}

void print_balance(customer *cus_arr, int cus_num)
{
    FILE *fp;
    char choice = getChar("Type (i/I) to sort the list incresingly, (d/D) to sort decresingly :", "iIdD");
    printf("||%-50s||%-20s||\n", "Customer's name", "Account's balance");
    puts("----------------------------------------------------------------------------");
    if (choice == 'i' || choice == 'I')
    {
        sort(cus_arr, cus_num);
        fp = fopen("increase.txt", "w");
        if (fp == NULL)
            printf("Failed open file\n");
    }
    else
    {
        sort_rev(cus_arr, cus_num);
        fp = fopen("decrease.txt", "w");
        if (fp == NULL)
            printf("Failed open file\n");
    }

    for (int i = 0; i < cus_num; i++)
    {
        char *buf = to_balance_string(cus_arr[i]);
        if (buf != NULL)
        {
            puts(buf);
            fprintf(fp, "%s\n", buf);
            free(buf);
        }
        else
            printf("Problem uccured");
    }
    if (fp != NULL)
        fclose(fp);
}

char *to_balance_string(customer cus)
{
    char *buffer = malloc(BUFFER_SIZE);
    snprintf(buffer, BUFFER_SIZE, "||%-50s||%-20.6lf||", cus.name, cus.balance);
    return buffer;
}

void swap(customer *c1, customer *c2)
{
    customer c3 = *c1;
    *c1 = *c2;
    *c2 = c3;
}

void sort(customer *cus_arr, int cus_size)
{
    for (int i = 0; i < cus_size; i++)
    {
        customer *cus_min = cus_arr + i;
        for (int j = i + 1; j < cus_size; j++)
            if (cus_arr[j].balance < cus_min->balance)
                cus_min = cus_arr + j;
        swap(&cus_arr[i], cus_min);
    }
}

void sort_rev(customer *cus_arr, int cus_size)
{
    for (int i = 0; i < cus_size; i++)
    {
        customer *cus_min = cus_arr + i;
        for (int j = i + 1; j < cus_size; j++)
            if (cus_arr[j].balance > cus_min->balance)
                cus_min = cus_arr + j;
        swap(&cus_arr[i], cus_min);
    }
}

void show_info(customer *cus_arr, int cus_num)
{
    int status;
    char name[BUFFER_SIZE];
    double balance;
    do
    {
        printf("Enter full name: ");
        fgets(name, NAME_SIZE, stdin);
        name[strcspn(name, "\n")] = '\0';
        if ((status = get_by_name(name, cus_arr, cus_num)) == -1)
            printf("Name does not exist, try again\n");
    } while (status == -1);
    do
    {
        balance = getDouble("Enter balance: ", 0, 99999999);
        if ((status = get_by_balance(balance, cus_arr, cus_num)) == -1)
            printf("Balance does not exist, try again\n");
    } while (status == -1);
    if ((status = get_by_name_and_balance(name, balance, cus_arr, cus_num)) == -1)
    {
        printf("Can't find customer with inputted info\n");
        return;
    }
    printf("Found customer: %d\n", status);
    print_cus(cus_arr + status, 1);
}

int get_by_name_and_balance(char *name, double balance, customer *cus_arr, int cus_num)
{
    for (int i = 0; i < cus_num; i++)
    {
        if (strcmp(name, cus_arr[i].name) == 0 && balance == cus_arr[i].balance)
        {
            return i;
        }
    }
    return -1;
}

int get_by_cardnum(char *id, customer *cus_arr, int cus_num)
{
    for (int i = 0; i < cus_num; i++)
        if (!strcmp(id, cus_arr[i].cardnum))
            return i;
    return -1;
}

int get_by_balance(double balance, customer *cus_arr, int cus_num)
{
    for (int i = 0; i < cus_num; i++)
        if (balance == cus_arr[i].balance)
            return i;
    return -1;
}

int get_by_name(char *name, customer *cus_arr, int cus_num)
{
    for (int i = 0; i < cus_num; i++)
        if (!strcmp(name, cus_arr[i].name))
            return i;
    return -1;
}

void print_cus(customer *cus_arr, int cus_num)
{
    printf("||%-30s||%-10s||%-30s||%-10s||%-10s||%-15s||%-16s||\n", "Customer's name", "Birth day", "Customer's adress", "Phone number", "Open date", "Balance", "Card number");
    puts("-------------------------------------------------------------------------------------------------------------------------------------------");
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

    for (; *cus_num < times; *cus_num += 1)
    {
        cus_arr[*cus_num] = inpCus((*cus_num) + 1, cus_arr, *cus_num);
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

customer inpCus(int ind, customer *cus_arr, int cus_num)
{
    int status;
    double min;
    customer inp;

    if (ind != 0)
    {
        printf("Customer #%d\n", ind);
    }

    printf("Enter your full name: ");
    fgets(inp.name, NAME_SIZE, stdin);
    inp.name[strcspn(inp.name, "\n")] = '\0';

    while (getdate(&inp.birth, "Enter birth day (date/month/year): "))
        ;

    printf("Enter your address: ");
    fgets(inp.address, ADDRESS_SIZE, stdin);
    inp.address[strcspn(inp.address, "\n")] = '\0';

    while (getphonenumber(inp.phone))
        ;

    min = 0;
    for (int i = 0; i < 11; i++)
    {
        char buf[BUFFER_SIZE];
        snprintf(buf, BUFFER_SIZE, "Input balance of %s: ", months[i]);
        inp.balance_arr[i] = getDouble(buf, min, 9999999999);
        min = inp.balance_arr[i] + 1;
    }
    inp.balance = getDouble("Input balance of december: ", min, 9999999999);

    while (getdate(&inp.opening, "Enter opening day  (date/month/year): "))
        ;
    do
    {
        while (getcardid(inp.cardnum))
            ;
        if ((status = get_by_cardnum(inp.cardnum, cus_arr, cus_num)) != -1)
            printf("Card number exists, try again\n");
    } while (status != -1);

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
    inp++;

    day->month = atoi(inp);
    inp += inc_to_num(inp);
    if (*inp != '/')
    {
        printf("Invalid input\n");
        return 1;
    }
    inp++;

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