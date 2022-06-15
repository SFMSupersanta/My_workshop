
include "emu8086.inc"
org 100h  

start:   

print "Type in the seconds: "
call scan_num
printn

mov r0, cx

mov dx, 0
mov ax, r0
div hour
mov r1, ax
mov ax, dx

mov dx, 0
div muines
mov r2, ax
mov r3, dx


print "Hour is : "
mov ax, r1
call print_num  
printn

print "muines is : "
mov ax, r2
call print_num
printn

print "second : "
mov ax, r3
call print_num


jmp halt



;Definding section

DEFINE_SCAN_NUM
DEFINE_PRINT_NUM
DEFINE_PRINT_NUM_UNS


; Declaring section

r0 dw 0
r1 dw 0
r2 dw 0
r3 dw 0

muines dw 60
hour dw 3600





halt:

ret




