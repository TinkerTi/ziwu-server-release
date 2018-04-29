import os
import sys

def commit(comment):
    os.system("git add .")
    os.system("git commit -m "+comment)
    os.system("git push bitbucket master")

commit(sys.argv[0])