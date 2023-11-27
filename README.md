# TAA - Branche tpServlet

Pour accéder à cette partie, il faudra faire un git checkout tpServlet.

Pour lancer le tpServlet, il faudra d'abord lancer le serveur de la base de donnée.
Pour ce faire, aller dans la racine du projet et lancer `.\run-hsqldb-server.bat` pour windows ou `.\run-hsqldb-server.sh` pour linux. On peut afficher la base en lançant aussi `.\show-hsqldb.bat`.
On peut alors lancer le serveur jetty en allant dans :
- Maven
- Plugins
- Jetty
- run

On peut alors aller tester l'application à l'adresse : `http://localhost:8080/myform.html`.
On peut alors y ajouter un `teacher` ou un `student` au choix. Après avoir cliqué sur `send`, on a un récapitulatif des informations et le `user` est créé en base. On peut d'ailleurs aller le vérifier sur le visuel de la base de donnée en faisant par exemple clique droit sur la table `STUDENT` puis `SELECT * FROM "PUBLIC"."STUDENT"`

