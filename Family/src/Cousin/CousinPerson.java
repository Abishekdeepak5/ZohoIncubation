package Cousin;
class Fperson {
    String name;
    String gender;
    Fperson father;
    Fperson mother;
    static Fperson[] Fpersons;
    static String[][] familyFperson = {
        {"a", "m", null, null},
        {"b", "m", "a", "d"},
        {"c", "f", null, null},
        {"d", "f", null, null},
        {"e", "m", "a", "d"}
    };

    Fperson(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    static void setFperson() {
        // Initialize the Fpersons array with the same length as familyFperson
        Fpersons = new Fperson[familyFperson.length];
        
        // Create Fperson objects for each entry in familyFperson
        for (int i = 0; i < familyFperson.length; i++) {
            String name = familyFperson[i][0];
            String gender = familyFperson[i][1];
            Fpersons[i] = new Fperson(name, gender);
        }
        
        // Set the father and mother fields
        for (int i = 0; i < familyFperson.length; i++) {
            String fatherName = familyFperson[i][2];
            String motherName = familyFperson[i][3];
            
            Fpersons[i].father = getFpersonByName(fatherName);
            Fpersons[i].mother = getFpersonByName(motherName);
        }
    }

    static Fperson getFpersonByName(String name) {
        if (name == null) {
            return null;
        }
        for (Fperson Fperson : Fpersons) {
            if (Fperson != null && Fperson.name.equals(name)) {
                return Fperson;
            }
        }
        return null;
    }

    static Fperson[] findCousins(String FpersonName) {
        Fperson Fperson = getFpersonByName(FpersonName);
        if (Fperson == null) {
            return new Fperson[0];
        }

        // Array to store aunts and uncles
        Fperson[] auntsAndUncles = new Fperson[Fpersons.length];
        int countAuntsAndUncles = 0;

        // Find aunts and uncles from father's side
        if (Fperson.father != null) {
            for (Fperson p : Fpersons) {
                if (p != null && p.father == Fperson.father.father && p.mother == Fperson.father.mother && !p.name.equals(Fperson.father.name)) {
                    auntsAndUncles[countAuntsAndUncles++] = p;
                }
            }
        }

        // Find aunts and uncles from mother's side
        if (Fperson.mother != null) {
            for (Fperson p : Fpersons) {
                if (p != null && p.father == Fperson.mother.father && p.mother == Fperson.mother.mother && !p.name.equals(Fperson.mother.name)) {
                    auntsAndUncles[countAuntsAndUncles++] = p;
                }
            }
        }

        // Array to store cousins
        Fperson[] cousins = new Fperson[Fpersons.length];
        int countCousins = 0;

        // Find cousins (children of aunts and uncles)
        for (int i = 0; i < countAuntsAndUncles; i++) {
            Fperson auntOrUncle = auntsAndUncles[i];
            for (Fperson p : Fpersons) {
                if (p != null && (p.father == auntOrUncle || p.mother == auntOrUncle)) {
                    cousins[countCousins++] = p;
                }
            }
        }

        // Resize the cousins array to fit the exact number of cousins
        Fperson[] result = new Fperson[countCousins];
        for (int i = 0; i < countCousins; i++) {
            result[i] = cousins[i];
        }
        return result;
    }
}
public class CousinPerson {
	 public static void main(String[] args) {
	        Fperson.setFperson();

	        // Find and display cousins of a given Fperson
	        String FpersonName = "b";
	        Fperson[] cousins = Fperson.findCousins(FpersonName);
	        
	        System.out.println("Cousins of " + FpersonName + ":");
	        for (Fperson cousin : cousins) {
	            System.out.println(cousin.name);
	        }
	    }
}

