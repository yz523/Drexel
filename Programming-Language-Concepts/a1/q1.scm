;Yiyun Zhang
;question 1
;in mit-scheme: (load "q1")
(define (make-leaf symbol weight)
  (list 'leaf symbol weight))

(define (leaf? object)
  (eq? (car object) 'leaf))

(define (symbol-leaf x) (cadr x))

(define (weight-leaf x) (caddr x))

(define (make-code-tree left right)
  (list left
        right
        (append (symbols left) (symbols right))
        (+ (weight left) (weight right))))

(define (left-branch tree) (car tree))

(define (right-branch tree) (cadr tree))

(define (symbols tree)
  (if (leaf? tree)
      (list (symbol-leaf tree))
      (caddr tree)))

(define (weight tree)
  (if (leaf? tree)
      (weight-leaf tree)
      (cadddr tree)))

;decoding
(define (decode bits tree)
  (define (decode-1 bits current-branch)
    (if (null? bits)
        '()
        (let ((next-branch
               (choose-branch (car bits) current-branch)))
          (if (leaf? next-branch)
              (cons (symbol-leaf next-branch)
                    (decode-1 (cdr bits) tree))
              (decode-1 (cdr bits) next-branch)))))
  (decode-1 bits tree))

(define (choose-branch bit branch)
  (cond ((= bit 0) (left-branch branch))
        ((= bit 1) (right-branch branch))
        (else (error "bad bit -- CHOOSE-BRANCH" bit))))

;encoding
(define (encode-symbol symbol tree)
  (define (encode-1 tree-list encoded)
    (if (leaf? tree-list)
  (reverse encoded)
  (let ((left (left-branch tree-list))
        (right (right-branch tree-list)))
    (let ((symbols-left (symbols left))
    (symbols-right (symbols right)))
      (cond ((element-of-set? symbol symbols-left)
       (encode-1 left (cons 0 encoded)))
      ((element-of-set? symbol symbols-right)
       (encode-1 right (cons 1 encoded)))
      (else
       (error "Bad symbol: ENCODE-SYMBOL" symbol)))))))
  (encode-1 tree '()))

(define (element-of-set? x set)
  (cond ((null? set) false)
        ((equal? x (car set)) true)
        (else (element-of-set? x (cdr set)))))

(define (encode message tree)
  (if (null? message)
      '()
      (append (encode-symbol (car message) tree)
              (encode (cdr message) tree))))

;create tree
(define mytree
  (make-code-tree
  (make-code-tree (make-leaf 'a 1) (make-leaf 'b 2))
  (make-code-tree (make-leaf 'c 3) (make-code-tree (make-leaf 'd 4)
                                                   (make-code-tree (make-leaf 'e 5) (make-leaf 'f 6))))))

;      tree
;     a    b
;   c   d
; e   f
;

(display "My tree\n")
(display "a:")
(encode-symbol 'a mytree)
(display "b:")
(encode-symbol 'b mytree)
(display "c:")
(encode-symbol 'c mytree)
(display "d:")
(encode-symbol 'd mytree)
(display "e:")
(encode-symbol 'e mytree)
(display "f:")
(encode-symbol 'f mytree)



(display "Encoding\n")
(encode '(a b c d e f) mytree)

(display "Decodeding\n")
(decode '(0 0 0 1 1 0 1 1 0 1 1 1 0 1 1 1 1) mytree)