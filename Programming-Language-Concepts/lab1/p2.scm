#lang racket

;2.1 tail
(define (fac1 n)
  (if (= n 1)
      1
      (* n(fac1 (- n 1)))))
(fac1 5)

;2.1 nontail
(define (fac2 n)
  (fac-iter1 1 1 n))

(define (fac-iter1 a b c)
  (if (> b c)
      a
      (fac-iter1 (* a b) (+ b 1) c)))
(fac2 5)

;2.2 tail
(define (fac3 n)
  (if (= n 1)
      1
      (* 2(fac3 (- n 1)))))
(fac3 5)

;2.2 nontail
(define (fac4 n)
  (fac-iter2 1 1 n))

(define (fac-iter2 a b c)
  (if (>= b c)
      a
      (fac-iter2 (* a 2) (+ b 1) c)))
(fac4 5)