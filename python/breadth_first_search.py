from collections import deque
from os import listdir
from os.path import isfile, join

graph = {}
graph["you"] = ["alice", "bob", "claire"]
graph["bob"] = ["anuj", "peggy", "claire"]
graph["alice"] = ["peggy"]
graph["claire"] = ["thom", "jonny"]
graph["anuj"] = []
graph["peggy"] = []
graph["thom"] = []
graph["jonny"] = []


def person_is_seller(name):
    return name[-1] == "m"


def search(name):
    search_queue = deque()
    search_queue += graph[name]
    searched = set()

    while search_queue:
        person = search_queue.popleft()
        if person not in searched:
            if person_is_seller(person):
                print(person + " is a mango seller!")
                return True
            else:
                search_queue += graph[person]
                searched.add(person)
    return False


search("you")


def print_file_names(start_dir):
    search_queue = deque()
    search_queue.append(start_dir)

    while search_queue:
        dir = search_queue.popleft()
        for file in sorted(listdir(dir)):
            full_path = join(dir, file)
            if isfile(full_path):
                print(file)
            else:
                search_queue.append(full_path)


print_file_names("../java")
