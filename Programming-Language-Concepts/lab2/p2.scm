(define the-global-environment (setup-environment))
(driver-loop)
(define (append x y)
 (if (null? x)
 y
 (cons (car x)
 (append (cdr x) y))))
(append '(a b c) '(d e f))
(define (factorial n)
 (if (= n 1)
 1
 (* (factorial (- n 1)) n)))
(factorial 10)