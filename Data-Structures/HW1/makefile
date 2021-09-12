PYTHON = python
VIEWER = less

.PYONY: clean run view

run : hello.py
		#chmod u+x hello.py
		$(PYTHON) hello.py
view : hello.py
		- $(VIEWER) hello.py
clean :
		- \rm $(outfile) > /dev/null 2>&1
		- \rm *.pyc ? /dev/null 2>&1
