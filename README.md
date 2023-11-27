# TAA - Branche tpSpring

Pour accéder à cette partie, il faudra faire un git checkout tpSpring.
Pour cette partie, Il faudra setup la base de donnée. Nous avons fait le choix d'utiliser `MySQL`. Il va falloir modifer le fichier `application.properties` si vous voulez en avoir une autre ou changer des valeurs.
- Pour la valeur de `spring.datasource.url`, il faut modifier l'url de connexion en fonction du schéma de base de donnée et du port que vous aurez choisi. Dans notre cas, on est sur : `jdbc:mysql://localhost:3306/my_bdd`. 
- Pour le username : `spring.datasource.username` = `root`
- Pour le password : `spring.datasource.password` = `admin123`

Une fois la base de donnée mise en place, vous pourrez lancer l'application via le fichier `SampleDataJpaApplication` et tester l'application avec postman à l'adresse : `http://localhost:8080/`.

Pour cette partie, nous avont appris de nos erreurs et nous avons décider de simplifier notre modèle relationnel pour faire une application fonctionnelle et bien comprendre les enjeux et principes de Spring.
Notre modèle relationnel évolue donc comme suit :
On a toujours un student mais il n'a qu'un `name`, un `studentNumber` (qui est maintenant généré automatiquement) et une `Liste d'Appointment`.
Le `teacher` a maintenant un `name` également et une `Liste d'Appointment`.
L'appointment quand à lui est défini avec un `student`, un `teacher`, une `date`, un `startTime` et un `endTime`.
Ce modèle étant plus simple à mettre en oeuvre, on a donc réussi à finaliser la partie Spring.

On peut alors avoir des requêtes de tout type comme sur le tpRest (get,post,put,delete). En voici quelques exemples :

- GET : `http://localhost:8080/api/{élément du modèle*}/all` (permet de get tous les {élément du modèle}) ou `http://localhost:8080/{élément du modèle*}/{id}` (permet de get l' {élément du modèle} par son id). 
- POST : `http://localhost:8080/api/{élément du modèle*}/create` avec le body* associé (permet de créer un {élément du modèle})
- PUT  : `http://localhost:8080/api/{élément du modèle*}/update/{id}` avec le body* associé (permet d'update un paramètre d'un {élément du modèle})
- DELETE : `http://localhost:8080/api/{élément du modèle*}/delete/{id}` (permet de supprimer un {élément du modèle})

- Élements du modèle* pour les requètes : 
    - `students`, 
    - `teachers`,
    - `appointments`.
    
- Exemple de body* associé aux éléments : 
    - students : *`{
            "name": "Lise"
    }`*
    - professors : *`{
            "name": "Fabrice"
    }`*
    - appointments : *`{
        "date": "2023-10-18",
        "startTime": "15:30:00",
        "endTime": "18:00:00",
        "studentId": 1,
        "professorId": 2
        }`*

Nous avons également implémenté swagger UI dans cette partie.
Pour y accéder, il faudra se rendre à l'addresse : `http://localhost:8080/swagger-ui/index.html`
AOP est également implémenté, il permet d'avoir plus de logs pour notre programme.
