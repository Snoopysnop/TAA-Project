# TAA - Branche tpRest
Pour accéder à cette partie, il faudra faire un `git checkout tpServlet`.
Ensuite une fois à la racine du projet, il faudra lancer le serveur de la bdd : `.\run-hsqldb-server.bat` pour windows `.\run-hsqldb-server.sh` pour linux et lancer le serveur ( fichier `RestServer` présent à la racine contenu dans le dossier `\src\main\java\fr\istic\taa\jaxrs`.

Une fois les serveurs lancés vous pouvez tester l'application ici : `http://localhost:8080/` en lançant des requêtes http via postman.
Pour avoir postman il faudra l'installer via internet.

On peut alors avoir des requêtes de tout type (get,post,put,delete). En voici quelques exemples :
- POST : `http://localhost:8080/student/create` avec le body* associé.
- GET : `http://localhost:8080/student/{studentNumber}` avec studentNumber qui correspond par exemple celui que l'on vient de créer juste avant.
- PUT  : `http://localhost:8080/student/{studentNumber}` avec le body* associé. 
- DELETE : `http://localhost:8080/student/delete/{studentNumber}`

- Exemple de body : 
    - student : *`{
        "firstName": "martin",
        "lastName": "dubois",
        "studentNumber":19008998
    }`*
    - student : *`{
        "firstName": "jules",
        "lastName": "dubois",
        "studentNumber":19008998
    }`*

On aurait pu prendre d'autres exemples car en collant ce système sur les autres éléments, cela donne un résultat simmilaire mais on a pas eu le temps de faire fonctionner le teacher ( sauf find qui permet de get un teacher avec son id et pareil pour appointment ).

On s'est rendu compte que notre modélisation était vraiment complèxe et donc difficile avec un manque de temps à mettre en oeuvre pour cette partie. On a tout de même réussi à faire fonctionner toutes les requêtes du student. Mais le principe aurait été le même pour les autres.
On retrouve bien les DAO, DTO, MAPPERS puis controlers.

    
