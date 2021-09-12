#lang scheme
(define (bc a b)
  (if (or (< a b) (< b 0))
      '()
      (rec a b 1)))

(define (rec a b c)
  (if (or (= b 0) (= a b))
      c
      (rec (- a 1) (- b 1) (* c (/ a b)))))

(bc 7 2)