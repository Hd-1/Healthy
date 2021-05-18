package content;

import android.content.Context;

import com.example.healthy.R;

import java.util.ArrayList;

import data.Dishes;

public class DishesContent {

    static ArrayList<Dishes> dishes = new ArrayList<>();
    static private Context context;

    public DishesContent(Context context) {
        DishesContent.context = context;
    }

    //ALL VALUES
    static ArrayList<String> ingredientsTunaSalad = new ArrayList<>();
    static ArrayList<String> ingredientsSmoothies = new ArrayList<>();
    static ArrayList<String> ingredientsToastWraps = new ArrayList<>();
    static ArrayList<String> ingredientsOatmeal = new ArrayList<>();
    static ArrayList<String> ingredientsRiceBowl = new ArrayList<>();
    static ArrayList<String> ingredientsChickenSalad = new ArrayList<>();
    static ArrayList<String> ingredientsPeachSmoothie = new ArrayList<>();
    static ArrayList<String> ingredientsDipBurgers = new ArrayList<>();
    static ArrayList<String> ingredientsQuinoaSalad = new ArrayList<>();
    static ArrayList<String> ingredientsSweetPotato = new ArrayList<>();
    static String directions0,directions1,directions2,directions3,directions4,directions5,directions6,directions7,directions8,directions9;
    static String nutrition0,nutrition1,nutrition2,nutrition3,nutrition4,nutrition5,nutrition6,nutrition7,nutrition8,nutrition9;


    public static void removeAllDishes(){
        dishes.clear();
    }

    public static void addDishes(){
        setAllValues();

        dishes.add(new Dishes("Tarragon Tuna Salad", R.drawable.pbanner28,directions0,nutrition0,ingredientsTunaSalad,R.drawable.p29,false));
        dishes.add(new Dishes("Ginger-Kale Smoothies",R.drawable.pbanner30,directions1,nutrition1,ingredientsSmoothies,R.drawable.p31,false));
        dishes.add(new Dishes("Fruit-Filled Toast Wraps",R.drawable.pbanner32,directions2,nutrition2,ingredientsToastWraps,R.drawable.p33,false));
        dishes.add(new Dishes("Peanut Butter Oatmeal",R.drawable.pbanner33,directions3,nutrition3,ingredientsOatmeal,R.drawable.p33,false));
        dishes.add(new Dishes("Stir-Fry Rice Bowl",R.drawable.pbanner35,directions4,nutrition4,ingredientsRiceBowl,R.drawable.p36,false));
        dishes.add(new Dishes("Chicken Curry Salad",R.drawable.pbanner39,directions5,nutrition5,ingredientsChickenSalad,R.drawable.p38,false));
        dishes.add(new Dishes("Peach Smoothie",R.drawable.pbanner40,directions6,nutrition6,ingredientsPeachSmoothie,R.drawable.p41,false));
        dishes.add(new Dishes("Dip Burgers",R.drawable.pbanner42,directions7,nutrition7,ingredientsDipBurgers,R.drawable.p43,false));
        dishes.add(new Dishes("Colorful Quinoa Salad",R.drawable.pbanner44,directions8,nutrition8,ingredientsQuinoaSalad,R.drawable.p45,false));
        dishes.add(new Dishes("Sweet Potato and Egg",R.drawable.pbanner46,directions9,nutrition9,ingredientsSweetPotato,R.drawable.p47,false));
    }

    private static void setAllValues() {

        directions0 = context.getResources().getString(R.string.directions0);
        nutrition0 = context.getResources().getString(R.string.nutrition0);

        directions1 = context.getResources().getString(R.string.directions1);;
        nutrition1 = context.getResources().getString(R.string.nutrition1);;

        directions2 = context.getResources().getString(R.string.directions2);;
        nutrition2 = context.getResources().getString(R.string.nutrition2);;

        directions3 = context.getResources().getString(R.string.directions3);;
        nutrition3 = context.getResources().getString(R.string.nutrition3);;

        directions4 = context.getResources().getString(R.string.directions4);;
        nutrition4 = context.getResources().getString(R.string.nutrition4);;

        directions5 = context.getResources().getString(R.string.directions5);;
        nutrition5 = context.getResources().getString(R.string.nutrition5);;

        directions6 = context.getResources().getString(R.string.directions6);;
        nutrition6 = context.getResources().getString(R.string.nutrition6);;

        directions7 = context.getResources().getString(R.string.directions7);;
        nutrition7 = context.getResources().getString(R.string.nutrition7);;

        directions8 = context.getResources().getString(R.string.directions8);;
        nutrition8 = context.getResources().getString(R.string.nutrition8);;

        directions9 = context.getResources().getString(R.string.directions9);;
        nutrition9 = context.getResources().getString(R.string.nutrition9);;

        ingredientsTunaSalad.add("-2 cans (6 ounces each) light water-packed tuna, drained and flaked");
        ingredientsTunaSalad.add("-1 cup chopped celery");
        ingredientsTunaSalad.add("-1/4 cup chopped sweet onion");
        ingredientsTunaSalad.add("-1/3 cup reduced-fat mayonnaise");
        ingredientsTunaSalad.add("-2 tablespoons minced fresh parsley");
        ingredientsTunaSalad.add("-1 tablespoon lemon juice");
        ingredientsTunaSalad.add("-1 teaspoon minced fresh tarragon or 1/4 teaspoon dried tarragon");
        ingredientsTunaSalad.add("-1/2 teaspoon Dijon mustard");
        ingredientsTunaSalad.add("-1/4 teaspoon white pepper");
        ingredientsTunaSalad.add("-Lettuce leaves, optional");

        ingredientsSmoothies.add("- 1,1/4 cups orange juice");
        ingredientsSmoothies.add("-1 teaspoon lemon juice");
        ingredientsSmoothies.add("-2 cups torn fresh kale");
        ingredientsSmoothies.add("-1 medium apple, peeled and coarsely chopped");
        ingredientsSmoothies.add("-1 tablespoon minced fresh gingerroot");
        ingredientsSmoothies.add("-4 ice cubes");
        ingredientsSmoothies.add("-1/8 teaspoon ground cinnamon");
        ingredientsSmoothies.add("-1/8 teaspoon ground turmeric or 1/4-inch piece fresh turmeric, peeled and finely chopped");
        ingredientsSmoothies.add("-Dash cayenne pepper");

        ingredientsToastWraps.add("-3/4 cup vanilla yogurt");
        ingredientsToastWraps.add("-2/3 cup sliced ripe banana");
        ingredientsToastWraps.add("-1 large egg");
        ingredientsToastWraps.add("-1/4 cup 2% milk");
        ingredientsToastWraps.add("-1 teaspoon ground cinnamon");
        ingredientsToastWraps.add("-1/2 teaspoon ground nutmeg");
        ingredientsToastWraps.add("-2 whole wheat tortillas (8 inches)");
        ingredientsToastWraps.add("-2 teaspoons butter");
        ingredientsToastWraps.add("-2/3 cup sliced fresh strawberries");
        ingredientsToastWraps.add("-2/3 cup fresh blueberries");
        ingredientsToastWraps.add("-1/4 cup granola");
        ingredientsToastWraps.add("-OPTIONAL TOPPINGS: additional vanilla yogurt, strawberries, blueberries and granola");

        ingredientsOatmeal.add("-1,3/4 cups water");
        ingredientsOatmeal.add("-1/8 teaspoon salt");
        ingredientsOatmeal.add("-1 cup old-fashioned oats");
        ingredientsOatmeal.add("-2 tablespoons creamy peanut butter");
        ingredientsOatmeal.add("-2 tablespoons honey");
        ingredientsOatmeal.add("-2 teaspoons ground flaxseed");
        ingredientsOatmeal.add("-1/2 to 1 teaspoon ground cinnamon");
        ingredientsOatmeal.add("-Chopped apple, optional");

        ingredientsRiceBowl.add("-1 tablespoon canola oil");
        ingredientsRiceBowl.add("-2 medium carrots, julienned");
        ingredientsRiceBowl.add("-1 medium zucchini, julienned");
        ingredientsRiceBowl.add("-1/2 cup sliced baby portobello mushrooms");
        ingredientsRiceBowl.add("-1 cup bean sprouts");
        ingredientsRiceBowl.add("-1 cup fresh baby spinach");
        ingredientsRiceBowl.add("-1 tablespoon water");
        ingredientsRiceBowl.add("-1 tablespoon reduced-sodium soy sauce");
        ingredientsRiceBowl.add("-1 tablespoon chili garlic sauce");
        ingredientsRiceBowl.add("-4 large eggs");
        ingredientsRiceBowl.add("-3 cups hot cooked brown rice");
        ingredientsRiceBowl.add("-1 teaspoon sesame oil");

        ingredientsChickenSalad.add("-2/3 cup honey Greek yogurt");
        ingredientsChickenSalad.add("-4 teaspoons lemon juice");
        ingredientsChickenSalad.add("-4 teaspoons honey");
        ingredientsChickenSalad.add("-1 teaspoon curry powder");
        ingredientsChickenSalad.add("-1/4 teaspoon salt");
        ingredientsChickenSalad.add("-1/4 teaspoon garlic powder");
        ingredientsChickenSalad.add("-1/4 teaspoon pepper");
        ingredientsChickenSalad.add("-1/8 teaspoon ground ginger");
        ingredientsChickenSalad.add("-3 cups cubed cooked chicken breast");
        ingredientsChickenSalad.add("-4 celery ribs, chopped");
        ingredientsChickenSalad.add("-2 medium carrots, chopped");
        ingredientsChickenSalad.add("-2/3 cup golden raisins");
        ingredientsChickenSalad.add("-1/2 cup chopped cashews");

        ingredientsPeachSmoothie.add("-1/2 cup peach or apricot nectar");
        ingredientsPeachSmoothie.add("-1/2 cup sliced fresh or frozen peaches");
        ingredientsPeachSmoothie.add("-1/4 cup fat-free vanilla yogurt");
        ingredientsPeachSmoothie.add("-2 ice cubes");

        ingredientsDipBurgers.add("-2/3 cup water");
        ingredientsDipBurgers.add("-1/3 cup quinoa, rinsed");
        ingredientsDipBurgers.add("-1 can (15 ounces) black beans, rinsed and drained");
        ingredientsDipBurgers.add("-1 jar (16 ounces) salsa, divided");
        ingredientsDipBurgers.add("-1 cup crushed baked tortilla chip scoops");
        ingredientsDipBurgers.add("-2 tablespoons reduced-sodium taco seasoning");
        ingredientsDipBurgers.add("-8 whole wheat hamburger buns, split");
        ingredientsDipBurgers.add("-8 lettuce leaves");
        ingredientsDipBurgers.add("-8 slices tomato");
        ingredientsDipBurgers.add("-8 slices red onion");

        ingredientsQuinoaSalad.add("-2 cups water");
        ingredientsQuinoaSalad.add("-1 cup quinoa, rinsed");
        ingredientsQuinoaSalad.add("-2 cups fresh baby spinach, thinly sliced");
        ingredientsQuinoaSalad.add("-1 cup grape tomatoes, halved");
        ingredientsQuinoaSalad.add("-1 medium cucumber, seeded and chopped");
        ingredientsQuinoaSalad.add("-1 medium sweet orange pepper, chopped");
        ingredientsQuinoaSalad.add("-1 medium sweet yellow pepper, chopped");
        ingredientsQuinoaSalad.add("-2 green onions, chopped");
        ingredientsQuinoaSalad.add("-3 tablespoons lime juice");
        ingredientsQuinoaSalad.add("-2 tablespoons olive oil");
        ingredientsQuinoaSalad.add("-4 teaspoons honey");
        ingredientsQuinoaSalad.add("-1 tablespoon grated lime zest");
        ingredientsQuinoaSalad.add("-2 teaspoons minced fresh gingerroot");
        ingredientsQuinoaSalad.add("-1/4 teaspoon salt");

        ingredientsSweetPotato.add("-2 tablespoons butter");
        ingredientsSweetPotato.add("-2 medium sweet potatoes, peeled and shredded (about 4 cups)");
        ingredientsSweetPotato.add("-1 garlic clove, minced");
        ingredientsSweetPotato.add("-1/2 teaspoon salt, divided");
        ingredientsSweetPotato.add("-1/8 teaspoon dried thyme");
        ingredientsSweetPotato.add("-2 cups fresh baby spinach");
        ingredientsSweetPotato.add("-4 large eggs");
        ingredientsSweetPotato.add("-1/8 teaspoon coarsely ground pepper");
    }

    public static ArrayList<Dishes> getDishes() {
        return dishes;
    }
}
