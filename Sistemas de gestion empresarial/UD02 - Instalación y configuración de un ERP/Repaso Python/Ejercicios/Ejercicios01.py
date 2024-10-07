def main():
    selection = int(input("qué ejercicio quieres seleccionar: "))
    while True:
        if selection == 1:
            ej1()
            break
        if selection == 2:
            ej2()
            break
        if selection == 3:
            ej3()
            break
        if selection == 4:
            ej4()
            break
        if selection == 5:
            ej5()
            break
        if selection == 6:
            ej6()
            break
        if selection == 7:
            ej7()
            break
        if selection == 8:
            ej8()
            break
        if selection == 9:
            ej9()
            break
        if selection == 10:
            ej10()
            break
        if selection == 11:
            ej11()
            break
        if selection == 12:
            ej12()
            break
        if selection == 13:
            ej13()
            break
        if selection == 14:
            ej14()
            break
        if selection == 15:
            ej15()
            break
        if selection == 16:
            ej16()
            break
        if selection == 17:
            ej17()
            break
        if selection == 18:
            ej18()
            break
        if selection == 19:
            ej19()
            break
        if selection == 20:
            ej20()
            break
        if selection == 21:
            ej21()
            break
        if selection == 22:
            ej22()
            break
        if selection == 23:
            ej23()
            break
        if selection == 24:
            ej24()
            break
        if selection == 25:
            ej25()
            break
        if selection == 26:
            ej26()
            break
        if selection == 27:
            ej27()
            break
        if selection == 28:
            ej28()
            break
        if selection == 29:
            ej29()
            break
        if selection == 30:
            ej30()
            break
        if selection == 31:
            ej31()
            break
        if selection == 32:
            ej32()
            break
        if selection == 33:
            ej33()
            break
        if selection == 34:
            ej34()
            break
        if selection == 35:
            ej35()
            break
        if selection == 36:
            ej36()
            break
        if selection == 37:
            ej37()
            break
        else:
            print("Ejercicio no válido.")

        opt = input("¿Deseas elegir otro ejercicio? (y/n): ").lower()
        if opt != "y":
            break


#-----------------------------------------------------------------------------------------------------------------------

def ej1():
    #Ej1. Escribir un programa que pregunte el nombre del usuario en la consola y después de
    #que el usuario lo introduzca muestre por pantalla la cadena ¡Hola <nombre>!, donde
    #<nombre> es el nombre que el usuario haya introducido.

    userName = str(input("cual es tu nombre: "))
    print(f"¡hola <{userName}>!")

#-----------------------------------------------------------------------------------------------------------------------

def ej2():
    #Ej2. Escribir un programa que muestre por pantalla el resultado de una operación aritmética.
    #((3+2)/(2*5))^2

    ope = ((3+2)/(2*5)) ** 2
    print(ope)

#-----------------------------------------------------------------------------------------------------------------------

def ej3():
    #Ej3. Escribir un programa que lea un entero positivo n, introducido por el usuario, y muestre
    #por pantalla la suma de todos los enteros desde 1 hasta n.

    number = int(input("introduce un numero entero positivo: "))
    for i in range(number):
        if number < 0:
            break
        number += i
    print(number)

#-----------------------------------------------------------------------------------------------------------------------

def ej4():
    #Ej4. Escribir un programa que pida al usuario dos números enteros y muestre por pantalla
    #el cociente y el resto de la división entera.

    number1 = int(input("introduce el primer numero: "))
    number2 = int(input("introduce el primer numero: "))

    print(f"el cociente es {number1 / number2}, y el resto es {number1 % number2}")

#-----------------------------------------------------------------------------------------------------------------------

def ej5():
    #Ej5. Escribir un programa que pregunte el nombre del usuario en la consola y un número entero,
    #e imprima por pantalla el nombre del usuario tantas veces como el número introducido.

    name = str(input("introduce tu nombre: "))
    number = int(input("introduce un numero: "))

    for i in range(number):
        print(name)

#-----------------------------------------------------------------------------------------------------------------------

def ej6():
    #Ej6. Escribir un programa que pregunte el nombre completo del usuario y lo muestre
    #tres veces: en minúsculas, en mayúsculas y con la primera letra de cada palabra en mayúscula.

    completeName = str(input("introduce tu nombre y apellidos: "))

    print(f"el nombre en minusculas es '{completeName.lower()}', el nombre en mayusculas es '{completeName.upper()}'"
          f"y el nombre con la primera letra en mayusculas es '{completeName.title()}'")

#-----------------------------------------------------------------------------------------------------------------------

def ej7():
    #Ej7. Escribir un programa que pida al usuario que introduzca una frase y muestre la frase invertida.

    phrase = str(input("escribe una frase "))
    inversalPhrase = ''.join(reversed(phrase))
    print(f"la frase al reves es {inversalPhrase}")

#-----------------------------------------------------------------------------------------------------------------------

def ej8():
    #Ej8. Escribir un programa que pregunte al usuario la fecha de su nacimiento en formato
    #dd/mm/aaaa y muestre el día, el mes y el año.

    day = int(input("Dime tu día de nacimiento: "))
    month = int(input("Dime tu mes de nacimiento (formato numero): "))
    year = int(input("Dime tu año de nacimiento: "))

    print(f"{day}/{month}/{year}")

#-----------------------------------------------------------------------------------------------------------------------

def ej9():
    #Ej9. Escribir un programa que pregunte el nombre de un producto, su precio y un número 
    #de unidades y muestre por pantalla una cadena con el nombre del producto seguido de 
    #su precio unitario con 6 dígitos enteros y 2 decimales, el número de unidades con tres 
    #dígitos y el coste total con 8 dígitos enteros y 2 decimales.
    
    productName = str(input("dime el nombre del producto "))
    productPrice = int(input("dime su precio "))
    productCuantity = int(input("cuantos productos quieres "))
    counter = 0
    string = ""
    for _ in str(productPrice):
        counter += counter
    digits = 6 - counter
    for _ in range(digits):
        string += "0"
    string += str(productPrice)
    print(string)
    while True:
        if productPrice > 999999:
            break

        break
        # print(f"el nombre del producto es {productName}, cuesta ")

#-----------------------------------------------------------------------------------------------------------------------

def ej10():
    #Ej10. Escribir un programa que pregunte al usuario su edad y muestre si es mayor de edad o no.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej11():

    #Ej11. Escribir un programa que pida al usuario un número entero y muestre si es par o impar.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej12():
    #Ej12. Escribir un programa que pregunte la edad de un cliente y calcule el precio de su entrada
    #según un sistema de tarifas por edad.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej13():
    #Ej13. Escribir un programa que pregunte al usuario su renta anual y muestre el tipo impositivo que le corresponde.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej14():
    #Ej14. Escribir un programa que pida al usuario una palabra y la muestre 10 veces.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej15():
    #Ej15. Escribir un programa que pida al usuario un número entero positivo y muestre
    #todos los números impares desde 1 hasta ese número, separados por comas.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej16():
    #Ej16. Escribir un programa que pida al usuario un número entero y muestre un triángulo
    #rectángulo de altura igual al número introducido.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej17():
    #Ej17. Escribir un programa que almacene las asignaturas de un curso en una lista y las muestre por pantalla.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej18():
    #Ej18. Escribir un programa que pregunte los números ganadores de la lotería primitiva, los almacene en una lista
    #y los muestre ordenados de menor a mayor.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej19():
    #Ej19. Escribir un programa que pida al usuario una palabra y muestre si es un palíndromo.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej20():
    #Ej20. Escribir un programa que almacene dos vectores y muestre su producto escalar.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej21():
    #Ej21. Rellenar con números aleatorios un array de 100 elementos y hallar el máximo, el mínimo y la media.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej22():
    #Ej22. Rellenar con números aleatorios un array de 100 elementos y ordenarlo.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej23():
    #Ej23. Escribir un programa que guarde en una variable un diccionario con divisas y pregunte al usuario por una divisa,
    #mostrando su símbolo o un mensaje si no está en el diccionario.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej24():
    #Ej24. Escribir un programa que guarde en un diccionario los precios de frutas, pregunte al usuario por una fruta
    #y muestre el precio de una cantidad especificada.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej25():
    #Ej25. Escribir un programa que almacene un diccionario con los créditos de las asignaturas de un curso y
    #muestre por pantalla los créditos de cada asignatura y el total.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej26():
    #Ej26. Escribir una función que muestre por pantalla el saludo ¡Hola amiga! cada vez que se la invoque.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej27():
    #Ej27. Escribir una función que reciba un número entero positivo y devuelva su factorial.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej28():
    #Ej28. Escribir una función que calcule el total de una factura tras aplicarle el IVA.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej29():
    #Ej29. Escribir una función que convierta un número decimal en binario y otra que lo convierta de binario a decimal.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej30():
    #Ej30. Escribir una función que aplique un descuento o el IVA a un precio usando otra función.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej31():
    #Ej31. Escribir una función que reciba otra función y una lista, y devuelva otra lista con el resultado de
    #aplicar la función a cada uno de los elementos.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej32():
    #Ej32. Escribir una función que reciba una frase y devuelva un diccionario con las palabras y su longitud.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej33():
    #Ej33. Construir una función que permita buscar inmuebles según un presupuesto dado.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej34():
    #Ej34. Escribir una función que pida un número entero entre 1 y 10 y guarde en un fichero la tabla de multiplicar de ese número.
    pass


#-----------------------------------------------------------------------------------------------------------------------

def ej35():
    #Ej35. Escribir una función que pida un número entero entre 1 y 10 y lea el fichero con la tabla de multiplicar
    #de ese número, mostrando el contenido o un mensaje si el fichero no existe.
    pass

#-----------------------------------------------------------------------------------------------------------------------

def ej36():
    #Ej36. Escribir un programa que acceda a un fichero en internet y muestre el número de palabras que contiene.
    pass

#-----------------------------------------------------------------------------------------------------------------------

def ej37():
    #Ej37. Escribir un programa que abra un fichero con información sobre el PIB per cápita de países
    #y muestre el dato del país indicado por el usuario.
    pass


#-----------------------------------------------------------------------------------------------------------------------

if __name__ == "__main__":
    main()
