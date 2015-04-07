# Fiat-Shamir

* Practica de Seguridad
* Lenguaje de programación: Java

Funcionamiento del algoritmo:

Inicialización: Escoger dos números primos secretos p,q y publicar N=p*q
Identificación secreta de A: Escoger un número secreto s tal que 0<s<N, y es primo con N
Identificación pública de A: Publicar v = s^2 (mod N)

i iteraciones:

    Compromiso secreto de A: Escoger un número secreto x tal que 0<x<N
    Testigo: A envía a B  a = x^2 (mod N)
    Reto: B envía a A Enviar un bit e, elegido al azar que solo puede tmar los valores 0 o 1
    Respuesta: A envía a B: 
        Si e = 0 -> y = x (mod N)
        Si e = 1 -> y = x * s (mod N)
    Verificación: B comprueba la información recibida:
        Si e = 0 -> y^2 = a (mod N)
        Si e = 1 -> y^2 = a * v (mod N)

Nota: En esta practica se usa el tipo de dato BigInteger que nos permite trabajar ocn números muy grandes.
