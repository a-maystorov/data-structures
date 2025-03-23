import heapq
import math

# Graph representation (Adjacency list with weights)
graph = {"start": {"a": 6, "b": 2}, "a": {"fin": 1}, "b": {"a": 3, "fin": 5}, "fin": {}}

# Costs table (Initialize "start" correctly)
costs = {"start": 0, "a": math.inf, "b": math.inf, "fin": math.inf}

# Parents table to track the shortest path
parents = {"a": None, "b": None, "fin": None}

# Min-heap priority queue
priority_queue = [(0, "start")]  # (cost, node)
heapq.heapify(priority_queue)

processed = set()  # Track processed nodes

while priority_queue:
    current_cost, node = heapq.heappop(
        priority_queue
    )  # Get node with the smallest cost

    if node in processed:
        continue

    processed.add(node)

    for neighbor, weight in graph[node].items():
        new_cost = current_cost + weight

        if new_cost < costs[neighbor]:  # Update if a shorter path is found
            costs[neighbor] = new_cost
            parents[neighbor] = node
            heapq.heappush(
                priority_queue, (new_cost, neighbor)
            )  # Push to priority queue

# Print shortest path costs
print("Shortest path costs:", costs)

# Reconstruct the shortest path
path = []
node = "fin"
while node:
    path.append(node)
    node = parents.get(node)

print("Shortest path:", " → ".join(reversed(path)))
