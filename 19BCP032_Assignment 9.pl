fact(0,1).
fact(A,B) :- A > 0, C is A-1,fact(C,D),B is A * D,write(B).
