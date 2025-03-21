def find_smallest_index(arr):
    smallest_index = 0

    for i in range(1, len(arr)):
        if arr[i] < arr[smallest_index]:
            smallest_index = i

    return smallest_index


def selection_sort(arr):
    sorted_arr = []
    arr_copy = list(arr)  # Copying to avoid modifying the original list

    while arr_copy:
        smallest_index = find_smallest_index(arr_copy)
        sorted_arr.append(arr_copy.pop(smallest_index))

    return sorted_arr


print(selection_sort([5, 3, 6, 2, 10]))
