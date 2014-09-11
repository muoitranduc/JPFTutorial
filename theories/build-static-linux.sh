# Note: Z3 was built using C++, so libz3.a has C++ dependencies. 
#       You can use gcc to link the program, but you need tell it 
#       to link the C++ libraries
g++ -fopenmp -static -I../lib -L../bin/external my_theory.cpp -lz3 -o my_theory
