virtualenv -p python3 env
pip install django



Taken from 
https://www.youtube.com/watch?v=D6esTdOLXh4


Details page not working

http://127.0.0.1:8000/posts/details/2/


TemplateDoesNotExist at /posts/
posts/index.html
Request Method:	GET
Request URL:	http://127.0.0.1:8000/posts/
Django Version:	2.1.1
Exception Type:	TemplateDoesNotExist
Exception Value:	
posts/index.html
Exception Location:	/home/sushma/Hacks/Programming-Languages/django/env/local/lib/python3.5/site-packages/django/template/loader.py in get_template, line 19
Python Executable:	/home/sushma/Hacks/Programming-Languages/django/env/bin/python 
Python Version:	3.5.2
Python Path:	
['/home/sushma/Hacks/Programming-Languages/django/minad',
 '/home/sushma/Hacks/Programming-Languages/django/env/lib/python35.zip',
 '/home/sushma/Hacks/Programming-Languages/django/env/lib/python3.5',
 '/home/sushma/Hacks/Programming-Languages/django/env/lib/python3.5/plat-x86_64-linux-gnu',
 '/home/sushma/Hacks/Programming-Languages/django/env/lib/python3.5/lib-dynload',
 '/usr/lib/python3.5',
 '/usr/lib/python3.5/plat-x86_64-linux-gnu',
 '/home/sushma/Hacks/Programming-Languages/django/env/local/lib/python3.5/site-packages',
 '/home/sushma/Hacks/Programming-Languages/django/env/lib/python3.5/site-packages']
Server time:	Sun, 2 Sep 2018 08:42:07 +0000
