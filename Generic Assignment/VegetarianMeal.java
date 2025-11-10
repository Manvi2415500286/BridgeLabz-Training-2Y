interface MealPlan {
    boolean isValid();
    String name();
}

class VegetarianMeal implements MealPlan {
    public boolean isValid(){ return true; }
    public String name(){ return "Vegetarian"; }
}

class VeganMeal implements MealPlan {
    public boolean isValid(){ return true; }
    public String name(){ return "Vegan"; }
}

class KetoMeal implements MealPlan {
    public boolean isValid(){ return true; }
    public String name(){ return "Keto"; }
}

class Meal<T extends MealPlan> {
    T plan;

    Meal(T p){ plan=p; }

    public static <T extends MealPlan> Meal<T> generate(T plan) {
        if(!plan.isValid()) throw new IllegalArgumentException("Invalid meal plan");
        return new Meal<>(plan);
    }

    public String toString(){ return "Meal Plan: " + plan.name(); }

    public static void main(String[] args) {
        Meal<VeganMeal> plan = Meal.generate(new VeganMeal());
        System.out.println(plan);
    }
}
