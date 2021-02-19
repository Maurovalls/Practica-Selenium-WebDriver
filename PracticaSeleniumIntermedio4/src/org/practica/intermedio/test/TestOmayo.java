package org.practica.intermedio.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
/*
1-Navegar hacia http://omayo.blogspot.com/
2-Comprobar que el titulo de la pagina sea "omayo (QAFox.com)"
3-Validar que el menu funcione correctamente
4-Validar que todos los links internos esten funcionando
5-Elegir las opciones "Volvo" y "Hyundai"
6-Elegir del menu desplegabla de abajo, la opcion "doc 4"
7-En la caja de ingreso de datos, donde dice "Selenium WebDriver",
corroborar que este escrito ese texto inicialmente. Luego cambiarlo por otro y comprobar que quedo escrito
8-Comprobar que el boton "Enabled button" este activo
9-Comprobar que el boton "Disabled  button" este inactivo
10-Comprobar que la Text Box este inactiva
11-Comprobar que los 3 botones tengan respectivamente como texto legible "Submit", "Login" y "Register"
12-Comprobar que la lista ordenada tenga 6 elementos
13-Comprobar que la lista desordenada contenga un elemento "Pomegranate"
14-Validar que los buscadores funcionen correctamente
15-Hacer click en el link "Open a popup window",
 navegar hacia la nueva ventana, copiar el segundo parrafo y cerrar la ventana
16.Hacer click en el boton "ClickAfterTextDissapears",
comprobar que el texto de la alerta diga "Hello" y darle aceptar
17-Comprobar que el boton "My Button" se desactive pasados 3 segundos al clickear el boton "Try it" ubicado mas abajo
18-Escribir tu nombre en la Text Area Field
19-Comprobar que el texto "The cat was playing in the garden." por defecto este escrito en la Text Area Field Two
20-Sumar las edades de las 4 personas y mostrarlo por consola
21-En la LoginSection, ingresar el usuario y contraseña, darle al boton "Cancel",
 comprobar que borre los datos ingresados anteriormente,
  volver a cargarlos y darle al boton "Login". Copiar el mensaje de la alerta y cerrarla
22-Hacer click en el boton "GetPrompt", ingresar una palabra y darle aceptar
23-Hacer click en el boton "GetConfirmation" y darle cancelar
24-Seleccionar el vehiculo "Car"
25-Invertir la seleccion por defecto de las opciones multiples (quedarian seleccionadas Pen, Laptop y Bag)
26-Comprobar que luego de 3 segundos de apretar el boton "Dropdown",
este disponible el link hacia Facebook, hacer click en el y comprobar el titulo de la pagina de Facebook
28-Hcaer doble click en el boton "Double click here", copiar el mensaje de la alerta y darle aceptar
29-Por ultimo realizar un reporte en tiempo real personalizado con la interface Listener
 */
public class TestOmayo {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("================");
        System.out.println("Comienza el test suite");
        System.out.println("================");
    }

    @AfterTest
    public void afterSuite(){
        System.out.println("================");
        System.out.println("Finaliza el test suite");
        System.out.println("================");
    }
}
