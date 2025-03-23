from os import listdir
from os.path import isfile, join


def print_file_names(dir):
    for file in sorted(listdir(dir)):
        full_path = join(dir, file)
        if isfile(full_path):
            print(file)
        else:
            print_file_names(full_path)


print_file_names("../java")
