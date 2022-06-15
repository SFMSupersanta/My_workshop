
include "emu8086.inc"
org 100h  

start:   

print "Type r0: "
call scan_num
printn

mov r0, cx  

print "Type r1: "
call scan_num
printn

mov r1, cx

mov ax, r0
mov bx, r1
cmp ax, bx
jg swap
swpc:


mov ax, r0
mov r2, ax
          
fun:
mov ax, r2
mov bx, r1
mov dx, 0
div bx
mov r3, dx
cmp dx, 0

jne cal

print "boi so nho nhat : "
mov ax, r2
call print_num
jmp halt

cal:
mov ax, r2
mov bx, r0
add ax, bx
mov r2, ax
jmp fun

swap:
mov r1, ax
mov r0, bx

jmp swpc




;Definding section

DEFINE_SCAN_NUM
DEFINE_PRINT_NUM
DEFINE_PRINT_NUM_UNS


; Declaring section

r0 dw 0
r1 dw 0
r2 dw 0
r3 dw 0





halt:

ret




