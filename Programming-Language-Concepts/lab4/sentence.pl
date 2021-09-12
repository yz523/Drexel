article(E) :- E = a; E = the.
verb(E) :- E = sees; E = pets.
noun(E) :- E = boy; E = girl ; E = dog; E = cat.
noun_phrase([X,Y|[]]) :- article(X), noun(Y).
verb_phrase([H|T]) :- verb(H), noun_phrase(T).
sentence([X,Y|T]) :- noun_phrase([X,Y]), verb_phrase(T), !.