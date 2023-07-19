class Car:
    def __init__(self, brand, year):
        self.brand = brand
        self.year = year

    def start_engine(self):
        for num in range(3,0,-1):
            print(f"Engine starting in {num}")
        print("Engine started")
    
    def get_classification(self) :
        if (self.year > 2010): print("Your car is modern")
        else: print("Your car is classic")

def main():
    my_car = Car("Toyota", 2021)
    print(my_car.brand)
    my_car.start_engine()
    my_car.get_classification()
    message = f"Car Brand: {my_car.brand} \nCar Year: {my_car.year}."
    try:
        file = open("example.txt", "w")
        file.write(message)
        file.close()
    except ZeroDivisionError:
        print("Cannot open file")

if __name__ == "__main__":
    main()