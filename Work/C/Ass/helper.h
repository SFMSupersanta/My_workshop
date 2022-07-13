#define FONE_SIZE 10
#define CARD_SIZE 17
#define NAME_SIZE 50
#define ADDRESS_SIZE 100
#define MAXCUS_SIZE 300
#define CHOICE_SIZE 10
#define BUFFER_SIZE 255

typedef struct
{
    int date;
    int month;
    int year;
} date;

typedef struct
{

    char name[NAME_SIZE]; // name string
    date birth;           // birth date
    char address[ADDRESS_SIZE];
    char phone[FONE_SIZE];
    date opening;
    double balance;         // december
    double balance_arr[12]; // first 11 month
    char cardnum[CARD_SIZE];

} customer;

void swap_double(double *a, double *b);

void sort_double(double arr[], int size);

void each_month_detail(customer *cus_arr, int cus_num);

double total_arr(double *arr, int size);

void arr_d_tostring(double *arr, int size);

double interest_cal(double interest, int yy);

char *to_interest_string(customer cus, int yy);

void print_interest(customer *cus_arr, int cus_num);

void swap(customer *c1, customer *c2);

void sort(customer *cus_arr, int cus_size);

void sort_rev(customer *cus_arr, int cus_size);

// get card id information
int getcardid(char *fone);

// get a fhone number from user
int getphonenumber(char *fone);

// clear input buffer
void clear_buffer(void);

// get an fixed size string
void getString(char msg[], char arr[], int size);

// get an int form min to max
long long getInt(char msg[], long long min, long long max);

// get a double value from min to max
double getDouble(char msg[], double min, double max);

// get a single character form string limit
char getChar(char msg[], char limit[]);

// increment number to the point of new int
int inc_to_num(char *string);

// get a valid date from user
int getdate(date *day, char *msg);

int get_by_name(char *name, customer *cus_arr, int cus_num);

int get_by_balance(double balance, customer *cus_arr, int cus_num);

int get_by_cardnum(char *id, customer *cus_arr, int cus_num);

int get_by_name_and_balance(char *name, double balance, customer *cus_arr, int cus_num);

// get all information about a customer and return customer struct
customer inpCus(int ind, customer *cus_arr, int cus_num);

void to_binary(customer *cus_arr, int cus_num);

void from_binary(customer *cus_arr, int *cus_num);

void input_mul(customer *cus_arr, int *cus_num, int times);

char *to_string(customer cus);

char *to_balance_string(customer cus);

void print_balance(customer *cus_arr, int cus_num);

void print_cus(customer *cus_arr, int cus_num);

void show_info(customer *cus_arr, int cus_num);

void print_highest_balance(customer *cus_arr, int cus_num);