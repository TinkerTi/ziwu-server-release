import os
import sys

def commit(comment):
    os.system("git add .")
    os.system("git commit -m "+comment)
    os.system("git push origin master")

commit(sys.argv[1])

# python ./scripts/commit.py ""