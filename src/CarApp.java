import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Steve on 7/18/2017.
 */
public class CarApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Car car = new Car();

        Validator validate = new Validator();
        ArrayList<Car> carList = new ArrayList<>();

        System.out.println("Welcome to the Grand Circus Motor Mall!");
        System.out.println("How many cars would you like to inport?: ");
        int numCars = validate.numberIsPositiveInteger(0);

        for (int i = 0; i < numCars; i++) {
            System.out.print("\nEnter car #" + (i + 1) + " make:");
            String userCar = scan.nextLine();
            car.setMake(userCar);
            System.out.print("Enter car #" + (i + 1) + " model:");
            String userModel = scan.nextLine();
            car.setModel(userModel);
            System.out.print("Enter car #" + (i + 1) + " year:");
            int userYear = validate.numberIsBetweenTwoNumbers(1000, 9999);
            car.setYear(userYear);
            System.out.print("Enter car #" + (i + 1) + " price:");
            double userPrice = validate.numberIsDouble();
            car.setPrice(userPrice);
            System.out.println("Is the car used? (y/n)");

            if (validate.validateUsed()) {
                System.out.println("Enter car #" + (i + 1) + " milage:");
                int userMilage = validate.numberIsPositiveInteger(0);
                carList.add(new UsedCar(userCar, userModel, userYear, userPrice, userMilage));
            } else {
                carList.add(new Car(userCar, userModel, userYear, userPrice));
            }

        }
        System.out.println("Current Inventory: ");
        for (Car list : carList) {
            System.out.print(list + "\n");
        }


    }
}
