package HWorks.Lesson2.addTask;

public class chef {

    static String[][] vegetables = {
            {"Tomato", "$2", "120"},
            {"Cucumber", "$1", "200"},
            {"Pepper", "$3", "300"},
            {"Cabbage", "$1", "60"}
    };

    static final int NAME = 0;
    static final int PRICE = 1;
    static final int CALORIES = 2;


    static void priceOfSalad () {
        int priceOfSalad = 0;

        for (int i = 0; i < vegetables.length; i++) {

            int price = Integer.parseInt(vegetables[i][PRICE].substring(1));
            priceOfSalad += price;

        }

        System.out.println("Price of salad is equal to: " + priceOfSalad);
    }

    static void sumOfCaloriesInSalad () {
        int sumOfCalories = 0;

        for (int i = 0; i < vegetables.length; i++) {

            int calories = Integer.parseInt(vegetables[i][CALORIES]);
            sumOfCalories += calories;

        }

        System.out.println("Sum of salad's calories is equal to: " + sumOfCalories);
    }

    static void sortIngredientsInSaladByCalories (){

        System.out.println("\nSorted list of ingredients by number of calories: \n");

        for (int i = 0; i < vegetables.length; i++) {
            for (int j = 0; j < vegetables.length-1; j++) {
                String[] currentVegetable = vegetables[j];
                String[] nextVegetable = vegetables[j+1];

                int caloriesCurrentVegetable = Integer.parseInt(currentVegetable[CALORIES]);
                int caloriesNextVegetable = Integer.parseInt(nextVegetable[CALORIES]);

                if (caloriesCurrentVegetable > caloriesNextVegetable){
                    vegetables[j] = nextVegetable;
                    vegetables[j+1] = currentVegetable;
                }
            }
        }

        for (int i = 0; i < vegetables.length; i++) {

            System.out.println("Name: " + vegetables[i][NAME] + ", calories: " + vegetables[i][CALORIES]);
        }

    }

    static void searchIngredientsByCalories(int levelOfCalories) {

        System.out.println("\nList of ingredients that have more than " + levelOfCalories + " calories:\n");

            for (int i = 0; i < vegetables.length; i++) {

                int calories = Integer.parseInt(vegetables[i][CALORIES]);

                if (calories >= levelOfCalories) {
                    System.out.println("Name: " + vegetables[i][NAME] + ", price: " + vegetables[i][PRICE] + ", calories: " + vegetables[i][CALORIES]);
                }
            }
    }

    public static void main(String[] args) {

        priceOfSalad();
        sumOfCaloriesInSalad();
        sortIngredientsInSaladByCalories();
        searchIngredientsByCalories(150);

    }
}

//        Шеф-повар. Определить иерархию овощей. Сделать салат. Подсчитать ка-
//        лорийность. Провести сортировку овощей для салата на основе одного
//        из параметров. Найти овощи в салате, соответствующие заданному диапа-
//        зону калорийности.