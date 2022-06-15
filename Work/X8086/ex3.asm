include "emu8086.inc"
org 100h  

start:   

print "Type x: "
call scan_num
printn

mov x, cx  

print "Type y: "
call scan_num
printn

mov y, cx

print "Type z: "
call scan_num
printn

mov z, cx

mov ax, x
cmp ax, y
jb s1
s1r:

mov ax, y
cmp ax, z
jb s2
s2r:

mov ax, x
cmp ax, y
jb s3
s3r:

print "After sorting : "
mov ax, x
call print_num 

print ", "
mov ax, y
call print_num 

print ", "
mov ax, z
call print_num

jmp halt



s1:
mov bx, ax
mov ax, y
mov x, ax
mov y, bx
jmp s1r

s2:
mov bx, ax
mov ax, z
mov y, ax
mov z, bx
jmp s2r

s3:
mov bx, ax
mov ax, y
mov x, ax
mov y, bx
jmp s3r

;Definding section

DEFINE_SCAN_NUM
DEFINE_PRINT_NUM
DEFINE_PRINT_NUM_UNS


; Declaring section

x dw 0
y dw 0
z dw 0





halt:

ret