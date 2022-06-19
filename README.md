# JavaPotters-Homework2

## Proyecto de CRM

### Proyecto realizado por:
* Laura Zambrano 
* Sofia de la Fuente
* Ana Bermejo
* Rocio Arellano 

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Bienvenida/o a un nuevo proyecto de Java del grupo JavaPotters. 
En este proyecto realizamos un simulador de un CRM para una empresa ficticia. 
------------------------------------------------------------------------------------------------------------------------------

### ¿Cómo usarlo?

Al compilar nuestro programa podrás acceder a un CRM interno ficticio que pretende simular las diferentes opciones que podría realizar un asistente comercial dentro de la empresa. 
De esta forma por consola se nos pregunta qué funcionalidad queremos ejecutar, a elegir entre: 
-Registrar un lead 
-Convertir el lead en oportunidad
-Que nos muestre la lista de leads y oportunidades
-Cerrar las oportunidades ganadas o perdidas de negocio
En nuestra consola te mostraremos las opciones a elegir, así como te iremos guiando en el camino si cometes algún error. 

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### ¿Qué lógica hemos usado?

En la clase `CRM` encontrarás todos los métodos que hemos usado en nuestra lógica; entre ellos encontrarás: 
-Para leads: `createContact`, `addLead`, `findLead`, `showListLead`, `deleteLead`, `trackingLeads`
-Para oportunidades: `createOpportunity`, `lookUpOpportunity`, `closeOpportunity`,`showListOpportunity` 
-Para accounts: `findAccount`, `createAccount`, `addAccount`

En la clase `Webinar` encontramos el método `signinUp`, lo hemos separado del resto, ya que en el enunciado del proyecto nos comentaba que los usuarios se registran para un webinar y es desde ahí que podemos registrarlos en nuestro sistema.  
Además, dentro de esta clase, hemos creado el método `validInput` que lanzará una excepción si el usuario introduce un dato diferente de un entero, y que hemos introducido en un while para que se pueda repetir. 

En las clases: `Account`, `Contact`, `Lead` y `Opportunity` hemos introducido los atributos, método constructor, getters, setters, método equals, método hashCode y método toString de cada clase. 

En la clase `MainMenu` hemos introducido toda la lógica que debe imprimirse por consola para interactuar con el usuario para no sobrecargar la clase `Main` . Desde la clase `Main` llamaremos a los métodos incluidos en el `MainMenu`.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### Excepciones y tests:

Algo nuevo que hemos introducido en este proyecto de java es la parte de test y excepciones. 
En la clase `CRMTest` hemos incluido todos los tests con los que hemos evaluado los diferentes métodos de la clase `CRM`. 
Para lanzar excepciones hemos usado `try...catch` y la excepción `InputMismatchException` que sirve para capturar el error que se produce al introducir datos de tipo diferente a un int por consola. 
Con todo ello hemos alcanzado una cobertura de líneas del código del 76%.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### Datos adicionales que nos gustaría que conocieras: 

•	El proyecto ha sido realizado por partes iguales por las 4 miembros del grupo, debido a que nuestra dinámica de trabajo ha consistido en realizar reuniones virtuales durante todo el proyecto. No nos hemos dividido el trabajo, sino que lo hemos ido haciendo de forma simultánea en conjunto. Íbamos turnándonos para escribir el código pero el resto del equipo participaba de la escritura del mismo a la vez.
•	Al inicio del proyecto realizamos dos diagramas; uno de clases y otro de casos de uso, tal como hemos visto en clase esta semana, que, adjuntamos a continuación y también encontrarás en nuestro repositorio: 

## DIAGRAMA CASOS DE USO:

<p align="center">
    <img src = https://github.com/JavaPotters/JavaPotters-Homework2/blob/main/diagrama%20casos%20de%20uso%20Homework2JavaPotters.png width="450">
</p>

## DIAGRAMA CLASES:

<p align="center">
    <img src = https://github.com/JavaPotters/JavaPotters-Homework2/blob/main/diagrama%20de%20clases%20Homework2%20JavaPotters.png width="450">
</p>

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Por último nos gustaría agradecerte tu tiempo por probar e interesarte en nuestro proyecto; esperamos haber estado a la altura de lo que se nos pedía.
Si tienes alguna sugerencia o comentario sobre nuestro proyecto, estaremos encantadas de recibir el feedback. 


