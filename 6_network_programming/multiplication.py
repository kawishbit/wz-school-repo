def generate_multiplication_table(number):
    print(f"Multiplication table for {number}:")
    for i in range(1, 11):
        result = number * i
        print(f"{number} x {i} = {result}")

def get_user_input():
    while True:
        try:
            number = int(input("Enter a number to generate its multiplication table: "))
            return number
        except ValueError:
            print("Invalid input. Please enter a valid number.")

def main():
    number = get_user_input()
    generate_multiplication_table(number)

if __name__ == "__main__":
    main()