.PHONY : make

prob1 : problem1.py
	python problem1.py $(arg)
prob2 : problem2.py
	python problem2.py $(arg)
prob3 : problem3.py
	@for n in $(shell seq 1 40); do\
        python problem3.py $$n; \
	done
