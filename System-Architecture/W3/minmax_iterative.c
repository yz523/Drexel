int A[10] =
 {
  11, 2, 33, 4, 15, 6, 7, 8, 9, 10
 };

main ()
 {
  int min, max;                                 // two new variable created, so $v0 = $a2 = min and $a3 = max, we need create 8 items on the stack here
  MinMaxIt (A, 10, &min, &max) ;                // there four argument in this function, so $a0 = A, $a1 = 10, $a2 = min, $a3 = max
//printf ("MinMaxIt = %d %d \n", min, max) ;
  print_str("MinMaxIt = ");                     // there is one argument in this function, so $a0 here is the string, since it is a function call, so the program jump to the corresponding funciton
  print_int(min); print_str("  ");              // there is one argument in the first function, so $a0 = min, and then jump to the function. In second function call, $a0 = empty string, and then jump to the function
  print_int(max); print_str("\n");              // same as previous lane
  return(0);                                    // the main function return 0, so let $v0 = 0 and copy it to $v0
 }                                              // main function end here, copy frame pointer to stack pointer, and load return address and frame pointer. Delete 8 items from the stack and jump to the return address

MinMaxIt (A, n, _min, _max)                     // there are four arguments in this function call so adjust stack first for this 4 items, and copy stak pointer to frame pointer
register int * A;                               // save A to $a0
register unsigned int n;                        // save n to $a1
register int * _min;                            // save _min to $a2
register int * _max;                            // save _max to $a3
 {
  register int min asm ("s5") ;                 // save min to $s5
  register int max asm ("s6") ;                 // save max to $s6
  register int *p  asm ("s7") ;                 // save p to $s7
  min = A[0];                                   // save A[0] to min($S5), and save base address of A in $v0
  max = A[0];                                   // save A[0] to max($S6), and save base address of A in $v1
  for (p = &A[1]; p < &A[n]; p ++ )             // initiate p and A first so $v0 = A and $s7 = p. This is the first loop(L3): for all p < &A[n], p++(so extra space is needed for $v0, and this is L5, which L3 is follows it) and go to the futher loop(L6). if p > &A[n] then jump to L4
   {
    if ( * p < min) min = * p;                  // This loop is L6, load $v0 =p and check if p is less then min($s5), if not jump to L7, if it is load min($s5) = p and then jump
    if ( * p > max) max = * p;                  // This loop is L7, load $v0 = p and check if max > p, if not jump to L5(the for loop), if it is load max($s6) = p and then jump
   }                                            // for loop end here(l4), no need to deal with return address, stack pointer and frame address here because this is not the end of the function
  * _max = max;                                 // let $v0 = _max and save _max($v0) = max($s6)
  * _min = min;                                 // let $v0 = _min and save _min($v0) = min($s7)
  return(0);                                    // the MinMaxIt function return 0, so let $v0 = 0 and copy it to $v0  copy frame pointer to stack pointer, and load return address and frame pointer. Delete 4 items from the stack and jump to the return address
 }                                              // MinMaxIt function end here,

__main ()
 {
  return(0);
 }

dummy (v)
int v;
 {
  return(0);
 }

print_int (value)
int value;
 {
  int code;
  code = 1;
  asm (
       "add $a0,%1,$zero\n\t"
       "add $v0,%0,$zero\n\t"
       "syscall"
       :
       : "r" (code), "r" (value));
  return(value);
 }

print_hex (value)
int value;
 {
  char s[10];
  itox(value,s);
  print_str(s);
  return(value);
 }

print_str (str)
char *str;
 {
  int code;
  code = 4;
  asm (
       "add $a0,%1,$zero\n\t"
       "add $v0,%0,$zero\n\t"
       "syscall"
       :
       : "r" (code), "r" (str));
  return(0);
 }

/*
  itox converts v to eight hex digits and stores them in str[]
  such that str[0] is the leftmost digit (msd) and str[7] is the rightmost (lsd)
*/

itox (v,str)
int v;
char *str;
 {
  int i, j, t;
  j = 7;
  for (i = 0; i < 8; i++)
   {
    t = v & 0x0f;
    if (t < 10) str[j] = t + '0';
     else str[j] = t - 10 + 'A';
    v = v >> 4;
    j--;
   }
  str[8] = 0;
  return(v);
 }

print_stack (var0)
int var0;
 {
  int *p, v, i, k;
  k = 42;
  p = &var0;
  v = (int) p;
  print_hex(v);
  print_str("\n");
  p = p - 20;
  for (i = 0; i < 82; i++)
   {
    v = (int) p;    print_hex(v);    print_str("  ");
    v =      *p;    print_hex(v);    print_str("\n");
    p++;
   }
  return(k);
 }
