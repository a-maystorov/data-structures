def quick_sort(arr):
    if len(arr) < 2:
        return arr
    else:
        pivot = arr[len(arr) // 2]
        less = [i for i in arr if i < pivot]
        greater = [i for i in arr if i > pivot]

        return quick_sort(less) + [pivot] + quick_sort(greater)


def quick_sort2(arr):
    if len(arr) < 2:
        return arr
    else:
        pivot = arr[len(arr) // 2]

        less = []
        greater = []

        # Using loops instead of list comprehensions
        for i in arr:
            if i < pivot:
                less.append(i)
            elif i > pivot:
                greater.append(i)

        return quick_sort2(less) + [pivot] + quick_sort2(greater)


print(quick_sort2([10, 5, 2, 3]))
