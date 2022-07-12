#define FONE_SIZE 10
#define CARD_SIZE 17
#define NAME_SIZE 50
#define ADDRESS_SIZE 100
#define MAXCUS_SIZE 300
#define CHOICE_SIZE 18
#define BUFFER_SIZE 255

typedef struct
{
    int date;
    int month;
    int year;
} date;

typedef struct
{

    char name[NAME_SIZE];
    date birth;
    char address[ADDRESS_SIZE];
    char phone[FONE_SIZE];
    date opening;
    double balance;
    char cardnum[CARD_SIZE];

} customer;

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

// get all information about a customer and return customer struct
customer inpCus(int ind);

void to_binary(customer *cus_arr, int cus_num);

void from_binary(customer *cus_arr, int *cus_num);

void input_mul(customer *cus_arr, int *cus_num, int times);

char *to_string(customer cus);

void print_cus(customer *cus_arr, int cus_num);

customer get_by_name(char *name, customer *cus_arr, int cus_num);
