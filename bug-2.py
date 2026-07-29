def calculate_average(numbers):
    total = 0
    for i in range(len(numbers)):
        total += numbers[i]
    return total / len(numbers)

data = [10, 20, 30, 40]
avg = calculate_average(data)
print("Average:", avg)
