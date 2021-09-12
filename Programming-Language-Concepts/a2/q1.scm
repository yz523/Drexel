;question 1
;Yiyun Zhang(Benny)

(define (lookup name assoc_list)
	(cond
		((null? assoc_list) '())
		((equal? name (caar assoc_list)) (car assoc_list))
		(else (lookup name (cdr assoc_list)))))

(define l1 '((l1 "l1") (l2 "l2") (l3 "l3") (l4 "l4") (l5 "l5")))
(define l2 '((t1 "t1") (t2 "t2") (t3 "t3") (t4 "t4") (t5 "t5")))
;search l1 in l1, return pair of l1
(lookup 'l1 l1)
;search l1 in l2, return null
(lookup 'l1 l2)

(define (lookup-env name environment)
	(if (null? environment) '()
		(let ((binding (lookup name (car environment))))
			(if (not (null? binding)) binding
				(lookup-env name (cdr environment))))))

(define t (list l1 l2))
;search l1 in environment, return pair of l1
(lookup-env 't1 t)
;search t6 in environment, return null
(lookup-env 't6 t)