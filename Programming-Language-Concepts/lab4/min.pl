min(M, [X | Y]) :- min(X,Y,M).
min(M, [], M).
min(M, [X | Y], M2) :-
( X < M ->
min(X, Y, M2)
;
min(M, Y, M2)
).
