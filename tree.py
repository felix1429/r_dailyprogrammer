#http://www.reddit.com/r/dailyprogrammer/comments/1t0r09/121613_challenge_145_easy_tree_generation/cfvkwiz?context=3

def tree(num, leaves, trunk):
    """num must be odd"""
    for x in range(1,num+1,2):
        for w in range(int(num - x)//2):
            print(" ", end = "")
        for y in range(x):
            print(leaves, end = "")
        print("\n")
    for foo in range((num - 3)//2):
        print(" ", end = "")
    for x in range(3):
        print(trunk, end = "")
