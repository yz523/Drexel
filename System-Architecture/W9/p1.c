main ()
{
    int r;
     
  r = setjmp(r);
  if (r == 0)
   {
    fun1();
    return(0);
   }
  else
   {
    print_str("error\n");
    return(2);
   }
 }

setjmp (v)
int v;
 {
  print_str("start setjump\n");
  if (v == 1)
  {
   return(1);
  }
  return(0);
 }

longjmp (v)
int v;
 {
  print_str("start longjump\n");
  if (v != 0)
  {
   print_str("returning setjmp(1) instead of longjmp\n");
   return setjmp(1);
  }
  return(1);
 }

fun1 ()
 {
  print_str("start fun1\n");
  fun2();
  return(0);
 }

fun2 ()
 {
  int d;
  print_str("start fun2\n");
  longjmp(d);
  return(0);
 }

__main ()
{
    return(0);
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

dummy (v)
int v;
{
    return(0);
}