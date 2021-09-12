#lang racket
;3.1
(define (rev1 l)
  (define (rev2 l res)
    (if (null? l)
        res
        (rev2 (cdr l) (cons (car l) res))))
  (rev2 l '()))

(define (range L)
  (let ([start (car L)])
    (let ([step (car (cdr L))])
      (let ([end (car (cdr (cdr L)))])
        (if (> start end)
            '()
            (if (< (- end start) (- end (+ start step)))
                '()
                (rev1 (rec1 (- start step) step end '()))))))))

(define (rec1 start step end res)
  (let ((n (+ start step)))
  (if(< end n)
     res
     (rec1 n step end (cons n res)))))
(range '(0 2 7))

;3.2
(define (rev3 l)
  (define (rev4 l res)
    (if (null? l)
        res
        (rev4 (cdr l) (cons (car l) res))))
  (rev4 l '()))

(define (seq f L)
  (let ([start (car L)])
    (let ([step (car (cdr L))])
      (let ([end (car (cdr (cdr L)))])
        (if (> start end)
            '()
            (if (< (- end start) (- end (+ start step)))
                '()
                (rev3 (rec2 f (- start step) step end '() ))))))))

(define (rec2 f start step end res )
  (let* ((n (+ start step)))
  (if(< end n)
     res
     (rec2 f n step end (cons (f n) res)))))
 (seq (lambda (x) (* x x)) '(0 2 7))