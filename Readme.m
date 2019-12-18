

Release Day 1:

Mise en place de la vue principale
Recherche d'un flux RSS et sur le parsing du XML correspondant
Tester le lancement du 1er Media
Conception du Podcast (Ajout des classes du Modèle)
Ajout des classes des vues( Combination FXML/JavaFX)

Release Day 2:
Réalisation d'une base de donnée en dur(format JSON) vu qu'on avait pas d'accès à l' API
Liaison entre Vue et modèle (PodcastApp)
Liason base de donnée et modèle (iTunes data)
Installation gradle
Visualisation de l'interface (PodcastView et EpisodeView) => Update de l'interface EpisodeView selon le Podcast sélectionné
Ajout lecture d'un Média se trouvant en local (Bouton Openfile)
Ajout d'une version prototype des fonctionnalités correspondantes au MediaPlayer (Play/Pause/Speed ratio/Stop)
récupération de la clé pour accéder à l'api partagée (ListenNotes)

Release Day 3:
Ajout de la classe PodcastApiFetcher qui récupère les flux RSS à travers une requête de l'utilisateur
Optimisation de l'interface Graphique (coloration)
Ajout un bouton Download qui permet le téléchargement en local les épisodes d'un podcast sans bloquer l'interface (Thread)
Modification de la classe PodcastApiFetcher pour qu'elle donnes des flux RSS correspondant à une requête de recherche selon un mot-clé ou un genre ou la langue
Modification de la classe Podcast et PodcastFinder pour qu'elle puisse inclure aussi l'image d'un Podcast, son langage et sa description.
Modification de la classe PodcastApp pour qu'elle sera compatible avec les fonctionnalités requises (mode préférence,mode accueil, mode recherche)