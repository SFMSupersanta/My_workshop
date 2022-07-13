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
    char choices[CHOICE_SIZE][BUFFER_SIZE];
    strcpy(choices[0], "0. Exit");
    strcpy(choices[1], "1. Input a number of customer and write into a binary file");
    strcpy(choices[2], "2. Input a customer and write into a binary file");
    strcpy(choices[3], "3. Show all customers detailed infomation");
    strcpy(choices[4], "4. Show info from name, balance of account");
    strcpy(choices[5], "5. Sort the balance incresingly or decresingly and output to file");
    strcpy(choices[6], "6. Print out the number of interest after (n) days");
    strcpy(choices[7], "7. Print the highest, second highest, lowest, second lowest of balance and array balance increasingly and decreasingly");
    strcpy(choices[8], "8. Print the highest, second highest, lowest, second lowest of each month and total ammount of each month");

    int choice,
        inpsize;
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
            cus_arr[cus_num] = inpCus(0, cus_arr, cus_num);
            cus_num++;
            to_binary(cus_arr, cus_num);
            break;
        case 3:
            print_cus(cus_arr, cus_num);
            break;
        case 4:
            show_info(cus_arr, cus_num);
            break;
        case 5:
            print_balance(cus_arr, cus_num);
            break;
        case 6:
            print_interest(cus_arr, cus_num);
            break;
        case 7:
            print_highest_balance(cus_arr, cus_num);
            break;
        case 8:
            each_month_detail(cus_arr, cus_num);
            break;
        }

    } while (choice != 0);

    return 0;
}
