
# ECIniciativas
## Escuela Colombiana de Ingeniería

### CVDS - 2022

#### Integrantes: Wilson Delgado, Juanita Oramas, Julia Mejia y Sebastian Rojas 


#### Contexto Del Proyecto 
La Plataforma banco de iniciativas de proyectos, es una herramienta donde la comunidad universitaria de la Escuela 
Colombiana de Ingeniería Julio Garavito pueden registrar sus iniciativas e ideas de proyectos para ser desarrollados o 
gestionados por la PMO de la Escuela.  

En la cual se pueden consultar otras iniciativas, las cuales están agrupadas por un area, consultar por el estado de la iniciativa.

### Gestión del proyecto
Se realizaron 2 sprints. Se cuenta con el burndown chart de cada uno:

Sprint 1:

<imagen>
Burndown Trend

![img_5.png](img_5.png)

Sprint 2:

<imagen>


![img_6.png](img_6.png) ![img_7.png](img_7.png)

#### Definicion del diseño de la base de datos
Se define el modelo entidad relación:


![img_1.png](img_1.png)


Se procede a implementarlo en los servicios de Azure, usando una base de datos MySQL:


![img_3.png](img_3.png)

Servidor:

![img_4.png](img_4.png)

Para la implementación en un principio se creó

Pantalla de home:

![img.png](img.png)


#### Los items más importantes desarrollados durante el sprint fueron:

* **Consultar iniciativas**

* **Consultar iniciativas por palabra clave**

  La consulta arroja todas las ideas o iniciativas que contengan las palabras clave dadas sin importar el orden.
* **Consultar iniciativas por usuario**

* **consultar iniciativas agrupadas**

* **modificar una iniciativa.**

  El sistema solo debe permitir modificar una iniciativa o idea en el estado "en espera de revisión".

* **Reporte de las iniciativas por estado**



### Análisis de código estático
Usando la herramienta de SonarQube se realizó un análisis de código estático sobre el proyecto y se encontró:

![img_2.png](img_2.png)
3.8% al momento






