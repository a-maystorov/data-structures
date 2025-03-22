def quick_sort(arr):
    if len(arr) < 2:
        return arr
    else:
        pivot = arr[0]
        less = [i for i in arr[1:] if i <= pivot]
        greater = [i for i in arr[1:] if i > pivot]

        return quick_sort(less) + [pivot] + quick_sort(greater)


def quick_sort2(arr):
    if len(arr) < 2:
        return arr
    else:
        pivot = arr[0]

        # Using loops instead of list comprehensions
        less = []
        greater = []

        for i in arr[1:]:
            if i <= pivot:
                less.append(i)
            else:
                greater.append(i)

        # Recursively sorting and combining results
        return quick_sort(less) + [pivot] + quick_sort(greater)


print(quick_sort2([10, 5, 2, 3]))
