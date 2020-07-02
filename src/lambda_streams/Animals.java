package lambda_streams;

import java.util.*;
import java.util.stream.Collectors;

class Animals {
    //This class will be using streams.
    static List<String> animals = Arrays.asList("peacoCK","rabbit","chiwawa","OranguTAN","vipeR","cobra","paNDa","bUffalo","DeeR","maLLard");

    public static void main(String[] args) {

        lambdaListBooleanProcessor lambdaUpperFirst = (animalList, mutate) -> {
            if(mutate){
                return animals = animalList.stream().map(animal -> animal.substring(0, 1).toUpperCase() + animal.substring(1).toLowerCase()).collect(Collectors.toList());
            } else {
                List<String> updatedAnimals = animalList;
                return updatedAnimals.stream().map(animal -> animal.substring(0, 1).toUpperCase() + animal.substring(1).toLowerCase()).collect(Collectors.toList());
            }
        };

        lambdaStringProcessor lambdaAddAnimalProcess = animal -> {
            ArrayList<String> updatedAnimals = new ArrayList<>(animals);
            updatedAnimals.add(animal);
            animals = updatedAnimals;
            return animal;
        };

        lambdaListBooleanProcessor lambdaLowerFirstProcess = (animalList, mutate) -> {
            if(mutate){
                return animals = animalList.stream().map(animal -> animal.substring(0, 1).toLowerCase() + animal.substring(1).toUpperCase()).collect(Collectors.toList());
            } else {
                List<String> updatedAnimals = animalList;
                return updatedAnimals.stream().map(animal -> animal.substring(0, 1).toLowerCase() + animal.substring(1).toUpperCase()).collect(Collectors.toList());
            }
        };

        lambdaBoolProcessor lambdaFlipAnimalsProcess = mutate -> {
            if(mutate) {
                int max_index = animals.size() - 1;
                int halfLength = animals.size() / 2;
                for(int i=0; i<halfLength; i++) {
                    String temp = animals.get(i);
                    animals.set(i, animals.get(max_index - i));
                    animals.set(max_index - i, temp);
                }
                return animals;
            } else {
                List<String> updatedAnimals = new ArrayList<>(animals);
                int max_index = updatedAnimals.size() - 1;
                int halfLength = updatedAnimals.size() / 2;
                for(int i=0; i<halfLength; i++) {
                    String temp = updatedAnimals.get(i);
                    updatedAnimals.set(i, updatedAnimals.get(max_index - i));
                    updatedAnimals.set(max_index - i, temp);
                }
                return updatedAnimals;
            }
        };

        lambdaBoolProcessor lambdaSortAnimalsProcess = mutate -> {
            if(mutate) {
                Collections.sort(animals);
                return animals;
            } else {
                List<String> updatedAnimals = new ArrayList<>(animals);
                Collections.sort(updatedAnimals);
                return updatedAnimals;
            }
        };

        //-------------------------------------------------------------------------------------------------
        System.out.println("original animals : " + animals);

        //clean up the animals array by using the capsFirst() method. follow instructions in the method definition. 
//        List<String> cleaned = capsFirst(animals, false);
//        System.out.println(cleaned);

        lambdaCapsFirst(animals, false, lambdaUpperFirst);
       
        //do not modify these addAnimal() method invocations
//        addAnimal("rEIndeeR");
//        addAnimal("Platypus");
//        addAnimal("frOg");
//        addAnimal("lEOpArD");

        lambdaAddAnimal("rEIndeeR", lambdaAddAnimalProcess);
        lambdaAddAnimal("Platypus", lambdaAddAnimalProcess);
        lambdaAddAnimal("frOg", lambdaAddAnimalProcess);
        lambdaAddAnimal("lEOpArD", lambdaAddAnimalProcess);
        //---------------------------------------

//        capsFirst(animals,true);
//        System.out.println(animals);
//
//        List<String> lowered = lowerFirst(animals,false);
//        System.out.println(lowered);
//
//        System.out.println(flipAnimals(false));
//
//        System.out.println(sortAnimals(false));

        lambdaCapsFirst(animals, true, lambdaUpperFirst);
        System.out.println("Animals List: " + animals);

        lambdaLowerFirst(animals, false, lambdaLowerFirstProcess);
        System.out.println("Animals List: " + animals);

        lambdaFlipAnimals(false, lambdaFlipAnimalsProcess);
        System.out.println("Animals List: " + animals);

        lambdaSortAnimals(false, lambdaSortAnimalsProcess);
        System.out.println("Animals List: " + animals);
        lambdaSortAnimals(true, lambdaSortAnimalsProcess);
        System.out.println("Animals List: " + animals);

    }

    interface lambdaListBooleanProcessor {
        List<String> processor(List<String> list, boolean mutate);
    }

    interface lambdaStringProcessor {
        String processor(String string);
    }

    interface lambdaBoolProcessor {
        List<String> processor(boolean mutate);
    }

    static List<String> lambdaCapsFirst(List<String> animalList, boolean mutate, lambdaListBooleanProcessor lambda) {
        System.out.println("Uppercase animals: " + lambda.processor(animalList, mutate));
        return animalList;
    }

    static  String lambdaAddAnimal(String animal, lambdaStringProcessor lambda) {
        System.out.println("Added animal: " + lambda.processor(animal));
        return animal;
    };

    static List<String> lambdaLowerFirst(List<String> animalList, boolean mutate, lambdaListBooleanProcessor lambda) {
        System.out.println("Lowercase animals: " + lambda.processor(animalList, mutate));
        return animalList;
    }

    static List<String> lambdaFlipAnimals(boolean mutate, lambdaBoolProcessor lambda) {
        System.out.println("Flipped animals: " + lambda.processor(mutate));
        return animals;
    };

    static  List<String> lambdaSortAnimals(boolean mutate, lambdaBoolProcessor lambda) {
        System.out.println("Sorted animals: " + lambda.processor(mutate));
        return animals;
    }

    static List<String> capsFirst(List<String> animalList, boolean mutate) {
        //clean up the animals list so that the first letter is capitalized, and all the other letters are lowercased. Use a stream to accomplish this task.  Also, the 2nd parameter of this function is a boolean.  use this boolean 'flag' to determine whether or not to 'mutate' the original animals array stored as a static class field.  if the flag is set to 'true', mutate the animals and return the animals out of the function.  if it is false, create a copy of the animals, perform your stream operations on the copy, and return the copy of animals out of the function, WITHOUT modifying the original animals array.
        if(mutate){
            return animals = animalList.stream().map(animal -> animal.substring(0, 1).toUpperCase() + animal.substring(1).toLowerCase()).collect(Collectors.toList());
        } else {
            List<String> updatedAnimals = animalList;
            return updatedAnimals.stream().map(animal -> animal.substring(0, 1).toUpperCase() + animal.substring(1).toLowerCase()).collect(Collectors.toList());
        }
    }

    static String addAnimal(String animal) {
        //add an animal to the animal list.
        ArrayList<String> updatedAnimals = new ArrayList<String>(animals);
        updatedAnimals.add(animal);
        animals = updatedAnimals;
        return animal;
    };


    static List<String> lowerFirst(List<String> animalList, boolean mutate) {
        //lowercase the first letter, and uppercase the rest of the letters, using streams.  Also, depending on the value of the boolean flag 'mutate', mutate the original animals list, or perform your stream operations on a 'copy' of the animals list.  return the list out of the function in both cases.
        if(mutate){
            return animals = animalList.stream().map(animal -> animal.substring(0, 1).toLowerCase() + animal.substring(1).toUpperCase()).collect(Collectors.toList());
        } else {
            List<String> updatedAnimals = animalList;
            return updatedAnimals.stream().map(animal -> animal.substring(0, 1).toLowerCase() + animal.substring(1).toUpperCase()).collect(Collectors.toList());
        }
    }

    static List<String> flipAnimals(boolean mutate) {
        //reverse the order of the animals in the animal list.  If the boolean parameter is true, reverse the static animals array list by mutating the array.  if the mutate boolean is false, flip a 'copy' of the animals list, then return that list of flipped animals, WITHOUT mutating the static animals array. return the flipped list in both cases.
//        List<String> instructions = Arrays.asList("Flip","the","animals","list","."," ","Mutate","the","animals","only","if","flag","true");
//        return instructions;
        if(mutate) {
            int max_index = animals.size() - 1;
            int halfLength = animals.size() / 2;
            for(int i=0; i<halfLength; i++) {
                String temp = animals.get(i);
                animals.set(i, animals.get(max_index - i));
                animals.set(max_index - i, temp);
            }
            return animals;
        } else {
            List<String> updatedAnimals = new ArrayList<>(animals);
            int max_index = updatedAnimals.size() - 1;
            int halfLength = updatedAnimals.size() / 2;
            for(int i=0; i<halfLength; i++) {
                String temp = updatedAnimals.get(i);
                updatedAnimals.set(i, updatedAnimals.get(max_index - i));
                updatedAnimals.set(max_index - i, temp);
            }
            return updatedAnimals;
        }
    }

    static List<String> sortAnimals(boolean mutate) {
    //sort the animals in alphabetical order.  If the boolean parameter is true, mutating the animals list.  if the mutate boolean is false, sort a 'copy' of the animals list, then return that list of sorted animals, WITHOUT mutating the static animals array. return the sorted list in both cases.
        if(mutate) {
            Collections.sort(animals);
            return animals;
        } else {
            List<String> updatedAnimals = new ArrayList<>(animals);
            Collections.sort(updatedAnimals);
            return updatedAnimals;
        }
    }


}
