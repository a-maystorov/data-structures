lst = [2, 4, 6]


def sum(lst):
    if lst == []:
        return 0
    return lst[0] + sum(lst[1:])


print("sum", "=", sum(lst))  # Does not mutate list, but creates sub-lists


def count(lst):
    if lst == []:
        return 0
    return 1 + count(lst[1:])


# Better performance: O(n)
def count2(lst, index=0):
    if index == len(lst):  # Base case: when index reaches the end of the list
        return 0
    return 1 + count2(lst, index + 1)  # Move to the next index


print("count", "=", count2(lst))


def max(lst, index=0, max_so_far=None):
    if index == len(lst):
        return max_so_far

    if max_so_far is None or lst[index] > max_so_far:
        max_so_far = lst[index]

    return max(lst, index + 1, max_so_far)


print("max", "=", max(lst))


def binary_search(arr, target, left=0, right=None):
    if right is None:
        right = len(arr) - 1

    if left > right:
        return -1  # Base case: Not found

    mid = (left + right) // 2

    if arr[mid] == target:
        return mid
    elif arr[mid] > target:
        return binary_search(arr, target, left, mid - 1)  # Search left half
    else:
        return binary_search(arr, target, mid + 1, right)  # Search right half


print("target", "=", binary_search(lst, 4))
