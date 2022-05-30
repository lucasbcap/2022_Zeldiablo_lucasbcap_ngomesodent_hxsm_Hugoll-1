Groupe 5
Beal Lucas / Alexandre Romain / Rouyer Hugolin / Gomes-Odent Noam


# commentaires

## fonctionnalités V3
	 
- pas de répartition de tâches entre vous

faites attention à bien prendre le temps de préciser cela dans votre document version 3

## diagrammes

- diagramme de classe
  - attention, certains attributs sont répétés
  - par exemple, une association représentée par une flèche doit remplacer la déclaration de l'attribut (cf caseExplosion dans bombe)
  - je ne sais pas si c'est judicieux de mettre bombes en attribut de personnage plutot que dans l'environnement. A voir en fonction des autres diagrammes de séquence. Peut etre faudra-t-il changer cela plus tard.

- diagramme de séquence
  - il n'y a que le dépot d'une bombe
  - attention, dans un diagramme de séquence ce ne sont pas des classes mais des objets (cf memo diagramme de séquence) !
  - vos appels 5 et 6 sont étranges car l'appel 4 fait sortir de bombe, l'appel 5 ne peut donc pas en partir
  - il manque les périodes d'activation (rectangle sur la ligne de vie) qui permettent de comprendre l'organisation des méthodes
  - on ne met pas les retours void

- diagramme de séquence "degat bombe" absent
  - c'est justement la partie intéressante
  - à développer à l'itération suivante.

## Code

- attention, il y a des diagrammes puml dans "projet_zeldiablo"
- degatbombe pourrait être mieux codé (en particulier, regarder comment éviter d'avoir des if pour gérer les directions : cf projet QDev). 
- La morale de COO : quand vous faites des copier-coller vous copier-coller les bugs et il y a plus de code à maintenir. Essayer de structurer votre code pour éviter les répétitions.

## bilan 

- il manque un fichier texte bilan qui explique les fonctionnalités codées et ce qui a été validé
- il manque aussi la répartition du travail

# Bilan

- une trés bonne base pour la suite du projet
- des diagrammes ok (mais avec quelques erreurs à corriger - cf remarques)

# Evaluation actuelle 

- (évaluation entre A et F) => B+ (bon début, continuez dans cette direction pour la suite du projet)
