
include "emu8086.inc"
org 100h  

start:   

print "Type a: "
call scan_num
printn

mov r0, cx  

print "Type b: "
call scan_num
printn

mov r1, cx

print "Type c: "
call scan_num
printn

mov r2, cx

mov bx, r0


cmp bx, r1
jb below2
s2:

cmp bx, r2
jb below3 
s3:

mov ax, bx
mov bx, 2
mul bx

mov bx, r0
sub ax, bx
mov bx, r1
sub ax, bx
mov bx, r2
sub ax, bx
mov bx, 1
add ax, bx

mov bx, 0
cmp bx, ax
jb none

print "S : "
call print_num 

jmp halt

none:
print "S : 0"
jmp halt



below2:
mov bx, r1

jmp s2

below3:
mov bx, r2

jmp s3

;Definding section

DEFINE_SCAN_NUM
DEFINE_PRINT_NUM
DEFINE_PRINT_NUM_UNS


; Declaring section

r0 dw 0
r1 dw 0
r2 dw 0





halt:

ret




