#lang racket

(define (member x L)
  (cond
    ((null? L) #f)
    ((equal? x (car L)) #t)
    (else (member x (cdr L)))))
	
(define (insert x L)
  (if (member x L) L
      (cons x L)))

(member 1 '(1 2 3 4))
