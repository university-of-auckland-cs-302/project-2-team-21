package com.example.sneakersteals;
import com.example.sneakersteals.Models.Shoe;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
public class DataProvider {
    public List<Shoe> shoeList = new LinkedList<Shoe>();
    public static Shoe generateShoe(int id) {
        String name, brand, description;
        List<String> colourList = new ArrayList<>(), imageFilenameList = new ArrayList<>();
        List<Integer> sizeList = new ArrayList<>();
        Shoe generatedShoe = null;
        //This function will generate a shoe based on the id given. This will be manually filled out
        // with id = 1 as an example
        if (id == 1) {
            name = "Nike Air Force 1";
            brand = "Nike";
            description = "Taken from the court to the street and back since the '80s, the AF-1 is a cherished icon.";
            colourList.add("Blue");
            colourList.add("White");
            imageFilenameList.add("nike_af1_1");
            imageFilenameList.add("nike_af1_2");
            imageFilenameList.add("nike_af1_3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else if (id == 2) {
            name = "Nike Air Max 95 EC";
            brand = "Nike";
            description = "Taking inspiration from the human body and '90s athletics aesthetics, the Nike Air Max 95 EC mixes unbelievable comfort with fast-paced style.";
            colourList.add("White");
            colourList.add("Grey");
            imageFilenameList.add("nike95ec");
            imageFilenameList.add("nike95ec2");
            imageFilenameList.add("nike95ec3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else if (id == 3) {
            name = "Nike Air Max 97";
            brand = "Nike";
            description = "Featuring the original ripple design inspired by bullet trains, the Nike Air Max 97 lets you push your style full-speed ahead.";
            colourList.add("Grey");
            colourList.add("Green");
            imageFilenameList.add("nike97");
            imageFilenameList.add("nike97_2");
            imageFilenameList.add("nike97_3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else if (id == 4) {
            name = "Nike Dunk Low";
            brand = "Nike";
            description = "Take your game anywhere with the Nike Dunk Low By You. Created for the hardwood but taken to the streets, the '80s b-ball icon returns with a new design thought up by you.";
            colourList.add("Purple");
            colourList.add("White");
            imageFilenameList.add("nikedl");
            imageFilenameList.add("nikedl2");
            imageFilenameList.add("nikedl3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else if (id == 5) {
            name = "Nike Air Presto";
            brand = "Nike";
            description = "With a sleek design that's more comfortable than your favourite T-shirt, the Nike Air Presto is made to feel good and look fast.";
            colourList.add("White");
            colourList.add("Black");
            imageFilenameList.add("nikepresto");
            imageFilenameList.add("nikepresto2");
            imageFilenameList.add("nikepresto3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(11);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else if (id == 6) {
            name = "Nike Waffle One";
            brand = "Nike";
            description = "Bringing a new look to the iconic Waffle franchise, the Nike Waffle One balances everything you love most about heritage Nike running with fresh innovations.";
            colourList.add("Chocolate");
            colourList.add("White");
            imageFilenameList.add("nikewaffle");
            imageFilenameList.add("nikewaffle2");
            imageFilenameList.add("nikewaffle3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }  else if (id == 7) {
            name = "Nike Wearallday";
            brand = "Nike";
            description = "What would it feel like to lace a pair of clouds to your feet? You'll never know, but we think the Nike Wearallday is pretty close.";
            colourList.add("White");
            colourList.add("Black");
            imageFilenameList.add("nikewear");
            imageFilenameList.add("nikewear2");
            imageFilenameList.add("nikewear3");
            sizeList.add(10);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        } else if (id == 8) {
            name = "Nike Air Max Invigor Print";
            brand = "Nike";
            description = "The Nike Air Max Invigor Print Men's Shoe takes design cues from the legendary Air Max 95, updating the silhouette with an innovative foam and mesh upper for ventilated comfort and a super-lightweight fit.";
            colourList.add("Grey");
            imageFilenameList.add("nikeinvigor");
            imageFilenameList.add("nikeinvigor2");
            imageFilenameList.add("nikeinvigor3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }
        else if (id == 9) {
            name = "Nike Venture Runner";
            brand = "Nike";
            description = "The Nike Venture Runner nods to the iconic shoes of the '80s that started the running revolution.";
            colourList.add("Black");
            colourList.add("Blue");
            imageFilenameList.add("nikeventure");
            imageFilenameList.add("nikeventure2");
            imageFilenameList.add("nikeventure3");
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }
        else if (id == 10) {
            name = "Nike Court Vision Low Next Nature";
            brand = "Nike";
            description = "In love with the classic look of '80s basketball but have a thing for the fast-paced culture of today's game? Meet the Nike Court Vision Low.";
            colourList.add("White");
            imageFilenameList.add("nikecourt");
            imageFilenameList.add("nikecourt2");
            imageFilenameList.add("nikecourt3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }
        else if (id == 11) {
            name = "Stan Smith";
            brand = "Adidas";
            description = "The adidas Stan Smith trainer is timeless. Iconic. Its crisp white upper and effortless style never lose their charm.";
            colourList.add("White");
            imageFilenameList.add("ad_ss");
            imageFilenameList.add("ad_ss2");
            imageFilenameList.add("ad_ss3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 12) {
            name = "Swift Run X";
            brand = "Adidas";
            description = "When you wear these running-inspired adidas Swift Run X Shoes, you're ready to take on the city first thing.";
            colourList.add("White");
            colourList.add("Black");
            colourList.add("Red");
            imageFilenameList.add("ad_srx");
            imageFilenameList.add("ad_srx2");
            imageFilenameList.add("ad_srx3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(11);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 13) {
            name = "NMD R1 Primeblue";
            brand = "Adidas";
            description = "Pack your bag, lace up and get going. City adventures beckon in these NMD_R1 shoes.";
            colourList.add("White");
            colourList.add("Red");
            colourList.add("Black");
            imageFilenameList.add("nmd1");
            imageFilenameList.add("nmd2");
            imageFilenameList.add("nmd3");
            sizeList.add(8);
            sizeList.add(10);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 14) {
            name = "ZX 2K Boost";
            brand = "Adidas";
            description = "Every day is a journey. Every moment presents something new. Fully embrace whatever comes your way in these adidas ZX 2K Boost Shoes.";
            colourList.add("Black");
            colourList.add("White");
            imageFilenameList.add("zx");
            imageFilenameList.add("zx2");
            imageFilenameList.add("zx3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 15) {
            name = "4D Fusio";
            brand = "Adidas";
            description = "The look of speed. The feeling of comfort. These adidas shoes give you a glimpse of the future with their cutting-edge 4D midsole for controlled energy return.";
            colourList.add("Grey");
            colourList.add("White");
            colourList.add("Black");
            imageFilenameList.add("ad4d");
            imageFilenameList.add("ad4d2");
            imageFilenameList.add("ad4d3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 16) {
            name = "Superstar";
            brand = "Adidas";
            description = "Originally made for basketball courts in the '70s. Celebrated by hip hop royalty in the '80s. ";
            colourList.add("White");
            colourList.add("Black");
            imageFilenameList.add("ss");
            imageFilenameList.add("ss2");
            imageFilenameList.add("ss3");
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 17) {
            name = "NMD 360";
            brand = "Adidas";
            description = "Coolest kid on the playground? Undoubtedly yours. In these shoes, they've got adidas style on lock and advanced trainer technology underfoot.";
            colourList.add("Black");
            imageFilenameList.add("nmd360_1");
            imageFilenameList.add("nmd360_2");
            imageFilenameList.add("nmd360_3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 18) {
            name = "Gazelle";
            brand = "Adidas";
            description = "A low-profile classic. The Gazelle shoe started life as a football trainer and grew into an iconic streetwear staple.";
            colourList.add("Black");
            colourList.add("Blue");
            imageFilenameList.add("gazelle");
            imageFilenameList.add("gazelle2");
            imageFilenameList.add("gazelle3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 19) {
            name = "Nizza Platform";
            brand = "Adidas";
            description = "What do skinny jeans and flowy skirts have in common? Both look fantastic with a trendy platform like these adidas Nizza shoes.";
            colourList.add("White");
            colourList.add("Black");
            colourList.add("Cream");
            imageFilenameList.add("nizza");
            imageFilenameList.add("nizza2");
            imageFilenameList.add("nizza3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 20) {
            name = "Forum Exhibit Low";
            brand = "Adidas";
            description = "You don't break the rules — you create them. As you dare to step outside the box, these adidas shoes accent every stride with that same boldness.";
            colourList.add("Red");
            colourList.add("Cream");
            imageFilenameList.add("forum");
            imageFilenameList.add("forum");
            imageFilenameList.add("forum");
            sizeList.add(10);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 21) {
            name = "Eternity Nitro";
            brand = "Puma";
            description = "The ideal performance running shoe for those needing added stability and support.";
            colourList.add("Black");
            colourList.add("White");
            imageFilenameList.add("pumanitro");
            imageFilenameList.add("pumanitro2");
            imageFilenameList.add("pumanitro3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 22) {
            name = "Basket Classic XII";
            brand = "Puma";
            description = "A true classic is timeless – and the enduring style of the low-cut Basket silhouette is a case in point.";
            colourList.add("White");
            colourList.add("Black");
            imageFilenameList.add("basket");
            imageFilenameList.add("basket2");
            imageFilenameList.add("basket3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 23) {
            name = "Wild Rider";
            brand = "Puma";
            description = "Pick up the pace with the new Wild Rider. An athletic mesh upper with suede overlays gives a sporty dimension to this bold new silhouette, with an exaggerated sole design and layered Formstrip detail.";
            colourList.add("Red");
            colourList.add("Cream");
            imageFilenameList.add("wildrider");
            imageFilenameList.add("wildrider2");
            imageFilenameList.add("wildrider3");
            sizeList.add(8);
            sizeList.add(10);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 24) {
            name = "Suede Classic XXI";
            brand = "Puma";
            description = "With its huge impact on footwear culture, PUMA's most iconic trainer first hit the scene in 1968 and has been worn by icons of every generation since.";
            colourList.add("Red");
            colourList.add("Black");
            colourList.add("Blue");
            colourList.add("Yellow");
            imageFilenameList.add("suede");
            imageFilenameList.add("suede2");
            imageFilenameList.add("suede3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 25) {
            name = "Puma X Batman";
            brand = "Puma";
            description = "This season, PUMA joins forces with a pop culture icon to create a truly heroic collection: launching with the release of the new Batman film, the PUMA x BATMAN Suede Classic Sneakers bring to life the essence of the story.";
            colourList.add("Black");
            imageFilenameList.add("batman");
            imageFilenameList.add("batman2");
            imageFilenameList.add("batman3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 26) {
            name = "Cell Vive";
            brand = "Puma";
            description = "Runners rejoice: ultra-supportive shoes with street-ready style do exist.";
            colourList.add("Black");
            colourList.add("Red");
            imageFilenameList.add("cell");
            imageFilenameList.add("cell2");
            imageFilenameList.add("cell3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 27) {
            name = "Axelion Block";
            brand = "Puma";
            description = "Be bold in the game-changing silhouette of our Axelion Block Running Shoes, which combine contemporary design with the supreme comfort of our foam heel unit for the last word in athletic style.";
            colourList.add("White");
            colourList.add("Black");
            imageFilenameList.add("axelion");
            imageFilenameList.add("axelion2");
            imageFilenameList.add("axelion3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 28) {
            name = "CA Pro Nylon WS";
            brand = "Puma";
            description = "The first thing you notice about these sneakers is their clean and winter-ready look. This is achieved through clever use of various leather and textile materials, along with the moulded details on the toe box.";
            colourList.add("Black");
            colourList.add("White");
            imageFilenameList.add("capro");
            imageFilenameList.add("capro2");
            imageFilenameList.add("capro3");
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 29) {
            name = "Retaliate Block";
            brand = "Puma";
            description = "Say hello to the all-new Retaliate Block Men’s Running Shoe. This contemporary model packs a punch with bold PUMA branding and a streetstyle aesthetic while still delivering on the performance you’d expect from a PUMA essential.";
            colourList.add("White");
            colourList.add("Black");
            imageFilenameList.add("retaliate");
            imageFilenameList.add("retaliate2");
            imageFilenameList.add("retaliate3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(11);
            sizeList.add(12);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }else if (id == 30) {
            name = "Softride Vital";
            brand = "Puma";
            description = "The SOFTRIDE Vital running shoes are designed to keep up with your pace, wherever the day takes you.";
            colourList.add("Black");
            colourList.add("Cream");
            imageFilenameList.add("softride");
            imageFilenameList.add("softride2");
            imageFilenameList.add("softride3");
            sizeList.add(8);
            sizeList.add(9);
            sizeList.add(10);
            sizeList.add(11);
            generatedShoe = new Shoe(name, brand, description, colourList, imageFilenameList, sizeList);
        }
        return generatedShoe;
    }
    public DataProvider() {
        for (int i = 1; i < 31; i++) {
            this.shoeList.add(generateShoe(i));
        }
    }
    public List<Shoe> getShoes() {
        //This function will provide a list of generated shoe objects.
        return this.shoeList;
    }
    public List<Shoe> getBrandShoes(String brand) {
        //This function will provide a list of generated shoe objects.
        List<Shoe> shoeList = new LinkedList<Shoe>();
        for (int i = 0; i < this.shoeList.size() ; i++) {
            Shoe currentShoe = this.shoeList.get(i);
            if (currentShoe.getBrand().equals(brand)) {
                shoeList.add(currentShoe);
            }
        }
        return shoeList;
    }
    public List<Shoe> getSearchShoes(String input) {
        List<Shoe> shoeList = new LinkedList<Shoe>();
        String searchable = input.toLowerCase();
        for (int i = 0; i < this.shoeList.size() ; i++) {
            Shoe currentShoe = this.shoeList.get(i);
            if (currentShoe.getName().toLowerCase().contains(searchable)) {
                shoeList.add(currentShoe);
            } else if (currentShoe.getDescription().toLowerCase().contains(searchable)) {
                shoeList.add(currentShoe);
            } else if (currentShoe.getColourList().toString().toLowerCase().contains(searchable)) {
                shoeList.add(currentShoe);
            } else if (currentShoe.getBrand().toLowerCase().contains(searchable)) {
                shoeList.add(currentShoe);
            }
        }
        return shoeList;
    }
    public Shoe getOneShoe(String nameInput) {
        for (int i = 0; i < this.shoeList.size() ; i++) {
            Shoe currentShoe = this.shoeList.get(i);
            if (currentShoe.getName().equals(nameInput)) {
                //global.database.shoeList.get(i).incrementViewCount();
                //this.shoeList.get(i).incrementViewCount();
                return currentShoe;
            }
        }
        return null;
    }
    public List<Shoe> getTopPicks() {
        List<Shoe> shoeList = new LinkedList<Shoe>();
        List<Shoe> searchList = new ArrayList<Shoe>(this.shoeList);
        for (int count = 0; count < 3; count++) {
            int maxIndex = 0;
            int maxViewCount = 0;
            for (int i = 0; i < searchList.size() ; i++) {
                Shoe currentShoe = searchList.get(i);
                if (currentShoe.getViewCount() > maxViewCount){
                    maxIndex = i;
                    maxViewCount = currentShoe.getViewCount();
                }
            }
            shoeList.add(searchList.remove(maxIndex));
        }
        return shoeList;
    }
}