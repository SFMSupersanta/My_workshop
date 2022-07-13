
CC=gcc
CFLAGS=-Wall -g
OUT=-o bank_man.exe

all: bank_man

bank_man: main.o helper.o
	$(CC) $(CFLAGS) main.o helper.o $(OUT)

main.o: main.c
	$(CC) $(CFLAGS) -c main.c

helper.o: helper.c
	$(CC) $(CFLAGS) -c helper.c

clean:
	rm bank_man.exe