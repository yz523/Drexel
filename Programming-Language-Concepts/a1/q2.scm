;Yiyun Zhang
;question 2
;in mit-scheme: (load "q2")
(define (iterator l)
  (define (range start step end)
    (lambda()
      (if (< start end)
            (begin
              ;start += step until start >= end
              (set! start (+ start step))
              (- start step))
            ;exhausted return ()
            '())))
  (range (car l) (car(cdr l)) (car(cdr(cdr l)))))


(define next (iterator '(0 2 7)))
(begin (next) (next) (next) (next) (next))