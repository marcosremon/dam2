package repasaco;

import repasaco.model.Character;
import repasaco.model.DevelopmentTeam;
import repasaco.model.InventoryItem;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ejercicios01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Character> characters = DataGenerator.randomCharacters.get();
        Map<String, InventoryItem> inventory = DataGenerator.randomInventory.get();
        List<DevelopmentTeam> teams = DataGenerator.randomDevelopmentTeams.get();

        System.out.print("Que ejercicio quieres ejecutar: ");
        int exercice = scanner.nextInt();
        switch (exercice) {
            case 1:
                ej1(characters);
                break;
            case 2:
                ej2(inventory);
                break;
            case 3:
                ej3(teams);
                break;
            case 4:
                ej4();
                break;
            case 5:
                ej5(inventory);
                break;
            default:
                System.out.println("Ejercicios Invalido");
                break;
        }
        scanner.close();
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej1(List<Character> characters) {
        //Ejercicio 1:
        //Dado un listado de personajes generados utilizando la clase DataGenerator, debes obtener los 3 personajes
        //con mayor nivel de "Intelligence". Una vez obtenidos, imprímelos en un formato bien estructurado y export
        //los resultados a un archivo llamado "PersonajesInteligentes.txt". El listado debe estar ordenado de mayor a
        //menor según el nivel de "Intelligence". Recuerda que debes utilizar lambdas y streams para realizar este ejercicio.
            //Ejemplo Resultado:
            //--- Personajes con mayor nivel de Intelligence ---
            //1. Nombre: Gandalf, Nivel: 45, Salud: 500, Intelligence: 9
            //2. Nombre: Legolas, Nivel: 38, Salud: 400, Intelligence: 8
            //3. Nombre: Aragorn, Nivel: 50, Salud: 550, Intelligence: 7

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej2(Map<String, InventoryItem> inventory) {
        //Ejercicio 2:
        //Usando la lista de objetos de inventario generados por DataGenerator, crea un informe que contenga los
        // nombres y categorías de los objetos cuyo valor en el mercado sea mayor a 200. Exporta este informe
        // a un archivo "ObjetosValiosos.txt", ordenando los objetos de mayor a menor según su valor en el mercado.
        //Debes utilizar lambdas y streams para realizar el filtrado y la ordenación.
            //Ejemplo Resultado:
            //--- Informe de Objetos Valiosos ---
            //        1. Nombre: Excalibur, Categoría: Weapon, Valor en el mercado: 450.5
            //2. Nombre: Armadura Dorada, Categoría: Armor, Valor en el mercado: 320.75
            //3. Nombre: Elixir de la Vida, Categoría: Potion, Valor en el mercado: 250.99

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej3(List<DevelopmentTeam> teams) {
        //Ejercicio 3:
        //Genera varios equipos de desarrollo utilizando DataGenerator. El objetivo es encontrar y mostrar los equipos
        //que tienen más de 3 miembros cuyo nombre comience con la letra 'M'. Debes imprimir los nombres de dichos
        //equipos en formato legible y exportarlos a un archivo "EquiposFiltrados.txt". Utiliza lambdas para filtrar
        //y contar los miembros que cumplen la condición.
            //Ejemplo Resultado:
            //--- Equipos con más de 3 miembros cuyo nombre comienza con 'M' ---
            //1. Equipo: Team Alpha
                //Miembros: [Michael, Maria, Martha, Marco, Matthew]
            //2. Equipo: Team Beta
                //Miembros: [Max, Maggie, Melanie, Miles, Megan]

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej4() {
        // Ejercicio 4:
        // Lee el archivo Inventario.txt y crea un listado de objetos InventoryItem usando lambdas.
        // Filtra los objetos que sean de la categoría "Potion" y que tengan un valor mayor a 150.
        // Ordena los objetos filtrados por cantidad de mayor a menor.
        // Imprime los nombres y valores de los objetos filtrados en la consola.
        // Exporta los resultados a un archivo llamado PocionesFiltradas.txt.

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej5(Map<String, InventoryItem> inventory) {
        //Ejercicio 5:
        //A partir del inventario generado, filtra todos los objetos de la categoría "Potion" que cumplan con las
        //siguientes condiciones: La cantidad debe ser mayor o igual a 30. El valor en el mercado debe ser mayor a 150.
        //Además, debes mostrar solo aquellas pociones cuyo nombre contenga la letra 'e'. Ordena estos objetos por
        //cantidad de mayor a menor y exporta el resultado a un archivo llamado "PocionesOrdenadas.txt".
        //Recuerda utilizar lambdas y streams para realizar el filtrado y la ordenación. Asegúrate de imprimir la
        // categoría, el valor y la cantidad de cada poción.
            //Ejemplo Resultado:
            //	--- Pociones Filtradas y Ordenadas ---
            //	Nombre: Elixir de Energía, Categoría: Potion, Cantidad: 50, Valor en el mercado: 200.75
            //	Nombre: Poción de Curación Rápida, Categoría: Potion, Cantidad: 45, Valor en el mercado: 180.00
            //	Nombre: Poción Mística, Categoría: Potion, Cantidad: 35, Valor en el mercado: 175.50

    }
}