def calculate_average(numbers):
    total = 0
    for i in range(len(numbers)):
        total += numbers[i]
    return total / len(numbers)

data = [10, 20, 30, 40]
avg = calculate_average(data)
print("Average:", avg)


# ------------------------------
# Extra random code below
# ------------------------------

def greet(name):
    print("Hello,", name)

greet("Alice")


def square_numbers(nums):
    result = []
    for n in nums:
        result.append(n * n)
    return result

squares = square_numbers(data)
print("Squares:", squares)


for i in range(5):
    print("Loop iteration:", i)


settings = {
    "version": 1.0,
    "enabled": True,
    "threshold": 15
}

if settings["enabled"]:
    print("Settings are enabled")


class Counter:
    def __init__(self):
        self.value = 0

    def increment(self):
        self.value += 1

counter = Counter()
counter.increment()
counter.increment()
print("Counter value:", counter.value)
