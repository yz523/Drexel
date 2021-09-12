#CS 360 Programming Languages 2013
#Drexel University
#Mark Boady

#Math Parser Example in Ply
#This file generates a parser for simple math expressions.
#Expressions are evaluated immediately.

#The language accepted by the parser is
# expr -> term + expr | term
# term -> factor * term | factor
# factor -> NUMBER | ( expr )

#Import the libraries for the PLY parser generator
import ply.lex as lex
import ply.yacc as yacc
import sys

#Define the Tokens used by the language
tokens =(
         'NUMBER',
         'PLUS',
         'TIMES',
         'POWER',
         'LPAREN',
         'RPAREN'
         )

#Define what character(s) define each of these tokens
t_PLUS= r'\+'
t_TIMES= r'\*'
t_POWER= r'\^'
t_LPAREN= r'\('
t_RPAREN= r'\)'
t_ignore= ' \t' #Ignore whitespace

#A Number is a collection of digits from 0-9
def t_NUMBER( t) :
    r'[0-9]+' #Match any numbers
    t.value = int(t.value) #Convert the number to an int
    return t;
#Print an error message on parsing error
def t_error(t):
    print "Illegal character '%s' on line %d" % (t.value[0],t.lexer.lineno)
    return t;
#Define the newline character and count the line number
def t_newline( t ):
    r'\n+'
    t.lexer.lineno += len(t.value)

#All the tokens are now defined.
#Command the parser to build a parse table for the tokens
lex.lex();

#Define the rules of our grammar
#Define Addition
#The return values of the symbols are placed into the p array
#An expression is defined as
#expr : term PLUS expr
#The return value is the first expr and called p[0]
#The value of term is in p[1].
#The character for the plus symbol is p[2]
#The second expr is p[3]
#This parse does the calculations immediately.
#The value of the expression is p[1]+p[3]
def p_expr_a( p ):
    'expr : term PLUS expr'
    p[0] =p[1] + p[3]
#Expression has two possible definitions
def p_expr_b( p ):
    'expr : term'
    p[0] = p[1]
#Define Multiplication
def p_term_a( p ):
    'term : pow TIMES term'
    p[0] = p[1] * p[3]
def p_term_b( p ):
    'term : pow'
    p[0] = p[1]
def p_pow_a ( p ):
    'pow : factor POWER pow'
    p[0] = p[1] ** p[3]
def p_pow_b ( p ):
    'pow : factor'
    p[0] = p[1]
#Define Factor
def p_factor_a( p ):
    'factor : NUMBER'
    p[0] = p[1]
def p_factor_b( p ):
    'factor : LPAREN expr RPAREN'
    p[0] = p[2]

#Give the error message for syntax errors
def p_error( p ):
    print "Syntax error in input!", str(p)
    sys.exit( 2 )

#Build the Parser
yacc.yacc()

#Define the main function
#This describes how our parser is called
#Take the standard input and parse it using the parser
if __name__ == '__main__' :
    print "Hello. Type ctrl-D (End of File) to quit."
    print "Type an expression followed by enter. For example, 5 * 6 + 4 * ( 8 + 3)";
    expression = sys.stdin.readline()
    while expression != "":
        result = yacc.parse(expression)
        print "The Answer is "+str(result)
        expression = sys.stdin.readline()