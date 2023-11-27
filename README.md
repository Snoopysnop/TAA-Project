# TAA Projet
- Ribeiro Gomes Lise &  Gombert Gwenaël

Sur ce git, vous pouvez retrouver 4 branches :

- `master` qui est la branche avec le TP1 donc toute la partie initialisation du tp avec notre modèle de donnée de base ainsi que les DAO. 
- `tpServlet` qui regroupe la partie master et la partie servlet.
- `tpRest` qui comporte l'implementation de notre api REST suivant notre modèle relationel et également le reste. Cette branche comporte également nos DTO, les mappers ainsi que les DAO déjà présentes.
- `tpSpring` qui est la partie spring boot comporte le modèle relationel, les dto, des mappers, notre API Rest mais en version spring et les controleurs. Elle comporte également la partie AOP et la partie Swagger.

Nous n'avons pas géré l'authentification Keycloak.

## Notre modèle relationnel 

Pour notre idée de base, nous avons décidés de faire un modèle relationnel comportant un `student` et un `teacher` qui sont des `user` ( par héritage ).
Chaque `teacher` possède une liste de `DateTimeSlot` qui représentera son agenda. A savoir qu'un `DateTimeSlot` est un objet composé d'une `Date` et d'un `TimeSlot` (ce dernier étant un slot horaire de la forme heure début/fin minute début/fin).
Finalement, nous avons aussi des `appointment` qui prennent en paramètre un `student`, un `teacher` et une `date`. Ils ont également un `timeSlot`.

Notre modèle se base alors sur "l'agenda" du `teacher` pour savoir quand est ce qu'il est disponible.

Pour plus de détail, se référer aux autres README.
