DROP TABLE IF EXISTS TDemande;
DROP TABLE IF EXISTS TEleve;
DROP TABLE IF EXISTS TCours;

CREATE TABLE TCours (
  noCours     CHAR(10) PRIMARY KEY,
  titre       VARCHAR(100),
  session     INT
);

INSERT INTO TCours (`noCours`, `titre`, `session`) VALUES 
	('201-420-SF', 'Mathématiques I', '1'),
	('420-100-SF', 'Éléments d\'informatique', '1'),
	('420-110-SF', 'Algorithmique', '1'),
	('420-120-SF', 'Programmation', '1'),
	('420-139-SF', 'Station de travail et réseaux', '1'),
	('201-421-SF', 'Mathématiques II', '2'),
	('420-229-SF', 'Algorithmique et programmation II', '2'),
	('420-239-SF', 'Configuration de matériel de transmission', '2'), 
	('420-300-SF', 'Systèmes d\'exploitation', '2'),
	('401-420-SF', 'Système d\'information organisationnel', '3'),
	('420-219-SF', 'Développement multimédia', '3'),
	('420-329-SF', 'Programmation en gestion', '3'),
	('420-339-SF', 'Conception de réseaux', '3'),
	('582-420-SF', 'Introduction au design graphique', '3'),
	('420-419-SF', 'Bases de données', '4'),
	('420-429-SF', 'Programmation objet', '4'),
	('420-439-SF', 'Intégration de réseaux', '4'),
	('420-459-SF', 'Conception de systèmes', '4'),
	('401-421-SF', 'Intégration au monde du travail', '5'),
	('420-569-SF', 'Projet synthèse', '5'),
	('350-420-SF', 'Interrelations et communications au travail', '5'),
	('420-659-SF', 'Stage', '6');

CREATE TABLE TEleve (
  matricule       CHAR(7) PRIMARY KEY,
  prenom          VARCHAR(30) NOT NULL,
  nom             VARCHAR(30) NOT NULL,
  estTuteur       BOOL
);

INSERT INTO TEleve (matricule, prenom, nom, estTuteur) VALUES
   ('1531111', 'Adam',    'Bernard',   false),
   ('1532222', 'Charles', 'Demers',    false),
   ('1533333', 'Eric',    'Fillion',   false),
   ('1439999', 'Kim',     'Labrecque', false),
   ('1330000', 'Monique', 'Nolet',     false);


CREATE TABLE TDemande (
  noDemande         INT PRIMARY KEY AUTO_INCREMENT,
  matrTutore        CHAR(7) NOT NULL,
  noCours           CHAR(10) NOT NULL,
  descrDemande      TEXT NOT NULL,
  matrTuteur        CHAR(7),
  coteTuteur        INT,
  commentaireTuteur TEXT
);

/* DONNÉES POUR TESTS */
INSERT INTO TDemande (matrTutore, noCours, descrDemande, matrTuteur, coteTuteur, commentaireTuteur) VALUES
  ('1532222', '420-219-SF', 'Comment marche le sélecteur nth-child ???', '1439999', 2, 
   'Charles n\'a plus de difficulté avec ce sélecteur de pseudo-classe.  Il est en mesure de sélectionner les items pairs ou impairs, les x premiers ou derniers éléments');
INSERT INTO TDemande (matrTutore, noCours, descrDemande) VALUES
  ('1531111', '420-219-SF', 'Je cherche à comprendre les routes paramétrées avec Lumen');
INSERT INTO TDemande (matrTutore, noCours, descrDemande, matrTuteur) VALUES
  ('1531111', '420-219-SF', 'Comment définir les clés étrangères (MySQL et SQLServer', '1439999');